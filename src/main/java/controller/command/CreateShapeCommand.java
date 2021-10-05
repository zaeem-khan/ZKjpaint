package controller.command;

import controller.Point;
import controller.interfaces.ICommand;
import controller.interfaces.Undoable;
import java.awt.Graphics2D;
import model.interfaces.UserChoices;
import model.shape.Picture;
import model.shape.Rectangle;
import view.gui.PaintCanvas;

public class CreateShapeCommand implements ICommand, Undoable {
  Point start, end;
  UserChoices userChoices;
  Rectangle rectangle;
  Picture picture;
  public CreateShapeCommand(UserChoices userChoices, Point start, Point end) {
    this.start = start;
    this.end = end;
    this.userChoices = userChoices;
    this.rectangle = new Rectangle(start, end, userChoices);
  }

  @Override
  public void run() {
    System.out.println("running...");
    picture.addShape(this.rectangle);
    CommandHistory.add(this);
  }

  @Override
  public void undo() {
    CommandHistory.undo();
  }

  @Override
  public  void redo() {
    CommandHistory.redo();
  }
}
