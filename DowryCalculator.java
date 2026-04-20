import java.util.Scanner;

public class DowryCalculator {

    public static double calculateDowry(int age, String education, double salary,
                                        boolean govtJob, boolean ownsHouse,
                                        boolean ownsCar, int familyStatusScore) {

        double dowry = 0;

        // Base on salary
        dowry += salary * 12 * 2;

        // Age factor
        if (age >= 21 && age <= 25) dowry += 200000;
        else if (age <= 30) dowry += 100000;
        else dowry -= 50000;

        // Education factor
        switch (education.toLowerCase()) {
            case "phd": dowry += 300000; break;
            case "masters": dowry += 200000; break;
            case "bachelors": dowry += 100000; break;
            default: dowry += 50000;
        }

        // Government job bonus
        if (govtJob) dowry += 500000;

        // Assets
        if (ownsHouse) dowry += 300000;
        if (ownsCar) dowry += 150000;

        // Family status (1–10 scale)
        dowry += familyStatusScore * 50000;

        return dowry;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Age: ");
        int age = sc.nextInt();

        System.out.print("Enter Education (PhD/Masters/Bachelors/Other): ");
        String education = sc.next();

        System.out.print("Enter Monthly Salary: ");
        double salary = sc.nextDouble();

        System.out.print("Government Job (true/false): ");
        boolean govtJob = sc.nextBoolean();

        System.out.print("Owns House (true/false): ");
        boolean ownsHouse = sc.nextBoolean();

        System.out.print("Owns Car (true/false): ");
        boolean ownsCar = sc.nextBoolean();

        System.out.print("Family Status Score (1-10): ");
        int familyStatus = sc.nextInt();

        double dowry = calculateDowry(age, education, salary, govtJob, ownsHouse, ownsCar, familyStatus);

        System.out.println("\nEstimated Dowry Value: ₹" + dowry);

        sc.close();
    }
}
