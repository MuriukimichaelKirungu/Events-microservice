package com.example.Tickets.service;

import com.example.Tickets.entity.Ticket;
import java.util.List;

public interface TicketService {
    Ticket createTicket(Ticket ticket);
    List<Ticket> getAllTickets();
    Ticket getTicketById(Long id);
    List<Ticket> getTicketsByEventName(String eventName);
    void deleteTicket(Long id);
}
