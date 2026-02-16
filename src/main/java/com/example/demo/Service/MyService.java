package com.example.demo.Service;

import com.example.demo.Model.*;

import java.io.PrintWriter;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MyService {
    public List<Vehicle> filterByTypeAndStatus(List<Vehicle>vehicles,VehicleType type, VehicleStatus status) {
        return vehicles.stream().filter(v->v.getType().equals(type) && v.getStatus().equals(status)).collect(Collectors.toList());
    }
    public List<Vehicle> sortVehicles(List<Vehicle>lista){
        return lista.stream().sorted(Comparator.comparing(Vehicle::getOwnerCity).thenComparing(Comparator.comparing(Vehicle::getId)).reversed()).collect(Collectors.toList());
    }
    public void saveVehiclesToFile(List<Vehicle>lista){
        try(PrintWriter out = new PrintWriter("C:\\Users\\Dell\\Desktop\\Examen Practic MAP\\demo1\\src\\main\\java\\com\\example\\demo\\vehicles_sorted.txt")){
            for(Vehicle v:lista){
                out.println(v);
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }

    }
    public int calculateRiskScore(TrafficEvent trafficEvent){
        return switch(trafficEvent.getType()){
            case SPEEDING->trafficEvent.getSeverity() * 2;
            case RED_LIGHT->trafficEvent.getSeverity() * 3;
            case ACCIDENT -> trafficEvent.getSeverity() * 5;
            case PRIORITY_PASS -> trafficEvent.getSeverity();

        };

    }
    public Map<Vehicle,Integer>computeTotalRisk(List<Vehicle>vehicles, List<TrafficEvent>events, List<Fine>fines){
        Map<Integer,Integer> map = events.stream().collect(Collectors.groupingBy(TrafficEvent::getVehicleId,Collectors.summingInt(this::calculateRiskScore)));
        Map<Integer,Integer>map1 = fines.stream().collect(Collectors.groupingBy(Fine::getVehicleId,Collectors.summingInt(Fine::getAmount)));
        return vehicles.stream().collect();
    }

}
