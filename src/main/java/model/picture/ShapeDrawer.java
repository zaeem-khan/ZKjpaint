package model.picture;

import java.awt.Graphics2D;
import java.util.function.BiConsumer;
import model.interfaces.DrawStrategy;
import model.interfaces.Shape;

public class ShapeDrawer implements DrawStrategy {

  private BiConsumer<Graphics2D, Shape> drawFunction;

  public ShapeDrawer(BiConsumer<Graphics2D, Shape> func) { drawFunction = func; }

  @Override
  public void draw(Graphics2D graphics, Shape shape) { drawFunction.accept(graphics, shape); }
}
