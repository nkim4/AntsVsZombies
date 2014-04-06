/**
 * This class represents a Fire Ant
 * Class invariants
 * - Fire Ant must have a food, cost, and description
 */
package proj4;

public class FireAnt extends Ant {
	/**
	 * Constructor of the class FireAnt
	 * Precondition: None
	 * Postcondition: An object of the class FireAnt
	 */
	public FireAnt(){
		super(20, 15, "Fire Ant");
	}
	/**
	 * This method attacks a zombie in 0th element of the horde by 30 if flammable, 10 if not
	 * Precondition: Object of the class FireAnt
	 * Postcondition: Damages the zombie
	 * @param g: The game in which the ant and zombie are in
	 */
	public void attack(Game g){
		Zombie z = g.getHorde().elementAt(0);
		if (z instanceof Flammable){
			z.takeDamage(20);
		}
		else{
			z.takeDamage(10);
		}
	}
}