package erkut.java.Location;

public abstract class Location {

	String locName;
	int creatureCount;


	public Location(String locName) {
		this.locName = locName;
		this.creatureCount = (int) (Math.random() * 3) + 1;
	}

	public String getName() {
		return locName;
	}

	public int getCreatureCount() {
		return creatureCount;
	}

}
