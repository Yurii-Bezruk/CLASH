package cards;

import main.Field;

public abstract class ShieldWarrior extends DamageWarrior {
	protected int shield;
	
	public ShieldWarrior(Field field, int cost, String name, int health, int damage, int shield, WarriorClass warriorClass) {
		super(field, cost, name, health, damage, warriorClass);
		this.shield = shield;
	}
	public int getShield() {
		return shield;
	}
	public void setShield(int shield) {
		this.shield = shield;
	}
	@Override
	public void takeDamage(int damagePoint) {
		if(shield > 0) {
			if(shield >= damagePoint)
				shield-=damagePoint;			
			else 
				shield = 0;
		}
		else super.takeDamage(damagePoint);
	}
}
