package org.jspiders.Spring3LayerTicket.domain;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.jspiders.Spring3LayerTicket.validation.Name;
import org.jspiders.Spring3LayerTicket.validation.Ticketano;
import org.springframework.format.annotation.DateTimeFormat;

import java.text.SimpleDateFormat;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Ticket {
    @Ticketano(message = "must start with MTB and exactly contain 8 characters followed by digits")
    private String ticketRef;

    @NotBlank(message = "EVENT NAME SHOULD NOT BLANK")
    @Name(message = "must be minimum of 5 characters & contain only letters")
    private String eventName;

    @NotBlank(message = "event type should not be null")
    private String eventType;

    @Future(message = "date should be in future")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date eventDate;


    @Max(value = 150,message = "available ticket can be max 150")
    private int availableTicket;


    @NotBlank(message = "INVALID LOCATION")
    @Size(min = 3, message = "Minimum 3 characters required")
    private String eventLocation;


    public String getDate(){
        SimpleDateFormat sd=new SimpleDateFormat("yyyy-MM-dd");
        return sd.format(eventDate);
    }
}
