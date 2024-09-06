package main;

public abstract class BattleLoc extends Location {
	protected Obstacle obstacle;

	BattleLoc(Player player, String name, Obstacle obstacle) {
		super(player);
		this.obstacle = obstacle;
		this.name = name;
	}

	public boolean getLocation() {
		int obsCount = obstacle.count();
		System.out.println("You are here now: " + this.getName());
		System.out.println("Be careful, there are " + obsCount + " " + obstacle.getName() + " living here !");
		System.out.println("<F>ight or Flig<h>t");
		String selCase = scan.next();
		selCase = selCase.toUpperCase();
		if (selCase.equals("F")) {
			if (combat(obsCount)) {
				System.out.println("You cleared all enemies in the " + this.getName() + " area");
				return true;
			} else {
				System.out.println("You Died");
				return false;
			}
		}
		return true;
	}

	public boolean combat(int obsCount) {
		for (int i = 0; i < obsCount; i++) {
			playerStats();
			enemyStats();
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
}
