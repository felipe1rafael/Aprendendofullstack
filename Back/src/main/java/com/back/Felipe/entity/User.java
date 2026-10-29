package com.back.Felipe.entity;
import com.back.Felipe.Enum.ProfileEnum;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import  org.springframework.data.mongodb.core.mapping.Document;

@Setter
@Getter
@Document
public class User {

    @Id
    private String id;

    @Indexed(unique = true)
    @NotBlank(message = "Email requerid")
    @Email(message = "email invalido")
    private String gmail;

    @NotBlank(message = "precisa de senha")
    @Size(min = 6)
    private String password;


     private ProfileEnum profile;

}
