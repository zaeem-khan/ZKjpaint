package model.interfaces;

import java.awt.Color;
import java.awt.Graphics2D;

/**
 * Represents an individual shape drawn by the user.
 */
public interface Shape {
  void draw(Graphics2D graphics);
  Color fillColor();
  Region region();
  void move(int deltaX, int deltaY);
}
