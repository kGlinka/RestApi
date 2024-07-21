package com.example.springbootapi.views;

import com.example.springbootapi.model.Customer;
import com.example.springbootapi.model.Reservation;
import com.example.springbootapi.model.Room;
import com.example.springbootapi.service.CustomerService;
import com.example.springbootapi.service.ReservationService;
import com.example.springbootapi.service.RoomService;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.IntegerField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.time.*;
import java.util.Date;

@Route("")
@Component
public class MainView extends VerticalLayout {

    @Autowired
    CustomerService customerService;

    @Autowired
    RoomService roomService;

    @Autowired
    ReservationService reservationService;

    private Date startDate;
    private Date endDate;

    public MainView() {
        DatePicker startDateField = new DatePicker("Data rozpoczęcia");
        DatePicker endDateField = new DatePicker("Data zakończenia");
        TextField nameTextField = new TextField("Podaj imię");
        IntegerField integerField = new IntegerField("Podaj numer telefonu");
        IntegerField numerPokojuTextField = new IntegerField("Liczba miejsc");
        Button rezerwujButton = new Button("Rezerwuj");

        add(startDateField, endDateField, nameTextField, integerField, numerPokojuTextField, rezerwujButton);

        rezerwujButton.addClickListener(e -> {
            Notification.show("Rezerwacja została złożona!");
            Customer customer = new Customer();
            Reservation reservation = new Reservation();
            Room room = new Room();

            customer.setName(nameTextField.getValue());
            customer.setTelNumber(integerField.getValue());

            LocalDate localStartDate = startDateField.getValue();
            LocalDate localEndDate = endDateField.getValue();


            startDate = Date.from(localStartDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
            endDate = Date.from(localEndDate.atStartOfDay(ZoneId.systemDefault()).toInstant());

            reservation.setStartDate(startDateField.getValue());
            reservation.setEndDate(endDateField.getValue());
            room.setRoomNumber(numerPokojuTextField.getValue());

            roomService.saveRoom(room);
            reservationService.saveReservation(reservation);
            customerService.saveCustomers(customer);
        });
    }
}
