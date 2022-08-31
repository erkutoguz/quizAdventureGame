package erkut.java.Location;

import erkut.java.Beings.Being;
import erkut.java.Beings.Boss;
import erkut.java.Item.Treasure;

public class Cave extends BattleLoc {

	public static boolean hasTreasure = true;

	public Cave(String locName) {
		super(locName);
		treasure = Treasure.GOBLET;
		creatureLord = new Boss("Parademon Bug Lord", 4, 15, 8);
		for(int i = 0; i < creatures.length; i++) {
			creatures[i] = new Being("Parademon", 3, 10, 4);
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
