package br.com.gaidzinski07.message.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.sql.Timestamp;

public record MessageRecordDTO(@NotNull String text, @NotNull String ownerId, @NotNull String chatId) {
}
