package se.liu.ida.oscth887oskth878.tddc69.project.Simulation;

/**
 * Created with IntelliJ IDEA.
 * User: Oscar
 * Date: 2013-09-15
 * Time: 20:26
 */
public class Tile {
    // who can move over this tile
    static enum MonsterMobility {
        NONE, ALL, GROUND_ONLY, AIR_ONLY
    }

    static enum Type {
        GRASS, SPECIAL
    }

    protected MonsterMobility monsterMobility;
    private boolean buildable = false;
    private Tower tower;
    private Type type;

    protected Tile(MonsterMobility mobility, boolean buildable, Type type) {
        this.monsterMobility = mobility;
        this.buildable = false;
        this.type = type;
    }

    public boolean isBuildable() {
        return (tower != null || buildable); // can only build on if no current tower is placed on tile
    }

    protected void setBuildable(boolean buildable) {
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

    public Type getType() {
        return type;
    }
}