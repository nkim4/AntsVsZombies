/**
 * This class represents a Pharaoh Ant
 * Class invariants
 * - Pharaoh Ant must have a food, cost, and description
 */
package proj4;

public class PharaohAnt extends Ant{
	/**
	 * Constructor of the class PharaohAnt
	 * Precondition: None
	 * Postcondition: An object of the class PharaohAnt
	 */
	public PharaohAnt(){
		super(10,15,"Pharaoh Ant");
	}
	/**
	 * This method attacks a zombie in 0th element of the horde by 30 if Gigantic, 10 otherwise
	 * Precondition: Object of the class PharaohAnt
	 * Postcondition: Damages the zombie
	 * @param g: The game in which the ant and zombie are in
	 */
	public void attack(Game g){
		
		Zombie z = g.getHorde().elementAt(0);
		if (z instanceof Gigantic){
			z.takeDamage(30);
		}
		else{
			z.takeDamage(10);
		}
	}
}
