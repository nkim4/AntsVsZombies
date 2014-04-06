/**
 * This class represents a Army Ant
 * Class invariants
 * - Army Ant must have a food, cost, and description
 */
package proj4;

public class ArmyAnt extends Ant{
	/**
	 * Constructor of the class ArmyAnt
	 * Precondition: None
	 * Postcondition: An object of the class ArmyAnt
	 */
	public ArmyAnt(){
		super(30,35,"Army Ant");
	}
	/**
	 * The method attacks a zombie in the amount that depends on the number or Army ants recruited this game
	 * Precondition: An object of the class ArmyAnt
	 * Postcondition: Damages the zombie
	 * @param g: The game in which the ant and zombie are in
	 */
	public void attack(Game g){
		
		Zombie z = g.getHorde().elementAt(0);
		
		z.takeDamage(10 + 5 * g.getArmy());
	}
}
