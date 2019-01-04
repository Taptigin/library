package ru.me.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
}
