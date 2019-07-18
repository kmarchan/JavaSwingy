package Model.Artifacts;

import lombok.Getter;

public class Artifact {
    public static final int HELM = 0;
    public static final int ARMOUR = 1;
    public static final int WEAPON = 2;
    @Getter private String name;
    @Getter int abilityBuff;

    public Artifact(String name, int abilityBuff) {
        this.name = name;
    	this.abilityBuff = abilityBuff;
    }

    public int getBuff() {
        return this.abilityBuff;
    }

}
