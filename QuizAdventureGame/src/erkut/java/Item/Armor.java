package erkut.java.Item;

public enum Armor {
	LIGHT_ARMOR("Light Armor", 1, 15), MEDIUM_ARMOR("Medium Armor", 3, 25), HEAVY_ARMOR("Heavy Armor", 5, 40);

	public final String name;
	public final int damageReduce;
	public final int cost;

	Armor(String name, int damageReduce, int cost) {
		this.name = name;
		this.damageReduce = damageReduce;
		this.cost = cost;
	}

	public String toString() {
		return name + "=> Damage Reduce: " + damageReduce + ", Cost: " + cost;
	}

}
