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

    public static void levelUp(Hero hero) {

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
        if (hero.equipped[WEAPON] != null)
            hero.attackPnts += hero.equipped[WEAPON].getBuff();

		hero.baseDefencePnts = hero.level * defence;
        hero.defencePnts = hero.baseDefencePnts;
        if (hero.equipped[ARMOUR] != null)
            hero.defencePnts += hero.equipped[ARMOUR].getBuff();

		hero.baseHitPnts = hero.level * hitPoints;
        hero.hitPnts = hero.baseHitPnts;
        if (hero.equipped[HELM] != null)
            hero.hitPnts += hero.equipped[HELM].getBuff();

        hero.experiencePnts -= hero.baseExperiencePnts;
        hero.baseExperiencePnts = hero.level * 1000 + (int)Math.pow(hero.level - 1, 2) * 450;
    }

    public void equipArtifact(Artifact drop){
    	switch (drop.getClass().getSimpleName()) {
			case "Weapon":
				this.equipped[WEAPON] = drop;
				break;
			case "Helm":
				this.equipped[HELM] = drop;
				break;
			case "Armour":
				this.equipped[ARMOUR] = drop;
				break;
		}
		addBuff(drop);
	}

	public void addBuff(Artifact item){
		switch (item.getClass().getSimpleName()) {
			case "Weapon":
				this.attackPnts += item.getBuff();
				this.baseAttackPnts += item.getBuff();
				break;
			case "Helm":
				this.hitPnts += item.getBuff();
				this.baseHitPnts += item.getBuff();
				break;
			case "Armour":
				this.defencePnts += item.getBuff();
				this.baseDefencePnts += item.getBuff();
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
}
