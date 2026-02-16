package com.example.demo.Model;

public class TrafficEvent {
   private int id;
   private int vehicleId;
    private EventType type;
    private int severity;
    private int timeSlot;
   public TrafficEvent(){}
    public TrafficEvent(int id, int vehicleId, EventType type, int severity, int timeSlot) {
        this.id = id;
        this.vehicleId = vehicleId;
        this.type = type;
        this.severity = severity;
        this.timeSlot = timeSlot;
    }

    public int getId() {
        return id;
    }

    public int getVehicleId() {
        return vehicleId;
    }

    public EventType getType() {
        return type;
    }

    public int getSeverity() {
        return severity;
    }

    public int getTimeSlot() {
        return timeSlot;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setType(EventType type) {
        this.type = type;
    }

    public void setVehicleId(int vehicleId) {
        this.vehicleId = vehicleId;
    }

    public void setSeverity(int severity) {
        this.severity = severity;
    }

    public void setTimeSlot(int timeSlot) {
        this.timeSlot = timeSlot;
    }
}
