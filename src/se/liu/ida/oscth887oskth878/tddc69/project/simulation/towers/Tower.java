package se.liu.ida.oscth887oskth878.tddc69.project.simulation.towers;

import se.liu.ida.oscth887oskth878.tddc69.project.simulation.Player;
import se.liu.ida.oscth887oskth878.tddc69.project.simulation.Tile;
import se.liu.ida.oscth887oskth878.tddc69.project.simulation.TowerFactory;
import se.liu.ida.oscth887oskth878.tddc69.project.simulation.units.Unit;
import se.liu.ida.oscth887oskth878.tddc69.project.util.Point;
import se.liu.ida.oscth887oskth878.tddc69.project.util.Pointf;

import java.util.Iterator;

/**
 * The base for all towers, extends <code>Tile</code> for the benefit of collision.
 *
 * @author Oscar Thunberg (oscth887)
 * @author Oskar Therén   (oskth878)
 * @version 1.0
 * @since 15/09/2013
 */
public class Tower extends Tile {
    private int damage;
    private float range;
    private int cooldown;
    private int cooldownLeft;
    private TowerFactory.TowerType towerType;

    protected Tower(TowerFactory.TowerType type, UnitMobility unitMobility, int damage, float range, int cooldown, Player.Team owner) {
        super(unitMobility, false, Type.TOWER, owner);
        this.towerType = type;
        this.damage = damage;
        this.range = range;
        this.cooldown = cooldown;
        this.cooldownLeft = cooldown;
    }

    public TowerFactory.TowerType getTowerType() {
        return this.towerType;
    }

    public void tick(Point point, Iterator<Unit> units) {
        if (this.range < 0) { // Spawn and Portal
            return;
        }

        hurtEnemies(point, units);
    }

    public void hurtEnemies(Point point, Iterator<Unit> units) {
        if (cooldownLeft == 0) {
            Pointf center = point.toPointf();
            center.add(Tile.HALF_TILE, Tile.HALF_TILE); // Center location

            while (units.hasNext()) {
                Unit unit = units.next();
                if (unit.getOwner() != this.getOwner()){
                    if (center.distance(unit.getLocation()) <= this.range) {
                        unit.hurt(this.damage);
                        this.cooldownLeft = this.cooldown;
                        break;
                    }

                }
            }
        }
        else
            cooldownLeft--;
    }
}
