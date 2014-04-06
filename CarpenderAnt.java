/**
 * This class represents a Carpender Ant
 * Class invariants
 * - Carpender Ant must have a food, cost, and description
 */
package proj4;

public class CarpenderAnt extends Ant {
	/**
	 * A constructor for the class Ant
	 * Precondition: None
	 * Postcondition: An object of the class Carpender Ant
	 */
	public CarpenderAnt(){
		
		super(10, 10, "Carpender Ant");
	}
	/**
	 * The method does damage to the zombie in the horde by 10
	 * Precondition: An object of the class Carpender Ant
	 * Postcondition: Zombie at the 0th element takes 10 damage 
	 */
	public void attack(Game g){
		
		Zombie z = g.getHorde().elementAt(0);
		z.takeDamage(10);
	}
}
