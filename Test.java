import java.lang.*;
import java.util.*;
import java.io.*;
public class Test
{
  Car car = new Car();
  private CarDatabase newcarlist;
   Calendar c = Calendar.getInstance();
   
     public void displaymenu()
   {
        System.out.println("Used Car Warehouse Database System");
        System.out.println("====================================");
        System.out.println("(1) Search Cars");
        System.out.println("(2) Add Car");
        System.out.println("(3) Delete Car");
        System.out.println("(4) Edit Car");
        System.out.println("(5) Exit System");
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
        System.out.println("(5) By Colour");
        System.out.println("(6) Back to Main Menu");
        System.out.println("====================================");
        System.out.println("Choose an option:");
   }
   
  public Test()
  {
    newcarlist = new CarDatabase();
    
    
  }


  private boolean validOption(char option) //method to check char option
    {
        
        if (option < '1' || option > '5')
        {
            System.out.println("Error : please insert from 1 to 5!");
            return false;
        }
        return true;        
    }
    
  public void run()
  {
    Car car = new Car();
    readFile();
    boolean exit = false;
    Scanner input = new Scanner(System.in);
       while (!exit)
       {
            displaymenu();

            //insert case
            String iobuffer = input.nextLine(); 
            System.out.println("");
            
         if (validBlank(iobuffer,"Option"))
         { 
           char option = iobuffer.charAt(0);
          if (validOption(option))
          {
           switch(option)
           {
                case '1': searchCase();
                        break;
                case '2': addcar();
                        break;
                case '3': deletecar();
                        break;
                case '4': editcar();
                         break;
                case '5': writeFile();
                        exit = true;
                        System.out.println("Goodbye. ");
                        break;
        
               
            }
            
       } 
      
    }
      
      
   }
}

   private void searchCase() //validBlank and validDelSelection to valid case option are between (1) and (2)
    {
        Scanner input = new Scanner(System.in);
         boolean exit = false;
        while (!exit)
       {
        displaymenu2();        
        String iobuffer = input.nextLine();
        char option = ' '; 

        while(validBlank(iobuffer.trim(),"Options"))
            iobuffer = input.nextLine();

        while(validDelSelection(convertStringtoInt(iobuffer.trim()), 6))
        {
            iobuffer = input.nextLine();
            //validate Option is blank
            while(validBlank(iobuffer.trim(),"Options"))    
                iobuffer = input.nextLine();
        }
        option = iobuffer.charAt(0);

        switch (option)
        {
            case '1':                        
            //search car from the reg
            searchcar();
            break;

            case '2':
            searchbycarmm();
            //search 
            break; 
            case '3':searchbyyear();
                    break;
            
            case '4': searchbyprice();
                        break;
            case '5': searchbycolour();
                        break;
            case '6': exit = true;
                      break;
        }
    }}
    
    private void searchbycolour() //not case-sensitive source.toLowerCase().contains(target.toLowerCase())
    {
        System.out.println(" ");
        System.out.println("=== Search Car by Colour ===");
        //input
        Scanner input = new Scanner(System.in);
        System.out.println("Search Car , please insert a keyword to search by colour:");
        String newcolour = input.nextLine().toLowerCase();
       
        while(validBlank(newcolour,"Colour"))
            newcolour = input.nextLine().toLowerCase();
       

        //searchBymake()
        ArrayList<Car> resultList = newcarlist.searchbycolour(newcolour);

        //display Car details

        System.out.println("Search Result");
        for (int j = 0 ; j < resultList.size() ; j++)
        {
            resultList.get(j).displaycarrecord();
        }

        if (resultList.size() == 0)
            System.out.println("No matched result");
       }
       

   
    
