package br.com.gaidzinski07.message.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MessageSecureDTO {
    private String text;
    private Timestamp tsMessage;
    private PersonSecureDTO owner;
}
