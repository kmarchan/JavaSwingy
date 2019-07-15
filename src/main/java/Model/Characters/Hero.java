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

	public static void gainExperience(Hero hero, int gain){
        hero.experiencePnts += gain;

        if (hero.experiencePnts >= hero.baseExperiencePnts) {
            levelUp(hero);
        }
    }

    public static void levelUp(Hero hero){

        hero.level++;

        hero.baseAttackPnts += 2;
        hero.attackPnts = hero.baseAttackPnts;
        if (hero.equipped[WEAPON] != null)
            hero.attackPnts += hero.equipped[WEAPON].getBuff();

        hero.baseDefencePnts += 2;
        hero.defencePnts = hero.baseDefencePnts;
        if (hero.equipped[ARMOUR] != null)
            hero.defencePnts += hero.equipped[ARMOUR].getBuff();

        hero.baseHitPnts += 2;
        hero.hitPnts = hero.baseHitPnts;
        if (hero.equipped[HELM] != null)
            hero.hitPnts += hero.equipped[HELM].getBuff();

        hero.experiencePnts -= hero.baseExperiencePnts;
        hero.baseExperiencePnts = hero.level * 1000 + (int)Math.pow(hero.level - 1, 2) * 450;
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

	public void setPreviousPosition(int row, int column) {
	    this.previousPosition[0] = row;
	    this.previousPosition[1] = column;
    }

    public String saveString(){
        return  ", " + name + ", " +
                experiencePnts + ", " +
                type + ", " +
                level + ", " +
                hitPnts + ", " +
                defencePnts + ", " +
				// TODO add saving of weapon armour and helm
                "Weapon, " +
				"Armour, " +
				"Helm";
    }

}
