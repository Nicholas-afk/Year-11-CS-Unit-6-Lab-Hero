import java.util.Random;

class Hero {
    String name;
    int hitPoints;

    Hero(String name) {
        this.name = name;
        this.hitPoints = 100;
    }

    String getName() {
        return this.name;
    }

    int getHitPoints() {
        return this.hitPoints;
    }

    public String toString() {
        return "Hero{" +
                "name='" + this.name + '\'' +
                ", hitPoints=" + this.hitPoints +
                '}';
    }

    void attack(Hero opponent) {
        Random random = new Random();
        double randomNumber = random.nextDouble();

        if (randomNumber < 0.5) {
            opponent.hitPoints -= 10;
        } else {
            this.hitPoints -= 10;
        }
    }

    void senzuBean() {
        this.hitPoints = 100;
    }

    private void fightUntilTheDeathHelper(Hero opponent) {
        while (this.hitPoints > 0 && opponent.hitPoints > 0) {
            this.attack(opponent);
        }
    }

    String fightUntilTheDeath(Hero opponent) {
        fightUntilTheDeathHelper(opponent);
        if (this.hitPoints == 0 && opponent.hitPoints == 0) {
            return "It's a draw!";
        } else if (this.hitPoints == 0) {
            return opponent.name + " wins!";
        } else {
            return this.name + " wins!";
        }
    }

    private String nFightsToTheDeathHelper(Hero opponent, int n) {
        int hero1Wins = 0;
        int hero2Wins = 0;

        for (int i = 0; i < n; i++) {
            this.hitPoints = 100;
            opponent.hitPoints = 100;
            fightUntilTheDeathHelper(opponent);
            if (this.hitPoints <= 0 && opponent.hitPoints <= 0) {
            } else if (this.hitPoints <= 0) {
                hero2Wins++;
            } else {
                hero1Wins++;
            }
        }

        return this.name + ": " + hero1Wins + " wins, " + opponent.name + ": " + hero2Wins + " wins";
    }

    String nFightsToTheDeath(Hero opponent, int n) {
        return nFightsToTheDeathHelper(opponent, n);
    }

    public String dramaticFightToTheDeath(Hero opponent) {
        while (this.hitPoints > 0 && opponent.hitPoints > 0) {
            this.attack(opponent);
            System.out.println(this.name + ": " + this.hitPoints + "  " + opponent.name + ": " + opponent.hitPoints);
        }

        if (this.hitPoints <= 0 && opponent.hitPoints <= 0) {
            return "It's a draw!";
        } else if (this.hitPoints <= 0) {
            return opponent.name + " wins!";
        } else {
            return this.name + " wins!";
        }
    }
}
