package erkut.java.Location;

import erkut.java.Beings.Being;
import erkut.java.Beings.Boss;
import erkut.java.Beings.Player;
import erkut.java.Item.Treasure;

public abstract class BattleLoc extends Location {

	public Being[] creatures;
	public Treasure treasure;
	public Boss creatureLord;

	public BattleLoc(String locName) {
		super(locName);
		creatures = new Being[creatureCount];
	}

	public Being[] getCreatures() {
		return creatures;
	}

	public void welcomeVisitor(Player player) {
		int answer = creatureLord.askQuestion();
		if (player.answerQuestion(answer)) {

				System.out.println();
				System.err.println(creatureLord.getName() + ":");
				System.err.println();
				System.out.println("You had luck. Next time you will be mine.");
				System.out.println("There is your treasure The " + treasure.getName() + " as I promised.");
				player.takeTreasure(treasure);
				giveTreasure();

		} else {
			player.setHealth(0);
			System.out.println();
			System.err.println(creatureLord.getName() + ":");
			System.err.println();
			System.out.println("You foolish " + player.getName() + ".");
			System.out.println("You answered wrong.");
			System.out.println("It will cost your soul. Now your soul is mine!");
		}


	}
	
	public void sendVisitorBack(Player player) {
		System.out.println("Go back. You've taken The " + treasure.getName() + ".");
	}

	public abstract boolean hasTreasure();

	public abstract void giveTreasure();

}
