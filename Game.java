/**
 * This is the Game.java file posted in the Project4 project
 * description. It contains only the nextFight method. Students
 * must complete the remainder of the Game methods and add the
 * Game instance variables.
 * Class Invariants 
 * - This game must have a colony and a horde
 * 
 * This class represents a game of Ants vs Zombies
 * @Date 4/20/13
 * @author Nicholas Kim
 * @Project CMSC202 - Spring 13 - Project 4
 * @section 10
 */
package proj4;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.Vector;

// SMM, 11/13/12: I renamed Game_MethodOnly to Game before posting
public class Game implements GameInterface {

    /******************** instance variables ********************/
	private int food;
	private Vector<Ant> colony;
	private Vector<Zombie> horde;
	private int roundNumber;
	private char cLast = '0';
	private boolean gameOver;
	private int numOfArmy;
	
    /*************** methods declared in GameInterface ****************/
	/**
	 * Constructor for the class game
	 * Preconditions: None
	 * Postconditions: A object of the class Game
	 */
	public Game(){
		this.food = 100;
		this.roundNumber = 1;
		this.horde = new Vector<Zombie>(0);
		this.colony = new Vector<Ant>(0,1);
		this.gameOver = false;
		this.numOfArmy = 0;
	}
    /**
     * Determine if the invasion is over. If the invasion is over, all
     * remaining ants' health reset to full life.
     * @return true if there are no ants or no zombies remaining.
     */
    public void nextFight() {
		Ant a = colony.elementAt(0);
		a.attack(this);
	
		Zombie z = horde.elementAt(0);
		if ((a instanceof LeafcutterAnt) && (z.getLife() <= 0)) {
		    // leafcutters have first strike, so opposing zombie gets no attack
		}
		else {
		    z.attack(this);
		}
	
		// reap all things dead
		boolean keepReaping = true;
		while (keepReaping) {
			keepReaping = false;
		    for (int i = 0; i < colony.size(); ) {
			a = colony.elementAt(i);
			if (a.getLife() > 0) {
			    i++;
			}
			else {
			    colony.remove(i);
			    if (a instanceof CitronellaAnt) {
				for (Ant a2 : colony) {
				    a2.takeDamage(2);
				}
				for (Zombie z2: horde) {
				    z2.takeDamage(2);
				}
			    }
			    keepReaping = true;
			}
		    }
	
		    for (int i = 0; i < horde.size(); ) {
			z = horde.elementAt(i);
			if (z.getLife() > 0) {
			    i++;
			}
			else {
			    horde.remove(i);
			    food += z.getReward();
			}
		    }
		}
		if (colony.size() == 0 && horde.size() > 0) {
			gameOver = true;
		}
    }
    
    /******************** other methods ********************/
    
    /**
     * A getter for the roundNumber variable of the class Game
     * Precondition: An object of the class Game
     * Postcondition: returns the round number of the game
     * @return roundNumber: the number of the round
     */
    public int getRoundNumber(){
    	return roundNumber;
    }
    
    /**
     * A getter for the food variable of the class Game
     * Precondition: An object of the class Game
     * Postcondition: returns the value of food
     * @return food: The amount of food the player has
     */
    public int getFood(){
    	return food;
    }
    /**
     * A setter for the food variable of the class Game
     * Precondition: An object of the class Game
     * Postcondition: Sets the new value for food
     * @param amount: the new value for food
     */
    public void setFood(int amount){
    	this.food = amount;
    }
    
    /**
     * Recruits a ant into the colony and returns true or false depending on if it was successful in 
     * recruiting that ant
     * Precondition: An object of the class Game
     * Postcondition: returns true or false depending on if the ant was successfully recruited and recruits the ant
     * @return: true or false
     * @param type: the name of the ant you want to recruit 
     */
    public boolean recruitAnt(String type){
    	
    	int price = getAntCost(type);
    	// Checks to see if the player has enough food
    	if (this.food < price){
    		return false;
    	}
    	else{
    		this.colony.addElement(Ant.makeAnt(getIdFromType(type)));
    		// reduces the food by the cost
    		food = food - Ant.makeAnt(getIdFromType(type)).getCost();
    		// records the number of Army ants ever recruited
    		if (type.equals("Army Ant")){
    			this.numOfArmy++;
    		}
    		return true;
    	}
    }
    private char getIdFromType(String type){
    	if (type.equals("Citronella Ant")){
    		return 'I';
    	}
    	else {
    		return type.charAt(0);
    	}
    }
    /**
     * A getter of the variable numOfArmy
     * Precondition: An object of the class Game
     * Postcondition: Returns the value of numOfArmy
     * @return: the number of Army Ants recruited in this game
     */
    public int getArmy(){
    	return numOfArmy;
    }
    
