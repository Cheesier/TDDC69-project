package se.liu.ida.oscth887oskth878.tddc69.project.rendering;

import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;
import org.newdawn.slick.util.ResourceLoader;
import se.liu.ida.oscth887oskth878.tddc69.project.client.GUI;
import se.liu.ida.oscth887oskth878.tddc69.project.simulation.Tile;
import se.liu.ida.oscth887oskth878.tddc69.project.simulation.TowerFactory;

import java.io.IOException;
import java.util.EnumMap;

/**
 * @author Oscar Thunberg (oscth887)
 * @author Oskar Therén   (oskth878)
 * @version 1.0
 * @since 27/09/2013
 */
public class ResourceManager {
    private static EnumMap<Tile.Type, Texture> textures = new EnumMap<Tile.Type, Texture>(Tile.Type.class);
    private static EnumMap<TowerFactory.TowerType, Texture> towers = new EnumMap<TowerFactory.TowerType, Texture>(TowerFactory.TowerType.class);
    private static EnumMap<GUI.GUIElements, Texture> uiElements = new EnumMap<GUI.GUIElements, Texture>(GUI.GUIElements.class);

    static {
        textures.put(Tile.Type.GRASS, load("res/tiles/grid.png"));

        towers.put(TowerFactory.TowerType.BASIC_TOWER, load("res/towers/bt.png"));

        uiElements.put(GUI.GUIElements.BACKGROUND, load("res/ui/backgound.png"));
    }

    private static Texture load(String path) {
        try {
            return TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream(path));
        } catch (IOException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException();
        }
    }

    public static void bindTexture(Tile.Type type) {
        textures.get(type).bind();
    }

    public static void bindTower(TowerFactory.TowerType type) {
        towers.get(type).bind();
    }

    public static void bindUIElement(GUI.GUIElements type) {
        uiElements.get(type).bind();
    }
}