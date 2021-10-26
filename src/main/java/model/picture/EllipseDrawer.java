package model.picture;

import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import model.interfaces.Region;
import model.interfaces.Shape;

import model.interfaces.DrawStrategy;

public class EllipseDrawer implements DrawStrategy {

  @Override
  public void draw(Graphics2D graphics, Shape shape) {
    Region region = shape.region();
    graphics.setColor(shape.fillColor());
    graphics.fill(new Ellipse2D.Double(region.getX(), region.getY(), region.getWidth(), region.getHeight()));
  }
}
