package com.riad8321.flashcash.service;

import com.riad8321.flashcash.model.Link;
import com.riad8321.flashcash.repository.LinkRepository;
import com.riad8321.flashcash.repository.UserRepository;
import com.riad8321.flashcash.service.form.AddContactForm;
import org.springframework.stereotype.Service;

@Service
public class LinkService {
    private final LinkRepository linkRepository;
    private final SessionService sessionService;
    private final UserRepository userRepository;

    public LinkService(LinkRepository linkRepository, SessionService sessionService, UserRepository userRepository) {
        this.linkRepository = linkRepository;
        this.sessionService = sessionService;
        this.userRepository = userRepository;
    }

    public void addContact(AddContactForm form) {
        Link link = new Link();
        link.setUser1(sessionService.sessionUser());
        link.setUser2(userRepository.findUserByEmail(form.getEmail()).get());

        linkRepository.save(link);
    }
}


