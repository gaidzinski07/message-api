package br.com.gaidzinski07.message.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.sql.Timestamp;

public record MessageRecordDTO(String text, Timestamp tsMessage) {
}
