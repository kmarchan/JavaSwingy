package Models.Mobs;

import Models.Artifacts.Artifact;
import Models.Items.Item;

import java.util.ArrayList;
import java.util.List;

import static Models.Artifacts.Artifact.*;
import static Models.Artifacts.Artifact.HELM;

public abstract class Mob {

    protected String name;
    protected int level;
    protected int attackPnts;
    protected int defencePnts;
    protected int hitPnts;
    protected int experiencePnts;
    protected int maxHitPnts;
    protected int maxAttackPnts;
    protected int maxDefencePnts;
    protected int maxExperiencePnts;
    protected List<Item> backpack = new ArrayList<Item>();
    protected Artifact[] equipped = new Artifact[3];

    public Mob() {
        this.name = "undefined";
        this.level = 0;
        this.attackPnts = 0;
        this.defencePnts = 0;
        this.hitPnts = 0;
        this.experiencePnts = 0;
        this.backpack = null;
        this.equipped = null;
    }

    public Mob(String name, int level, int experiencePnts, int maxHitPnts, int maxAttackPnts, int maxDefencePnts, List<Item> backpack, Artifact[] equipped) {
        this.name = name;
        this.level = level;

        this.maxAttackPnts = maxAttackPnts;
        attackPnts = maxAttackPnts;
        if (equipped[WEAPON] != null)
            attackPnts += equipped[WEAPON].getBuff();

        this.maxDefencePnts = maxDefencePnts;
        defencePnts = maxDefencePnts;
        if (equipped[ARMOUR] != null)
            defencePnts += equipped[ARMOUR].getBuff();

        this.maxHitPnts = maxHitPnts;
        hitPnts = maxHitPnts;
        if (equipped[HELM] != null)
            hitPnts += equipped[HELM].getBuff();

        this.experiencePnts -= maxExperiencePnts;
        maxExperiencePnts = level * 1000 + (int)Math.pow(level - 1, 2) * 450;
        this.backpack = backpack;
        this.equipped = equipped;
    }

    public void attack(){}

    public void defend(){}

    public void takeDamage(){}

    public void gainHitPnts(){}
}
