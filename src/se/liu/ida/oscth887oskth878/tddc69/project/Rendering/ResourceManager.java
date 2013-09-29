package se.liu.ida.oscth887oskth878.tddc69.project.Rendering;

import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;
import org.newdawn.slick.util.ResourceLoader;
import se.liu.ida.oscth887oskth878.tddc69.project.Simulation.Tile;

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

    public static void init() {
        textures.put(Tile.Type.GRASS, load("res/tiles/grid.png"));
        textures.put(Tile.Type.TOWER, load("res/tiles/tower.png"));

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
        //GL11.glBindTexture(GL11.GL_TEXTURE_2D, textures.get(type).getTextureID());
    }
}
