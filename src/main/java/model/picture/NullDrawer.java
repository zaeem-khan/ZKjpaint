package model.picture;

import java.awt.Graphics2D;
import model.interfaces.DrawStrategy;
import model.interfaces.Shape;

public class NullDrawer implements DrawStrategy {
  @Override
  public void draw(Graphics2D graphics, Shape shape) {

  }
}
