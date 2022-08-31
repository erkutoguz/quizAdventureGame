package erkut.java.Location;

import erkut.java.Beings.Being;
import erkut.java.Beings.Boss;
import erkut.java.Beings.Player;
import erkut.java.Item.Treasure;

public class Castle extends BattleLoc {

	public static boolean hasTreasure = true;

	public Castle(String locName) {
		super(locName);
		treasure = Treasure.WUND_OF_GOD;
		creatureLord = new Boss("Lord Dracula", 4, 15, 8);
		for (int i = 0; i < creatures.length; i++) {
			creatures[i] = new Being("Vampire", 7, 20, 12);
		}
	}

	@Override
	public boolean hasTreasure() {
		return hasTreasure;
	}

	public void draculaWelcome(Player player) {
		System.out.println();
		System.err.println("Lord Dracula:");
		System.out.println("I've been waiting for you... " + player.getName() + ".");
		System.out.println("My followers tell a lot about you. The Demon Killer.");
		System.out.println("Here you are. You are againts your biggest fear... I The Dracula...");
		System.out.println("You've been through so much obstacles and killed many of my allies.");
		System.out.println("You collected Immortal Trinity... My toolls...");
		System.out.println("I will take them back!");
		System.out.println("Attack my dear vampires!");
		System.out.println();
	}

	@Override
	public void giveTreasure() {
		treasure = null;
		hasTreasure = false;
	}

}
