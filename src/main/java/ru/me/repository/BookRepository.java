package ru.me.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import ru.me.models.Book;

import java.util.List;

/**
 * Created by Александр on 28.12.2018.
 */
public interface BookRepository extends JpaRepository<Book, Long>, JpaSpecificationExecutor<Book> {

    List<Book> findAllByName(String name);
}
