package se.liu.ida.oscth887oskth878.tddc69.project.simulation;

import se.liu.ida.oscth887oskth878.tddc69.project.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: Oscar
 * Date: 2013-09-15
 * Time: 20:35
 */
public abstract class Unit {
    public static Pathfinding pathfinding = new Astar();
    public enum MoveType {
        GROUND, AIR
    }

    private int hitpoints;
    private MoveType moveType;
    private float speed; // tiles per tick
    private Pointf position;
    private Path path;
    private Player.Team owner;

    protected Unit(Pointf position, Player.Team owner, int hitpoints, MoveType moveType, float speed) {
        this.position = position;
        this.owner = owner;
        this.hitpoints = hitpoints;
        this.moveType = moveType;
        this.speed = speed;
    }

    public void tick() {
        move();
    }

    // returns false if at end of path
    private boolean move() {
        float movePool = speed;

        while (path.hasNext() && movePool > 0) {
            Pointf next = path.next();
            if (position.x != next.x) { // move in x axis
                float distance = Math.abs(position.x - next.x);
                if (movePool > distance) {
                    position.x = next.x;
                    movePool -= distance;
                    continue;
                }
                else {
                    position.x -= ((position.x - next.x)/distance) * movePool;
                    break;
                }
            }
            else if (position.y != next.y) { // move in y axis
                float distance = Math.abs(position.y - next.y);
                if (movePool > distance) {
                    position.y = next.y;
                    movePool -= distance;
                    continue;
                }
                else {
                    position.y -= ((position.y - next.y)/distance) * movePool;
                    break;
                }
            }
            else { // right on top of center of tile
                path.removeLast();
                if (!path.hasNext()) {
                    // damage team
                    // remove self
                    return false;
                }
                continue;
            }
        }
        return true; // can still move
    }

    public void generatePath(Point portal, Level level) {
        path = pathfinding.findPath(this, new Pointf(0, 0), level);
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
        return position;
    }

    public float getSpeed() {
        return speed;
    }
}
