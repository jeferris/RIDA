package com.example.rida;

public class Event extends Events {
    private String eventname;
    private String eventlocation;

    public Event() {
    }

    public Event(String eventname, String eventlocation) {
        this.eventname = eventname;
        this.eventlocation = eventlocation;

    }

    public String getEventName() {
        return eventname;
    }

    public String getEventLocation() {
        return eventlocation;
    }

    public void setEventName(String eventname) {
        this.eventname = eventname;
    }

    public void getEventLocation(String eventlocation) {
        this.eventlocation = eventlocation;
    }


//    @Override
//    public void onPointerCaptureChanged(boolean hasCapture) {
//
//    }
}
