/**
 * This class represents a Leafcutter Ant
 * Class invariants
 * - Leafcutter Ant must have a food, cost, and description
 */
package proj4;

public class LeafcutterAnt extends Ant{
	/**
	 * Constructor of the class LeafcutterAnt
	 * Precondition: None
	 * Postcondition: An object of the class LeafcutterAnt
	 */
	public LeafcutterAnt(){
		super(10, 20, "Leafcutter Ant");
	}
	/**
	 * This method attacks a zombie in 0th element of the horde by 10
	 * Precondition: Object of the class LeafcutterAnt
	 * Postcondition: Damages the zombie
	 * @param g: The game in which the ant and zombie are in
	 */
	public void attack(Game g){
		Zombie z = g.getHorde().elementAt(0);
		z.takeDamage(10);
	}
	
}