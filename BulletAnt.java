/**
 * This class represents a Bullet Ant
 * Class invariants
 * - Bullet Ant must have a food, cost, and description
 */
package proj4;

public class BulletAnt extends Ant{
	/**
	 * Constructor of the class BulletAnt
	 * Precondition: None
	 * Postcondition: An object of the class BulletAnt
	 */
	public BulletAnt(){
		super(1, 10, "Bullet Ant");
	}
	/**
	 * This method attack a zombie in 0th element of the horde by 25
	 * Precondition: Object of the class BulletAnt
	 * Postcondition: Damages the zombie
	 * @param g: The game in which the ant and zombie are in
	 */
	public void attack(Game g){
		
		Zombie z = g.getHorde().elementAt(0);
		z.takeDamage(25);
	}
}
