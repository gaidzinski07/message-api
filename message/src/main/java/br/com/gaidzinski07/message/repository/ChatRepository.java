package br.com.gaidzinski07.message.repository;

import br.com.gaidzinski07.message.model.Chat;
import br.com.gaidzinski07.message.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Set;
import java.util.UUID;

public interface ChatRepository extends JpaRepository<Chat, UUID> {
    @Query(value="select c.people from Chat c where c.chatId = ?1")
    Set<Person> findPeopleInChat(UUID uuid);
}