    private void searchbyyear()
    {
        System.out.println(" ");
        System.out.println("=== Search Car by Year ===");
        //input
        Scanner input = new Scanner(System.in);
        System.out.println("Search Car , please insert max age:");
        String max = input.nextLine().toLowerCase();
        

        while(validBlanknumber(max))
            max = input.nextLine().toLowerCase();
        System.out.println("Which year now?");    
        System.out.println("1.enter it"); 
        System.out.println("2.use system"); 
        String iobuffer = input.nextLine();
         
        while(validBlanknumber(iobuffer))
            iobuffer = input.nextLine();
            int option =convertStringtoInt(iobuffer) ;
        if(option == 1)
        {
        Scanner input2 = new Scanner(System.in);
        System.out.println("Search Car , please insert year:");
        String year1 = input.nextLine().toLowerCase();
        while(validBlanknumberyear(year1))
            year1 = input.nextLine().toLowerCase();
            int year = convertStringtoInt(year1);
            int maxyear = convertStringtoInt(max);
        
        

        ArrayList<Car> resultList = newcarlist.searchbyyear(maxyear,year);
        for (int j = 0 ; j < resultList.size() ; j++)
        {
            resultList.get(j).displaycarrecord();
        }

        if (resultList.size() == 0)
            System.out.println("No matched result");
        }
        else
        if(option == 2)
        {
            int year = c.get(Calendar.YEAR);
            int maxyear = convertStringtoInt(max);
        
        

        ArrayList<Car> resultList = newcarlist.searchbyyear(maxyear,year);
        for (int j = 0 ; j < resultList.size() ; j++)
        {
            resultList.get(j).displaycarrecord();
        }

        if (resultList.size() == 0)
            System.out.println("No matched result");
        }
        else
        System.out.println("please enter 1-2");
        
        
        
    }
    
    private void searchbyprice()
    {
        System.out.println(" ");
        System.out.println("=== Search Car by Price ===");
        //input
        Scanner input = new Scanner(System.in);
        System.out.println("Search Car , please insert max price:");
        String max = input.nextLine().toLowerCase();
        Scanner input2 = new Scanner(System.in);
        System.out.println("Search Car , please insert min price:");
        String min = input2.nextLine().toLowerCase();

        while(validBlanknumber(max))
            max = input.nextLine().toLowerCase();
        while(validBlanknumber(min))
            min = input2.nextLine().toLowerCase();
        int maxprice = convertStringtoInt(max);
        int minprice = convertStringtoInt(min);
        ArrayList<Car> resultList = newcarlist.searchbyprice(maxprice,minprice);
        for (int j = 0 ; j < resultList.size() ; j++)
        {
            resultList.get(j).displaycarrecord();
        }

        if (resultList.size() == 0)
            System.out.println("No matched result");
    }
    
    private void searchbycarmm() //not case-sensitive source.toLowerCase().contains(target.toLowerCase())
    {
        System.out.println(" ");
        System.out.println("=== Search Car by Make ===");
        //input
        Scanner input = new Scanner(System.in);
        System.out.println("Search Car , please insert a keyword to search by make:");
        String newcarmake = input.nextLine().toLowerCase();
        Scanner input2 = new Scanner(System.in);
        System.out.println("Search Car , please insert a keyword to search by model:");
        String newcarmodel = input2.nextLine().toLowerCase();

        while(validBlank(newcarmake,"Car Make"))
            newcarmake = input.nextLine().toLowerCase();
        while(validBlank(newcarmodel,"Car Model"))
            newcarmodel = input2.nextLine().toLowerCase();

        //searchBymake()
        ArrayList<Car> resultList = newcarlist.searchbymake(newcarmake);

        //display Car details
        if(newcarmodel == "any")
        {
        System.out.println("Search Result");
        for (int j = 0 ; j < resultList.size() ; j++)
        {
            resultList.get(j).displaycarrecord();
        }

        if (resultList.size() == 0)
            System.out.println("No matched result");
       }
       else
       resultList = newcarlist.searchbymodel(newcarmodel);
       System.out.println("Search Result");
        for (int j = 0 ; j < resultList.size() ; j++)
        {
            resultList.get(j).displaycarrecord();
        }

        if (resultList.size() == 0)
            System.out.println("No matched result");

        }

