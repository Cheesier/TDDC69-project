package se.liu.ida.oscth887oskth878.tddc69.project.simulation;

/**
 * Represents a single player.
 *
 * @author Oskar Therén
 * @author Oscar Thunberg
 * @version 1.0
 * @since 24/09/2013
 */
public class Player {
    public enum Team {
        RED, BLUE, NEUTRAL
    }

    private Team team = null;
    private String name = null;

    public Player() {
    }

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
            case NEUTRAL:
            default:
                throw new RuntimeException(team + " does not have an enemy");
        }
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Player && name.equals(((Player) obj).name) && team == ((Player) obj).team;
    }

    @Override
    public int hashCode() {
        return 1+super.hashCode();
    }

    public Team getTeam() {
        return team;
    }

    public String getName() {
        return name;
    }
}
