package br.com.gaidzinski07.message.dto;

import br.com.gaidzinski07.message.model.Person;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ChatResponseDTO {
    private String id;
    private String name;
    private Set<PersonSecureDTO> people;
    private Set<MessageSecureDTO> messages;
}
