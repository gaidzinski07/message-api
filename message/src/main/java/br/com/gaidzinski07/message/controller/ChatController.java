package br.com.gaidzinski07.message.controller;

import br.com.gaidzinski07.message.dto.ChatRecordDTO;
import br.com.gaidzinski07.message.dto.ChatResponseDTO;
import br.com.gaidzinski07.message.model.Chat;
import br.com.gaidzinski07.message.repository.ChatRepository;
import br.com.gaidzinski07.message.service.ChatService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/chat")
public class ChatController {
    @Autowired
    ChatService service;

    @PostMapping("/start-chat")
    public ResponseEntity<Chat> createChat(@RequestBody @Valid ChatRecordDTO dto){
        Chat chat = new Chat();
        BeanUtils.copyProperties(dto, chat);
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(chat));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ChatResponseDTO> getById(@PathVariable String id){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.findById(id));
    }

}
