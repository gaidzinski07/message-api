package br.com.gaidzinski07.message.repository;

import br.com.gaidzinski07.message.model.Chat;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

import java.util.List;
import java.util.UUID;

public class ChatCustomRepositoryImpl implements ChatCustomRepository{
    @PersistenceContext
    EntityManager entityManager;
}
