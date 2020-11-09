import com.bridgelabz.*;
import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.Arrays;

public class InvoiceGeneratorTest {
    @Test
    public void givenDistanceAndTime_ShouldReturnFare(){
        InvoiceGenerator invoiceGenerator=new InvoiceGenerator();
        double distance= 2.0;
        int time=5;
        double fare= invoiceGenerator.calculateFare(distance,time);
        Assert.assertEquals(25,fare,0.0001);
    }
    @Test
    public void givenLessDistanceAndTime_ShouldReturnMinimumFare(){
        InvoiceGenerator invoiceGenerator=new InvoiceGenerator();
        double distance= 0.1;
        int time=1;
        double fare= invoiceGenerator.calculateFare(distance,time);
        Assert.assertEquals(5,fare,0.0001);
    }
/*
    @Test
    public void givenMultipleRide_shouldReturnTotalFare(){
        InvoiceGenerator invoiceGenerator=new InvoiceGenerator();
        Ride[] rides={new Ride(2.0,5),
                new Ride(0.1,1)};
        Double fare=invoiceGenerator.calculateFare(rides);
        Assert.assertEquals(30,fare,0.001);
    }



 */

    @Test
    public void givenMultipleRide_shouldReturnInvoiceSummary(){
        InvoiceGenerator invoiceGenerator=new InvoiceGenerator();
        Ride[] rides={new Ride(2.0,5),
                new Ride(0.1,1)};
        InvoiceSummary Summary =invoiceGenerator.calculateFare(rides);
        InvoiceSummary expectedInvoiceSummary=new InvoiceSummary(2,30);
       // Double fare=invoiceGenerator.calculateFare(rides);
        Assert.assertEquals(expectedInvoiceSummary,Summary);
    }

    @Test
    public void givenUserId_shouldReturnInvoiceService(){
        RideRepository[] rideRepositories={
                new RideRepository(1,new Ride[]{new Ride(1.0,2),new Ride(0.4,8)}),
                new RideRepository(2, new Ride[]{ new Ride(2.0,5)})
        };
        InvoiceService invoiceService=new InvoiceService(Arrays.asList(rideRepositories));
        InvoiceSummary invoiceSummary=invoiceService.getSummary(1);
        InvoiceSummary expected=new InvoiceSummary(2,30);
        Assert.assertEquals(expected,invoiceSummary);
    }

    @Test
    public void givenDistanceAndTimeForPremium_ShouldReturnFare(){
        InvoiceGenerator invoiceGenerator=new InvoiceGenerator();
        double distance= 2.0;
        int time=5;
        double fare= invoiceGenerator.calculateFare(distance,time,true);
        Assert.assertEquals(40,fare,0.0001);
    }

    @Test
    public void givenFareLessThanPremiumFare_ShouldReturnMinmunFare(){
        InvoiceGenerator invoiceGenerator=new InvoiceGenerator();
        double distance=0.1;
        int time=1;
        double fare= invoiceGenerator.calculateFare(distance,time,true);
        Assert.assertEquals(20,fare,0.0001);
    }



}
