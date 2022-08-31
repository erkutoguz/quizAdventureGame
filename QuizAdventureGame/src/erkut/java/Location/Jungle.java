package erkut.java.Location;

import erkut.java.Beings.Being;
import erkut.java.Beings.Boss;
import erkut.java.Item.Treasure;

public class Jungle extends BattleLoc {

	public static boolean hasTreasure = true;

	public Jungle(String locName) {
		super(locName);
		treasure = Treasure.CROWN;
		creatureLord = new Boss("Jungle Elf King", 4, 15, 8);
		for (int i = 0; i < creatures.length; i++) {
			creatures[i] = new Being("Dark Elf", 4, 14, 7);
		}
	}

	@Override
	public boolean hasTreasure() {
		return hasTreasure;
	}

	@Override
	public void giveTreasure() {
		treasure = null;
		hasTreasure = false;
	}

}
