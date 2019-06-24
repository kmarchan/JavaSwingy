package Model.Artifacts;

public class Artifact {
    public static final int HELM = 0;
    public static final int ARMOUR = 1;
    public static final int WEAPON = 2;

    private int abilityBuff;

    public Artifact(int abilityBuff) {
        this.abilityBuff = abilityBuff;
    }

    public int getBuff() {
        return this.abilityBuff;
    }
}
