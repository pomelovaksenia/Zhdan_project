package system_pac.service;

import system_pac.model.UserAccount;

public interface UserService {
    void create(UserAccount account);
    UserAccount getById(long id);
}
