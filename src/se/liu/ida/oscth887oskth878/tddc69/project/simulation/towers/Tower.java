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
public abstract class Tower extends Tile {
    public static enum DamageType {
        PHYSICAL
    }
    private final int damage;
    private final DamageType damageType;
    private final float range;
    private final int cooldown;
    private int cooldownLeft;
    private final TowerFactory.TowerType towerType;

    protected Tower(TowerFactory.TowerType type, UnitMobility unitMobility, DamageType damageType, int damage, float range, int cooldown, Player.Team owner) {
        super(unitMobility, false, Type.TOWER, owner);
        this.towerType = type;
        this.damageType = damageType;
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

    void hurtEnemies(Point point, Iterator<Unit> units) {
        if (cooldownLeft == 0) {
            Pointf center = point.toPointf();
            center.add(0.5f, 0.5f); // Center location

            while (units.hasNext()) {
                Unit unit = units.next();
                if (unit.getOwner() != this.getOwner()){
                    if (center.distance(unit.getLocation()) <= this.range) {
                        unit.hurt(this.damage, this.damageType);
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
