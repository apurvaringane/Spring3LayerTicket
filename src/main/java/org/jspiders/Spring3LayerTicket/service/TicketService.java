package org.jspiders.Spring3LayerTicket.service;

import org.jspiders.Spring3LayerTicket.domain.Ticket;
import org.jspiders.Spring3LayerTicket.repository.TicketRepository;

import java.util.List;

public class TicketService {
    TicketRepository repository=new TicketRepository();







    public List<Ticket> getTicketList(){
        return repository.getTicketList();
    }
    public void addTicket(Ticket ticket)
    {
        repository.addTicket(ticket);
    }
    public Ticket getTicket(String ticketRef){
        Ticket t1=null;
        for (Ticket t:repository.getTicketList()){
            if (t.getTicketRef().equals(ticketRef)){
                t1=t;
            }
        }
        return t1;
    }
    public void deleteTicket(String ticketRef){
    Ticket t1=null;
    for (Ticket t:repository.getTicketList()){
        if (t.getTicketRef().equals(ticketRef)){
            t1=t;
        }
    }
    repository.deleteTicket(t1);
    }
    public void updateTicket(Ticket ticket){
        int index=0;
        String ticketRef=ticket.getTicketRef();
        for (int a=0;a<repository.getTicketList().size();a++){
            Ticket t=repository.getTicketList().get(a);
            if (t.getTicketRef().equals(ticketRef)){
                index=a;
            }
        }
        repository.updateTicket(index,ticket);
    }
}
