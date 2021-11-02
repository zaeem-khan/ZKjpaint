package model.picture;

import java.awt.Color;
import java.awt.Graphics2D;
import model.interfaces.DrawStrategy;
import model.interfaces.Region;
import model.interfaces.Shape;

public class ShapeImpl implements Shape {

  private final Color fillColor;
  private final Region region;
  private final Color borderColor;
  private DrawStrategy fillStrategy = null;
  private DrawStrategy borderStrategy = null;
  private DrawStrategy selectedStrategy = null;

  public ShapeImpl(
      Region region,
      Color fillColor,
      Color borderColor,
      DrawStrategy fillStrategy,
      DrawStrategy borderStrategy,
      DrawStrategy selectedStrategy) {
    this.region = region;
    this.fillColor = fillColor;
    this.borderColor = borderColor;
    this.fillStrategy = fillStrategy;
    this.borderStrategy = borderStrategy;
    this.selectedStrategy = selectedStrategy;
  }

  public Color fillColor() { return fillColor; }
  public Color borderColor() { return borderColor; }
  public Region region() {return region; }

  @Override
  public void draw(Graphics2D graphics) {
    fillStrategy.draw(graphics, this);
    borderStrategy.draw(graphics, this);

  }

  public void move(int x, int y) {
    region.move(x, y);
  }

  @Override
  public void drawSelected(Graphics2D graphics) { selectedStrategy.draw(graphics, this); }
}
