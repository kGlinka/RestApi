package com.example.springbootapi.repository;


import com.example.springbootapi.model.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RoomRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Room> getAllRooms(){
        return jdbcTemplate.query("SELECT room_id, roomNumber, roomStatus FROM room",
                BeanPropertyRowMapper.newInstance(Room.class));
    }

    public Room getRoomById(int tableId){
        return jdbcTemplate.queryForObject("SELECT room_id, roomNumber, roomStatus from room where" +
                " room_id = ?", BeanPropertyRowMapper.newInstance(Room.class), tableId);
    }

    public int saveRoom(Room room){
         jdbcTemplate.update("INSERT INTO room(roomNumber, roomStatus) VALUES(?,?)",
                        room.getRoomNumber(), room.getRoomStatus());
        return 1;
    }

    public int saveRoom(List<Room> rooms){
        rooms.forEach(desk -> jdbcTemplate
                .update("INSERT INTO room(roomNumber, roomStatus) VALUES(?,?)",
                        desk.getRoomNumber(), desk.getRoomStatus()));
        return 1;
    }

    public int updateRoom(Room room){
        return jdbcTemplate.update("UPDATE room SET roomNumber=?, roomStatus=? WHERE room_id = ? ",
                room.getRoomNumber(), room.getRoomStatus(), room.getRoom_id());
    }

    public int deleteRoom(int room_id){
        return jdbcTemplate.update("DELETE FROM room WHERE room_id = ?", room_id );
    }
}
