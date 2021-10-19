package model.picture;

import java.awt.Graphics2D;
import model.ShapeColor;
import model.interfaces.Shape;

public class Triangle implements Shape {
  private Point start;
  private Point end;
  private ShapeColor color;

  public Triangle(Point start, Point end, ShapeColor color) {
    this.start = start;
    this.end = end;
    this.color = color;
  }

  @Override
  public void draw(Graphics2D graphics) {
    int[] xCoordinates = {start.getX(), end.getX(), start.getX() - (end.getX() - start.getX())};
    int[] yCoordinates = {start.getY(), end.getY(), end.getY()};
    graphics.setColor(color.value);
    graphics.fillPolygon(xCoordinates, yCoordinates, 3);
  }

  private int getWidth() {
    return end.getX() - start.getX();
  }

  private int getHeight() {
    return end.getY() - start.getY();
  }

}
