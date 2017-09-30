import java.lang.*;
import java.util.*;
import java.io.*;
public class Test
{
  public void runtest()
  {
     Car car = new Car();
     car.setcarreg("abc113");
     
     System.out.println(car);
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
