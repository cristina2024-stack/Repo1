package com.example.demo.Repository;

import com.example.demo.Model.TrafficEvent;
import com.example.demo.Model.Vehicle;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.util.List;

public class VehicleRepository {
    public static List<Vehicle> load(String filename)throws Exception{
        ObjectMapper obj = new ObjectMapper();

        return List.of(obj.readValue(new File(filename), Vehicle[].class));
    }

}
