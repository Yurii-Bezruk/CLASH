package cards;

import main.Field;

public abstract class Building extends Damageable implements Cyclical{
	protected BuildingClass buildingClass;
	
	public Building(Field field, int cost, String name, int health, BuildingClass buildingClass) {
		super(field, cost, name, health);
		this.buildingClass = buildingClass;
	}
	@Override
	public void everyCycle() {
		takeDamage(1);		
	}
	public BuildingClass getBuildingClass() {
		return buildingClass;
	}
	public void setBuildingClass(BuildingClass buildingClass) {
		this.buildingClass = buildingClass;
	}
}
