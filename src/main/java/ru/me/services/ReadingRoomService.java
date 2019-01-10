package ru.me.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.me.models.Book;
import ru.me.models.ReadingRoom;
import ru.me.models.ReadingRoom_;
import ru.me.repository.ReadingRoomRepository;
import ru.me.utils.OrderBookErorrs;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Александр on 06.01.2019.
 */
@Service
public class ReadingRoomService {

    @Autowired
    private ReadingRoomRepository readingRoomRepository;

    @Autowired
    private StorageService storageService;

    @Autowired
    private BookService bookService;

    public OrderBookErorrs orderBook(String bookName, String userName){
        Book book = bookService.getBookByName(bookName);

        if (book == null) return OrderBookErorrs.NOT_FOUND;
        if (getBooksByUserName(userName).contains(book)) return OrderBookErorrs.BOOK_IS_ALREADY;

        if (storageService.getCountBookByBookId(book.getId()) > 0){
            storageService.decrementBookCountByBookNameAndBookCount(bookName, 1);

            ReadingRoom readingRoom = new ReadingRoom();
            readingRoom.setBookId(book.getId());
            readingRoom.setUserName(userName);
            readingRoomRepository.save(readingRoom);
            return OrderBookErorrs.OK;
        } else return OrderBookErorrs.NOT_FOUND;
    }

    public List<Book> getBooksByUserName(String userName){
        List<Long> bookIds = readingRoomRepository.findAll((root, criteriaQuery, criteriaBuilder) ->
                criteriaBuilder.equal(root.get(ReadingRoom_.userName), userName))
                .stream().map(readingRoom -> readingRoom.getBookId()).collect(Collectors.toList());
        return bookIds.isEmpty() ? Collections.EMPTY_LIST : bookService.getAllBookByIds(bookIds);
    }

    public List<ReadingRoom> getAllOrders(){
        return readingRoomRepository.findAll();
    }

    public String returnBook(String bookName, String userName){
        Book book = bookService.getBookByName(bookName);
        if (book == null) return OrderBookErorrs.NOT_FOUND.getErrorDescrption();

        List<Book> userBooks = getBooksByUserName(userName);
        if (!userBooks.contains(book)){
            return "Книга - " + bookName + ", у пользователя " + userName + " не найдена.";
        }else {
            ReadingRoom currentRow = findByUserNameAndBookName(book.getId(), userName);
            if (currentRow != null){
                readingRoomRepository.delete(currentRow);
                storageService.incrementBookCountByBookNameAndBookCount(bookName, 1);
                return "Книга - " + bookName + " возвращена на склад";
            } else return "Книга - " + bookName + ", у пользователя " + userName + " не найдена.";
        }

    }

    public ReadingRoom findByUserNameAndBookName(Long bookId, String userName){
        List<ReadingRoom> list =readingRoomRepository.findByBookIdAndUserName(bookId, userName);
        return list.isEmpty() ? null : list.get(0);
    }
}
