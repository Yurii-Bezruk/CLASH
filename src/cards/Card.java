package cards;

import main.Field;

public abstract class Card {
	protected Field field;
	protected int cost;
	protected String name;	
		
	public Card(Field field, int cost, String name) {
		this.field = field;
		this.cost = cost;
		this.name = name;
	}
	
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}	
}
