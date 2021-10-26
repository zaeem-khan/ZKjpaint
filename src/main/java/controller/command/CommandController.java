/*
 * Assignment: 1
 * Topic: JPaint
 * Author: Dan Walker
 */
package controller.command;

import model.interfaces.Region;
import model.interfaces.UserChoices;
import model.picture.Point;
import model.interfaces.Picture;
import model.picture.RegionImpl;
import view.gui.PaintCanvas;
import controller.interfaces.Undoable;
import controller.interfaces.Command;

/**
 * CommandController is responsible for creating new Commands based on
 * current user input.  The new Command is normally executed as well.
 */
public class CommandController {
  private final PaintCanvas canvas;
  private final UserChoices choices;
  private final Picture picture;

  public CommandController(PaintCanvas canvas, UserChoices choices, Picture picture) {
    this.choices = choices;
    this.canvas = canvas;
    this.picture = picture;
  }

  public void onDraw(Point start, Point end) {
    Region region = new RegionImpl(start, end);
    Command cmd = CommandFactory.makeCommand(choices, canvas, picture, region);
    cmd.run();

    canvas.repaint();
  }

  public void onUndo() {
    CommandHistory.undo();
    canvas.repaint();
  }
  public void onRedo() {
    CommandHistory.redo();
    canvas.repaint();
  }
}

