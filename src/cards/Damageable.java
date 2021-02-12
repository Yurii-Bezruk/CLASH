package cards;

import main.Field;

public abstract class Damageable extends Card {
	protected int health;
	protected boolean alive;
	
	public Damageable(Field field, int cost, String name, int health) {
		super(field, cost, name);
		this.health = health;
		alive = true;
	}
	
	public int getHealth() {
		return health;
	}
	public void setHealth(int health) {		
		if(health <= 0) {
			this.health = 0;
			alive = false;
		}
		else
			this.health = health;
	}
	public void takeDamage(int damagePoint) {
		health-=damagePoint;
		if(health < 0) 
			health = 0;
		if(health == 0)
			alive = false;
	}
	public boolean isAlive() {
		return alive;
	}
	public boolean isDead() {
		return !alive;
	}
}
