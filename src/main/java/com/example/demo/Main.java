package com.example.demo;

import com.example.demo.Model.*;
import com.example.demo.Repository.FineRepository;
import com.example.demo.Repository.TrafficEventRepository;
import com.example.demo.Repository.VehicleRepository;
import com.example.demo.Service.MyService;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        try {
            File f = new File("C:\\Users\\Dell\\Desktop\\Examen Practic MAP\\demo1\\src\\main\\java\\com\\example\\demo\\fines.json");
            System.out.println("Exists fines.json? " + f.exists());
            System.out.println("Absolute: " + f.getAbsolutePath());
            System.out.println("Working dir: " + System.getProperty("user.dir"));

            List<Fine> fines = FineRepository.load("C:\\Users\\Dell\\Desktop\\Examen Practic MAP\\demo1\\src\\main\\java\\com\\example\\demo\\fines.json");
            List<Vehicle> vehicles = VehicleRepository.load("C:\\Users\\Dell\\Desktop\\Examen Practic MAP\\demo1\\src\\main\\java\\com\\example\\demo\\vehicles.json");


            List<TrafficEvent> events = TrafficEventRepository.load("C:\\Users\\Dell\\Desktop\\Examen Practic MAP\\demo1\\src\\main\\java\\com\\example\\demo\\events.json");
            System.out.println("Anzahl der Fahrzeuge: " + vehicles.size());
            System.out.println("Anzahl der Ereignisse: " + events.size());
            System.out.println("Anzahl der Bußgelder: " + fines.size());
            for (Vehicle v : vehicles) {
                System.out.println(v);
            }
            MyService service = new MyService();
            List<Vehicle>l = service.filterByTypeAndStatus(vehicles,VehicleType.BUS, VehicleStatus.ACTIVE);
            System.out.println("Metoda de filtrare");
            l.forEach(System.out::println);
            System.out.println("Metoda de sortare");
            List<Vehicle>l2 =service.sortVehicles(vehicles);
            l2.forEach(System.out::println);
            service.saveVehiclesToFile(vehicles);
            events.stream().limit(5).map(e->" Event " + e.getId() + " Severity " + e.getSeverity() + " Type " + e.getType() + service.calculateRiskScore(e)).forEach(System.out::println);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}