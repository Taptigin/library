package ru.me.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import ru.me.models.Author;
import ru.me.models.Author_;
import ru.me.repository.AuthorRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * Created by Александр on 25.12.2018.
 */
@Service
public class AuthorService {

    @Autowired
    private EntityManager em;

    @Autowired
    private final AuthorRepository authorRepository;

    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public void createAuthor(Author author) {
        authorRepository.save(author);
    }


    public List<Author> findAll(){
        return authorRepository.findAll();
    }

    public List<Author> findAuthorByName(String name) {
        final Specification<Author> spec = Specification.where((root, cq, cb) -> (cb.equal(root.get(Author_.name), name)));
        return authorRepository.findAll(spec);
    }

}
