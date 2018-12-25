package ru.me.Services;


import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import ru.me.models.Author;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Service("libraryService")
@Repository
public class LibraryServiceImpl implements LibraryService{

    @PersistenceContext
    private EntityManager em;

    @Override
    public Author getAuthorByName(String authorName) {
        final String stringQuery = "select a from Author a where a.name = :authorName";
        TypedQuery<Author> query = em.createQuery(stringQuery, Author.class);
        query.setParameter("authorName", authorName);
        return query.getSingleResult();
    }
}
