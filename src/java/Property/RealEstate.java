/*
 * The RealEstate class extends Property, inheriting all parameters from it.
 * This class specifically keeps track of colored properties that is used
 * for holding the number of houses on a particular colored property and 
 * for calculating the rent for these types of properties.
 */
package Property;

import java.util.ArrayList;
import java.util.Arrays;
import Database.RealEstateDatabaseController;

/**
 *
 * @author Kenneth Robertson and Derek Ma
 */
public class RealEstate extends Property {

    private String color;
    private int numberOfHouses;
    private int costOfAHouse;
    private int numberForMonopoly; 
    private ArrayList<Integer> rents;
    
    public static RealEstateDatabaseController database = Database.RealEstateDatabaseController.getInstance();

    /* Constructors - 11 parameters */
    public RealEstate(int owner, int location, String name, int price, int costOfAHouse, boolean hasMortgage,
            String color, int numberOfHouses, int numberForMonopoly, ArrayList<Integer> rents, int gameID) 
    {
        super(owner, location, name, price, gameID); // 7 parameters
        this.color = color;
        this.numberOfHouses = numberOfHouses;
        this.numberForMonopoly = numberForMonopoly;
        this.costOfAHouse = costOfAHouse;
        this.rents = rents;
        this.isMortgaged = hasMortgage;
    }
    
    public RealEstate() {
        super(); // 7 parameters
        this.numberOfHouses = 0;
        this.rents = new ArrayList<Integer>();
    }

    /* Initialize method */
    public void initialize(int owner, int location, String name, int price, int costOfAHouse, boolean hasMortgage,
            String color, int numberOfHouses, int numberForMonopoly, ArrayList<Integer> rents, int gameID) 
    {
        super.initialize(owner, location, name, price, hasMortgage, gameID);
        this.setColor(color);
        this.setNumberOfHouses(numberOfHouses);
        this.setNumberForMonopoly(numberForMonopoly);
        this.setRents(rents);
    }

    
    
    /* Getters */
    public String getColor() {
        return color;
    }
    
    public int getNumberOfHouses() {
        return numberOfHouses;
    }
    
    public int getNumberForMonopoly() {
        return numberForMonopoly;
    }
    
    public ArrayList<Integer> getRents() {
        return rents;
    }

    public int getCostOfAHouse() {
        return costOfAHouse;
    }
    
    

    /* Setters */
    
    @Override
    public void setIsMortgaged(boolean isMortgaged) {
        this.isMortgaged = isMortgaged;
        database.updateRealEstate(this);
    }
    
    @Override
    public void setOwnerID(int ownerID) {
        this.ownerID = ownerID;
        database.updateRealEstate(this);
    }
    
    
    public void setColor(String color) {
        this.color = color;
    }
    
    public void setNumberOfHouses(int numberOfHouses) {
        this.numberOfHouses = numberOfHouses;
        database.updateRealEstate(this);
    }
    
    public void setNumberForMonopoly(int numberOfColorNeededForMonopoly) {
        this.numberForMonopoly = numberOfColorNeededForMonopoly;
    }
    
    public void setRents(ArrayList<Integer> rents) {
        this.rents = rents;
    }

    public void setCostOfAHouse(int costOfAHouse) {
        this.costOfAHouse = costOfAHouse;
    }
    
        

   
    // TO BE RE DONE AS A CASE STATMENT ***************************
    //*******************************************************************
    
    @Override
    /* calculateRent
     * If the player has a colored set monopoly for the color
     * of this set, the rent will be doubled.  With each additional
     * house on the property, the total rent will be the following:
     * 
     * rent for monopolys is either the rent value based on houses on property
     * or two times the normal rent without a monopoly.
     * Game class determines if a colored monopoly exists 
     */
    public int calculateRent(int numOwned) {
        
        int rent = rents.get(0);
        
        if (isMortgaged) return 0;
                
        if (numOwned == numberForMonopoly) {            
            if(numberOfHouses == 0)
                return 2*rents.get(0);
            return rents.get(numberOfHouses);
        }
        else {            
            rent = rents.get(numberOfHouses);
        }
        
        return rent;
    }
   
}

