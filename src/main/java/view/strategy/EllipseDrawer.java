package view.strategy;

import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import model.interfaces.Region;

public class EllipseDrawer extends BasicDrawer{

  @Override
  protected void drawBorder(Graphics2D graphics, Region region) {
    graphics.draw(new Ellipse2D.Double(region.getX(), region.getY(), region.getWidth(), region.getHeight()));
  }

  @Override
  protected void drawShape(Graphics2D graphics, Region region) {
    graphics.fill(new Ellipse2D.Double(region.getX(), region.getY(), region.getWidth(), region.getHeight()));
  }
}
