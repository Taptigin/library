package ru.me.models;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AppUserForm {

    private Long userId;
    private String userName;
    private boolean enabled;
    private String password;
    private String confirmPassword;

    public AppUserForm(Long userId, String userName,
                       boolean enabled,
                       String password, String confirmPassword) {
        this.userId = userId;
        this.userName = userName;
        this.enabled = enabled;
        this.password = password;
        this.confirmPassword = confirmPassword;
    }


}
