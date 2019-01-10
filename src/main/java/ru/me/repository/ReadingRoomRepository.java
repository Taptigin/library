package ru.me.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import ru.me.models.ReadingRoom;

import java.util.List;

/**
 * Created by Александр on 06.01.2019.
 */
public interface ReadingRoomRepository extends JpaRepository<ReadingRoom, Long>, JpaSpecificationExecutor<ReadingRoom>
, CrudRepository<ReadingRoom, Long>{
    List<ReadingRoom> findByBookIdAndUserName(Long bookId, String userName);
}
