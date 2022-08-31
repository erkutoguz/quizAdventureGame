package erkut.java.Beings;

public class Being {

	protected String name;
	protected int damage;
	protected int health;
	protected int gold;

	public Being(String name, int damage, int health, int gold) {
		this.name = name;
		this.damage = damage;
		this.health = health;
		this.gold = gold;
	}

	public void attack(Being being) {
		if (being instanceof Player) {
			Player player = (Player) being;
			this.setDamage(this.getDamage() - player.armorRate);
		}
		if (this.isAlive()) {
			being.setHealth(being.getHealth() - damage);
		}
		System.out.println();

		if (being.isAlive() && this.isAlive()) {
			System.out.println(name + " is attacking to " + being.getName());
			System.out.println(being.getName() + " has " + being.getHealth() + " health");
			System.out.println();
		} else if (!being.isAlive()) {
			System.out.println(name + " is attacking to " + being.getName());
			System.out.println(being.getName() + " is killed by " + name);
			System.out.println();
		}


	}


	public boolean isAlive() {
		return health > 0;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public int getGold() {
		return gold;
	}

	public void setGold(int gold) {
		this.gold = gold;
	}

}
