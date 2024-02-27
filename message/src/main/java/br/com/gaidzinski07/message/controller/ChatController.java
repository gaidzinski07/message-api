package br.com.gaidzinski07.message.controller;

import br.com.gaidzinski07.message.dto.ChatRecordDTO;
import br.com.gaidzinski07.message.dto.PersonRecordDTO;
import br.com.gaidzinski07.message.model.Chat;
import br.com.gaidzinski07.message.model.Person;
import br.com.gaidzinski07.message.repository.ChatCustomRepository;
import br.com.gaidzinski07.message.repository.ChatRepository;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.UUID;


@Controller
public class ChatController {
    @Autowired
    ChatRepository repository;

    @PostMapping("/start-chat")
    public ResponseEntity<Chat> createChat(@RequestBody @Valid ChatRecordDTO dto){
        Chat chat = new Chat();
        BeanUtils.copyProperties(dto, chat);
        return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(chat));
    }

}
