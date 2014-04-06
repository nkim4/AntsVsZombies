package proj4;

public abstract class Ant {
	
	private int life;
	private int cost;
	private String desc;
	private int totalLife;
	
	/**
	 * A constructor of the class Ant
	 * Precondition: None
	 * Postcondition: An object of the class Ant
	 * @param life: the amount of life this ant has
	 * @param cost: the cost for this ant
	 * @param desc: the name of the ant
	 */
	protected Ant(int life, int cost, String desc){
		
		this.totalLife = life;
		this.life = life;
		this.cost = cost;
		this.desc = desc;
	}
	/**
	 * This method refills the life of the ant
	 * Precondition: Object of the class Ant
	 * Postcondition: Refills the ant's life to full
	 */
	public void refillLife(){
		this.life = totalLife;
	}
	/**
	 * The method makes an object of the different subclasses of ants depending on the type specified
	 * Precondition: the parameter, type
	 * Postcondition: An object of a subclass of Ant 
	 * @param type: The type of ant, by name, that you want to create
	 * @return: The created subclass of Ant
	 */
	public static Ant makeAnt(char type){
		switch(type){
		
		case 'C': return new CarpenderAnt();
		case 'I': return new CitronellaAnt();
		case 'L': return new LeafcutterAnt();
		case 'F': return new FireAnt();
		case 'A': return new ArmyAnt();
		case 'P': return new PharaohAnt();
		case 'B': return new BulletAnt();
		case 'S': return new SugarAnt();
		case 'T': return new ThiefAnt();
		case 'W': return new WeaverAnt();
		}
		return null;
	}
	/**
	 * A getter that returns the variable life
	 * Precondition: An Object of the class Ant
	 * Postcondition: returns the value of life
	 * @return: the value of life
	 */
	public int getLife(){
		return this.life;
	}
	/**
	 * A getter that returns the variable cost
	 * Precondition: An Object of the class Ant
	 * Postcondition: returns the value of cost
	 * @return: the value of cost
	 */
	public int getCost(){
		return this.cost;
	}
	/**
	 * A getter that returns the String desc
	 * Precondition: An Object of the class Ant
	 * Postcondition: returns the variable desc
	 * @return: the name of the ant
	 */
	public String getDesc(){
		return this.desc;
	}
	/**
	 * A setter that sets the life of the ant
	 * Precondition: An object of the class Ant
	 * Postcondition: Sets the life to the amount
	 * @param amount: The amount you want the life to be
	 */
	public void setLife(int amount){
		this.life = amount;
	}
	/**
	 * This method damages the ant depending on the amount
	 * Precondition: An object of the class Ant
	 * Postcondition: Damages the ant by the amount
	 * @param amount: the amount you want to damage the ant
	 * @param z: The zombie that damaged the ant
	 */
	public void takeDamage(int amount, Zombie z){
		takeDamage(amount);
		
	}
	/**
	 * This method damages the ant depending on the amount
	 * Precondition: An object of the class Ant
	 * Postcondition: Damages the ant by the amount
	 * @param amount: the amount you want to damage the ant
	 */
	public void takeDamage(int amount){
		this.life = this.life - amount;
	}
	/**
	 * An abstract method define later in the subclass
	 * Precondition: An object of the class Ant
	 * Postcondition: The damaged zombie
	 * @param g: the game in which the ant is in
	 */
	public abstract void attack(Game g);
	
}
