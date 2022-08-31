package erkut.java.Item;

public enum Treasure {
	GOBLET("Immortality Goblet"), WUND_OF_GOD("Wund of God"), CROWN("Wizard's King Crown");

	String name;

	Treasure(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}
