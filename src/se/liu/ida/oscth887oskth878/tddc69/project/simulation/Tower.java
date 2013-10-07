package se.liu.ida.oscth887oskth878.tddc69.project.simulation;

import se.liu.ida.oscth887oskth878.tddc69.project.client.Client;
import se.liu.ida.oscth887oskth878.tddc69.project.util.Point;
import se.liu.ida.oscth887oskth878.tddc69.project.util.Pointf;

import java.util.Iterator;

/**
 * Created with IntelliJ IDEA.
 * User: Oscar
 * Date: 2013-09-15
 * Time: 20:27
 */
public abstract class Tower extends Tile {
    public static enum DamageType {
        PHYSICAL
    }
    private int damage;
    private DamageType damageType;
    private float range;
    private int cooldown;
    private int cooldownLeft;
    private TowerFactory.TowerType towerType;

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

    public float getRange() {
        return range;
    }

    public DamageType getDamageType() {
        return damageType;
    }

    public int getDamage() {
        return damage;
    }

    public void tick(Point point, Iterator<Unit> untis) {
        if (this.range < 0) { // Spawn and Portal
            return;
        }

        if (cooldownLeft == 0) {
            Pointf center = point.toPointf();
            center.add(0.5f, 0.5f); // Center location

            while (untis.hasNext()) {
                Unit unit = untis.next();
                if (unit.getOwner() != this.getOwner()){
                    if (center.distance(unit.getLocation()) <= this.range) {
                        unit.hurt(this.damage, this.damageType);
                        this.cooldownLeft = this.cooldown;
                        System.out.println("Tower at " + center + " fired!");
                        break;
                    }

                }
            }
        }
        else
            cooldownLeft--;
    }
}
