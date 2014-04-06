/**
 * This class represents a Thief Ant
 * Class invariants
 * - Thief Ant must have a food, cost, and description
 */
package proj4;

public class ThiefAnt extends Ant{

	/**
	 * A constructor for the class Thief Ant
	 * Precondition: None
	 * Postcondition: An Object of the class Thief Ant
	 */
	
	public ThiefAnt(){
		super(25,15,"Thief Ant");
	}
	/**
	 * The method damages a zombie at element 0 of horde
	 * Precondition: Object of the class Thief Ant
	 * Postcondition: Zombie takes 0 damage
	 * @param g: The game this object is in
	 */
	public void attack(Game g){
		
		Zombie z = g.getHorde().elementAt(0);
		z.takeDamage(0);
	}
	/**
	 * This method defines how the thief ant takes and reflect damage
	 * Precondition: Object of the class Thief Ant
	 * Postcondition: Damages a zombies by 1/2 of the damage it has received
	 */
	public void takeDamage(int amount, Zombie z){
		takeDamage(amount);
		z.takeDamage(amount/2);
		
	}
	
}
