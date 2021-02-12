package cards;

public abstract class Hero {
	protected String name;
	protected int health;
	protected Ability[] abilities;
	protected boolean alive;
	
	public Hero(String name, Ability[] abilities) {
		this.name = name;
		health = 60;
		this.abilities = abilities;
		alive = true;
	}
	
	public String getName() {
		return name;
	}
	public int getHealth() {
		return health;
	}
	public Ability[] getAbilities() {
		return abilities;
	}
	public boolean isAlive() {
		return alive;
	}
	public boolean isDead() {
		return !alive;
	}
	public void takeDamage(int damagePoint) {
		health-=damagePoint;
		if(health < 0) 
			health = 0;
		if(health == 0)
			alive = false;
	}
	
}
