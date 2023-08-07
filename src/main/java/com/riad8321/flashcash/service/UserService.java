package com.riad8321.flashcash.service;

import com.riad8321.flashcash.model.User;
import com.riad8321.flashcash.model.UserAccount;
import com.riad8321.flashcash.repository.AccountRepository;
import com.riad8321.flashcash.repository.UserRepository;
import com.riad8321.flashcash.service.form.SignUpForm;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service("UserService")
public class UserService {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final AccountRepository accountRepository;

    public UserService(UserRepository userRepository, AccountRepository accountRepository, PasswordEncoder passwordEncoder) {
            this.passwordEncoder = passwordEncoder;
            this.accountRepository = accountRepository;
            this.userRepository = userRepository;
    }


    public User registration(SignUpForm form) {
        User user = new User();

      UserAccount account = new UserAccount();
      account.setAmount(0.0);
      user.setAccount(account);
      user.setFirstName(form.getFirstName());
      user.setLastName(form.getLastName());
      user.setEmail(form.getEmail());
      user.setPassword(passwordEncoder.encode(form.getPassword()));

      return userRepository.save(user);
    }

    public Iterable<User> getUsers() { return userRepository.findAll();}

}



