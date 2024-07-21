package com.example.springbootapi.service;

import com.example.springbootapi.model.Reservation;
import com.example.springbootapi.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    public List<Reservation> getAllReservations() {
        return reservationRepository.getAllReservations();
    }

    public Reservation getReservationById(int reservationId) {
        return reservationRepository.getReservationById(reservationId);
    }

    public void saveReservation(Reservation reservation) {
        reservationRepository.saveReservation(reservation);
    }

    public int saveReservation(List<Reservation> reservation) {
        reservationRepository.saveReservation(reservation);
        return 0;
    }

    public void saveReservations(List<Reservation> reservations) {
        reservationRepository.saveReservation(reservations);
    }

    public void updateReservation(Reservation reservation) {
        reservationRepository.updateReservation(reservation);
    }

    public int deleteReservation(int reservationId) {
        reservationRepository.deleteReservation(reservationId);
        return reservationId;
    }
}
