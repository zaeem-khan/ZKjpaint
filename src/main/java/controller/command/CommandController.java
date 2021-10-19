/*
 * Assignment: 1
 * Topic: JPaint
 * Author: Dan Walker
 */
package controller.command;

import model.interfaces.UserChoices;
import model.picture.Point;
import model.interfaces.Picture;
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
    Command cmd;
    switch(choices.getActiveMouseMode()) {
      case DRAW:
        cmd = new CreateShapeCommand(choices, canvas, picture, start, end);
        cmd.run();
        break;
      case MOVE:
        cmd = new MoveShapeCommand(choices, canvas, picture, start, end);
        cmd.run();
        break;
      case SELECT:
        cmd = new SelectShapeCommand(picture, start, end);
        cmd.run();
        break;
      default:
        throw new IllegalArgumentException("Invalid mouse mode given");
    }

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

