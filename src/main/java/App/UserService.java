/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package App;


import com.centurylink.mdw.model.user.User;

public interface UserService {

    /**
     * Find a user by username.
     * 
     * @param username The username to search for.
     * @return The user if found, otherwise null.
     */
    User findByUsername(String username);

    /**
     * Register a new user.
     * 
     * @param username The username of the new user.
     * @param password The password of the new user.
     * @return The registered user.
     */
    User registerUser(String username, String password);

    /**
     * Check if a username is already taken.
     * 
     * @param username The username to check.
     * @return True if the username is taken, otherwise false.
     */
    boolean isUsernameTaken(String username);

    // Other methods, if any
}
