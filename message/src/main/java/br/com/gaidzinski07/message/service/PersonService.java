package br.com.gaidzinski07.message.service;

import br.com.gaidzinski07.message.dto.PersonChatDTO;
import br.com.gaidzinski07.message.dto.PersonRecordDTO;
import br.com.gaidzinski07.message.dto.PersonSearchDTO;
import br.com.gaidzinski07.message.model.Chat;
import br.com.gaidzinski07.message.model.Person;
import br.com.gaidzinski07.message.repository.ChatRepository;
import br.com.gaidzinski07.message.repository.PersonRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PersonService {
    private final PersonRepository repository;
    @Autowired
    private ChatRepository chatRepository;

    @Autowired
    public PersonService(PersonRepository repository){ this.repository = repository;}

    @Transactional
    public Person save(PersonRecordDTO dto){
        Person person = new Person();
        BeanUtils.copyProperties(dto, person);
        return repository.save(person);
    }
    @Transactional
    public Person enterChat(PersonChatDTO dto) {
        Person person = repository.getReferenceById(dto.person());
        Chat chat = chatRepository.getReferenceById(dto.chat());
        Set<Chat> chatList = person.getChats() == null ? new HashSet<>() : person.getChats();
        chatList.add(chat);
        person.setChats(chatList);
        return repository.save(person);
    }

    public Set<Chat> getPersonChats(String id) {
        Person person = repository.getReferenceById(UUID.fromString(id));
        return person.getChats();
    }
}
