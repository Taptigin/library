package ru.me.Services;


import ru.me.models.Author;

public interface LibraryService {

    public Author getAuthorByName(String authorName);

}
