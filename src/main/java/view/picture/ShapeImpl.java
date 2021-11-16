package view.picture;

import java.awt.Color;
import java.awt.Graphics2D;
import model.ShapeShadingType;
import view.interfaces.DrawStrategy;
import model.interfaces.Region;
import view.interfaces.Shape;

public class ShapeImpl implements Shape {

  private final Color fillColor;
  private final Region region;
  private final Color borderColor;
  private DrawStrategy drawStrategy = null;
  private ShapeShadingType shadingType;

  public ShapeImpl(
      Region region, Color fillColor, Color borderColor, DrawStrategy drawStrategy, ShapeShadingType shadingType) {
    this.region = region;
    this.fillColor = fillColor;
    this.borderColor = borderColor;
    this.drawStrategy = drawStrategy;
    this.shadingType = shadingType;
  }

  public Color fillColor() { return fillColor; }
  public Color borderColor() { return borderColor; }
  public Region region() {return region; }

  @Override
  public ShapeShadingType getShadingType() { return shadingType; }

  @Override
  public void draw(Graphics2D graphics) { drawStrategy.draw(graphics, this); }

  public void move(int x, int y) {
    region.move(x, y);
  }

  @Override
  public void drawSelected(Graphics2D graphics) { drawStrategy.drawSelected(graphics, this); }

  public Shape copy() {
    return new ShapeImpl(region.copy(), fillColor, borderColor, drawStrategy, shadingType);
  }
}
