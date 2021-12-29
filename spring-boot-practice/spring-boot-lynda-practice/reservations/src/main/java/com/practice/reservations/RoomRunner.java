package com.practice.reservations;

import com.practice.reservations.entity.Room;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;


@Component
public class RoomRunner implements CommandLineRunner {
    private RestTemplate restTemplate;

    public RoomRunner() {
        restTemplate = new RestTemplate();
    }

    @Override
    public void run(String... args) throws Exception {
  /*     Room[] rooms =restTemplate.getForObject("http://localhost:8000/api/rooms", Room[].class);
       for(Room room: rooms){
           System.out.println(room.getRoomName());
       }*/
    }
}
