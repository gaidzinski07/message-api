package br.com.gaidzinski07.message.dto;

import jakarta.validation.constraints.NotNull;

public record PersonRecordDTO(@NotNull String name, @NotNull String email) {
}
