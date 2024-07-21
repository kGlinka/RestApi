package com.example.springbootapi.controller;

import com.example.springbootapi.model.Room;
import com.example.springbootapi.repository.RoomRepository;
import com.example.springbootapi.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("desks")
public class RoomController {

    @Autowired
    private RoomService roomService;

    @Autowired
    private RoomRepository roomRepository;

    @GetMapping
    public List<Room> getAllRooms() {
        return roomService.getAllRooms();
    }

    @GetMapping("/{id}")
    public Room getRoomById(@PathVariable("id") int id) {
        return roomService.getRoomById(id);
    }

    @PostMapping("")
    public int addRoom(@RequestBody List<Room> room) {
        return roomService.saveRoom(room);
    }

    @PatchMapping("/{id}")
    public int partialUpdateRoom(@PathVariable("id") int id, @RequestBody Room updatedRoom) {
        Room room = roomRepository.getRoomById(id);

        if (room != null) {
            if (updatedRoom.getRoomNumber() != null) room.setRoomNumber(updatedRoom.getRoomNumber());
            if (updatedRoom.getRoomStatus() != null) room.setRoomStatus(updatedRoom.getRoomStatus());
            roomRepository.updateRoom(room);
            return 1;
        } else {
            return -1;
        }
    }

    @DeleteMapping("/{id}")
    public int deleteRoom(@PathVariable("id") int id) {
        return roomService.deleteRoom(id);
    }
}
