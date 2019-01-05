package ru.me.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.me.models.AppUser;
import ru.me.repository.UserRepository;

/**
 * Created by Александр on 05.01.2019.
 */
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserRoleService userRoleService;

    public void createNewUser(AppUser appUser){
        userRepository.save(appUser);
        AppUser commitedUser = userRepository.findByUserName(appUser.getUserName());
        userRoleService.createRoleForNewUser(commitedUser);
    }
}
