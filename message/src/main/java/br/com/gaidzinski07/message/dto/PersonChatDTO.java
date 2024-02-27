package br.com.gaidzinski07.message.dto;

import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record PersonChatDTO(@NotNull UUID person, @NotNull UUID chat) {
}
