package erkut.java.Location;

import erkut.java.Beings.Player;

public class SafeHouse extends Location {

	public SafeHouse(String locName) {
		super(locName);
	}

	public void renewHealth(Player player) {
		player.setHealth(player.getBaseHealth());
		System.out.println();
		System.out.println("Your health is full now.");
	}

	public void showStats(Player player) {
		System.out.println();
		System.out.println(player);
		player.showTreasures();
	}


}
