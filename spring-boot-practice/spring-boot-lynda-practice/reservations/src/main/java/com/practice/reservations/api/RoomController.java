package com.practice.reservations.api;

import com.practice.logging.Timed;
import com.practice.reservations.entity.Room;
import com.practice.reservations.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class RoomController {

    @Autowired
    private RoomRepository roomRepository;

    @RequestMapping(value = "/rooms",method = RequestMethod.GET)
    @Timed
    public List<Room> getAllRooms(){
        Iterable<Room> results= roomRepository.findAll();
        List<Room> rooms = new ArrayList<>();
        System.out.println("hello");
        results.forEach(room-> rooms.add(room));
        return rooms;
    }
}
