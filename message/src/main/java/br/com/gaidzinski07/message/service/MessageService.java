package br.com.gaidzinski07.message.service;

import br.com.gaidzinski07.message.dto.MessageRecordDTO;
import br.com.gaidzinski07.message.model.Chat;
import br.com.gaidzinski07.message.model.Message;
import br.com.gaidzinski07.message.model.Person;
import br.com.gaidzinski07.message.repository.ChatRepository;
import br.com.gaidzinski07.message.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

@Service
public class MessageService {
    @Autowired
    private MessageRepository repository;


    public Message save(MessageRecordDTO dto) {
        Chat chat = new Chat();
        Person person = new Person();
        chat.setChatId(UUID.fromString(dto.chatId()));
        person.setId(UUID.fromString(dto.ownerId()));
        Message message = new Message(dto.text(), new Timestamp(System.currentTimeMillis()), chat, person);
        return repository.save(message);
    }

    public List<Message> findMessagesFromChat(String chatId) {
        return repository.findByChatChatId(UUID.fromString(chatId));
    }

    public Message findMessage(String messageId) {
        return repository.findById(UUID.fromString(messageId)).orElse(null);
    }
}
