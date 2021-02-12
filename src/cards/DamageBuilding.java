package cards;

import main.Field;

public abstract class DamageBuilding extends Building implements Damaging {
	protected int damage;
	
	public DamageBuilding(Field field, int cost, String name, int health, int damage, BuildingClass buildingClass) {
		super(field, cost, name, health, buildingClass);
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
