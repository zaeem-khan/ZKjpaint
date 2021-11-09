package controller.command;

import controller.interfaces.Command;
import controller.interfaces.Undoable;
import java.util.ArrayList;
import java.util.List;
import model.interfaces.Picture;
import model.interfaces.Shape;
import view.gui.PaintCanvas;

public class PasteShapeCommand implements Command, Undoable {

  private final Picture picture;
  private final List<Shape> clipboardContents;
  private final PaintCanvas canvas;

  private List<Shape> pastedShapes = new ArrayList<>();
  private final int OFFSET = 10;

  public PasteShapeCommand(Picture picture, List<Shape> clipboardContents, PaintCanvas canvas) {
    this.picture = picture;
    this.clipboardContents = clipboardContents;
    this.canvas = canvas;
    CommandHistory.add(this);
  }

  @Override
  public void run() {
    for (Shape shape : clipboardContents) {
      shape.move(OFFSET, OFFSET);
      Shape newShape = shape.copy();
      picture.add(newShape);
      pastedShapes.add(newShape);
    }
  }

  @Override
  public void undo() {
    for (Shape shape: pastedShapes) {
      picture.remove(shape);
    }
  }

  @Override
  public void redo() { picture.add(pastedShapes);}
}
