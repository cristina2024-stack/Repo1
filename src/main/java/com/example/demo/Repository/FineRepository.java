package com.example.demo.Repository;

import com.example.demo.Model.Fine;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.util.List;

public class FineRepository {
    public static List<Fine> load(String filename)throws Exception{
        ObjectMapper obj = new ObjectMapper();
        return List.of(obj.readValue(new File(filename),Fine[].class));
    }
}
