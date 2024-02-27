package br.com.gaidzinski07.message.dto;

import jakarta.validation.constraints.NotNull;

public record PersonSearchDTO(@NotNull String id) {
}
