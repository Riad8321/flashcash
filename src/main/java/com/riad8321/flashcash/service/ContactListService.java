package com.riad8321.flashcash.service;

import com.riad8321.flashcash.model.Link;
import com.riad8321.flashcash.model.User;
import com.riad8321.flashcash.repository.ContactListRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ContactListService {
    private final ContactListRepository contactListRepository;

    private final SessionService sessionService;

    public ContactListService(ContactListRepository contactListRepository, ContactListRepository contactListRepository1, SessionService sessionService) {
        this.contactListRepository = contactListRepository1;
        this.sessionService = sessionService;
    }

    public List<String> findLinksEmail(){
        return contactListRepository.findLinksByUser1Email(sessionService.sessionUser().getEmail()).stream().map(Link::getUser2).map(User::getEmail).distinct().collect(Collectors.toList());
    }
}

