/*
 * Assignment: 1
 * Topic: JPaint
 * Author: Jeffrey Sharpe, Dan Walker
 */
package main;

import controller.interfaces.EventConnector;
import controller.EventConnectorImpl;
import controller.KeyboardInterface;
import controller.MouseHandler;
import controller.command.CommandController;
import model.interfaces.Picture;
import model.interfaces.UserChoices;
import model.persistence.UserChoicesImpl;
import model.picture.PictureImpl;
import view.gui.Gui;
import view.gui.GuiWindowImpl;
import view.gui.PaintCanvas;
import view.interfaces.GuiWindow;
import view.interfaces.UiModule;

/**
 * The class that contains the main method of tha application.  Performs
 * most of the dependency injection required by the system.
 */
public class Main {
    public static void main(String[] args){
        Picture picture = new PictureImpl();
        PaintCanvas paintCanvas = new PaintCanvas(picture);
        GuiWindow guiWindow = new GuiWindowImpl(paintCanvas);
        UiModule uiModule = new Gui(guiWindow);
        UserChoices userChoices = new UserChoicesImpl(uiModule);
        CommandController commandControl = new CommandController(paintCanvas, userChoices, picture);
        EventConnector controller = new EventConnectorImpl(uiModule, userChoices, commandControl);

        KeyboardInterface keys = new KeyboardInterface(paintCanvas, userChoices);
        keys.setup();

        CommandController c = new CommandController(paintCanvas, userChoices, picture);
        MouseHandler mouse = new MouseHandler(c);
        paintCanvas.addMouseListener(mouse);
        controller.setup();
    }
}
