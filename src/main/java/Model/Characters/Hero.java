package Model.Characters;

import Model.Artifacts.Artifact;

import static Model.Artifacts.Artifact.ARMOUR;
import static Model.Artifacts.Artifact.HELM;
import static Model.Artifacts.Artifact.WEAPON;

public class Hero extends Character {

    public Hero() {
        super();
    }

    public Hero(String name, int level, int experiencePnts, int baseHitPnts, int baseAttackPnts, int baseDefencePnts, Artifact[] equipped) {
        super(name, level, experiencePnts, baseHitPnts, baseAttackPnts, baseDefencePnts, equipped);
    }

	public static void gainExperience(Hero hero, int gain) {
        hero.experiencePnts += gain;

        if (hero.experiencePnts >= hero.baseExperiencePnts) {
            levelUp(hero);
        }
    }

    private static void levelUp(Hero hero) {

        hero.level++;

		int attack = 15;
		int defence = 15;
		int hitPoints = 15;
		switch (hero.getClass().getSimpleName()){
			case "Orc":
				attack = Orc.getAttack();
				defence = Orc.getDefence();
				hitPoints = Orc.getHitPoints();
				break;
			case "Elf":
				attack = Elf.getAttack();
				defence = Elf.getDefence();
				hitPoints = Elf.getHitPoints();
				break;
			case "BlackMage":
				attack = BlackMage.getAttack();
				defence = BlackMage.getDefence();
				hitPoints = BlackMage.getHitPoints();
				break;
			case "Knight":
				attack = Knight.getAttack();
				defence = Knight.getDefence();
				hitPoints = Knight.getHitPoints();
				break;
		}

		hero.baseAttackPnts = hero.level * attack;
    	hero.attackPnts = hero.baseAttackPnts;

		hero.baseDefencePnts = hero.level * defence;
        hero.defencePnts = hero.baseDefencePnts;

		hero.baseHitPnts = hero.level * hitPoints;
        hero.hitPnts = hero.baseHitPnts;

		updateEquipped(hero);
        hero.experiencePnts -= hero.baseExperiencePnts;
        hero.baseExperiencePnts = hero.level * 1000 + (int)Math.pow(hero.level - 1, 2) * 450;
    }

    public void equipArtifact(Hero hero, Artifact drop){
    	switch (drop.getClass().getSimpleName()) {
			case "Weapon":
				this.equipped[WEAPON] = drop;
				break;
			case "Helm":
				hero.hitPnts -= hero.equipped[HELM].getBuff();
				if (hero.hitPnts < 0) {
					hero.hitPnts = 0;
				}				this.equipped[HELM] = drop;
				break;
			case "Armour":
				hero.defencePnts -= hero.equipped[ARMOUR].getBuff();
				if (hero.defencePnts < 0) {
					hero.defencePnts = 0;
				}
				this.equipped[ARMOUR] = drop;
				break;
		}
		addBuff(hero, drop);
	}

	private static void updateEquipped(Hero hero) {
		for (int i = 0; i < hero.equipped.length; i++) {
			addBuff(hero, hero.equipped[i]);
		}
	}

	private static void addBuff(Hero hero, Artifact item){
		switch (item.getClass().getSimpleName()) {
			case "Weapon":
				hero.attackPnts =  hero.baseAttackPnts + item.getBuff();
				break;
			case "Helm":
				hero.hitPnts += item.getBuff();
				break;
			case "Armour":
				hero.defencePnts += item.getBuff();
				break;
		}
	}

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
                ", equipped=" + equipped[WEAPON].getName() + ":" + equipped[WEAPON].getBuff() + ", " +
				equipped[ARMOUR].getName() + ":" + equipped[ARMOUR].getBuff() + ", " +
				equipped[HELM].getName() + ":" + equipped[HELM].getBuff() +
                "}";
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
                equipped[WEAPON].getName() + ", " + equipped[WEAPON].getBuff() + ", " +
				equipped[ARMOUR].getName() + ", " + equipped[ARMOUR].getBuff() + ", " +
				equipped[HELM].getName() + ", " + equipped[HELM].getBuff();
    }


	public String saveStringFirst(){
		return  name + ", " +
				experiencePnts + ", " +
				type + ", " +
				level + ", " +
				hitPnts + ", " +
				defencePnts + ", " +
				equipped[WEAPON].getName() + ", " + equipped[WEAPON].getBuff() + ", " +
				equipped[ARMOUR].getName() + ", " + equipped[ARMOUR].getBuff() + ", " +
				equipped[HELM].getName() + ", " + equipped[HELM].getBuff();
	}
}
