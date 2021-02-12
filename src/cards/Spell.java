package cards;

import main.Field;

public abstract class Spell extends ActionThrowable {

	public Spell(Field field, int cost, String name) {
		super(field, cost, name);
	}

	@Override
	public void action() {
		// TODO Auto-generated method stub

	}

}
