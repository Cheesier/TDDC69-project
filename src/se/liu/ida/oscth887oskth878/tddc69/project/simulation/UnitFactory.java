package se.liu.ida.oscth887oskth878.tddc69.project.simulation;

import se.liu.ida.oscth887oskth878.tddc69.project.simulation.units.BasicUnit;
import se.liu.ida.oscth887oskth878.tddc69.project.util.Pointf;

/**
 * @author Oscar Thunberg (oscth887)
 * @author Oskar Therén   (oskth878)
 * @version 1.0
 * @since 30/09/2013
 */
public class UnitFactory {
    public static enum UnitType {
        BASIC_UNIT
    }

    public static Unit getUnit(UnitType type, Player.Team team, Pointf pointf) {
        switch (type) {
            case BASIC_UNIT:
                return new BasicUnit(pointf, team); //TODO: change to spawn point
        }
        throw new RuntimeException(type + " is not spawnable");
    }
}
