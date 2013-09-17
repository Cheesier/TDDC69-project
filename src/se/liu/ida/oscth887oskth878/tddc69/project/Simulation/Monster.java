package se.liu.ida.oscth887oskth878.tddc69.project.Simulation;

import se.liu.ida.oscth887oskth878.tddc69.project.Util.Point;

/**
 * Created with IntelliJ IDEA.
 * User: Oscar
 * Date: 2013-09-15
 * Time: 20:35
 */
public abstract class Monster {
    public enum MoveType {
        GROUND, AIR
    }

    private int hitpoints;
    private MoveType moveType;
    private Point location;
    private Point[] tilesToMoveOver;

    protected Monster(int hitpoints, MoveType moveType) {
        this.hitpoints = hitpoints;
        this.moveType = moveType;
    }

    /**
     * Attempt to hurt a monster
     * @param damage an integer specifying how much hitpoints should be taken from the monster
     *               (before any resistance or )
     * @return boolean monsters alive status
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

    public Point getLocation() {
        return location;
    }
}