   private void addcar()
  {
    Scanner input = new Scanner(System.in);
    System.out.println("=== Add Car ===");
    System.out.println("Please insert car registration number :");        
    String newcarname = input.nextLine();
    
    
    while (validcarname(newcarname))
    newcarname = input.nextLine();
    while (validBlank(newcarname,"car name"))
    {
        newcarname = input.nextLine();
        while (validcarname(newcarname))
        newcarname = input.nextLine();
    
    }
    
    System.out.println("Please insert car make");
    String newcarmake = input.nextLine();
    while (validBlank(newcarmake,"car make"))
    newcarmake = input.nextLine();
    
    System.out.println("Please insert car model");
    String newcarmodel = input.nextLine();
    while (validBlank(newcarmodel,"car model"))
    newcarmodel = input.nextLine();
    
    System.out.println("Please insert car colour1");
    String newcarcolour1 = input.nextLine();
    while (validBlank(newcarcolour1,"car colour1"))
    newcarcolour1 = input.nextLine();
    
    System.out.println("Please insert car colour2, if havent canbe blank");
    String newcarcolour2 = input.nextLine(); 
    while (validSpace(newcarcolour2))
    newcarcolour2 = input.nextLine();
     
    System.out.println("Please insert car colour3, if havent canbe blank");
    String newcarcolour3 = input.nextLine();
    while (validSpace(newcarcolour3))
    newcarcolour3 = input.nextLine();
    
    
    System.out.println("Please insert car yearmade");
    String newcaryearmade = input.nextLine();
    while (validBlanknumberyear(newcaryearmade))
    newcaryearmade = input.nextLine();
    int newcaryearmadeint = convertStringtoInt(newcaryearmade);
    
    System.out.println("Please insert car price");
    String newcarprice = input.nextLine();
    while (validBlanknumber(newcarprice))
    newcarprice = input.nextLine();
    int newcarpriceint = convertStringtoInt(newcarprice);
    
    car.setcarreg(newcarname);
    car.setcarmake(newcarmake);
    car.setcarmodel(newcarmodel);
    car.setcolour1(newcarcolour1);
    car.setcolour2(newcarcolour2);
    car.setcolour3(newcarcolour3);
    car.setprice(newcarpriceint);
    car.setyearmade(newcaryearmadeint);
    newcarlist.addcar(car);
    
   }
   
   private void deletecar()
   {
       System.out.println("delete car: ");
       Scanner input = new Scanner(System.in);
       System.out.println("=== Search Car to delete : ===");
       System.out.println("Search Car , please insert registration number:");
       String deletecar = input.nextLine().toLowerCase();
       while (validBlank(deletecar,"registration number"))
            deletecar = input.nextLine().toLowerCase();
       ArrayList<Car> delResultList = newcarlist.searchcar(deletecar);
       System.out.println("Search Result");
        for (int j = 0 ; j < delResultList.size() ; j++)
        {
            System.out.print( (j + 1) + ") ");
            delResultList.get(j).displaycarrecord();
        }
       int size = delResultList.size();
       if (size != 0)
        {
 
            newcarlist.deletecar(deletecar);
        }
        else
            System.out.println("No matched cars");
    }
       
       
       

    private void searchcar()
    {
        Scanner input = new Scanner(System.in);
        System.out.println("enter something");
        String newcar = input.nextLine().toLowerCase();
        while(validBlank(newcar,"Car reg"))
            newcar = input.nextLine().toLowerCase();
        ArrayList<Car> resultList = newcarlist.searchcar(newcar);
        //display car details
        System.out.println("Search Result");
        for (int j = 0 ; j < resultList.size() ; j++)
        {
            resultList.get(j).displaycarrecord();
        }

        if (resultList.size() == 0)
            System.out.println("No matched result");
    
    }
    
