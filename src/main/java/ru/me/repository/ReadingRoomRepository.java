package ru.me.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.me.models.ReadingRoom;

/**
 * Created by Александр on 06.01.2019.
 */
public interface ReadingRoomRepository extends JpaRepository<ReadingRoom, Long>{
}
