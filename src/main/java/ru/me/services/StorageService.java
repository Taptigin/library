package ru.me.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.me.models.Book;
import ru.me.models.Storage;
import ru.me.repository.StorageRepository;

import javax.persistence.EntityManager;

/**
 * Created by Александр on 04.01.2019.
 */
@Service
public class StorageService {

    @Autowired
    private EntityManager em;

    @Autowired
    StorageRepository storageRepository;

    @Autowired
    BookService bookService;

    public Integer getCountBookByBookId(long bookId){
        return storageRepository.getOne(bookId).getBookCount();
    }

    public void incrementBookCountByBookNameAndBookCount(String bookName, int bookCount){
        Storage storage = storageRepository.getOne(bookService.getBookIdByBookName(bookName));
        storage.setBookCount(storage.getBookCount() + bookCount);
        storageRepository.save(storage);
    }

    public void decrementBookCountByBookNameAndBookCount(String bookName, int bookCount){
        Storage storage = storageRepository.getOne(bookService.getBookIdByBookName(bookName));
        if (storage.getBookCount() - bookCount >= 0){
            storage.setBookCount(storage.getBookCount() - bookCount);
        }else{
            storage.setBookCount(0);
        }
        storageRepository.save(storage);
    }

    public void addNewBook(Book book){
        book = bookService.getBookByName(book.getName());
        Storage storage = new Storage();
        storage.setBookId(book.getId());
        storage.setBookCount(1);
        storageRepository.save(storage);
    }
}
