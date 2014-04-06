/**
 * This class represents a Citronella Ant
 * Class invariants
 * - Citronella Ant must have a food, cost, and description
 */
package proj4;

public class CitronellaAnt extends Ant{
	/**
	 * Constructor of the class CitronellaAnt
	 * Precondition: None
	 * Postcondition: An object of the class CitronellaAnt
	 */
	public CitronellaAnt(){
		
		super(25, 25, "Citronella Ant");
	}
	/**
	 * This method attacks a zombie in 0th element of the horde by 10
	 * Precondition: Object of the class CitronellaAnt
	 * Postcondition: Damages the zombie
	 * @param g: The game in which the ant and zombie are in
	 */
	public void attack(Game g){
		Zombie z = g.getHorde().elementAt(0);
		z.takeDamage(10);
	}
	
}
