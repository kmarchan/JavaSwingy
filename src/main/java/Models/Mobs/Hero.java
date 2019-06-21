package Models.Mobs;

import Models.Artifacts.Artifact;
import Models.Items.Item;

import java.util.List;

import static Models.Artifacts.Artifact.*;

public class Hero extends Mob {

    public Hero() {
        super();
    }

    public Hero(String name, int level, int experiencePnts, int maxHitPnts, int maxAttackPnts, int maxDefencePnts, List<Item> backpack, Artifact[] equipped) {
        super(name, level, experiencePnts, maxHitPnts, maxAttackPnts, maxDefencePnts, backpack, equipped);
    }

    public void gainExperince(int gain){
        experiencePnts += gain;

        if (experiencePnts >= maxExperiencePnts) {
            this.levelUp();
        }
    }

    public void levelUp(){

        level++;

        maxAttackPnts += 2;
        attackPnts = maxAttackPnts;
        if (equipped[WEAPON] != null)
            attackPnts += equipped[WEAPON].getBuff();

        maxDefencePnts += 2;
        defencePnts = maxDefencePnts;
        if (equipped[ARMOUR] != null)
            defencePnts += equipped[ARMOUR].getBuff();

        maxHitPnts += 2;
        hitPnts = maxHitPnts;
        if (equipped[HELM] != null)
            hitPnts += equipped[HELM].getBuff();

        experiencePnts -= maxExperiencePnts;
        maxExperiencePnts = level * 1000 + (int)Math.pow(level - 1, 2) * 450;
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
                ", maxHitPnts=" + maxHitPnts +
                ", maxAttackPnts=" + maxAttackPnts +
                ", maxDefencePnts=" + maxDefencePnts +
                ", maxExperiencePnts=" + maxExperiencePnts +
                ", backpack=" + backpack +
                ", equipped=" + equipped +
                '}';
    }
}
