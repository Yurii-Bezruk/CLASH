package cards.buildings;

import cards.BuildingClass;
import cards.DamageBuilding;
import cards.Damaging;
import language.Namespace;
import main.Field;

public class Canon extends DamageBuilding implements Damaging {

	public Canon(Field field, Namespace namespace) {
		super(field, 3, namespace.CANON, 3, 2, BuildingClass.GROUND);
	}

}
