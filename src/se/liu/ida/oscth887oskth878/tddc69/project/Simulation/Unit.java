package se.liu.ida.oscth887oskth878.tddc69.project.Simulation;

import se.liu.ida.oscth887oskth878.tddc69.project.Util.Path;
import se.liu.ida.oscth887oskth878.tddc69.project.Util.Pointf;

/**
 * Created with IntelliJ IDEA.
 * User: Oscar
 * Date: 2013-09-15
 * Time: 20:35
 */
public abstract class Unit implements Placeable {
    public enum MoveType {
        GROUND, AIR
    }

    private int hitpoints;
    private MoveType moveType;
    private int speed;
    private Pointf location;
    private Path path;

    protected Unit(int hitpoints, MoveType moveType, int speed) {
        this.hitpoints = hitpoints;
        this.moveType = moveType;
        this.speed = speed;
    }

    /**
     * Attempt to hurt a unit
     * @param damage an integer specifying how much hitpoints should be taken from the unit
     *               (before any resistance or )
     * @return boolean unit alive status
     */
    public boolean hurt(int damage, Tower.DamageType type) {
        this.hitpoints -= damage;

        return this.hitpoints > 0;
    }

    public int getHitpoints() {
        return hitpoints;
    }

    public MoveType getMoveType() {
        return moveType;
    }

    public Pointf getLocation() {
        return location;
    }

    public int getSpeed() {
        return speed;
    }

    @Override
    public void onSelect() {
        // Spawn the unit on the level, at given position
    }
}
