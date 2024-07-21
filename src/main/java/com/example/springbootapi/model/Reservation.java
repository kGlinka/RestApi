package com.example.springbootapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.sql.Date;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Reservation {

    private Integer reservation_id;
    private Date startDate;
    private Date endDate;

    // Metoda do ustawiania LocalDate jako startDate
    public void setStartDate(LocalDate localDate) {
        this.startDate = Date.valueOf(localDate);
    }

    // Metoda do ustawiania LocalDate jako endDate
    public void setEndDate(LocalDate localDate) {
        this.endDate = Date.valueOf(localDate);
    }
}
