package controller.command;

import controller.interfaces.Command;
import model.MouseMode;
import model.interfaces.Picture;
import model.interfaces.Region;
import model.interfaces.UserChoices;
import view.gui.PaintCanvas;

public class CommandFactory {

  public static Command makeCommand(UserChoices userChoices, PaintCanvas canvas, Picture picture, Region region) {
    Command cmd;
    MouseMode mode = userChoices.getActiveMouseMode();
    switch (mode) {
      case DRAW:
        cmd = new CreateShapeCommand(userChoices, canvas, picture, region);
        break;
      case SELECT:
        cmd = new SelectShapeCommand(picture, region);
        break;
      case MOVE:
        cmd = new MoveShapeCommand(picture, region);
        break;
      default:
        throw new IllegalArgumentException("Unknown mouse mode");
    }
    return cmd;
    }
  }

}
