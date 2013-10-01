package se.liu.ida.oscth887oskth878.tddc69.project.rendering;

import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.GL11;
import se.liu.ida.oscth887oskth878.tddc69.project.client.Client;
import se.liu.ida.oscth887oskth878.tddc69.project.client.GUI;
import se.liu.ida.oscth887oskth878.tddc69.project.simulation.Level;
import se.liu.ida.oscth887oskth878.tddc69.project.simulation.Tower;

/**
 * @author Oscar Thunberg (oscth887)
 * @author Oskar Therén   (oskth878)
 * @version 1.0
 * @since 27/09/2013
 */
public class GLBegin implements Renderer {
    private int width;
    private int height;
    private int size;


    @Override
    public void init(int width, int height, int size) {
        this.width = width;
        this.height = height;
        this.size = size;


        // init OpenGL
        GL11.glMatrixMode(GL11.GL_PROJECTION);
        GL11.glLoadIdentity();
        GL11.glOrtho(0, this.width, 0, this.height, 1, -1);
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


                    ResourceManager.bindTexture(level.getTile(x, y).getType());

                    GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MAG_FILTER, GL11.GL_NEAREST);
                    GL11.glBegin(GL11.GL_QUADS);
                        GL11.glVertex2f(baseX,      baseY);
                        GL11.glTexCoord2f(1,0);
                        GL11.glVertex2f(baseX+size, baseY);
                        GL11.glTexCoord2f(1,1);
                        GL11.glVertex2f(baseX+size, baseY+size);
                        GL11.glTexCoord2f(0,1);
                        GL11.glVertex2f(baseX,      baseY+size);
                        GL11.glTexCoord2f(0,0);
                    GL11.glEnd();

                    Tower tower = level.getTile(x, y).getTower();
                    if (tower != null) {
                        ResourceManager.bindTower(tower.getTowerType());

                        GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MAG_FILTER, GL11.GL_NEAREST);
                        GL11.glBegin(GL11.GL_QUADS);
                        GL11.glVertex2f(baseX,      baseY);
                        GL11.glTexCoord2f(1,0);
                        GL11.glVertex2f(baseX+size, baseY);
                        GL11.glTexCoord2f(1,1);
                        GL11.glVertex2f(baseX+size, baseY+size);
                        GL11.glTexCoord2f(0,1);
                        GL11.glVertex2f(baseX,      baseY+size);
                        GL11.glTexCoord2f(0,0);
                        GL11.glEnd();
                    }

                    baseY += size;
                }
                baseY = Client.UI_SIZE;
                baseX += size;
            }


        Display.update();
    }

    @Override
    public void drawUI() {
        int baseX = 0;
        int baseY = 0;

        ResourceManager.bindUIElement(GUI.GUIElements.BACKGROUND);
        for (int i = 0; i < Client.WIDTH*Client.PIXELS_PER_TILE / Client.UI_SIZE; i++) {
            GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MAG_FILTER, GL11.GL_NEAREST);
            GL11.glBegin(GL11.GL_QUADS);
                GL11.glVertex2f(baseX,                  baseY);
                GL11.glTexCoord2f(1,0);
                GL11.glVertex2f(baseX+Client.UI_SIZE,   baseY);
                GL11.glTexCoord2f(1,1);
                GL11.glVertex2f(baseX+Client.UI_SIZE,   baseY+Client.UI_SIZE);
                GL11.glTexCoord2f(0,1);
                GL11.glVertex2f(baseX,                  baseY+Client.UI_SIZE);
                GL11.glTexCoord2f(0,0);
            GL11.glEnd();
            baseX += Client.UI_SIZE;
        }

        baseX = 0;

        for (int i = 0; i < GUI.guiTowerElements.length; i++) {

            if (GUI.guiTowerElements[i] == null) {
                baseX += Client.UI_SIZE;
                continue;
            }

            ResourceManager.bindTower(GUI.guiTowerElements[i]);

            GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MAG_FILTER, GL11.GL_NEAREST);
            GL11.glBegin(GL11.GL_QUADS);
                GL11.glVertex2f(baseX,                  baseY);
                GL11.glTexCoord2f(1,0);
                GL11.glVertex2f(baseX+Client.UI_SIZE,   baseY);
                GL11.glTexCoord2f(1,1);
                GL11.glVertex2f(baseX+Client.UI_SIZE,   baseY+Client.UI_SIZE);
                GL11.glTexCoord2f(0,1);
                GL11.glVertex2f(baseX,                  baseY+Client.UI_SIZE);
                GL11.glTexCoord2f(0,0);
            GL11.glEnd();

            baseX += Client.UI_SIZE;
        }
    }
}