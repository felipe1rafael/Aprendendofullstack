package com.back.Felipe.entity;

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
public class MundacasStatus {

    @Id
    private String id;

    @DBRef
    private Ticket ticket;

    @DBRef
    private User userChage;

    private Date date;

    private StatusEnum statusEnum ;

}
