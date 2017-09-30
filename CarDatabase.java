import java.util.*;

public class CarDatabase
{
   private ArrayList<Car> carlist;
   
   /*public CarDatebase()
   {
      carlist = new ArrayList<Car>();
   }*/
   
   public boolean addcar (Car car)
   {
       if (car != null)
       {
           carlist.add(car);
           return true;
        }
       return false;
       
   }
   
   public Car getCar(int index)
   {
       return carlist.get(index);
   }
    
   public ArrayList<Car> getCars()
   {
       return carlist;
   }
   
   public void displayallcars()
   {
       for (Car car : carlist)
       {
           System.out.println(carlist);
        }
   }
}