    /**
     * Creates a String of Ants in the colony seperated by a new line
     * Precondition: An object of the class Game
     * Postcondition: Returns a String of the ants in the game's colony
     * @return: a String of ants in the colony
     */
    public String getColonyDesc(){
    	// Initialize the String
    	String col = "";
    	for (Ant a : this.colony){
    		// Puts all the ants in a neat String
    		col = col + a.getDesc() + " - Life: " + a.getLife() + "\n";
    	}
    	return col;
    }
    /**
     * Reads a certain file specified in its parameters and fill the horde with zombies
     * Precondition: An object of the class Game
     * Postcondition: Fills the horde with the zombies in the file
     * @param filename: The name of the file you want to read
     */
    public void readHordeFile(String filename){
    	
		try {
			java.io.FileReader file = new java.io.FileReader(filename);
			java.io.BufferedReader buf = new java.io.BufferedReader(file);
			String zombieString = buf.readLine();
			char ZwaveList[] = zombieString.toCharArray();
	    	for (char c : ZwaveList){
	    		// Checks the see if the next char is a number. 
	    		if (c == '1' || c == '2' ||c == '3' ||c == '4' ||c == '5' ||c == '6' ||c == '7' ||c == '8' || c == '9'){
	    			
	    			// turns the char into a int
	    			int repeat = (int)c - 48;
	    			// Repeats the last zombie made accordingly 
	    			for (int i = 0; i < repeat; i++){
	    				this.horde.addElement(Zombie.makeZombie(cLast));
	    			}
	    		}
	    		else{
	    			this.horde.addElement(Zombie.makeZombie(c));
	    		}
	    		// notes the last zombie made
	    		cLast = c;
	    	}
	    	buf.close();
		} 
		catch (FileNotFoundException e) {
			// returns an error if the file was not found
			System.out.println("File was not found! " + e.getMessage());
		}
		catch (IOException e){
			// returns a error if there is some kind of I/O exception
			System.out.println("Input Output Exception " + e.getMessage());
		}
    }
    
    /**
     * Returns a printable string that lists all the zombies in the horde
     * Precondition: An object of the class Game
     * Postcondition: returns a String of zombies in the horde
     * @return: a String of zombies in the horde
     */
    public String getHordeDesc(){
    	// Initialize the String
    	String hrd = "";
    	for (Zombie z : this.horde){
    		// adds all the zombies in a neat way all in one String
    		hrd = hrd + z.getDesc() + " - Life: " + z.getLife() + "\n";
    	}
    	return hrd;
    }
    
