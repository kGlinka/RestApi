package com.example.springbootapi.controller;


import com.example.springbootapi.model.Reservation;
import com.example.springbootapi.repository.ReservationRepository;
import com.example.springbootapi.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservations")
public class ReservationController {

    @Autowired
    ReservationRepository reservationRepository;

    @Autowired
    ReservationService reservationService;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @GetMapping("")
    public List<Reservation> getAllReservations(){
     return reservationService.getAllReservations();
    }

    @GetMapping("/{id}")
    public Reservation getReservationById(@PathVariable int reservation_id) {
        return reservationService.getReservationById(reservation_id);
    }

    @PostMapping("")
    public int addReservation(@RequestBody List<Reservation> reservations){
        return reservationService.saveReservation(reservations);
    }

    @PatchMapping("/{id}")
    public int partiallyUpdate(@PathVariable int id, @RequestBody Reservation updatedReservation){
        Reservation reservation = reservationRepository.getReservationById(id);

        if (reservation != null) {
          if (updatedReservation.getStartDate() != null) reservation.setStartDate(updatedReservation.getStartDate().toLocalDate());
          reservationRepository.updateReservation(updatedReservation);
          return 1;
        }else{
            return -1;
        }
    }

    @DeleteMapping("/{id}")
    public int deleteReservation(@PathVariable int reservation_id){
        return reservationService.deleteReservation(reservation_id);
    }

}
