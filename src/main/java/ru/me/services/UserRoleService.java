package ru.me.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.me.models.AppRole;
import ru.me.models.AppUser;
import ru.me.models.UserRole;
import ru.me.repository.UserRoleRepository;

/**
 * Created by Александр on 05.01.2019.
 */
@Service
public class UserRoleService {
    @Autowired
    UserRoleRepository userRoleRepository;

    public void createRoleForNewUser(AppUser appUser){
        UserRole userRole = new UserRole();
        userRole.setAppUser(appUser);
        AppRole appRole = new AppRole();
        appRole.setRoleId(2L);
        appRole.setRoleName("ROLE_USER");
        userRole.setAppRole(appRole);

        userRoleRepository.save(userRole);
    }
}
