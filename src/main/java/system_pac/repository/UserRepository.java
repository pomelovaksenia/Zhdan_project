package system_pac.repository;

import system_pac.model.UserAccount;

public interface UserRepository {
    void create(UserAccount account);
    UserAccount getById(long id);
}
