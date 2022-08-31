package erkut.java;

import java.util.Scanner;

import erkut.java.Beings.Boss;
import erkut.java.Beings.Player;
import erkut.java.Item.Armor;
import erkut.java.Item.Weapon;
import erkut.java.Location.Castle;
import erkut.java.Location.Cave;
import erkut.java.Location.Jungle;
import erkut.java.Location.Location;
import erkut.java.Location.Market;
import erkut.java.Location.SafeHouse;

public class Game {

	Player player;
	Boss vampire;
	Location currentLocation;
	Scanner sc = new Scanner(System.in);

	public Game() {

	}

	public void setHero() {
		System.out.println("Before start the game plase select the character you want to play");
		System.out.println("Fighter (Damage: 5, Health: 21, Gold: 15) => f");
		System.out.println("Mage (Damage: 7, Health: 18, Gold: 20) => m");
		System.out.println("Knight (Damage: 8, Health: 24, Gold: 5) => k");
		System.out.print("Select => ");
		char selected = sc.next().charAt(0);

		while (selected != 'f' && selected != 'm' && selected != 'k') {
			System.out.println();
			System.err.print("Enter valid hero => ");
			selected = sc.next().charAt(0);
		}
		if (selected == 'f') {
			player = new Player("Fighter", 5, 21, 15);
		} else if (selected == 'm') {
			player = new Player("Mage", 7, 18, 20);
		} else {
			player = new Player("Knight", 8, 54, 105);
		}
	}

	public void startDialogue() {
		System.out.println();
		System.out.println("Welcome to your adventure Mighty " + player.getName() + "!");
		System.out.println();
		System.out.println("You heard some rumors about a creature kills farmers and drain their blood...");
		System.out.println("Until last night, rumors became truth and truth became inevitable...");
		System.out.println("You woke up because of the noise of settlers.");
		System.out.println("Two farmers attacked by a demon.");
		System.out.println("They were covered in blood.");
		System.out.println("One of the farmers whistled until he died.");
		System.out.println("Dracu.....");
		System.out.println("His last words was that.");
		System.out.println("So you have to protect your home.");
		System.out.println("Your journey starts here " + player.getName() + ".");
		System.out.println("Go find and kill the demon. Kill Dracula Lord of Vampires...");
		System.out.println();

	}

	public void selectLocation() {
		System.out.println("Please tell me where do you want to go?");
		System.out.println("Remember you can find treasures in dangerous locations.");
		System.out.println("SafeHouse (Renew your health) 's'");
		System.out.println("Market (Buy Armor and Weapon) 'm'");
		System.out.println("Cave (1-3 Parademons) 'c'");
		System.out.println("Jungle (1-3 Dark Elves) 'j'");
		System.out.println("Castle (1-3 Vampires) 'd'");
		System.out.print("Enter loc => ");
		char locSelect = sc.next().charAt(0);

		boolean stillSelecting = true;

		while (stillSelecting) {
			switch (locSelect) {
			case 's':
				currentLocation = new SafeHouse("Safe House");
				stillSelecting = false;
				break;
			case 'm':
				currentLocation = new Market("Market");
				stillSelecting = false;
				break;
			case 'c':
				currentLocation = new Cave("Cave");
				stillSelecting = false;
				break;
			case 'j':
				currentLocation = new Jungle("Jungle");
				stillSelecting = false;
				break;
			case 'd':
				if (!Cave.hasTreasure && !Jungle.hasTreasure) {
					currentLocation = new Castle("Castle");
					stillSelecting = false;
				} else {
					System.out.println();
					System.err.println("You can not enter the Castle without collecting other treasures!");
					System.out.println("Select another location:");
					System.out.println("SafeHouse (Renew your health) 's'");
					System.out.println("Market (Buy Armor and Weapon) 'm'");
					System.out.println("Cave (1-3 Parademons) 'c'");
					System.out.println("Jungle (1-3 Dark Elves) 'j'");
					System.out.println("Castle (1-3 Vampires) 'd'");
					System.out.print("Enter loc => ");
					locSelect = sc.next().charAt(0);
				}
				break;
			default:
				System.err.print("You have to select exist locations => ");
				locSelect = sc.next().charAt(0);
				break;
			}
		}
	}

	public void run() {
		startDialogue();
		while (player.isAlive() && !player.allTreasuresCollected()) {
			selectLocation();

			if (currentLocation instanceof SafeHouse) {
				((SafeHouse) currentLocation).renewHealth(player);
				((SafeHouse) currentLocation).showStats(player);
			} else if (currentLocation instanceof Market) {
				Market market = (Market) currentLocation;

				System.out.println();
				char select = sc.next().charAt(0);
				while (select != 'a' && select != 'w' && select != 'q') {
					System.err.print("Select valid item => ");
					select = sc.next().charAt(0);
				}
				if (select == 'a') {
					market.showArmor();
					Armor armor = market.buyArmor(player);
					if (armor != null) {
						player.equip(armor);
					}

				} else if (select == 'w') {
					market.showWeapon();
					Weapon weapon = market.buyWeapon(player);
					if (weapon != null) {
						player.equip(weapon);
					}
				}

			} else if (currentLocation instanceof Cave) {
				Cave cave = (Cave) currentLocation;
				player.enterLocation(cave);

				if (!player.isAlive()) {
					System.out.println("Game Over...");
					break;
				} else {
					if (!player.isCollectedFrom(cave)) {

						cave.welcomeVisitor(player);
					} else {
						cave.sendVisitorBack(player);
					}
				}

			} else if (currentLocation instanceof Jungle) {
				Jungle jungle = (Jungle) currentLocation;

				player.enterLocation(jungle);
				if (!player.isAlive()) {
					System.out.println("Game Over...");
					break;
				} else {
					if (!player.isCollectedFrom(jungle)) {
						jungle.welcomeVisitor(player);
					} else {
						jungle.sendVisitorBack(player);
					}
				}

			} else if (currentLocation instanceof Castle) {
				Castle castle = (Castle) currentLocation;
				castle.draculaWelcome(player);


				player.enterLocation(castle);
				if (!player.isAlive()) {
					System.out.println("Game Over...");
					break;
				} else {
					if (!player.isCollectedFrom(castle)) {
						castle.welcomeVisitor(player);
					} else {
						castle.sendVisitorBack(player);
					}
				}
			}
			System.out.println();
			if (player.allTreasuresCollected()) {
				System.out.println();
				System.out.println("You have done so many things for this village.");
				System.out.println("You are a hero now!");
				System.out.println("Now it's time to rest...");
				System.out.println("Live with your family. You deserve it...");
				System.out.println("Goodbye, our saviour " + player.getName() + "...");
			}
			if (!player.isAlive()) {
				System.out.println();
				System.out.println("You couldn't make it.");
				System.out.println("Your sacrifice will encourage rest of all.");
				System.out.println("Rest in peace.");
				System.out.println("Goodbye, our saviour " + player.getName() + "...");
			}

		}

	}

	public static void main(String[] args) {
		Game game = new Game();
		game.setHero();
		game.run();
	}

}
