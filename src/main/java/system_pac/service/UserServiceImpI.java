package system_pac.service;

import org.springframework.stereotype.Service;
import system_pac.model.UserAccount;
import system_pac.repository.UserRepository;
@Service
public class UserServiceImpI implements UserService{

    private final UserRepository userRepository;

    public UserServiceImpI(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void create(UserAccount account) {
        userRepository.create(account);
    }

    @Override
    public UserAccount getById(long id) {
        return userRepository.getById(id);
    }
}
