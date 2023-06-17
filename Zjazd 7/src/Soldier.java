import java.io.Serializable;

public class Soldier implements Serializable {
    private String name;
    private int rank;
    private int experience;

    public Soldier(String name, int i, int i1) {
        this.name = name;
        this.rank = 1;
        this.experience = 1;
    }

    public String getName() {
        return name;
    }

    public int getRank() {
        return rank;
    }

    public int getExperience() {
        return experience;
    }

    public int getStrength() {
        return rank * experience;
    }

    public boolean isDead() {
        return experience <= 0;
    }

    public void promote() {
        if (experience % (5 * rank) == 0) {
            rank++;
            experience = 1;
        }
    }

    public void fight() {
        if (!isDead()) {
            experience--;
            if (experience == 0) {
                System.out.println(name + " zginął w walce!");
            }
        }
    }
}
