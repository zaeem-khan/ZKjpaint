package view.interfaces;

import java.awt.Color;
import java.awt.Graphics2D;
import model.ShapeShadingType;
import model.interfaces.Region;

/**
 * Represents an individual shape drawn by the user.
 */
public interface Shape {
  void draw(Graphics2D graphics);
  Color fillColor();
  Color borderColor();
  ShapeShadingType getShadingType();
  Region region();
  void move(int deltaX, int deltaY);
  void drawSelected(Graphics2D graphics);
  Shape copy();
}
