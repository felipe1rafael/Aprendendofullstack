package com.back.Felipe.repository;

import com.back.Felipe.entity.ChargeStatus;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ChargeStatusRepository extends MongoRepository<ChargeStatus, String> {

    Iterable<ChargeStatus> findByTicketIdOrderByDateChargeStatusDesc(String ticketId);


}
