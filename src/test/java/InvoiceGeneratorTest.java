import com.bridgelabz.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

public class InvoiceGeneratorTest {

    InvoiceGenerator invoiceGenerator;
    @Before
    public void setUp() throws Exception{
        invoiceGenerator=new InvoiceGenerator();
    }

    @Test
    public void givenDistanceAndTime_ShouldReturnFare(){
        double distance= 2.0;
        int time=5;
        double fare= invoiceGenerator.calculateFare(distance,time);
        Assert.assertEquals(25,fare,0.0001);
    }
    @Test
    public void givenLessDistanceAndTime_ShouldReturnMinimumFare(){
        double distance= 0.1;
        int time=1;
        double fare= invoiceGenerator.calculateFare(distance,time);
        Assert.assertEquals(5,fare,0.0001);
    }


    @Test
    public void givenMultipleRide_shouldReturnInvoiceSummary(){
        Ride[] rides={new Ride(2.0,5,false),
                new Ride(0.1,1, false)};
        InvoiceSummary Summary =invoiceGenerator.calculateFare(rides);
        InvoiceSummary expectedInvoiceSummary=new InvoiceSummary(2,30);
        Assert.assertEquals(expectedInvoiceSummary,Summary);
    }

    @Test
    public void givenUserId_shouldReturnInvoiceService(){
        RideRepository[] rideRepositories={
                new RideRepository(1,new Ride[]{new Ride(2.0,5,true),new Ride(1,1, true)}),
                new RideRepository(2, new Ride[]{ new Ride(2.0,5, true)})
        };
        InvoiceService invoiceService=new InvoiceService(Arrays.asList(rideRepositories));
        InvoiceSummary invoiceSummary=invoiceService.getSummary(1);
        InvoiceSummary expected=new InvoiceSummary(2,60);
        Assert.assertEquals(expected,invoiceSummary);
    }

    @Test
    public void givenDistanceAndTimeForPremium_ShouldReturnFare(){
        double distance= 2.0;
        int time=5;
        double fare= invoiceGenerator.calculateFare(distance,time,true);
        Assert.assertEquals(40,fare,0.0001);
    }

    @Test
    public void givenFareLessThanPremiumFare_ShouldReturnMinimumFare(){
        double distance=0.1;
        int time=1;
        double fare= invoiceGenerator.calculateFare(distance,time,true);
        Assert.assertEquals(20,fare,0.0001);
    }



}
