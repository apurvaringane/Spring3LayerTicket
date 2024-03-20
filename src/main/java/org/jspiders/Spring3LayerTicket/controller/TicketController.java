package org.jspiders.Spring3LayerTicket.controller;

import jakarta.validation.Valid;
import org.jspiders.Spring3LayerTicket.domain.Ticket;
import org.jspiders.Spring3LayerTicket.service.TicketService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TicketController {
    TicketService service=new TicketService();
    @GetMapping("/")
    public String getTicket(Model model){
        model.addAttribute("ticket",new Ticket());
        //model.addAttribute("tickets",service.getTicketList());
        return "addticket";
    }
    @GetMapping("/ticket")
    public String getTicketInfo(Model model){
        model.addAttribute("tickets",service.getTicketList());
        return "ticket";
    }
    @PostMapping("/addticketinfo")
    public String saveTicketInfo(@Valid Ticket ticket, BindingResult result){
        boolean status=result.hasErrors();
        if (status)
            return "addticket";
        service.addTicket(ticket);
        return "redirect:/ticket";
    }
    @GetMapping("/viewticket")
    public String viewTicketDetails(Model model){
        model.addAttribute("tickets",service.getTicketList());
        return "/view";
    }
    @GetMapping("/delete/{ticketRef}")
    public String deleteTicket(@PathVariable(name = "ticketRef") String ticketRef,Model model){
    service.deleteTicket(ticketRef);
        return "redirect:/ticket";
    }
   @GetMapping("/update/{ticketRef}")
    public String getUpdateForm(@PathVariable(name = "ticketRef") String ticektRef,Model model){
    model.addAttribute("ticket",service.getTicket(ticektRef));
    return "/updateticket";
   }
   @PostMapping("/updateticket")
    public String updateTicketDetails(Ticket ticket){
    service.updateTicket(ticket);
       return "redirect:/ticket";
   }
}
