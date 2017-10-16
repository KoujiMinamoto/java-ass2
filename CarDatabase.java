import java.util.*;
import java.io.*;

public class CarDatabase
{
   private ArrayList<Car> carlist;
   
   
   public CarDatabase()
   {
      carlist = new ArrayList<Car>();
   }
   
   public boolean addcar (Car newcar)
   {
       if (newcar != null)
       {
           carlist.add(newcar);
           return true;
        }
       return false;
       
   }
   
   public void deletecar(String delCarname)
   {
       boolean isdeleted = false;
       for (int i = 0; i < getnumberofcars() ; i++)
       {
           if(getCars().get(i).getcarreg().equals(delCarname))
           {
               System.out.println(getCars().get(i).getcarreg() + "are deleted.");
               getCars().remove(i);
               isdeleted = true;
            
            }
        
        }
       if (! isdeleted)
       {
            System.out.println(" No matched cars are deleted."); 
       }
    }
   
   public ArrayList<Car> searchcar (String searchthing)
   {
       ArrayList<Car> resultlist = new ArrayList<Car>();
       for (int i = 0; i < getnumberofcars() ; i++)
       {
           if(getCars().get(i).getcarreg().toLowerCase().contains(searchthing))
           resultlist.add(getCars().get(i));
        
       }
       return resultlist;
    
   }
   
   public void editcar(String editcar, String editcolour1 , String editcolour2 ,String editcolour3 ,  int editprice)
    {        
        //set()
        boolean isEdited = false;
        for (int i = 0 ; i < getnumberofcars() ; i++)
        {
            if(getCars().get(i).getcarreg().equals(editcar))
            {
                System.out.println(getCars().get(i).getcarreg() + " are edited.");
                getCars().get(i).setcolour1(editcolour1);
                getCars().get(i).setcolour2(editcolour2);
                getCars().get(i).setcolour3(editcolour3);
                getCars().get(i).setprice(editprice);
               
                isEdited = true;
            }                        
        }        
        if (! isEdited)
        {
            System.out.println(" No matched movies are Edited."); 
        }
    }
    
   public int getnumberofcars()
   {
       
       return carlist.size();
    
   }
   
   public void setCar(Car insertedCar, int index)
   {
        carlist.set(index, insertedCar);
    }
    
   public Car getCar(int index)
   {
       return carlist.get(index);
   }
    
   public ArrayList<Car> getCars()
   {
       return carlist;
   }
   
   public boolean validcarname(String carname)
   {
       //check if car is not in database , and return false to break while loop
       for (int i =0; i < getnumberofcars(); i++)
       {
        if (carname.equals(getCars().get(i).getcarreg()))
        return true;
        }
        
        return false;
   }
   public void displayallcars()
   {
       for (Car car : carlist)
       {
           System.out.println(carlist);
        }
   }
}
