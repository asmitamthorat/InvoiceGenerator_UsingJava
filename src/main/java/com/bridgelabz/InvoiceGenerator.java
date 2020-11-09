package com.bridgelabz;

public class InvoiceGenerator {
    private static final int COST_PER_TIME=1;
    private static final int COST_PER_KILOMETER=10;
    private static final Double MINIMUM_FARE=5.0;
    private static final Double PREMIUM_MINIMUM_FARE=20.0;
    private static final int PREMIUM_COST_PER_TIME=2;
    private static final int PREMIUM_COST_PER_KILOMETER=15;

    public double calculateFare(double distance, int time) {
        Double totalFare= distance*COST_PER_KILOMETER+time*COST_PER_TIME;
        if(totalFare<MINIMUM_FARE){
            totalFare=MINIMUM_FARE;
        }
        return totalFare;
    }

    public InvoiceSummary calculateFare(Ride[] rides) {
        double totalFare = 0;
        for (Ride ride:rides) {
            totalFare +=this.calculateFare(ride.distance,ride.time);
        }
        return new InvoiceSummary(rides.length,totalFare);
    }

    public double calculateFare(double distance, int time,boolean premium) {
        double totalFare = 0;
        if (true) {
            totalFare= distance*PREMIUM_COST_PER_KILOMETER+time*PREMIUM_COST_PER_TIME;
            return Math.max(totalFare,PREMIUM_MINIMUM_FARE);

        }
        if(!premium){
            totalFare=calculateFare( distance, time);
        }
        return totalFare;
    }


}
