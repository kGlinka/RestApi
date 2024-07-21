package com.example.springbootapi.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Room {



    private Integer room_id;
    private Integer roomNumber;
    private String roomStatus;



}
