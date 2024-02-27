package br.com.gaidzinski07.message.controller;

import br.com.gaidzinski07.message.dto.MessageRecordDTO;
import br.com.gaidzinski07.message.model.Message;
import br.com.gaidzinski07.message.repository.MessageRepository;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {

    @Autowired
    MessageRepository repository;
    @PostMapping("/send-message")
    public ResponseEntity<Message> saveMessage(@RequestBody @Valid MessageRecordDTO dto){
        Message message = new Message();
        BeanUtils.copyProperties(dto, message);
        return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(message));
    }

}
