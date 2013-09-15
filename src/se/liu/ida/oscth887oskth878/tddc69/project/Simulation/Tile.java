package se.liu.ida.oscth887oskth878.tddc69.project.Simulation;

/**
 * Created with IntelliJ IDEA.
 * User: Oscar
 * Date: 2013-09-15
 * Time: 20:26
 */
public abstract class Tile {
    // who can move over this tile
    static enum MonsterMobility {
        NONE, ALL, GROUND_ONLY, AIR_ONLY
    }

    protected MonsterMobility monsterMobility;
    private boolean buildable;
    private Tower tower;

    protected Tile(MonsterMobility mobility) {
        this.monsterMobility = mobility;
        this.buildable = false;
    }

    protected Tile(MonsterMobility monsterMobility, boolean buildable) {
        this.monsterMobility = monsterMobility;
        this.buildable = buildable;
    }

    public boolean canPass(Monster monster) {
        if (monsterMobility == MonsterMobility.NONE) return false;
        if (tower != null && !tower.canPass(monster)) return false;

        switch (monster.getMoveType()) {
            case GROUND:
                return monsterMobility == MonsterMobility.ALL || monsterMobility == MonsterMobility.GROUND_ONLY;
            case AIR:
                return monsterMobility == MonsterMobility.ALL || monsterMobility == MonsterMobility.AIR_ONLY;
            default:
                System.err.println("Could not calculate the movability for: " + monster.getMoveType().toString());
                Thread.currentThread().getStackTrace();
                return false;
        }
    }
}
