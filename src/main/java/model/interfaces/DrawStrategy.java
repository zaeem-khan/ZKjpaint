package model.interfaces;

import java.awt.Graphics2D;

public interface DrawStrategy {
  void draw(Graphics2D graphics, Shape shape);
}
