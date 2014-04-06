/**
 * This class represents a Weaver Ant
 * Class invariants
 * - Weaver Ant must have a food, cost, and description
 */
package proj4;

public class WeaverAnt extends Ant{
	/**
	 * A constructor of the class Weaver Ant
	 * Precondition: None
	 * Postcondition: An object of the class WeaverAnt
	 */
	public WeaverAnt(){
		super(10,20,"Weaver Ant");
	}
	/**
	 * This method attacks a zombie in the 1 element of the horde
	 * Precondition: Object of the class WeaverAnt
	 * Postcondition: Damages the zombie
	 * @param g: The game in which the ant and zombie is in
	 */
	public void attack(Game g){
		try{
			// tries to attack the zombie behind the first
			Zombie z = g.getHorde().elementAt(1);
			z.takeDamage(15);
		}
		// if there is no zombie behind the first it does nothing
		catch(ArrayIndexOutOfBoundsException e){
			
		}
	}
}
