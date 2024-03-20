package org.jspiders.Spring3LayerTicket.repository;

import org.jspiders.Spring3LayerTicket.domain.Ticket;

import java.util.ArrayList;
import java.util.List;

public class TicketRepository {
    private List<Ticket> ticketList=new ArrayList<>();

//    {
//        ticketList.add(new Ticket("MTB123","ACTION","MOVIE",150,"ABCD"));
//    }

    public List<Ticket> getTicketList(){
        return ticketList;
    }
    public void addTicket(Ticket ticket){
        ticketList.add(ticket);
    }
    public void deleteTicket(Ticket t1){
        ticketList.remove(t1);
    }
    public void updateTicket(int index,Ticket ticket){
        ticketList.set(index,ticket);
    }
}
