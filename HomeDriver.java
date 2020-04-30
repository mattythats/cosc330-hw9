import java.util.Scanner;
import java.util.ArrayList;

public class HomeDriver{

  public static int choose(String prompt, ArrayList<String> nameOptions, ArrayList<Integer> priceOptions, Scanner input){
    System.out.println(prompt);
    System.out.println("Enter the number corresponding to your selection.");
    int choice = -1;
    for(int i = 0; i < nameOptions.size(); i++){
      System.out.println(i+1 + ". " + nameOptions.get(i) + "\t$" + priceOptions.get(i));
    }
    while(choice < 1 || choice > nameOptions.size()){
      choice = input.nextInt();
      input.nextLine();
      if(choice < 1 || choice > nameOptions.size()){
        System.out.println("Invalid choice.");
       }
    }
    return choice-1;
  }

  public static void main(String args[]){
    Scanner input = new Scanner(System.in);
    ArrayList<String> homeNameOptions = new ArrayList<String>();
    ArrayList<Integer> homePriceOptions = new ArrayList<Integer>();
    ArrayList<String> amenityNameOptions = new ArrayList<String>();
    ArrayList<Integer> amenityPriceOptions = new ArrayList<Integer>();
    HomeInterface home;
    char moreAmenities = 't';
    homeNameOptions.add("Colonial Style");
    homeNameOptions.add("Modern Style");
    homePriceOptions.add(10000);
    homePriceOptions.add(15000);
    amenityNameOptions.add("Fence");
    amenityNameOptions.add("Patio");
    amenityNameOptions.add("Pool");
    amenityPriceOptions.add(500);
    amenityPriceOptions.add(1000);
    amenityPriceOptions.add(2500);
    System.out.println("Thank you for choosing HomeDecorator to build your new home!");
    int homeChoice = choose("Choose a home style.", homeNameOptions, homePriceOptions, input);
    home = new Home(homeNameOptions.get(homeChoice),homePriceOptions.get(homeChoice));
    System.out.println("Thank you for selecting a home! Would you like to add a fence, pool, or patio?");
    System.out.println("Enter y or n.");
    while(moreAmenities != 'y' || moreAmenities != 'n'){
      moreAmenities = input.nextLine().toLowerCase().charAt(0);
      if(moreAmenities == 'y' || moreAmenities == 'n'){
        break;
      }
      System.out.println("Invalid choice.");
    }
    while(moreAmenities == 'y'){
      int amenityChoice = choose("Choose an amenity.", amenityNameOptions, amenityPriceOptions, input);
      home = new Amenity(amenityNameOptions.get(amenityChoice), amenityPriceOptions.get(amenityChoice), home);
      System.out.println("Would you like to add another amenity?");   
      while(moreAmenities != 'y' || moreAmenities != 'n'){
        moreAmenities = input.nextLine().toLowerCase().charAt(0);
        if(moreAmenities == 'y' || moreAmenities == 'n'){
          break;
        }
        System.out.println("Invalid choice.");
      }
    }
    System.out.println("You have purchased: " + home.getName() + "\nWith a cost of: $" + home.getCost());
    System.out.println("Thank you for visiting HomeDecorator!");
  }
}