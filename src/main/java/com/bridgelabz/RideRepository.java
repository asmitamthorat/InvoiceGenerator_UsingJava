package com.bridgelabz;

public class RideRepository {
    final int userId;
     final Ride[] rides;

    public RideRepository(int userId, Ride[] rides) {
        this.userId=userId;
        this.rides=rides;
    }
}
