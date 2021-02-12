package cards;

import main.Field;

public abstract class DamageWarrior extends Warrior implements Damaging{
	protected int damage;
	
	public DamageWarrior(Field field, int cost, String name, int health, int damage, WarriorClass warriorClass) {
		super(field, cost, name, health, warriorClass);
		this.damage = damage;
	}
	public int getDamage() {
		return damage;
	}
	public void setDamage(int damage) {
		this.damage = damage;
	}
	public void attack(Damageable[] line, boolean player) { //пострадавший
		if(line[Field.B(player)] != null) {
			line[Field.B(player)].takeDamage(damage);
		}
		else if(line[Field.A(player)] != null) {
			line[Field.A(player)].takeDamage(damage);
		}
		else {
			field.getHero(player).takeDamage(damage);
			if(field.getHero(player).isDead())
				System.exit(0);
		}
	}
}
