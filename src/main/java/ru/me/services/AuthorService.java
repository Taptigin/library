package ru.me.services;

import org.springframework.beans.factory.annotation.Autowired;
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
    EntityManager em;

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

    public List<Author> findAll(){
        return authorRepository.findAll();
    }

    public List<Author> test() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Author> cq = cb.createQuery(Author.class);
        Root<Author> root = cq.from(Author.class);

        cq.select(root).where(cb.greaterThan(root.get(Author_.id), 0L));
        Query query = em.createQuery(cq);
        List<Author> lst = query.getResultList();
        return lst;
    }

}
