package system_pac.repository;

import org.springframework.stereotype.Repository;
import system_pac.model.UserAccount;

import java.util.HashMap;
import java.util.Map;
@Repository
public class InMemoryUserRepository implements UserRepository{

    private Map<Long, UserAccount> accountMap = new HashMap<>();

    @Override
    public void create(UserAccount account) {
        accountMap.put(account.getId(), account);
    }

    @Override
    public UserAccount getById(long id) {
        return accountMap.get(id);
    }
}
