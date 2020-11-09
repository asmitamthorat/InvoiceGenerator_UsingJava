package com.bridgelabz;
import java.util.List;

public class InvoiceService {
    private final List<RideRepository> repositories;
    public InvoiceService(List<RideRepository> repositories) {
        this.repositories=repositories;
    }



    public InvoiceSummary getSummary(int userID) {
        InvoiceSummary invoiceSummary = null;
        for (RideRepository repo:repositories) {
            if(repo.userId==userID){
                   invoiceSummary=new InvoiceGenerator().calculateFare(repo.rides);
            }
        }
        return invoiceSummary;
    }
}
