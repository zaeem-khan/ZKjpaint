package controller.command;

import controller.interfaces.Command;
import controller.interfaces.Undoable;
import model.interfaces.Picture;
import model.interfaces.Shape;
import model.interfaces.UserChoices;
import model.picture.Point;
import view.gui.PaintCanvas;

/**
 * MoveShapeCommand is responsible for moving existing shapes from
 * the canvas
 */

public class MoveShapeCommand implements Command, Undoable {
  private Shape shape;
  private UserChoices userChoices;
  private PaintCanvas canvas;
  private Picture picture;
  private Point start;
  private Point end;

  public MoveShapeCommand(UserChoices userChoices, PaintCanvas canvas, Picture picture, Point start, Point end) {
    this.userChoices = userChoices;
    this.canvas = canvas;
    this.picture = picture;
    this.start = start;
    this.end = end;
  }

  @Override
  public void undo() {

  }

  @Override
  public void redo() {

  }

  @Override
  public void run() {

  }
}
