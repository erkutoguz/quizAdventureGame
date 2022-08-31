package erkut.java.Item;

public enum Weapon {

	KNIFE("Knife", 2, 25), WUND("Wund", 3, 35), SWORD("Sword", 7, 45);
	public final String name;
	public final int damage;
	public final int cost;

	Weapon(String name, int damage, int cost) {
		this.name = name;
		this.damage = damage;
		this.cost = cost;
	}

	public String toString() {
		return name + "=> Damage: " + damage + ", Cost: " + cost;
	}

}
