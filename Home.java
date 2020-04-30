public class Home implements HomeInterface{
  private String name;
  private int cost;
  
  public Home(String s, int c){
    name = s;
    cost = c;
  }
  
  public String getName(){
    return name;
  }
  
  public int getCost(){
    return cost;
  }
  
}
