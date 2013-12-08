package se.liu.ida.oscth887oskth878.tddc69.project.client.input;

import org.lwjgl.input.Mouse;

import java.util.ArrayList;

/**
 * Manages the mouse clicks and those who are listening to events.
 *
 * @author Oskar Therén
 * @author Oscar Thunberg
 * @version 1.0
 * @since 29/09/2013
 */
public final class MouseHandler {
    private static ArrayList<MouseListener> listeners = new ArrayList<MouseListener>();

    private MouseHandler() {
    }

    public static void update() {
        Mouse.updateCursor();
        while (Mouse.next()) {
            if (Mouse.getEventButton() != -1) {
                switch (Mouse.getEventButton()) {
                    case 0: // left click
                        notifyLeftListener(new MouseClickEvent(
                                Mouse.getEventButtonState(),
                                Mouse.getEventX(),
                                Mouse.getEventY()));
                        break;
                    case 1: // right click
                        notifyRightListener(new MouseClickEvent(
                                Mouse.getEventButtonState(),
                                Mouse.getEventX(),
                                Mouse.getEventY()));
                        break;
                }
            }
        }
    }

    public static void addTileListener(MouseListener listener) {
        listeners.add(listener);
    }

    private static void notifyLeftListener(MouseClickEvent event) {

        for (MouseListener listener : listeners) {
            listener.onLeftClick(event);
        }
    }

    private static void notifyRightListener(MouseClickEvent event) {

        for (MouseListener listener : listeners) {
            listener.onRightClick(event);
        }
    }

}
