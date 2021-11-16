package view.strategy;

import java.awt.Graphics2D;
import model.interfaces.Region;

public class EmptyShapeDrawer extends BasicDrawer{

  private final BasicDrawer realDrawer;

  public EmptyShapeDrawer (BasicDrawer realDrawer) { this.realDrawer = realDrawer; }

  @Override
  protected void drawShape(Graphics2D graphics, Region region) {

  }

  @Override
  protected void drawBorder(Graphics2D graphics, Region region) {
    realDrawer.drawBorder(graphics, region);
  }
}
