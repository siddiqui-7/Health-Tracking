/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package App;

import com.centurylink.mdw.model.user.User;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.logging.Level;
import java.util.logging.Logger;
import static org.oxerr.commons.user.domain.QUser.user;

public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User registerUser(String username, String password) {
        // Check if the username is already taken
        if (isUsernameTaken(username)) {
            // Rethrow the exception or handle it appropriately
            throw new UsernameAlreadyTakenException("Username is already taken");
        }

        // Encode the password before saving it
        String encodedPassword = passwordEncoder.encode(password);

        // Create and save the user
        //User user = new User(username, encodedPassword);
        return userRepository.save(user);
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public boolean isUsernameTaken(String username) {
        return userRepository.existsByUsername(username);
    }

    // Custom exception class for username already taken scenario
    private static class UsernameAlreadyTakenException extends RuntimeException {
        public UsernameAlreadyTakenException(String message) {
            super(message);
        }
    }
}
