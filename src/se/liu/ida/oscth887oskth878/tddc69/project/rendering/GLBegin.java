package se.liu.ida.oscth887oskth878.tddc69.project.rendering;

import org.lwjgl.opengl.GL11;
import se.liu.ida.oscth887oskth878.tddc69.project.client.Client;
import se.liu.ida.oscth887oskth878.tddc69.project.client.GUI;
import se.liu.ida.oscth887oskth878.tddc69.project.simulation.Level;
import se.liu.ida.oscth887oskth878.tddc69.project.simulation.towers.Tower;
import se.liu.ida.oscth887oskth878.tddc69.project.simulation.units.Unit;

import java.util.Iterator;

/**
 * Implementation of the relatively simple OpenGL glBegin to render sprites.
 *
 * @author Oscar Thunberg (oscth887)
 * @author Oskar Therén   (oskth878)
 * @version 1.0
 * @since 27/09/2013
 */
public class GLBegin implements Renderer {
    private int screenWidth;
    private int screenHeight;

    @Override
    public void init(int width, int height) {
        this.screenWidth = width;
        this.screenHeight = height;

        // init OpenGL
        GL11.glMatrixMode(GL11.GL_PROJECTION);
        GL11.glLoadIdentity();
        GL11.glOrtho(0, this.screenWidth, 0, this.screenHeight, 1, -1);
        GL11.glMatrixMode(GL11.GL_MODELVIEW);

        GL11.glEnable(GL11.GL_TEXTURE_2D);
        GL11.glDisable(GL11.GL_DEPTH);

        GL11.glEnable(GL11.GL_BLEND);
        GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);

        System.out.println("OpenGL version: " + GL11.glGetString(GL11.GL_VERSION));
    }

    @Override
    public void drawLevel(Level level) {
        int baseX = 0;
        int baseY = Client.UI_SIZE;

        for (int x = 0; x < level.getDimensions().x; x++) {
            for (int y = 0; y < level.getDimensions().y; y++) {

                ResourceManager.bindTexture(level.getTileType(x, y));
                drawSprite(baseX, baseY, Client.PIXELS_PER_TILE, Client.PIXELS_PER_TILE);

                Tower tower = level.getTower(x, y);
                if (tower != null) {
                    ResourceManager.bindTower(tower.getTowerType());
                    drawSprite(baseX, baseY, Client.PIXELS_PER_TILE, Client.PIXELS_PER_TILE);
                }

                baseY += Client.PIXELS_PER_TILE;
            }
            baseY = Client.UI_SIZE;
            baseX += Client.PIXELS_PER_TILE;
        }

        drawUnits(level);
    }

    @Override
    public void drawUI() {
        int baseX = 0;
        int baseY = 0;

        ResourceManager.bindUIElement(GUI.GUIElements.BACKGROUND);
        for (int i = 0; i < screenWidth / Client.UI_SIZE; i++) {
            drawSprite(baseX, baseY, Client.UI_SIZE, Client.UI_SIZE);

            baseX += Client.UI_SIZE;
        }

        baseX = 0;

        for (int i = 0; i < GUI.guiTowerElements.length; i++) {

            if (GUI.guiTowerElements[i] == null) {
                baseX += Client.UI_SIZE;
                continue;
            }

            ResourceManager.bindTower(GUI.guiTowerElements[i]);
            drawSprite(baseX, baseY, Client.UI_SIZE, Client.UI_SIZE);

            baseX += Client.UI_SIZE;
        }

        for (int i = 0; i < GUI.guiUnitElements.length; i++) {

            if (GUI.guiUnitElements[i] == null) {
                baseX += Client.UI_SIZE;
                continue;
            }

            ResourceManager.bindUnit(GUI.guiUnitElements[i]);
            drawSprite(baseX, baseY, Client.UI_SIZE, Client.UI_SIZE);

            baseX += Client.UI_SIZE;
        }
    }

    private void drawUnits(Level level) {
        Iterator<Unit> units = level.getUnitIterator();

        int displacement = Client.PIXELS_PER_TILE / 2; //places the unit in the middle of the tile

        while (units.hasNext()) {
            Unit unit = units.next();

            float baseX =                  (unit.getLocation().x * Client.PIXELS_PER_TILE) - displacement;
            float baseY = Client.UI_SIZE + (unit.getLocation().y * Client.PIXELS_PER_TILE) - displacement;

            ResourceManager.bindUnit(unit.getUnitType());
            drawSprite(baseX, baseY, Client.PIXELS_PER_TILE, Client.PIXELS_PER_TILE);
        }
    }

    private void drawSprite(float x, float y, float width, float height) {
        GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MAG_FILTER, GL11.GL_NEAREST);

        GL11.glBegin(GL11.GL_QUADS);
            GL11.glVertex2f(x, y);
            GL11.glTexCoord2f(1,1);
            GL11.glVertex2f(x+width, y);
            GL11.glTexCoord2f(1,0);
            GL11.glVertex2f(x+width, y+height);
            GL11.glTexCoord2f(0,0);
            GL11.glVertex2f(x, y+height);
            GL11.glTexCoord2f(0,1);
        GL11.glEnd();
    }
}
