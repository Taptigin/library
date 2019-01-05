package ru.me.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.me.models.AppUser;

/**
 * Created by Александр on 05.01.2019.
 */
public interface UserRepository extends JpaRepository<AppUser, Long> {
}
