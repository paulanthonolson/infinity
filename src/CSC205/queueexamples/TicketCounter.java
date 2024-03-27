package queueexamples;

import queue.*;

public class TicketCounter {
    private final static int PROCESS = 120; // in seconds
    private final static int MAX_CASHIERS = 10;
    private final static int NUM_CUSTOMERS = 100;

    public static void main(String[] args) {
        // Run the simulation for a number of cashiers, from 1 to MAX_CASHIERS
        for (int cashiers = 1; cashiers <= MAX_CASHIERS; cashiers++) {
            QueueInterface<Cashier> cashierQueue = new ArrayQueue<>();
            // Initialize each cashier's availability time to zero
            for (int count = 1; count <= cashiers; count++)
                cashierQueue.enqueue(new Cashier(0));

            QueueInterface<Customer> customerQueue = new ArrayQueue<>();
            // Initialize customers to arrive every 15 seconds starting at time 15
            for (int count = 1; count <= NUM_CUSTOMERS; count++)
                customerQueue.enqueue(new Customer(count * 15));

            // Keep track of total wait time of all customers
            int totalTime = 0;

            // Process all customers in the queue
            while (!customerQueue.isEmpty()) {
                Customer customer = customerQueue.dequeue();
                Cashier cashier = cashierQueue.dequeue();
                // Start at the later of when the customer arrived or when the next cashier
                // became available
                int start = Math.max(customer.getArrivalTime(), cashier.getNextAvailableTime());
                int departs = start + PROCESS;
                customer.setDepartureTime(departs);
                cashier.setNextAvailableTime(departs);
                totalTime += customer.totalTime();
                // Put the cashier back in the queue to handle another customer
                cashierQueue.enqueue(cashier);
            }

            // Compute average wait time of customers
            int averageTime = totalTime / NUM_CUSTOMERS;

            System.out.println("Number of cashiers: " + cashiers);
            if (averageTime > 120) {
                System.out.println("Average time: " + averageTime / 60 + " minutes.");
                System.out.println();
            } else if (averageTime <= 120) {
                System.out.println("Average time: " + averageTime + " seconds.");
                System.out.println();
            }
        }
    }
}