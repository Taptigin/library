package ru.me.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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

    public Integer getCountBookByBookId(long bookId){
        return storageRepository.getOne(bookId).getBookCount();
    }
}
