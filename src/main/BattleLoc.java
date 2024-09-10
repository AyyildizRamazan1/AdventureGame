package main;

public abstract class BattleLoc extends Location {
	protected Obstacle obstacle;
	protected String award;

	BattleLoc(Player player, String name, Obstacle obstacle, String award) {
		super(player);
		this.obstacle = obstacle;
		this.name = name;
		this.award = award;
	}

	public boolean getLocation() {
		int obsCount = obstacle.count();
		System.out.println("You are here now: " + this.getName());
		System.out.println("Be careful, there are " + obsCount + " " + obstacle.getName() + " living here !");
		System.out.print("<F>ight or Flig<h>t: ");
		String selCase = scan.nextLine();
		selCase = selCase.toUpperCase();
		if (selCase.equals("F")) {
			if (combat(obsCount)) {
				System.out.println("You cleared all enemies in the " + this.getName() + " area");
				if (this.award.equals("Food") && player.getInv().isFood() == false) {
					System.out.println(this.award + " You won !");
					player.getInv().setFood(true);
				} else if (this.award.equals("Water") && player.getInv().isWater() == false) {
					System.out.println(this.award + " You won !");
					player.getInv().setWater(true);
				} else if (this.award.equals("Firewood") && player.getInv().isFirewood() == false) {
					System.out.println(this.award + " You won !");
					player.getInv().setFirewood(true);
				}
				return true;
			}
			if (player.getHealthy() <= 0) {
				System.out.println("You Died!");
				return false;
			}
		}
		return true;
	}

	public boolean combat(int obsCount) {
		for (int i = 0; i < obsCount; i++) {
			int defObsHealth = obstacle.getHealth();
			playerStats();
			enemyStats();
			while (player.getHealthy() > 0 && obstacle.getHealth() > 0) {
				System.out.print("<H>it or <R>un: ");
				String selCase = scan.nextLine();
				selCase = selCase.toUpperCase();
				if (selCase.equals("H")) {
					System.out.println("You shot");
					obstacle.setHealth(obstacle.getHealth() - player.getTotalDamage());
					afterHit();
					if (obstacle.getHealth() > 0) {
						System.out.println();
						System.out.println("The monster hit you");
						player.setHealthy(player.getHealthy() - (obstacle.getDamage() - player.getInv().getArmor()));
						afterHit();
					}
				} else {
					return false;
				}
			}
			if (obstacle.getHealth() < player.getHealthy()) {
				System.out.println("You defeated the enemy");
				player.setMoney(player.getMoney() + obstacle.getAward());
				System.out.println("Your current money: " + player.getMoney());
				obstacle.setHealth(defObsHealth);
			} else {
				return false;
			}
			System.out.println("----------------------------");
		}
		return true;
	}

	public void playerStats() {
		System.out.println("Player Values\n---------------------------");
		System.out.println("Healthy: " + player.getHealthy());
		System.out.println("Damage: " + player.getDamage());
		System.out.println("Money: " + player.getMoney());
		if (player.getInv().getDamage() > 0) {
			System.out.println("Weapon: " + player.getInv().getwName());
		}
		if (player.getInv().getArmor() > 0) {
			System.out.println("Armor: " + player.getInv().getaName());
		}
	}

	public void enemyStats() {
		System.out.println("\n" + obstacle.getName() + " Values\n----------------------------------");
		System.out.println("Healthy: " + obstacle.getHealth());
		System.out.println("Damage: " + obstacle.getDamage());
		System.out.println("Award: " + obstacle.getAward());
	}

	public void afterHit() {
		System.out.println("Player Health :" + player.getHealthy());
		System.out.println(obstacle.getName() + " Health: " + obstacle.getHealth());
		System.out.println();
	}
}
