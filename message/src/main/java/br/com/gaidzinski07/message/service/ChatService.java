package br.com.gaidzinski07.message.service;

import br.com.gaidzinski07.message.dto.ChatResponseDTO;
import br.com.gaidzinski07.message.dto.PersonSecureDTO;
import br.com.gaidzinski07.message.model.Chat;
import br.com.gaidzinski07.message.model.Person;
import br.com.gaidzinski07.message.repository.ChatRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ChatService {
    @Autowired
    private ChatRepository repository;

    public Chat save(Chat chat){
        return repository.save(chat);
    }

    public ChatResponseDTO findById(String id) {
        Chat chat = repository.findById(UUID.fromString(id)).orElse(null);
        ChatResponseDTO chatDto = new ChatResponseDTO();
        if(chat == null){
            return null;
        }
        BeanUtils.copyProperties(chat, chatDto);
        Set<Person> people = findPeopleInChat(id);
        Set<PersonSecureDTO> peopleSecure = people.stream().map(p -> {
            PersonSecureDTO ps = new PersonSecureDTO();
            ps.setId(p.getId());
            ps.setName(p.getName());
            return ps;
        }).collect(Collectors.toSet());
        chatDto.setPeople(peopleSecure);
        return chatDto;
    }

    public Set<Person> findPeopleInChat(String id){
        return repository.findPeopleInChat(UUID.fromString(id));
    }
}
