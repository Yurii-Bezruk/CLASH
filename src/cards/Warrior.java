package cards;

import main.Field;

public abstract class Warrior extends Damageable {
	protected WarriorClass warriorClass;
	
	public Warrior(Field field, int cost, String name, int health, WarriorClass warriorClass) {
		super(field, cost, name, health);
		this.warriorClass = warriorClass;
	}
	public WarriorClass getWarriorClass() {
		return warriorClass;
	}
	public void setWarriorClass(WarriorClass warriorClass) {
		this.warriorClass = warriorClass;
	}
}