        private void editcar()
    {
        System.out.println("Edit Car :");        
      
        Scanner input = new Scanner(System.in);

      
        System.out.println("=== Search Car to edit : ===");
        System.out.println("Search Car , please insert registration number:");

        String editKeyword = input.nextLine().toLowerCase();

        while (validBlank(editKeyword,"Title keyword"))
            editKeyword = input.nextLine().toLowerCase();

        ArrayList<Car> editResultList = newcarlist.searchcar(editKeyword);

      
        System.out.println("Search Result");
        for (int j = 0 ; j < editResultList.size() ; j++)
        {
            System.out.print( (j + 1) + ") ");
            editResultList.get(j).displaycarrecord();
        }

        int size = editResultList.size();

        //selection
        if (size != 0)
        {
            System.out.println("Please insert which option number you would select to delete, press 0 to quit :");
            String editcarselection = input.nextLine();
            int index = convertStringtoInt(editcarselection);

            if (index == 0)
                size = 0;
            //validDelSelection (index, delresultList.size());
          while (validDelSelection (index, size))
            {
             editcarselection = input.nextLine();
             index = convertStringtoInt(editcarselection);
             if (index == 0)
                    size = 0;
          
             while (validBlank(editcarselection,"Selection"))
                {    
                    editcarselection = input.nextLine();
                    index = convertStringtoInt(editcarselection);
                    if (index == 0)
                        size = 0;
                }
            }
            System.out.println(editcarselection);

            String editcarname;

            if (size != 0)
                editcarname = editResultList.get(index - 1).getcarreg();
            else
                editcarname = "";

            if (size !=0)
            {
                System.out.println("==== Edit Car ====");

                System.out.println("Please insert colour1 :");        
                //input Actor1's name
                String newcolour1 = input.nextLine();

                while (validBlank(newcolour1,"colour1"))
                    newcolour1 = input.nextLine();

                System.out.println("Please insert colour2:");    
                //input Actor2's name
                String newcolour2 = input.nextLine();

                while (validSpace(newcolour2))
                    newcolour2 = input.nextLine();

                System.out.println("Please insert colour3:");
                //input Actor3's name
                String newcolour3 = input.nextLine();

                while (validSpace(newcolour3))
                    newcolour3 = input.nextLine();

                System.out.println("Please insert price :");
                //input
                String newprice = input.nextLine();

                while (validBlanknumber(newprice))
                    newprice = input.nextLine();

                //Convert String newRating to int newRatingInt
                int newpriceInt = convertStringtoInt(newprice);


                newpriceInt = convertStringtoInt(newprice);
               

            
                int editprice = newpriceInt;
                String editcolour1 = newcolour1;
                String editcolour2 = newcolour2;  
                String editcolour3 = newcolour3;  
                newcarlist.editcar(editcarname,editcolour1,editcolour2,editcolour3,editprice);
               
            }
        }
        else
            System.out.println("No matched cars");
    }
    
   private int convertStringtoInt(String input) //method to convert String to Integer
    {
        //intialised variables
        String S = input;
        int i = 0;
        //try catch to handle NumberFormatException
        try
        {
            // the String to int conversion happens here
            i = Integer.parseInt(input.trim());

            // print out the value after the conversion
            //System.out.println("int i = " + i);
        }
        catch (NumberFormatException nfe)
        {
            System.out.println("NumberFormatException: " + nfe.getMessage() + ", please input an integer!");
        }
        return i;
    }
     public boolean validcarname(String carname)
   {
       //check if car is not in database , and return false to break while loop
       boolean isrepeated = newcarlist.validcarname(carname);
       if (isrepeated)
       {
        System.out.println("Error : car name existed , please insert another car registration number!");
        return isrepeated;
        
        }
        
        return false;
   }
   
    private boolean validBlank(String iobuffer,String subject) //method to check insert any empties or blanks
    {
            if (iobuffer.matches("[a-zA-Z_0-9]*"))
            {
                
        if (subject.equals("Option"))
        {
            //if iobuffer isEmpty or iobuffer.length() > 1 , Error : please insert from (1) to (6)! and return false to break if condition
            if (iobuffer.isEmpty() || iobuffer.length() > 1)
            {
                System.out.println("Error : please insert from 1 to 6 !");
                return false;
            }
            return true;
        }
        else
        if ((subject.equals("car name")))
        {
            if (iobuffer.isEmpty() || iobuffer.length() > 6)
            {
                System.out.println("Error : please insert from 1 - 6 characters or number!");
                return true;
            }
            return false;
        }
        else
        {    
            if (iobuffer.trim().isEmpty())
            {
                System.out.println("Error: " + subject + " shouldn't be blank! Please enter again:");
                return true;
            }
            
        }
        return false;
    }
     System.out.println("Error: " + subject + " shouldn't be #!...Please enter again:");
    return true;
    }
    
    private boolean validBlanknumber(String iobuffer) //method to check insert any empties or blanks
    {
        if (iobuffer.matches("[0-9]*"))
        {
            return false;
        }
        System.out.println("Error:   should be number!...Please enter again:");
        return true;
    }
    
