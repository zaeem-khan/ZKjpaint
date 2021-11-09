package controller;

import controller.interfaces.Command;
import controller.interfaces.Undoable;
import controller.command.CommandFactory;
import java.util.ArrayList;
import java.util.List;
import model.interfaces.Picture;
import model.interfaces.Shape;
import view.gui.PaintCanvas;


/**
 * Manages copy and paste operations by creating the appropriate command objects.
 */
public class Clipboard {
  private List<Shape> contents = new ArrayList<>();
  private final Picture picture;
  private final PaintCanvas canvas;

  public Clipboard(Picture picture, PaintCanvas canvas) {
    this.picture = picture;
    this.canvas = canvas;
  }

  public void copy() {
    contents.clear();
    List<Shape> selected = picture.getSelected();
    for (Shape s : selected) {
      Shape clone = s.copy();
      contents.add(clone);
    }
  }

  public Undoable paste() {
    Command paster = CommandFactory.makePasteCommand(picture, contents, canvas);
    paster.run();
    return (Undoable) paster;
  }
}

