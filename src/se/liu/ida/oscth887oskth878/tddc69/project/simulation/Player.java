package se.liu.ida.oscth887oskth878.tddc69.project.simulation;

/**
 * @author: Oskar Therén
 * @author: Oscar Thunberg
 * @version 1.0
 * @since: 24/09/2013
 */
public class Player {
    public static enum Team {
        RED, BLUE, NEUTRAL
    }

    public final Team team;
    public final String name;

    public Player(Team team, String name) {
        this.team = team;
        this.name = name;
    }

    public static Team getEnemy(Team team) {
        switch (team) {
            case BLUE:
                return Team.RED;
            case RED:
                return Team.BLUE;
            default:
                throw new RuntimeException(team + " does not have an enemy");
        }
    }
}
