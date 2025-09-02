import java.util.Scanner;

public class EB_Bill {
    public static void main(String[] args) {
        int consumerNumber, connectionType;
        String consumerName;
        float previousReading, currentReading, unitsConsumed, billAmount = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter consumer number: ");
        consumerNumber = scanner.nextInt();
        System.out.print("Enter consumer name: ");
        scanner.nextLine();
        consumerName = scanner.nextLine();

        System.out.print("Enter previous month reading: ");
        previousReading = scanner.nextFloat();

        System.out.print("Enter current month reading: ");
        currentReading = scanner.nextFloat();

        if (currentReading < previousReading) {
            System.out.println("Invalid readings! Current reading must be greater than or equal to previous reading.");
            scanner.close();
            return;
        }

        unitsConsumed = currentReading - previousReading;

        System.out.print("Enter the type of EB connection (1 for Domestic, 2 for Commercial): ");
        connectionType = scanner.nextInt();
        switch (connectionType) {
            case 1: 
                if (unitsConsumed <= 100) {
                    billAmount = unitsConsumed * 1f;
                } else if (unitsConsumed <= 200) {
                    billAmount = 100 * 1f + (unitsConsumed - 100) * 2.5f;
                } else if (unitsConsumed <= 500) {
                    billAmount = 100 * 1f + 100 * 2.5f + (unitsConsumed - 200) * 4f;
                } else {
                    billAmount = 100 * 1f + 100 * 2.5f + 300 * 4f + (unitsConsumed - 500) * 6f;
                }
                break;

            case 2: 
                if (unitsConsumed <= 100) {
                    billAmount = unitsConsumed * 2f;
                } else if (unitsConsumed <= 200) {
                    billAmount = 100 * 2f + (unitsConsumed - 100) * 4.5f;
                } else if (unitsConsumed <= 500) {
                    billAmount = 100 * 2f + 100 * 4.5f + (unitsConsumed - 200) * 6f;
                } else {
                    billAmount = 100 * 2f + 100 * 4.5f + 300 * 6f + (unitsConsumed - 500) * 7f;
                }
                break;

            default:
                System.out.println("Invalid connection type. Please enter 1 for Domestic or 2 for Commercial.");
                scanner.close();
                return;
        }

        System.out.println("\n--- Electricity Bill Summary ---");
        System.out.println("Consumer Number : " + consumerNumber);
        System.out.println("Consumer Name   : " + consumerName);
        System.out.println("Units Consumed  : " + unitsConsumed);
        System.out.println("Connection Type : " + (connectionType == 1 ? "Domestic" : "Commercial"));
        System.out.printf("Total Bill      : ₹%.2f\n", billAmount);

        scanner.close();
    }
}

