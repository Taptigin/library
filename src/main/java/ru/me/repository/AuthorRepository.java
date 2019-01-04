package ru.me.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import ru.me.models.Author;

/**
 * Created by Александр on 26.12.2018.
 */
public interface AuthorRepository extends JpaRepository<Author, Long>, JpaSpecificationExecutor<Author> {


}
