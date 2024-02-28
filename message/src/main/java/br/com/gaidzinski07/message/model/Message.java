package br.com.gaidzinski07.message.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.UUID;

@Entity
@Table(name="message")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Message implements Serializable {
    private static final long serialVersionUID = 3L;

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private UUID idMessage;

    @NotNull
    private String text;

    @NotNull
    private Timestamp tsMessage;

    @JsonBackReference
    @NotNull
    @ManyToOne
    @JoinColumn(name="chat_id")
    private Chat chat;

    @NotNull
    @ManyToOne
    @JoinColumn
    private Person owner;

    public Message(String text, Timestamp tsMessage, Chat chat, Person owner) {
        this.text = text;
        this.tsMessage = tsMessage;
        this.chat = chat;
        this.owner = owner;
    }
}
