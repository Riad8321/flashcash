package com.riad8321.flashcash.service;

import com.riad8321.flashcash.model.User;
import com.riad8321.flashcash.model.UserAccount;
import com.riad8321.flashcash.repository.AccountRepository;
import com.riad8321.flashcash.repository.UserRepository;
import com.riad8321.flashcash.service.form.SignUpForm;
import org.springframework.stereotype.Service;

@Service("UserService")
public class UserService {
    private final UserRepository userRepository;
    private final AccountRepository accountRepository;

    public UserService(UserRepository userRepository, AccountRepository accountRepository) {
            this.accountRepository = accountRepository;
            this.userRepository = userRepository;
    }


    public User registration(SignUpForm form) {
        User user = new User();
        UserAccount UserAccount = new UserAccount();
        account.SetAmount(0.0);
        user.setAccount(account);
        user.setFirstName(form.getFirstName());
        user.setLastName(form.getLastName());
        user.setEmail(form.getEmail());
        user.setPassword(user.getPassword());
        return userRepository.save(user);
    }
}



