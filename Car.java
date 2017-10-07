import java.util.*;
public class Car
{
   private String carreg, carmake, carmodel, colour1, colour2, colour3;
   private int yearmade, price;
   
   public void displaymenu()
   {
        System.out.println("Used Car Warehouse Database System");
        System.out.println("====================================");
        System.out.println("(1) Search Cars");
        System.out.println("(2) Add Car");
        System.out.println("(3) Delete Car");
        System.out.println("(4) Exit System");
        System.out.println("====================================");
        System.out.println("Choose an option:");
   }
   
   public void displaymenu2()
   {
        System.out.println("Car Searching Options:");
        System.out.println("====================================");
        System.out.println("(1) By Registration Number");
        System.out.println("(2) By Car Make and Car Model");
        System.out.println("(3) By Age");
        System.out.println("(4) By Price (range)");
        System.out.println("(5) Back to Main Menu");
        System.out.println("====================================");
        System.out.println("Choose an option:");
   }
   
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