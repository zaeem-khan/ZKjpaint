package view.strategy;

import java.awt.Graphics2D;
import model.interfaces.Region;
import view.interfaces.Shape;

public class RectangleDrawer extends BasicDrawer {

  @Override
  public void drawShape(Graphics2D graphics, Region region) {
    graphics.fillRect(region.getX(), region.getY(), region.getWidth(), region.getHeight());
  }

  @Override
  protected void drawBorder(Graphics2D graphics, Region region) {
    graphics.drawRect(region.getX(), region.getY(), region.getWidth(), region.getHeight());
  }
}
