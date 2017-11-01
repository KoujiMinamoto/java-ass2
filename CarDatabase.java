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
            System.out.println(" No matched cars are Edited."); 
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
    
   public ArrayList<Car> searchbymake(String searchmake) //not case-sensitive source.toLowerCase().contains(target.toLowerCase())
    {
        ArrayList<Car> resultList = new ArrayList<Car>();
        
        for (int i = 0 ; i < getnumberofcars(); i++)
        {
            if(getCars().get(i).getcarmake().toLowerCase().contains(searchmake))
                resultList.add(getCars().get(i));            
        }
                
        return resultList;
    }
    
    public ArrayList<Car> searchbyprice(int maxprice , int minprice) //not case-sensitive source.toLowerCase().contains(target.toLowerCase())
    {
        ArrayList<Car> resultList = new ArrayList<Car>();
        
        for (int i = 0 ; i < getnumberofcars(); i++)
        {
            if(getCars().get(i).getprice() >= minprice && getCars().get(i).getprice() <= maxprice)
               resultList.add(getCars().get(i)); 
        }
                
        return resultList;
    }
    
    public ArrayList<Car> searchbyyear(int maxyear,int year) //not case-sensitive source.toLowerCase().contains(target.toLowerCase())
    {
        ArrayList<Car> resultList = new ArrayList<Car>();
        
        for (int i = 0 ; i < getnumberofcars(); i++)
        {
            if(getCars().get(i).getyearmade() >= (year - maxyear) && getCars().get(i).getyearmade() <= year)
               resultList.add(getCars().get(i)); 
        }
                
        return resultList;
    }
   
   public ArrayList<Car> searchbymodel(String searchmodel) //not case-sensitive source.toLowerCase().contains(target.toLowerCase())
    {
        ArrayList<Car> resultList = new ArrayList<Car>();
        
        for (int i = 0 ; i < getnumberofcars(); i++)
        {
            if(getCars().get(i).getcarmodel().toLowerCase().contains(searchmodel))
                resultList.add(getCars().get(i));            
        }
                
        return resultList;
    }
   
    public ArrayList<Car> searchbycolour(String searchcolour) //not case-sensitive source.toLowerCase().contains(target.toLowerCase())
    {
        ArrayList<Car> resultList = new ArrayList<Car>();
        
        for (int i = 0 ; i < getnumberofcars(); i++)
        {
            if(getCars().get(i).getc1().toLowerCase().contains(searchcolour)||getCars().get(i).getc2().toLowerCase().contains(searchcolour)||getCars().get(i).getc3().toLowerCase().contains(searchcolour))
                resultList.add(getCars().get(i));            
        }
                
        return resultList;
    }
    
   public void displayallcars()
   {
       for (Car car : carlist)
       {
           System.out.println(carlist);
        }
   }
}
