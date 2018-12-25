package ru.me.services;

import ru.me.models.Author;

/**
 * Created by Александр on 25.12.2018.
 */
public interface LibraryService {
    public Author getAuthorByName(String authorName);
}
