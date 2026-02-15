import java.util.Scanner;

// This program defines a Member class to represent gym members in Nepal. It includes attributes such as member name, membership type, monthly fee, and join date. The class provides methods to calculate the annual fee with VAT, get discounted fees, check eligibility for discounts, and display member information. The main method allows users to input their details and see the calculated fees and eligibility for discounts.
class Member {
    String memberName;
    String membershipType; // Monthly, Quarterly, Yearly can be defined as per user need
    double monthlyFee;
    String joinDate;

    // Constructor is defined
    Member(String memberName, String membershipType, double monthlyFee, String joinDate) {
        this.memberName = memberName;
        this.membershipType = membershipType;
        this.monthlyFee = monthlyFee;
        this.joinDate = joinDate;
    }

    // Return the valeu yearly cost with 13% VAT
    double calculateAnnualFee() {
        return monthlyFee * 12 * 1.13;
    }

    // Returns discounted monthly fee
    double getDiscountedFee(double discountPercent) {
        return monthlyFee - (monthlyFee * discountPercent / 100);
    }

    // true for member whose membership is Quarterly
    boolean isEligibleForDiscount() {
        // If joinDate is more than 6 months ago return true
        return joinDate.compareTo("2025-06-27") <= 0;
    }

    // Display member details
    void displayMemberInfo() {
        System.out.println("----------- Gym Membership Details-----------");
        System.out.println("Name         : " + memberName);
        System.out.println(" Membership Type: " + membershipType);
        System.out.println("Monthly fee   : रु " + monthlyFee);
        System.out.println("Joined Date: " + joinDate);
        System.out.println("-----------------------------------");
    }
}

// Main class to run the program
public class GymMemberNepal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);// Scanner object is created to take user input
        // User input for member details
        System.out.print("Enter your name : ");
        String name = sc.nextLine();
        // User input for membership type, monthly fee, and join date
        System.out.print("Membership type (Monthly / Quarterly / Yearly): ");
        String type = sc.nextLine();
        // User input for monthly fee
        System.out.print("Enter the monthly fee: ");
        double fee = sc.nextDouble();
        // User input for join date
        System.out.print("Enter the date you have joined (YYYY-MM-DD): ");
        String dateInput = sc.next();

        Member member = new Member(name, type, fee, dateInput);
        // Display member information and calculate fees
        System.out.println();
        System.out.println("======================================================");
        member.displayMemberInfo();
        System.out.println("======================================================");
        System.out.println("Annual fee with 13% vat: " + member.calculateAnnualFee());
        System.out.println("======================================================");
        if (member.isEligibleForDiscount()) {
            System.out.println("are you student and seniors?");
            System.out.println("Annual fee after Discount:" + member.getDiscountedFee(10));
        } else {
            System.out.println("Not a person to eligible for discount");
        }
        System.out.println("======================================================");

    }
}
// This program allows users to input their gym membership details and
// calculates the annual fee with VAT, checks for discount eligibility, and
// displays the member information in a structured format.
