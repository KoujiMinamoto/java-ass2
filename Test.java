import java.lang.*;
import java.util.*;
import java.io.*;
public class Test
{
  Car car = new Car();
  private CarDatabase newcarlist;
  
  public Test()
  {
    newcarlist = new CarDatabase();
    
  }
  public void runtest()
  {
     Car car = new Car();
     car.setcarreg("abc113");
     
     System.out.println(car);
  }
  public int getChoice()
  {
       Scanner choiceScanner = new Scanner(System.in);
       int choice;
       car.displaymenu();
       choice = choiceScanner.nextInt();
       return choice;
       
  }
  public void run()
  {
    
    boolean exit = false;
       while (!exit)
       {
           switch(getChoice())
           {
                case 1: 
                case 2: addcar();
                        break;
                case 3: deletecar();
                        break;
                case 4: exit = true;
                        System.out.println("Goodbye. ");
                        break;
        
               
            }
            
       } 
      
      
      
      
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
    newcarcolour2 = input.nextLine();
     
    System.out.println("Please insert car colour3, if havent canbe blank");
    String newcarcolour3 = input.nextLine();
    newcarcolour3 = input.nextLine();
    
    
    System.out.println("Please insert car yearmade");
    String newcaryearmade = input.nextLine();
    while (validBlank(newcaryearmade,"car yearmade"))
    newcaryearmade = input.nextLine();
    int newcaryearmadeint = convertStringtoInt(newcaryearmade);
    
    System.out.println("Please insert car price");
    String newcarprice = input.nextLine();
    while (validBlank(newcarprice,"car price"))
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
       
       //判断是否在表中，先不写了
       
       
       newcarlist.deletecar(deletecar);
       
       
    
    
    }
    
    private void search()
    {
        Scanner input = new Scanner(System.in);
        System.out.println("enter something");
        String newcar = input.nextLine().toLowerCase();
        while(validBlank(newcar,"Movie Name"))
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
        if (subject.equals("Option"))
        {
            //if iobuffer isEmpty or iobuffer.length() > 1 , Error : please insert from (1) to (5)! and return false to break if condition
            if (iobuffer.isEmpty() || iobuffer.length() > 1)
            {
                System.out.println("Error : please insert from (1) to (6)!");
                return false;
            }
            return true;
        }
        else
        {    
            //iobuffer.trim().isEmpty(), "Error: subject's name shouldn't be blank! Please enter the name again:" and return true to keep while condition
            if (iobuffer.trim().isEmpty())
            {
                System.out.println("Error: " + subject + " shouldn't be blank! Please enter the name again:");
                return true;
            }
        }
        return false;
    }
  /*
  private void readFile()
    {
        String filename = ("cars.txt");
        String cars;
        Car loadFromFile;
        // try catch to handle FileNotFoundException and IOException
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

                for (int i = 0 ; i < attribute.length ; i++)
                {
                   System.out.println (attribute[i]);
                
                   //numbers of Movies
                   //for (int k = 0 ; k < loadFromFile.getNumbersOfElements() ; k++)
                   //{
                   //attributes of Movies
                   //}
                }

                System.out.println ("Car"+ linecount);
                loadFromFile.setcarreg(attribute[0]);
                loadFromFile.setcarmake(attribute[1]);
                loadFromFile.setcarmodel(attribute[2]);
                loadFromFile.setyearmade(attribute[3]);
                loadFromFile.setprice(attribute[4]);
                
                //add movie to the list
                Car newCar = new Car(); 
                ListOfColours newColourList = new ListOfColours();
                //handle String
                ArrayList<String> loadFromFileColourStringList = new ArrayList<String>();
                
                //for loop to handle attribute[2] - attribute[4] 
                for (int i = 0 ; i < (attribute.length - 3) ; i++) 
                {
                    loadFromFileColourStringList.add(attribute[ i + 2 ]);
                    //String newActor2Name = attribute[3];
                    //String newActor3Name = attribute[4];
                }
               
                //actor list (using for loop to handle it)
                ArrayList<Colours> loadFromFileColourList = new ArrayList<Colours>();
                for (int i = 0 ; i < loadFromFileColourStringList.size() ; i++)
                {
                    Colours colour = new Colours();
                    //using loadFromFileActorStringList.get(i) to replace newActorName
                    colour.setName(loadFromFileColourStringList.get(i)); 
                    loadFromFileColourList.add(colour);
                }
               /* loadFromFile.cleanListOfColours();
                loadFromFile.setColourList(loadFromFileColourList);                               
                                
                //use movie.getNumbersOfElement() to replace 6, 6 - 1 = 5
                loadFromFile.setRating(convertStringtoInt(attribute[ loadFromFile.getNumbersOfElements() - 1 ]));
                //loadFromFile.displayMovieRecord();
                loadFromFile.displayCarRecord();
                newCarList.addCar(loadFromFile);
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
*/
  
}
