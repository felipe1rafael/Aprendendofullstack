package com.back.Felipe.entity;


import com.back.Felipe.Enum.PrioridadeEnum;
import com.back.Felipe.Enum.StatusEnum;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Getter
@Setter
@Document
public class Ticket {
    @Id
    private String id;

    @DBRef(lazy = true)
    private String user;

    private Date date ;

    private String title;

    private Integer number;

     private StatusEnum status;

    private PrioridadeEnum priority;

    @DBRef(lazy = true)
    private User assignedUser;

    private String descricao;

    private String imagem;

    //private list<>  mudancas;

}
