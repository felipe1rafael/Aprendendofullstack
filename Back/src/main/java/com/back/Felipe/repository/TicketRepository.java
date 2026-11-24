package com.back.Felipe.repository;


import com.back.Felipe.entity.Ticket;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TicketRepository extends MongoRepository<Ticket, String> {

    Page<Ticket> findByUseridOrderByDateDesc(Pageable pages, String userId);

    Page<Ticket> findByTitleIgnoreCaseContainingAndStatusAndPriorityOrderByDateDesc(
            String title , String status , String priority , Pageable pages
    );
    Page<Ticket> findByTitleIgnoreCaseContainingAndStatusAndPriorityAndUserIdOrderByDateDesc(
            String title , String status , String priority , Pageable pages
    );
    Page<Ticket> findByTitleIgnoreCaseContainingAndStatusAndPriorityAndAssignedUserIdOrderByDateDesc(
            String title , String status , String priority , Pageable pages
    );
    Page<Ticket> findByNumber(String number , Pageable pages);

}
