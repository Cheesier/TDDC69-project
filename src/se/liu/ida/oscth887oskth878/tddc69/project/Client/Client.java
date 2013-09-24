package se.liu.ida.oscth887oskth878.tddc69.project.Client;

import se.liu.ida.oscth887oskth878.tddc69.project.Network.Client.GameClient;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;


public class Client {
    public static void main(String[] args) {
        /*GameClient server = new GameClient();

        try {
            Thread.sleep(10000l);
            server.close("End of game");
        } catch (InterruptedException e) {
        }
        */

        DisplayMode[] modes = new DisplayMode[0];
        try {
            modes = Display.getAvailableDisplayModes();
        } catch (LWJGLException e) {
            e.printStackTrace();
        }

        for (int i=0;i<modes.length;i++) {
            DisplayMode current = modes[i];
            System.out.println(current.getWidth() + "x" + current.getHeight() + "x" +
                    current.getBitsPerPixel() + " " + current.getFrequency() + "Hz");
        }

        try {
            Display.setDisplayMode(new DisplayMode(800, 600));
            Display.create();
            Display.setTitle("OTD game");
        } catch (LWJGLException e) {
            e.printStackTrace();
        }

        /* PREPARATIONS FOR GAMELOOP


        const int TICKS_PER_SECOND = 25;
        const int SKIP_TICKS = 1000 / TICKS_PER_SECOND;
        const int MAX_FRAMESKIP = 5;

        DWORD next_game_tick = GetTickCount();
        int loops;
        float interpolation;

        bool game_is_running = true;
        while( game_is_running ) {

            loops = 0;
            while( GetTickCount() > next_game_tick && loops < MAX_FRAMESKIP) {
                update_game();

                next_game_tick += SKIP_TICKS;
                loops++;
            }

            interpolation = float( GetTickCount() + SKIP_TICKS - next_game_tick )
                            / float( SKIP_TICKS );
            display_game( interpolation );
        }
         */
    }
}
