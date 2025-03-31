package ru.yandex.practicum.models;

public class RentData {
    private final String rentStartDate;
    private final String rentLengthPeriod;

    public RentData(String rentStartDate, String rentLengthPeriod) {
        this.rentStartDate = rentStartDate;
        this.rentLengthPeriod = rentLengthPeriod;
    }

    public String getRentStartDate() {
        return rentStartDate;
    }

    public String getRentLengthPeriod() {
        return rentLengthPeriod;
    }
}
