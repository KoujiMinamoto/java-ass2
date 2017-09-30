import java.util.*;
public class Car
{
   private String carreg, carmake, carmodel;
   private String yearmade, price;
   private ListOfColours colourlist;
  
   
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
   public String getyearmade()
   {
       return yearmade;  
   }
   public void setyearmade(String year) 
   {
       yearmade = year;
    }
    public String price()
   {
       return price;  
   }
   public void setprice(String pr) 
   {
       price = pr;
    }
}
