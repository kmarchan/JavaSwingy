package Model.Characters;

import Model.Artifacts.Artifact;
import static Model.Artifacts.Artifact.*;

public class Hero extends Character {

    public Hero() {
        super();
    }

    public Hero(String name, int level, int experiencePnts, int baseHitPnts, int baseAttackPnts, int baseDefencePnts, Artifact[] equipped) {
        super(name, level, experiencePnts, baseHitPnts, baseAttackPnts, baseDefencePnts, equipped);
    }

    public void gainExperience(int gain){
        experiencePnts += gain;

        if (experiencePnts >= baseExperiencePnts) {
            this.levelUp();
        }
    }

    public void levelUp(){

        level++;

        baseAttackPnts += 2;
        attackPnts = baseAttackPnts;
        if (equipped[WEAPON] != null)
            attackPnts += equipped[WEAPON].getBuff();

        baseDefencePnts += 2;
        defencePnts = baseDefencePnts;
        if (equipped[ARMOUR] != null)
            defencePnts += equipped[ARMOUR].getBuff();

        baseHitPnts += 2;
        hitPnts = baseHitPnts;
        if (equipped[HELM] != null)
            hitPnts += equipped[HELM].getBuff();

        experiencePnts -= baseExperiencePnts;
        baseExperiencePnts = level * 1000 + (int)Math.pow(level - 1, 2) * 450;
    }

    public void unequipArtifact(){}
    public void lootEnemy(){}
    public void equipArtifact(){}
    public void save(){}
    public void load(){}

    @Override
    public String toString() {
        return "Hero{" +
                "name='" + name + '\'' +
                ", level=" + level +
                ", attackPnts=" + attackPnts +
                ", defencePnts=" + defencePnts +
                ", hitPnts=" + hitPnts +
                ", experiencePnts=" + experiencePnts +
                ", baseHitPnts=" + baseHitPnts +
                ", baseAttackPnts=" + baseAttackPnts +
                ", baseDefencePnts=" + baseDefencePnts +
                ", baseExperiencePnts=" + baseExperiencePnts +
                ", equipped=" + equipped +
                '}';
    }
}
