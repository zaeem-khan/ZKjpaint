package model.picture;

import java.awt.Color;
import java.awt.Graphics2D;
import model.interfaces.DrawStrategy;
import model.interfaces.Region;
import model.interfaces.Shape;

public class ShapeImpl implements Shape {

  private final Color color;
  private final Region region;
  private DrawStrategy drawStrategy = null;

  public ShapeImpl(Region region, Color color, DrawStrategy drawStrategy) {
    this.region = region;
    this.color = color;
    this.drawStrategy = drawStrategy;
  }

  public Color fillColor() { return color; }

  public Region region() {return region; }

  @Override
  public void draw(Graphics2D graphics) {
    drawStrategy.draw(graphics, this);
  }

  public void move(int x, int y) {
    region.move(x, y);
  }
}
