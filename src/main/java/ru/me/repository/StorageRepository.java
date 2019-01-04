package ru.me.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import ru.me.models.Storage;

/**
 * Created by Александр on 04.01.2019.
 */
public interface StorageRepository extends JpaRepository<Storage,Long>, JpaSpecificationExecutor<Storage> {

    Integer getCountBookByBookId(long bookId);
}
