import java.io.Console;
import java.util.List;
import java.util.ArrayList;

//read length, width, height, weight, distance, gift wrap, and speed of shipping

public class App {
  public static void main(String[] args) {
    Console myConsole = System.console();
    int choice = 1;
    List<Parcel> parcelList = new ArrayList<Parcel>();
    int totalCost = 0;

    while (choice == 1) {
      System.out.println("Welcome to our Shipping Store. Press 1 to prepare a shipment and Press 2 to Quit.");
      choice = Integer.parseInt(myConsole.readLine());

      if (choice == 1) {
        System.out.println("Input package length in centimeters: ");
        int length = Integer.parseInt(myConsole.readLine());
        System.out.println("Input package width in centimeters: ");
        int width = Integer.parseInt(myConsole.readLine());
        System.out.println("Input package height in centimeters: ");
        int height = Integer.parseInt(myConsole.readLine());
        System.out.println("Input package weight in kilograms: ");
        int weight = Integer.parseInt(myConsole.readLine());
        System.out.println("Input package distance in kilometers: ");
        int distance = Integer.parseInt(myConsole.readLine());
        System.out.println("Do you want overnight, 2-day, or ground shipping?");
        String speed = myConsole.readLine();
        System.out.println("Do you want gift wrapping?");
        boolean giftWrap;
        String wrap = myConsole.readLine();
        if (wrap.contains("y")) {
          giftWrap = true;
        } else { giftWrap = false; }

        Parcel newParcel = new Parcel(length, width, height, weight, distance, giftWrap, speed);
        newParcel.calculateVolume();
        newParcel.calculateSurfaceArea();
        newParcel.calculateCost();
        totalCost += newParcel.mCost;
        parcelList.add(newParcel);

        for(Parcel eachParcel : parcelList) {
          System.out.println("-----------");
          System.out.println("Length: "+eachParcel.mLength+"cm");
          System.out.println("Width: "+eachParcel.mWidth+"cm");
          System.out.println("Height: "+eachParcel.mHeight+"cm");
          System.out.println("Surface Area: "+eachParcel.mSurfaceArea+"cm^2");
          System.out.println("Volume: "+eachParcel.mVolume+"cm^3");
          System.out.println("Weight: "+eachParcel.mWeight+"kg");
          System.out.println("Distance: "+eachParcel.mDistance+"km");
          System.out.println("Shipping Method: "+eachParcel.mSpeed);
          System.out.println("Gift Wrapping: "+eachParcel.mGiftWrap);
          System.out.println("Package Cost: $"+eachParcel.mCost);
        }

        System.out.println("Your TOTAL COST is: $"+ totalCost);
      }

    }
  }

}
