/**
 * This class represents a Sugar Ant
 * Class invariants
 * - Sugar Ant must have a food, cost, and description
 */
package proj4;

public class SugarAnt extends Ant{

	/**
	 * Constructor of the class SugarAnt
	 * Precondition: None
	 * Postcondition: An object of the class SugarAnt
	 */
	public SugarAnt(){
		super(20,20,"Sugar Ant");
	}
	/**
	 * This method attacks a zombie in 0th element of the horde by 10, if it kills the zombie, it gives you 5 food
	 * Precondition: Object of the class SugarAnt
	 * Postcondition: Damages the zombie
	 * @param g: The game in which the ant and zombie are in
	 */
	public void attack(Game g){
		
		Zombie z = g.getHorde().elementAt(0);
		z.takeDamage(10);
		if (z.getLife() == 0){
			g.setFood(g.getFood() + 5);
		}
	}
}
