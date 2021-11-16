package controller.command;

import controller.interfaces.Command;
import controller.interfaces.Undoable;
import java.util.ArrayList;
import java.util.List;
import view.interfaces.Picture;
import view.interfaces.Shape;
import view.gui.PaintCanvas;


public class DeleteShapeCommand implements Command, Undoable {

  private Shape shapeToDelete;
  private Picture picture;
  private List<Shape> deleteShapes = new ArrayList<>();
  private PaintCanvas canvas;

  public DeleteShapeCommand(Picture picture, PaintCanvas canvas) {
    this.picture = picture;
    this.canvas = canvas;
    CommandHistory.add(this);
  }

  @Override
  public void run() {
    deleteShapes.clear();
    List<Shape> selected = picture.getSelected();
    for (Shape shape : selected) {
      shapeToDelete = shape;
      picture.remove(shapeToDelete);
      deleteShapes.add(shapeToDelete);
    }
  }

  @Override
  public void undo() {
      picture.add(shapeToDelete);
  }

  @Override
  public void redo() {
    run();
  }
}
