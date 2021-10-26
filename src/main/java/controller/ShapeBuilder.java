package controller;

import java.awt.Color;
import model.ShapeType;
import model.interfaces.DrawStrategy;
import model.interfaces.Region;
import model.interfaces.Shape;
import model.picture.EllipseDrawer;
import model.picture.RectangleDrawer;
import model.picture.ShapeImpl;
import model.picture.TriangleDrawer;

public class ShapeBuilder {
  private Color fillColor;
  private ShapeType type;
  private Region region;

  public ShapeBuilder setFillColor(Color color) {
    this.fillColor = color;
    return this;
  }

  public ShapeBuilder setRegion(Region region) {
    this.region = region;
    return this;
  }

  public ShapeBuilder setType(ShapeType type) {
    this.type = type;
    return this;
  }

  public Shape build() {

    DrawStrategy drawStrategy;

    switch (type) {
      case ELLIPSE:
        drawStrategy = new EllipseDrawer();
        break;
      case RECTANGLE:
        drawStrategy = new RectangleDrawer();
        break;
      case TRIANGLE:
        drawStrategy = new TriangleDrawer();
        break;
      default:
        throw new IllegalArgumentException("Unknown ShapeType");
    }

    return new ShapeImpl(region, fillColor, drawStrategy);
  }
}
