package br.com.gaidzinski07.message.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name="chat")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Chat implements Serializable {
    private static final long serialVersionUID = 2L;
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private UUID chatId;
    @NotNull
    private String name;
    @JsonBackReference
    @ManyToMany(mappedBy="chats", fetch = FetchType.LAZY)
    private List<Person> people;
}
