package ru.me.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.me.models.UserRole;

/**
 * Created by Александр on 05.01.2019.
 */
public interface UserRoleRepository extends JpaRepository<UserRole, Long> {
}
