package ru.me.DAO;


import org.springframework.stereotype.Repository;
import ru.me.models.Author;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;


@Repository
public class LibraryDaoImpl implements LibraryDao{

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
