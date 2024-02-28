package br.com.gaidzinski07.message.controller;

import br.com.gaidzinski07.message.dto.MessageRecordDTO;
import br.com.gaidzinski07.message.model.Message;
import br.com.gaidzinski07.message.service.MessageService;
import jakarta.validation.Valid;
import jakarta.websocket.server.PathParam;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/message")
public class MessageController {

    @Autowired
    MessageService service;
    @PostMapping("/send")
    public ResponseEntity<Message> sendMessage(@RequestBody @Valid MessageRecordDTO dto){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(dto));
    }

    @GetMapping("/{chatId}")
    public ResponseEntity<List<Message>> getMessagesFromChat(@PathVariable String chatId){
        return ResponseEntity.status(HttpStatus.FOUND).body(service.findMessagesFromChat(chatId));
    }

}
