package cards.warriors;

import cards.DamageWarrior;
import cards.WarriorClass;
import language.Namespace;
import main.Field;

public class Barbarian extends DamageWarrior {
	
	public Barbarian(Field field, Namespace namespace) {
		super(field, 2, namespace.BARBARIAN, 3, 1, WarriorClass.GROUND);
	}
}
