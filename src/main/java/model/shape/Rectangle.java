package model.shape;

import java.awt.BasicStroke;
import model.ShapeColor;
import model.interfaces.Shape;
import controller.Point;
import java.awt.Graphics2D;
import model.interfaces.UserChoices;
import view.gui.PaintCanvas;

public class Rectangle implements Shape {
  Point start, end;
  ShapeColor shapeColor;


  public Rectangle(Point start, Point end, UserChoices userChoices) {
    this.start = start;
    this.end = end;
    this.shapeColor = userChoices.getActivePrimaryColor();
  }


  @Override
  public void draw(Graphics2D graphics2D) {
    int width, height;
    width = end.getX() - start.getX();
    height = end.getY() - start.getY();
    graphics2D.setColor(this.shapeColor.value);
    graphics2D.fillRect(start.getX(), start.getY(), width, height);
    graphics2D.setStroke(new BasicStroke(5));
    graphics2D.setColor(this.shapeColor.value);
    graphics2D.drawRect(start.getX(), start.getY(), width, height);

  }
}
