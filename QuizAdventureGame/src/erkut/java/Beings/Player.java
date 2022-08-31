package erkut.java.Beings;

import java.util.Scanner;

import erkut.java.Item.Armor;
import erkut.java.Item.Treasure;
import erkut.java.Item.Weapon;
import erkut.java.Location.BattleLoc;

public class Player extends Being {
	Scanner sc = new Scanner(System.in);
	Treasure[] collectedTreasures;
	int collectedTreasureCount;
	int baseHealth;
	int baseDamage;
	int armorRate;
	Armor armor;
	Weapon weapon;

	public Player(String name, int damage, int health, int gold) {
		super(name, damage, health, gold);
		this.baseHealth = health;
		this.baseDamage = damage;
		collectedTreasureCount = 0;
		collectedTreasures = new Treasure[3];
	}

	public boolean answerQuestion(int correctIndex) {
		System.out.println("My answer is...");
		System.out.print("Enter between 1-4 => ");
		int answer = sc.nextInt();

		while (answer < 1 || answer > 4) {
			System.out.println();
			System.err.println("Invalid answer");
			System.out.println("Answer the quesiton again...");
			System.out.println("Enter between 1-4 => ");
			answer = sc.nextInt();
		}
		if (correctIndex == answer) {
			return true;
		}
		return false;
	}

	public void showTreasures() {
		System.out.println("I've collected...");
		if(collectedTreasureCount <= 0 ) {
			System.out.println("Nothing so far...");
		}
		for (Treasure t : collectedTreasures) {
			if (t != null)
				System.out.println(t.getName());
		}
	}

	public boolean allTreasuresCollected() {

		for (int i = 0; i < collectedTreasures.length; i++) {
			if (collectedTreasures[i] == null) {
				return false;
			}
		}
		return true;
	}

	public void equip(Armor armor) {
		System.out.println("Equipped: " + armor.name);
		this.armor = armor;
		armorRate = armor.damageReduce;
	}

	public void equip(Weapon weapon) {
		System.out.println("Equipped: " + weapon.name);
		this.weapon = weapon;
		damage = baseDamage;
		damage += weapon.damage;
	}

	public void takeTreasure(Treasure treasure) {

		for (int i = 0; i < collectedTreasures.length; i++) {
			if (collectedTreasures[i] == null && collectedTreasures[i] != treasure) {
				collectedTreasures[i] = treasure;
				break;
			}
		}
		collectedTreasureCount++;
			System.out.println();
			System.out.println("I have found " + treasure.getName() + ".");
			if (collectedTreasureCount != 3) {
				System.out.println("Let's find another " + (3 - collectedTreasureCount) + ".");
			}
			
			

	}

	public boolean hasTreasureFrom(BattleLoc location) {
		return location.hasTreasure();
	}

	public void enterLocation(BattleLoc location) {
		System.out.println();
		System.out.println(
				"I am in " + location.getName() + ". There " + ((location.getCreatureCount() != 1) ? "are" : "is a")
						+ " " + location.creatures[0].getName() + (location.getCreatureCount() != 1 ? "s" : ""));
		System.out.println("I have to prepare myself.");

		for (int i = 0; i < location.creatures.length; i++) {
			battleTillDeath(location.creatures[i]);
			if (!this.isAlive()) {
				break;
			} else {
				setGold(getGold() + location.creatures[i].getGold());
				location.creatures[i] = null;
			}
		}

	}

	public void battleTillDeath(Being being) {
		while (being.isAlive() && this.isAlive()) {
			this.attack(being);
			if (being.isAlive()) {
				being.attack(this);
			}
		}
	}

	public boolean isCollectedFrom(BattleLoc location) {
		if (location.hasTreasure() == true) {
			return false;
		}
		return true;
	}

	public int getBaseHealth() {
		return baseHealth;
	}

	public Armor getArmor() {
		return armor;
	}

	public void setArmor(Armor armor) {
		this.armor = armor;
	}

	public Weapon getWeapon() {
		return weapon;
	}

	public void setWeapon(Weapon weapon) {
		this.weapon = weapon;
	}

	public String toString() {
		return "Player " + name + ", Damage: " + baseDamage + "(+" + ((weapon != null) ? weapon.damage : "0")
				+ "), Health: " + health + ", Gold: "
				+ gold
				+ ((armor != null) ? ", Armor: " + armor.name + "(Damage Taken -" + armor.damageReduce + ")" : "")
				+ ((weapon != null) ? ", Weapon: " + weapon.name : "") + ".";
	}

}
