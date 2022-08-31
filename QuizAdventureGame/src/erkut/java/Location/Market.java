package erkut.java.Location;

import java.util.Scanner;

import erkut.java.Beings.Player;
import erkut.java.Item.Armor;
import erkut.java.Item.Weapon;

public class Market extends Location {
	static Scanner sc = new Scanner(System.in);

	public Market(String locName) {
		super(locName);
		System.out.println();
		System.out.println("Welcome to the market!");
		System.out.println("What do you want to buy? ");
		System.out.print("Armor (a) or Weapon (w) to quit (q) => ");

	}

	
	public void showArmor() {
		System.out.println();
		System.out.println("Armors:");
		System.out.println("1-)" + Armor.LIGHT_ARMOR);
		System.out.println("2-)" + Armor.MEDIUM_ARMOR);
		System.out.println("3-)" + Armor.HEAVY_ARMOR);
		System.out.println("4-)Exit");
	}

	public void showWeapon() {
		System.out.println();
		System.out.println("Weapons:");
		System.out.println("1-)" + Weapon.KNIFE);
		System.out.println("2-)" + Weapon.WUND);
		System.out.println("3-)" + Weapon.SWORD);
		System.out.println("4-)Exit");
	}

	public Armor buyArmor(Player player) {
		System.out.println();
		System.out.print("Select armor => ");
		int select = sc.nextInt();
		while (select < 1 || select > 4) {
			System.err.print("Select valid armor => ");
			select = sc.nextInt();
		}
		if (select == 1 && player.getGold() >= Armor.LIGHT_ARMOR.cost) {
			player.setGold(player.getGold() - Armor.LIGHT_ARMOR.cost);
			return Armor.LIGHT_ARMOR;
		} else if (select == 2 && player.getGold() >= Armor.MEDIUM_ARMOR.cost) {
			player.setGold(player.getGold() - Armor.MEDIUM_ARMOR.cost);
			return Armor.MEDIUM_ARMOR;
		} else if (select == 3 && player.getGold() >= Armor.HEAVY_ARMOR.cost) {
			player.setGold(player.getGold() - Armor.HEAVY_ARMOR.cost);
			return Armor.HEAVY_ARMOR;
		} else if (select == 4) {
			return null;
		} else {
			System.out.println("Sorry you don't have enough money to buy");
			return null;
		}
	}

	public Weapon buyWeapon(Player player) {
		System.out.println();
		System.out.print("Select weapon => ");
		int select = sc.nextInt();
		while (select < 1 || select > 4) {
			System.err.print("Select valid weapon => ");
			select = sc.nextInt();
		}
		if (select == 1 && player.getGold() >= Weapon.KNIFE.cost) {
			player.setGold(player.getGold() - Weapon.KNIFE.cost);
			return Weapon.KNIFE;
		} else if (select == 2 && player.getGold() >= Weapon.WUND.cost) {
			player.setGold(player.getGold() - Weapon.WUND.cost);
			return Weapon.WUND;
		} else if (select == 3 && player.getGold() >= Weapon.SWORD.cost) {
			player.setGold(player.getGold() - Weapon.SWORD.cost);
			return Weapon.SWORD;
		} else if (select == 4) {
			return null;
		} else {
			System.out.println("Sorry you don't have enough money to buy");
			return null;
		}
	}

}
