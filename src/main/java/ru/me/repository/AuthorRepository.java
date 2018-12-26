package ru.me.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.me.models.Author;

import java.util.List;

/**
 * Created by Александр on 26.12.2018.
 */
public interface AuthorRepository extends JpaRepository<Author, Long> {

    List<Author> findAllByName(String name);
}
