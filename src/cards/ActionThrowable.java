package cards;

import main.Field;

public abstract class ActionThrowable extends Card {

	public ActionThrowable(Field field, int cost, String name) {
		super(field, cost, name);
	}
	public abstract void action();
}
