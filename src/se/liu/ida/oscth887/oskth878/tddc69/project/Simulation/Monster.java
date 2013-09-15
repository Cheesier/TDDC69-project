package se.liu.ida.oscth887.oskth878.tddc69.project.Simulation;

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

    /**
     * Atempt to hurt a monster
     * @param damage an integer specifying how much hitpoints should be taken from the monster
     * @return boolean indicating if damage landed or not
     */
    public boolean hurt(int damage, Tower.DamageType type) {
        this.hitpoints -= damage;

        /*
         * For future, in case we want to have an enemy immune to a type of damage income or just immortal for a
         * duration of time. For now this is okay
         */
        return true;
    }


}
