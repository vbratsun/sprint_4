package ru.yandex.practicum.models;

public class OrderData {
    private final String name;
    private final String surname;
    private final String address;
    private final String subwayStation;
    private final String phone;

    public OrderData(String name, String surname, String address, String subwayStation, String phone) {

        this.name = name;
        this.surname = surname;
        this.address = address;
        this.subwayStation = subwayStation;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getAddress() {
        return address;
    }

    public String getSubwayStation() {
        return subwayStation;
    }

    public String getPhone() {
        return phone;
    }
}
