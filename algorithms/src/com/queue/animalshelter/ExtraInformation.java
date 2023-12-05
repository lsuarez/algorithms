package com.queue.animalshelter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Formatter;

public class ExtraInformation {
    private LocalDateTime arrivalDate;

    public LocalDateTime getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(LocalDateTime arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public ExtraInformation() {
        this.arrivalDate = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "ExtraInformation{" +
                "arrivalDate=" + arrivalDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")) +
                '}';
    }
}
