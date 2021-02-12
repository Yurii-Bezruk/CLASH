package cards;


public interface Damaging {
	
	public int getDamage();
	public void setDamage(int damage);
	public void attack(Damageable[] line, boolean player);
}
