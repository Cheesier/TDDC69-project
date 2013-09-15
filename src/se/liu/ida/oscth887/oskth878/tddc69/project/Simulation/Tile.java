package se.liu.ida.oscth887.oskth878.tddc69.project.Simulation;

/**
 * Created with IntelliJ IDEA.
 * User: Oscar
 * Date: 2013-09-15
 * Time: 20:26
 */
public abstract class Tile {
    // who can move over this tile
    static enum EnemyMobility {
        NONE, ALL, GROUND_ONLY, AIR_ONLY
    }

    protected EnemyMobility enemyMobility;
    protected boolean buildable;

    protected Tile(EnemyMobility mobility) {
        enemyMobility = mobility;
    }

    public boolean canMove(Monster.MoveType type) {
        if (enemyMobility == EnemyMobility.NONE) return false;

        switch (type) {
            case GROUND:
                return enemyMobility == EnemyMobility.ALL || enemyMobility == EnemyMobility.GROUND_ONLY;
            case AIR:
                return enemyMobility == EnemyMobility.ALL || enemyMobility == EnemyMobility.AIR_ONLY;
            default:
                System.err.println("Could not calculate the movability for: " + type.name());
                Thread.currentThread().getStackTrace();
                return false;
        }
    }
}
