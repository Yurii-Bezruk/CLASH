package cards.warriors;

import cards.DamageWarrior;
import cards.WarriorClass;
import language.Namespace;
import main.Field;

public class Skeleton extends DamageWarrior {

	public Skeleton(Field field, Namespace namespace) {
		super(field, 1, namespace.SKELETON, 1, 1, WarriorClass.GROUND);
	}

}
