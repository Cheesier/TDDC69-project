package se.liu.ida.oscth887oskth878.tddc69.project.Rendering;

import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.GL11;
import org.newdawn.slick.Color;
import se.liu.ida.oscth887oskth878.tddc69.project.Simulation.Level;
import se.liu.ida.oscth887oskth878.tddc69.project.Simulation.Tile;

import java.io.IOException;

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
        ResourceManager.init();

        this.width = width;
        this.height = height;
        this.size = size;


        // init OpenGL
        GL11.glMatrixMode(GL11.GL_PROJECTION);
        GL11.glLoadIdentity();
        GL11.glOrtho(0, this.width, this.height, 0, 1, -1);
        GL11.glMatrixMode(GL11.GL_MODELVIEW);

        GL11.glEnable(GL11.GL_TEXTURE_2D);
        GL11.glDisable(GL11.GL_DEPTH);

        GL11.glHint(GL11.GL_PERSPECTIVE_CORRECTION_HINT, GL11.GL_NICEST);
        GL11.glHint(GL11.GL_LINE_SMOOTH_HINT, GL11.GL_NICEST);

        System.out.println("OpenGL version: " + GL11.glGetString(GL11.GL_VERSION));
    }

    @Override
    public void draw(Level level) {
        // Clear the screen and depth buffer
        GL11.glClear(GL11.GL_COLOR_BUFFER_BIT);

        int baseX = 0;
        int baseY = 0;

            for (int x = 0; x < level.getDimensions().x; x++) {
                for (int y = 0; y < level.getDimensions().y; y++) {


                    ResourceManager.bindTexture(level.getTile(x, y).getType());

                    GL11.glBegin(GL11.GL_QUADS);
                    GL11.glVertex2f(baseX,      baseY);
                    GL11.glTexCoord2f(0,0);
                    GL11.glVertex2f(baseX+size, baseY);
                    GL11.glTexCoord2f(0,1);
                    GL11.glVertex2f(baseX+size, baseY+size);
                    GL11.glTexCoord2f(1,1);
                    GL11.glVertex2f(baseX,      baseY+size);
                    GL11.glTexCoord2f(1,0);
                    GL11.glEnd();

                    baseY += size;
                }
                baseY = 0;
                baseX += size;
            }


        Display.update();
    }
}
