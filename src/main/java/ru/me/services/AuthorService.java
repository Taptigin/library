package ru.me.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.me.models.Author;
import ru.me.repository.AuthorRepository;

import java.util.List;

/**
 * Created by Александр on 25.12.2018.
 */
@Service
public class AuthorService {

    @Autowired
    private final AuthorRepository authorRepository;

    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public void createAuthor(Author author) {
        authorRepository.save(author);
    }

    public List<Author> findAllByName(String name){
        return authorRepository.findAllByName(name);
    }
}
