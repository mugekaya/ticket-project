package com.felece.project.entity;

import javax.persistence.*;

@Entity
@Table(name = "route")
public class Route {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;
    @Column(name = "route_name")
    private String routeName;
    @Column(name = "route_type")
    private String routeType;
    @Column(name = "departure_point")
    private String departurePoint;
    @Column(name = "arrive_point")
    private String arrivePoint;
    @Column(name = "departure_time")
    private String departureTime;
    @Column(name = "arrive_time")
    private String arriveTime;
    @Column
    private double price;
    @Column
    private Long remainTicket;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "route_vehicle", referencedColumnName = "id")
    private Vehicle vehicle;
    @Column
    private Long soldSeat;

    public Long getRemainTicket() {
        return remainTicket;
    }

    public void setRemainTicket(Long remainTicket) {
        this.remainTicket = remainTicket;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Long getSoldSeat() {
        return soldSeat;
    }

    public void setSoldSeat(Long soldSeat) {
        this.soldSeat = soldSeat;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Route() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRouteName() {
        return routeName;
    }

    public void setRouteName(String routeName) {
        this.routeName = routeName;
    }

    public String getRouteType() {
        return routeType;
    }

    public void setRouteType(String routeType) {
        this.routeType = routeType;
    }

    public String getDeparturePoint() {
        return departurePoint;
    }

    public void setDeparturePoint(String departurePoint) {
        this.departurePoint = departurePoint;
    }

    public String getArrivePoint() {
        return arrivePoint;
    }

    public void setArrivePoint(String arrivePoint) {
        this.arrivePoint = arrivePoint;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public String getArriveTime() {
        return arriveTime;
    }

    public void setArriveTime(String arriveTime) {
        this.arriveTime = arriveTime;
    }
}