    /**
     * A boolean method that returns true if there are no zombies or if there are no more ants, false otherwise
     * Precondition: An object of the class Game
     * Postcondition: Returns true or false
     * @return: True or false
     */
    public boolean isInvasionOver(){
    
    	// Checks to see if the horde is empty
    	if (horde.isEmpty()){
    		// Increase roundNumber for the next round
    		this.roundNumber = this.roundNumber + 1;
    		for (Ant a : this.colony){
    			a.refillLife();
    		}
    		return true;
    	}
    	// Check to see if you have lost all your ants
    	else if(this.colony.isEmpty() && !this.horde.isEmpty()){
    		return true;
    	}
    	else{
    		return false;
    	}
    }
    /**
     * A method that checks if the game is over after a round
     * Precondition: An object of the class Game
     * Postcondition: Returns true if the player has lost or if the player has completed 5 rounds, false if otherwise
     * @return: true or false
     */
    public boolean isGameOver(){
    	// checks to see if 5 rounds were completed
    	if (this.roundNumber > 5){
    		return true;
    	}
    	else{
    		return this.gameOver;
    	}
    	
    }
    /**
     * This method creates an array of String with all the ant types
     * Precondition: An object of the class Game
     * Postcondition: Returns an array of Ant types
     * @return: An array of Ant types (String)
     */
    public String[] getAntTypes(){
    	// creates an array of Strings with all ant types
    	String[] antTypes = new String[10];
    	antTypes[0] = "Army Ant";
    	antTypes[1] = "Bullet Ant";
    	antTypes[2] = "Carpender Ant";
    	antTypes[3] = "Citronella Ant";
    	antTypes[4] = "Fire Ant";
    	antTypes[5] = "Leafcutter Ant";
    	antTypes[6] = "Pharaoh Ant";
    	antTypes[7] = "Sugar Ant";
    	antTypes[8] = "Thief Ant";
    	antTypes[9] = "Weaver Ant";
    	
    	return antTypes;
    }
    /**
     * Returns a message saying if you won or not
     * Precondition: An object of the class Game
     * Postcondition: A message of your victory and score or of Game Over
     * @return: An ending message depending on your victory or loss
     */
    public String getEndingMessage(){
    	if (colony.isEmpty()){
    		return "Game Over";
    	}
    	else{
    		return "You Win! Score: " + this.getFood();
    	}
    }
    /**
     * A method that returns the cost of a certain ant type
     * Precondition: An object of the class Game
     * Postcondition: Returns the cost of the ant
     * @param type: The name of the ant you want the cost of
     * @return: the cost of the ant
     */
    public int getAntCost(String type){
    	
    	if (type.equals("Carpender Ant") || type.equals("Bullet Ant")){
    		return 10;
    	}
    	else if (type.equals("Fire Ant") || type.equals("Pharaoh Ant") || type.equals("Thief Ant")){
    		return 15;
    	}
    	else if (type.equals("Leafcutter Ant") || type.equals("Sugar Ant") || type.equals("Weaver Ant")){
    		return 20;
    	}
    	else if (type.equals("Citronella Ant")){
    		return 25;
    	}
    	else{
    		return 35;
    	}
    }
    /**
     * A getter for the vector colony in the class Game
     * Precondition: An object of the class Game
     * Postcondition: returns the vector colony
     * @return: The vector colony
     */
    public Vector<Ant> getColony(){
    	return this.colony;
    }
    
    /**
     * A getter for the vector horde in the class Game
     * Precondition: An object of the class Game
     * Postcondition: returns the vector horde
     * @return
     */
    public Vector<Zombie> getHorde(){
    	return this.horde;
    }
    /**
     * A method that removes the players food by a certain amount
     * Precondition: An object of the class Game
     * Postcondition: food is removed by the int by
     * @param by: the amount of food you wish to remove
     */
    public void removeFood(int by){
    	this.food = this.food - by;
    }
    public static void main(String args[]) {
    	// Gives the tester options on important things to test
    	Scanner input = new Scanner(System.in);
    	System.out.println("1 - Read Horde file and fill horde and colony");
    	System.out.println("2 - Test the game over");
    	System.out.print("Please choose what to test: ");
    	int userInput = input.nextInt();
    	switch (userInput){
    	
    	case 1:
    	Game testGame = new Game();
    	// Testing file reading and filling/printing of horde
    	testGame.readHordeFile("horde_1.data");
    	System.out.println(testGame.getHordeDesc());
    	
    	// Testing filling/printing for colony
    	System.out.println(testGame.getFood());
    	testGame.recruitAnt("Carpender Ant");
    	testGame.recruitAnt("Leafcutter Ant");
    	testGame.recruitAnt("Citronella Ant");
    	testGame.recruitAnt("Carpender Ant");
    	System.out.println(testGame.getFood());
    	System.out.println(testGame.getColonyDesc());
    	
    	case 2:
    		Game testGame1 = new Game();
    		testGame1.readHordeFile("horde_1.data");
    		System.out.println(testGame1.getHordeDesc());
    		
    		System.out.println(testGame1.colony.size());
    		System.out.println(testGame1.isGameOver());
    		
    		testGame1.recruitAnt("Carpender Ant");
    		System.out.println(testGame1.getColonyDesc());
    		System.out.println(testGame1.isGameOver());
    }
    	input.close();
}
    }