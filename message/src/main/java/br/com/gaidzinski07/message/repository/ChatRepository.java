package br.com.gaidzinski07.message.repository;

import br.com.gaidzinski07.message.model.Chat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.UUID;

public interface ChatRepository extends JpaRepository<Chat, UUID>, ChatCustomRepository {
    @Query("select c from Chat c")
    List<Chat> findAllByPersonId(UUID personId);
}
