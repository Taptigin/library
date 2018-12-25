package ru.me.DAO;


import ru.me.models.Author;

public interface LibraryDao {

    public Author getAuthorByName(String authorName);

}
