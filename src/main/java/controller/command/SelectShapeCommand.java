package controller.command;

import controller.interfaces.Command;
import controller.interfaces.Undoable;
import model.interfaces.Picture;
import model.interfaces.Shape;
import model.interfaces.UserChoices;
import model.picture.Point;
import view.gui.PaintCanvas;

public class SelectShapeCommand implements Command {

  private Picture picture;
  private Point start;
  private Point end;

  public SelectShapeCommand(Picture picture, Point start, Point end) {
    this.picture = picture;
    this.start = start;
    this.end = end;
  }

  @Override
  public void run() {

  }

}
