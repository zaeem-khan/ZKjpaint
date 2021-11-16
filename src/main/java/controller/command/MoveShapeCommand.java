package controller.command;

import controller.interfaces.Command;
import controller.interfaces.Undoable;
import java.util.ArrayList;
import java.util.List;
import view.interfaces.Picture;
import model.interfaces.Region;
import view.interfaces.Shape;


/**
 * MoveShapeCommand is responsible for moving existing shapes from
 * the canvas
 */

public class MoveShapeCommand implements Command, Undoable {
  private List<Shape> movedShapes = new ArrayList<>();
  private int deltaX;
  private int deltaY;
  private final Region region;
  private final Picture picture;

  public MoveShapeCommand(Picture picture, Region region) {
    this.region = region;
    this.picture = picture;

    CommandHistory.add(this);
  }

  @Override
  public void run() {
    movedShapes.addAll(picture.getSelected());
    deltaX = region.getDeltaX();
    deltaY = region.getDeltaY();
    moveShapes(deltaX, deltaY);
  }

  private void moveShapes(int dx, int dy) {
    for (Shape shape : movedShapes) {
      shape.move(dx, dy);
    }
  }

  @Override
  public void undo() {
    moveShapes(deltaX * -1, deltaY * -1);
  }

  @Override
  public void redo() {
    moveShapes(deltaX, deltaY);
  }

}
