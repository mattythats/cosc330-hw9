public class Amenity implements HomeInterface{
  
  private String name;
  private int cost;
  private HomeInterface home;
  
  public Amenity(String s, int c, HomeInterface h){
    name = s;
    cost = c;
    home = h;
  }
  
  public String getName(){
    return home.getName() + " " + name;
  }
  
  public int getCost(){
    return home.getCost() + cost;
  }
  
}
 
