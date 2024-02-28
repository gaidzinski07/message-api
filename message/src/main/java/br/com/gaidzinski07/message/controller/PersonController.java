package br.com.gaidzinski07.message.controller;

import br.com.gaidzinski07.message.dto.*;
import br.com.gaidzinski07.message.model.Chat;
import br.com.gaidzinski07.message.model.Message;
import br.com.gaidzinski07.message.model.Person;
import br.com.gaidzinski07.message.repository.PersonRepository;
import br.com.gaidzinski07.message.service.PersonService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/person")
public class PersonController {
    @Autowired
    private PersonService service;

    @PostMapping("/signup")
    public ResponseEntity<Person> saveMessage(@RequestBody @Valid PersonRecordDTO dto){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(dto));
    }

    @PostMapping("/enter-chat")
    public ResponseEntity<Person> enterChat(@RequestBody @Valid PersonChatDTO dto){
        return ResponseEntity.status(HttpStatus.ACCEPTED).body((service.enterChat(dto)));
    }

    @GetMapping("/get-chats/{id}")
    public ResponseEntity<Set<Chat>> getChats(@PathVariable String id){
        return ResponseEntity.status(HttpStatus.FOUND).body(service.getPersonChats(id));
    }
}
