package User;

/**
 *
 * @author John
 * 
 * Summary: The User class allows different actions for a User. A User is someone who can browse the
website, register, login, logout, get login username and password from the database, and 
change password.
 */
public class User
{
    private int userID;
    private int playerID;
    private String username;
    private String firstName;
    private String lastName;
    private String password;

    // default empty constructor needed for JSP/Servlets and Database Classes
    public User(){
        
    }

    // initializer needed by the Database Class
    public void initializeUser(int userID, String username, String password, String firstName, String lastName){
        this.userID = userID;
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.playerID = -1;
    }
    
    
    // initializer without user ID
    public void initializeUser(String username, String password, String firstName, String lastName)
    {
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.playerID = -1;
    }
    
    
    public void setUsername(String username){
        this.username = username;
    }
    
    public String getUsername(){
        return username;
    }
    
    public void setPassword(String password){
        this.password = password;
    }

    public String getPassword(){
        return password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    // the database gives the user a player id when the player is created at the start of a game
    public void setPlayerID(int id){
        playerID = id;
    }

    public int getPlayerID(){
        return playerID;
    }
   
    // id is auto assigned by the database when the user is created the first time by registering
    public void setUserID(int id){
        userID = id;
    }

    public int getUserID(){
        return userID;
    }
}
