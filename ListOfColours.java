import java.util.*;
public class ListOfColours
{   
    private ArrayList<Colours> coloursList;
    private int sampleSize;
    public ListOfColours()
    {
        
       coloursList = new ArrayList<Colours>();
       sampleSize = 3;
       
    }
    
    public String getStringOfListOfColours()
    {
        int listSize = coloursList.size();
        String listString = coloursList.get(0).getName();
        for (int i = 1 ; i < listSize ; i++ )
            listString = listString + "," + coloursList.get(i).getName();
        return listString;
    }
    public void setListOfColours(ArrayList<Colours> newColourlist)
    {              
        //change to pass arraylist (set it before pass)
        for (int i = 0 ; i < newColourlist.size() ; i++ )
            coloursList.add(newColourlist.get(i));
        //actorsList.add(newActorlist.get(1));
        //actorsList.add(newActorlist.get(2));
    }    
}
