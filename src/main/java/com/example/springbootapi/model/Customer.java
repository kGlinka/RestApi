package com.example.springbootapi.model;
import com.example.springbootapi.model.Reservation;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Customer {



    private Integer customer_id;
    private String Name;
    private Integer TelNumber;


}
