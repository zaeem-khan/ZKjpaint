package controller;

import java.awt.Color;
import model.ShapeShadingType;
import model.ShapeType;
import model.interfaces.DrawStrategy;
import model.interfaces.Region;
import model.interfaces.Shape;
import model.picture.EllipseExpert;
import model.picture.NullDrawer;
import model.picture.RectangleExpert;
import model.picture.ShapeDrawer;
import model.picture.ShapeImpl;
import model.picture.TriangleExpert;

public class ShapeBuilder {
  private Color fillColor;
  private Color borderColor;
  private ShapeType type;
  private ShapeShadingType shadingType;
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
  
  public ShapeBuilder setBorderColor(Color color) {
    this.borderColor = color;
    return this;
  }
  
  public ShapeBuilder setShadingType(ShapeShadingType shadingType) {
    this.shadingType = shadingType;
    return this;
  }

  public Shape build() {

    DrawStrategy fillStrategy = new NullDrawer();
    DrawStrategy borderStrategy = new NullDrawer();
    DrawStrategy selectedStrategy;
    Shape newShape;
    DrawStrategy drawStrategy = null;

    switch (type) {
      
      case ELLIPSE:
        if (shadingType == ShapeShadingType.FILLED_IN || shadingType == ShapeShadingType.OUTLINE_AND_FILLED_IN) {
          fillStrategy = new ShapeDrawer(EllipseExpert::drawFilled);
        }
        if (shadingType == ShapeShadingType.OUTLINE || shadingType == ShapeShadingType.OUTLINE_AND_FILLED_IN) {
          borderStrategy = new ShapeDrawer(EllipseExpert::drawBorder);
        }
        selectedStrategy = new ShapeDrawer(EllipseExpert::drawSelected);
        break;
      case RECTANGLE:
        if (shadingType == ShapeShadingType.FILLED_IN || shadingType == ShapeShadingType.OUTLINE_AND_FILLED_IN) {
          fillStrategy = new ShapeDrawer(RectangleExpert::drawFilled);
        }
        if (shadingType == ShapeShadingType.OUTLINE || shadingType == ShapeShadingType.OUTLINE_AND_FILLED_IN) {
          borderStrategy = new ShapeDrawer(RectangleExpert::drawBorder);
        }
        selectedStrategy = new ShapeDrawer(RectangleExpert::drawSelected);
        break;
      case TRIANGLE:
        if (shadingType == ShapeShadingType.FILLED_IN || shadingType == ShapeShadingType.OUTLINE_AND_FILLED_IN) {
          fillStrategy = new ShapeDrawer(TriangleExpert::drawFilled);
        }
        if (shadingType == ShapeShadingType.OUTLINE || shadingType == ShapeShadingType.OUTLINE_AND_FILLED_IN) {
          borderStrategy = new ShapeDrawer(TriangleExpert::drawBorder);
        }
        selectedStrategy = new ShapeDrawer(TriangleExpert::drawSelected);
        break;
      default:
        throw new IllegalArgumentException("Unknown ShapeShadingType");
    }

    newShape = new ShapeImpl(region, fillColor, borderColor, fillStrategy, borderStrategy, selectedStrategy, shadingType);
    return newShape;
  }
}
