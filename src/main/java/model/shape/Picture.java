package model.shape;


import java.awt.Graphics2D;
import java.util.List;
import model.interfaces.Shape;
import view.gui.PaintCanvas;

public class Picture {

  public List<Rectangle> shapeList;
  private Rectangle rectangle;
  public void addShape(Rectangle rectangle) {
    shapeList.add(rectangle);
  }

  public  void removeShape(Rectangle rectangle) {
    shapeList.remove(rectangle);
  }

  public List<Rectangle> grabList() {
    return shapeList;
  }

  public void draw(Graphics2D graphics2D) {
    for (Rectangle rectangle : grabList()) {
      rectangle.draw(graphics2D);
    }
  }
}
