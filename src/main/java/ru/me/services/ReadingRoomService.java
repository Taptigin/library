package ru.me.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.me.models.Book;
import ru.me.models.ReadingRoom;
import ru.me.repository.ReadingRoomRepository;

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

    public boolean orderBook(String bookName, String userName){
        Book book = bookService.getBookByName(bookName);
        boolean sucsess = false;
        if (storageService.getCountBookByBookId(book.getId()) > 0){
            storageService.decrementBookCountByBookNameAndBookCount(bookName, 1);

            sucsess  = true;

            ReadingRoom readingRoom = new ReadingRoom();
            readingRoom.setBookId(book.getId());
            readingRoom.setUserName(userName);
            readingRoomRepository.save(readingRoom);
        }
        return sucsess;
    }
}
