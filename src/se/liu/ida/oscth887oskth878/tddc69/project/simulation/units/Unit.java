package se.liu.ida.oscth887oskth878.tddc69.project.simulation.units;

import se.liu.ida.oscth887oskth878.tddc69.project.simulation.Level;
import se.liu.ida.oscth887oskth878.tddc69.project.simulation.Player;
import se.liu.ida.oscth887oskth878.tddc69.project.simulation.towers.Tower;
import se.liu.ida.oscth887oskth878.tddc69.project.simulation.UnitFactory;
import se.liu.ida.oscth887oskth878.tddc69.project.util.Astar;
import se.liu.ida.oscth887oskth878.tddc69.project.util.Path;
import se.liu.ida.oscth887oskth878.tddc69.project.util.Pathfinding;
import se.liu.ida.oscth887oskth878.tddc69.project.util.Pointf;

/**
 * @author Oscar Thunberg (oscth887)
 * @author Oskar Therén   (oskth878)
 * @version 1.0
 * @since 15/09/2013
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
    private UnitFactory.UnitType unitType;
    private Player.Team owner;

    protected Unit(Pointf position, Player.Team owner, int hitpoints, MoveType moveType, float speed, UnitFactory.UnitType unitType) {
        this.position = position;
        this.owner = owner;
        this.hitpoints = hitpoints;
        this.moveType = moveType;
        this.speed = speed;
        this.unitType = unitType;

    }

    public boolean tick() {
        if (hitpoints <= 0)
            return false;

        if (!move())
            return false;

        return true;
    }

    /**
     * Try to move the unit one step forward, with length based on his speed
     *
     * @return <code>true</code> if the unit has a next position
     */
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

    /**
     * Give the unit a new path to the enemy endpoint
     *
     * @param portal endpoint to be reached
     * @param level the level the endpoint is located at
     * @return <code>false</code> if the endpoint is unreachable
     */
    public boolean generatePath(Pointf portal, Level level) {
        path = pathfinding.findPath(this, portal, level);
        if (path == null || path.length() < 1) { // no path to portal was found
            path = new Path();
            return false;
        }
        return true;
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

    public UnitFactory.UnitType getUnitType() {
        return unitType;
    }

    public Player.Team getOwner() {
        return owner;
    }
}
