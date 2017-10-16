import java.util.*;
public class Car
{
   private String carreg, carmake, carmodel, colour1, colour2, colour3;
   private int yearmade, price;
   

   
   public Car()
   {
       carreg = "";
       carmake = "";
       carmodel = "";
       colour1 = "";
       colour2 = "";
       colour3 = "";
       yearmade = 0;
       price = 0;
       
   }
  
   public void displaycarrecord()
    {
        //method to test displaying attributes of the movie
        System.out.print(carreg + ",");
        System.out.print(carmake + ",");
        System.out.print(carmodel + ",");
        System.out.print(colour1 + ",");
        System.out.print(colour2 + ",");
        System.out.print(colour3 + ",");
        System.out.print(yearmade + ",");
        System.out.println(price + ",");
    }
   public String getcarreg()
   {
       return carreg;  
   }
   
   public void setcarreg(String reg) 
   {
       carreg = reg;
    }
    
    public String getcarmake()
   {
       return carmake;  
   }
   
   public void setcarmake(String make) 
   {
       carmake = make;
    }
    
   public String getcarmodel()
   {
       return carmodel;  
   }
   
   public void setcarmodel(String model) 
   {
       carmodel = model;
    }
    
   public int getyearmade()
   {
       return yearmade;  
   }
   
   public void setyearmade(int year) 
   {
       yearmade = year;
    }
    
    public int getprice()
   {
       return price;  
   }
   
   public void setprice(int pr) 
   {
       price = pr;
    }
    
     public String getc1()
   {
       return colour1;  
   }
   
   public void setcolour1(String c1) 
   {
       colour1 = c1;
    }
    
   public String getc2()
   {
       return colour2;  
   }
   
   public void setcolour2(String c2) 
   {
       colour2 = c2;
   }
   
    public String getc3()
   {
       return colour3;  
   }
   
   public void setcolour3(String c3) 
   {
       colour3 = c3;
   }
}