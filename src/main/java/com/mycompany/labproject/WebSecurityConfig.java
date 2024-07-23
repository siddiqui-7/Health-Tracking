/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.labproject;

// MainApplication.java

//import com.centurylink.mdw.model.user.User;
import online.inote.naruto.security.core.EnableWebSecurity;
import org.oxerr.commons.user.service.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.stereotype.Controller;
import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;













// WebSecurityConfig.java
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private final UserDetailsService userDetailsService;

    public WebSecurityConfig(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                .antMatchers("/", "/home").permitAll()
                .anyRequest().authenticated()
                .and()
            .formLogin()
                .loginPage("/login")
                .permitAll()
                .and()
            .logout()
                .permitAll();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
            .userDetailsService(userDetailsService)
            .passwordEncoder(passwordEncoder());
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
// UserController.java
//@Controller
//@RequestMapping("/user")
//public class UserController {

  //  private final UserService userService;

    //public UserController(UserService userService) {
      //  this.userService = userService;
    //}

    //@GetMapping("/registration")
    //public String showRegistrationForm() {
        //return "registration"; // Assuming you have a Thymeleaf template named "registration"
    //}

    //@PostMapping("/registration")
    //public String registerUser(@RequestParam String username, @RequestParam String password) {
        // Perform user registration using the UserService
      //  userService.registerUser(username, password);
        //return "redirect:/login"; // Redirect to the login page after successful registration
    //}

    //@GetMapping("/profile")
    //public String userProfile(Model model) {
        // Retrieve the currently logged-in user's details
      //  Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        //String username = authentication.getName();
        //User user;
       // user = userService.findByUsername(username);

        //model.addAttribute("user", user);
        //return "profile"; // Assuming you have a Thymeleaf template named "profile"
    //}
//}


