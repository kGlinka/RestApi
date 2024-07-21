package com.example.springbootapi.repository;

import com.example.springbootapi.model.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ReservationRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;;

    public List<Reservation> getAllReservations() {
        return jdbcTemplate.query("SELECT reservation_id, date FROM Reservation",
                BeanPropertyRowMapper.newInstance(Reservation.class));
    }

    public Reservation getReservationById(int reservation_id) {
        return jdbcTemplate.queryForObject("SELECT reservation_id, date, date2 from reservation where" +
                " reservation_id =?", BeanPropertyRowMapper.newInstance(Reservation.class), reservation_id);
    }

    public int saveReservation(Reservation reservation) {
        jdbcTemplate.update("INSERT INTO reservation(reservation.date, reservation.date2) VALUES (?, ?)",
                        reservation.getStartDate(), reservation.getEndDate());
        return 1;
    }

    public int saveReservation(List<Reservation> reservations) {
        reservations.forEach(reservation -> jdbcTemplate
                .update("INSERT INTO reservation(reservation.date) VALUES (?)",
                        reservation.getStartDate()));
        return 1;
    }

    public int updateReservation(Reservation reservation) {
        return jdbcTemplate.update("UPDATE reservation SET date=? WHERE reservation_id=?",
                reservation.getStartDate(), reservation.getReservation_id());
    }

    public int deleteReservation(int reservation_id){
        return jdbcTemplate.update("DELETE FROM reservation WHERE reservation_id = ?", reservation_id);
    }

}
