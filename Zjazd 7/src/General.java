import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class General implements Serializable {
    private String name;
    private int goldAmount;
    private List<Soldier> army;

    public General(String name, int goldAmount) {
        this.name = name;
        this.goldAmount = goldAmount;
        this.army = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getGoldAmount() {
        return goldAmount;
    }

    public void setGoldAmount(int goldAmount) {
        this.goldAmount = goldAmount;
    }

    public void recruitSoldier(Soldier soldier) {
        int soldierCost = soldier.getRank() * 10;
        if (goldAmount >= soldierCost) {
            army.add(soldier);
            goldAmount -= soldierCost;
        } else {
            System.out.println("Generał " + name + " nie posiada wystarczającej ilości złota, aby zwerbować " + soldier.getName() + ".");
        }
    }

    public void maneuverArmy() {
        int maneuverCost = 5;
        for (Soldier soldier : army) {
            maneuverCost += soldier.getRank();
            soldier.getExperience();
        }
        goldAmount -= maneuverCost;
    }

    public void attack(General enemyGeneral) {
        int totalStrength = calculateTotalStrength();
        int enemyTotalStrength = enemyGeneral.calculateTotalStrength();

        if (totalStrength > enemyTotalStrength) {
            int plunderAmount = (int) (0.1 * enemyGeneral.getGoldAmount());
            goldAmount += plunderAmount;
            enemyGeneral.setGoldAmount(enemyGeneral.getGoldAmount() - plunderAmount);

            for (Soldier soldier : army) {
                soldier.getExperience();
            }
            for (Soldier enemySoldier : enemyGeneral.getArmy()) {
                enemySoldier.getExperience();
            }
        } else if (totalStrength < enemyTotalStrength) {
            int plunderAmount = (int) (0.1 * goldAmount);
            enemyGeneral.setGoldAmount(enemyGeneral.getGoldAmount() + plunderAmount);
            goldAmount -= plunderAmount;

            for (Soldier soldier : army) {
                soldier.getExperience();
            }
            for (Soldier enemySoldier : enemyGeneral.getArmy()) {
                enemySoldier.getExperience();
            }
        } else {
            Random random = new Random();
            Soldier randomSoldier = army.get(random.nextInt(army.size()));
            Soldier randomEnemySoldier = enemyGeneral.getArmy().get(random.nextInt(enemyGeneral.getArmy().size()));

            randomSoldier.getExperience();
            randomEnemySoldier.getExperience();
        }
    }

    private int calculateTotalStrength() {
        int totalStrength = 0;
        for (Soldier soldier : army) {
            totalStrength += soldier.getStrength();
        }
        return totalStrength;
    }

    public List<Soldier> getArmy() {
        return army;
    }

    public void saveState(String filename) {
        try {
            FileOutputStream fileOut = new FileOutputStream(filename);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(this);
            objectOut.close();
            fileOut.close();
            System.out.println("Stan generała został zapisany do pliku: " + filename);
        } catch (IOException e) {
            System.out.println("Błąd podczas zapisu stanu generała: " + e.getMessage());
        }
    }

    public static General loadState(String filename) {
        try {
            FileInputStream fileIn = new FileInputStream(filename);
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);
            General general = (General) objectIn.readObject();
            objectIn.close();
            fileIn.close();
            System.out.println("Stan generała został wczytany z pliku: " + filename);
            return general;
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Błąd podczas wczytywania stanu generała: " + e.getMessage());
            return null;
        }
    }
}
