package com.riad8321.flashcash.service;

import com.riad8321.flashcash.model.User;
import com.riad8321.flashcash.model.UserAccount;
import com.riad8321.flashcash.repository.AccountRepository;
import com.riad8321.flashcash.repository.UserRepository;
import com.riad8321.flashcash.service.form.AddCashForm;
import com.riad8321.flashcash.service.form.AddIbanForm;
import com.riad8321.flashcash.service.form.SignUpForm;
import com.riad8321.flashcash.service.form.WithdrawCashForm;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service("UserService")
public class UserService {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final AccountRepository accountRepository;
    private final SessionService sessionService;

    public UserService(UserRepository userRepository, AccountRepository accountRepository, PasswordEncoder passwordEncoder, SessionService sessionService) {
            this.passwordEncoder = passwordEncoder;
            this.accountRepository = accountRepository;
            this.userRepository = userRepository;
            this.sessionService = sessionService;
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

    public UserAccount ibanRegistration(AddIbanForm form) {
        UserAccount account= sessionService.sessionUser().getAccount();
        account.setIban(form.getIban());

        return accountRepository.save(account);
    }

    public UserAccount addCash(AddCashForm form) {
        UserAccount account= sessionService.sessionUser().getAccount();
        account.plus(form.getAmount());

        return accountRepository.save(account);
    }

    public UserAccount withdrawCash(WithdrawCashForm form) {
        UserAccount account = sessionService.sessionUser().getAccount();
        account.minus(form.getAmount());

        return accountRepository.save(account);
    }



    public Iterable<User> getUsers() { return userRepository.findAll();}

}



