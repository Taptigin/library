package ru.me.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.me.DAO.LibraryDao;
import ru.me.models.Author;

/**
 * Created by Александр on 25.12.2018.
 */
@Service("storageService")
public class LibraryServiceImpl implements LibraryService{

    @Autowired
    private LibraryDao libraryDao;


    @Override
    public Author getAuthorByName(String authorName) {
        return libraryDao.getAuthorByName(authorName);
    }
}
