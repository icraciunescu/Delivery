package ro.mxp.delivery.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ro.mxp.delivery.entities.User;
import ro.mxp.delivery.repositories.UserRepository;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findUserByUsername(String username) {
        Optional<User> user =  userRepository.findUserByUsername(username);
        return user.orElseThrow(() -> new UsernameNotFoundException("user not found !"));
    }

}
