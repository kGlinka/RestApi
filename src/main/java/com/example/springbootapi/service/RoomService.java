package com.example.springbootapi.service;

import com.example.springbootapi.model.Room;
import com.example.springbootapi.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomService {

    @Autowired
    private RoomRepository roomRepository;

    public List<Room> getAllRooms() {
        return roomRepository.getAllRooms();
    }

    public Room getRoomById(int roomId) {
        return roomRepository.getRoomById(roomId);
    }

    public void saveRoom(Room room) {
        roomRepository.saveRoom(room);
    }

    public int saveRoom(List<Room> rooms) {
        roomRepository.saveRoom(rooms);
        return 1;  // lub zwróć odpowiednią wartość
    }

    public void updateRoom(Room room) {
        roomRepository.updateRoom(room);
    }

    public int deleteRoom(int roomId) {
        roomRepository.deleteRoom(roomId);
        return 1;  //
    }
}