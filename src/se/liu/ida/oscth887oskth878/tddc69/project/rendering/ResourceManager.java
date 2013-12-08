package se.liu.ida.oscth887oskth878.tddc69.project.rendering;

import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;
import org.newdawn.slick.util.ResourceLoader;
import se.liu.ida.oscth887oskth878.tddc69.project.client.GUI;
import se.liu.ida.oscth887oskth878.tddc69.project.simulation.Tile;
import se.liu.ida.oscth887oskth878.tddc69.project.simulation.TowerFactory;
import se.liu.ida.oscth887oskth878.tddc69.project.simulation.UnitFactory;

import java.io.IOException;
import java.util.EnumMap;
import java.util.Map;

/**
 * Manages all the textures in the game.
 *
 * @author Oscar Thunberg (oscth887)
 * @author Oskar Therén   (oskth878)
 * @version 1.0
 * @since 27/09/2013
 */
public final class ResourceManager {
    private final static Map<Tile.Type, Texture> TILES = new EnumMap<Tile.Type, Texture>(Tile.Type.class);
    private final static Map<TowerFactory.TowerType, Texture> TOWERS = new EnumMap<TowerFactory.TowerType, Texture>(TowerFactory.TowerType.class);
    private final static Map<GUI.GUIElements, Texture> UI_ELEMENTS = new EnumMap<GUI.GUIElements, Texture>(GUI.GUIElements.class);
    private final static Map<UnitFactory.UnitType, Texture> UNITS = new EnumMap<UnitFactory.UnitType, Texture>(UnitFactory.UnitType.class);

    static {
        TILES.put(Tile.Type.GRASS, load("res/tiles/grid.png"));

        TOWERS.put(TowerFactory.TowerType.BASIC_TOWER, load("res/towers/bt.png"));
        TOWERS.put(TowerFactory.TowerType.ADVANCED_TOWER, load("res/towers/advanced_tower.png"));
        TOWERS.put(TowerFactory.TowerType.SPAWN, load("res/towers/spawn.png"));
        TOWERS.put(TowerFactory.TowerType.PORTAL, load("res/towers/portal.png"));

        UI_ELEMENTS.put(GUI.GUIElements.BACKGROUND, load("res/ui/backgound.png"));

        UNITS.put(UnitFactory.UnitType.BASIC_UNIT, load("res/units/basic_unit.png"));
        UNITS.put(UnitFactory.UnitType.GOOMBA_UNIT, load("res/units/goomba_unit.png"));
        UNITS.put(UnitFactory.UnitType.ADVANCED_UNIT, load("res/units/advanced_unit.png"));
        UNITS.put(UnitFactory.UnitType.BASIC_FLYING, load("res/units/basic_flying.png"));

    }

    private ResourceManager() {
    }

    @SuppressWarnings({"ProhibitedExceptionThrown", "ThrowInsideCatchBlockWhichIgnoresCaughtException"})
    private static Texture load(String path) {
        try {
            return TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream(path));
        } catch (IOException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException("Something went wrong loading textures.");
        }
    }

    public static void bindTexture(Tile.Type type) {
        TILES.get(type).bind();
    }

    public static void bindTower(TowerFactory.TowerType type) {
        TOWERS.get(type).bind();
    }

    public static void bindUIElement(GUI.GUIElements type) {
        UI_ELEMENTS.get(type).bind();
    }

    public static void bindUnit(UnitFactory.UnitType type) {
        UNITS.get(type).bind();
    }
}
