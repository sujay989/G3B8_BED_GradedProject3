package com.greatlearning.tta.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.greatlearning.tta.entity.Ticket;

public interface TicketRepository extends JpaRepository<Ticket, Long> {

	@Query(value = "select * from tickets where ticket_title like %?1%", nativeQuery = true)
	List<Ticket> findByTicketTitle(String keyword);
}