  private boolean validBlanknumberyear(String iobuffer) //method to check insert any empties or blanks
    {
         int yearnow = c.get(Calendar.YEAR);
         if (iobuffer.matches("[0-9]*"))
         {
             if (convertStringtoInt(iobuffer) > yearnow)
             {
                System.out.println("Error:  year should be less than nowyear!...Please enter again:");
             }
            return false;
         }
         System.out.println("Error:   should be number!...Please enter again:");
         return true;
    }
  private void readFile()
    {
        String filename = ("usedcars.txt");
        String cars;
        Car loadFromFile;
        
        try
        {
            FileReader inputFile = new FileReader(filename);
            Scanner parser = new Scanner(inputFile);
            int linecount = 0;
            while (parser.hasNextLine())
            {
                loadFromFile = new Car(); 
                cars = parser.nextLine();
                String[] attribute = cars.split(",");



                System.out.println ("Car"+ (linecount+1));
                loadFromFile.setcarreg(attribute[0]);
                loadFromFile.setcarmake(attribute[5]);
                loadFromFile.setcarmodel(attribute[6]);
                loadFromFile.setcolour1(attribute[2]); 
                loadFromFile.setcolour2(attribute[3]);
                loadFromFile.setcolour3(attribute[4]);
                loadFromFile.setyearmade(convertStringtoInt(attribute[1]));
                loadFromFile.setprice(convertStringtoInt(attribute[7]));
                
                //add movie to the list
                Car newCar = new Car(); 

                


                loadFromFile.displaycarrecord();
                newcarlist.addcar(loadFromFile);
                linecount++; 
            }
            inputFile.close();
        }
        catch(FileNotFoundException exception)
        {
            System.out.println(filename + " not found");
        }
        catch(IOException exception)
        {
            System.out.println("Unexpected I/O error occured");
        }
    }

    private boolean validSpace(String iobuffer) 
    {
        if (iobuffer.matches("[a-zA-Z_0-9]*"))
            {
        if (iobuffer.isEmpty())
            return false;
        else if (iobuffer.charAt(0) == ' ')
        {
            System.out.println("Error: colour name should be space only or start by space character! Please enter again:");
            return true;
        }
        return false;
    }
    System.out.println("Error: colour shouldn't be #!...Please enter again:");
            return true;
    } 
    

    private boolean validDelSelection(int index, int size) //method to check int index
    {
        //check if rating is from 1 to size  and return false to break while loop
        if (index < 0 || index > size)
        {
            System.out.println("Error : please insert from (1) to (" + size +")!");
            System.out.print("Please insert :");
            return true;
        }
        return false;
    }

    
  private void writeFile()
    {
        String filename = ("usedcars.txt");
        String[] cars = new String[8];
        Scanner input = new Scanner(System.in);
        CarDatabase toWriteCarList = new CarDatabase();
        int numberofcars;
        String line = "";
        numberofcars = newcarlist.getnumberofcars();
        //try catch to handle IOException
        try
        {
            PrintWriter outputFile = new PrintWriter (filename);
            
            for (int i = 0 ; i < numberofcars ; i++ )
            {
            cars[0] = newcarlist.getCars().get(i).getcarreg();
            cars[5] = newcarlist.getCars().get(i).getcarmake();
            cars[6] = newcarlist.getCars().get(i).getcarmodel();
            cars[2] = newcarlist.getCars().get(i).getc1();
            cars[3] = newcarlist.getCars().get(i).getc2();
            cars[4] = newcarlist.getCars().get(i).getc3();
            cars[1] = newcarlist.getCars().get(i).getyearmade()+ ""; 
            cars[7] = newcarlist.getCars().get(i).getprice() + ""; 
           
            for (int k = 0 ; k < 8 ; k++ )
                {   
                    //line = cars[0] + "," + cars[1] + "," + .....;
                    if (k != 7)
                        line = line + cars[k] + ",";
                    else
                        line = line + cars[k];
                }
            outputFile.println(line);
            //reset line
            line = "";
              
           
            }
            outputFile.close();    
        }
        catch(IOException exception)
        {
            System.out.println("Unexpected I/O error occured");
        }
    }
}
