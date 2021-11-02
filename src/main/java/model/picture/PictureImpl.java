/*
 * Assignment: 1
 * Topic: JPaint
 * Author: Dan Walker
 */
package model.picture;

import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;
import model.interfaces.Picture;
import model.interfaces.Region;
import model.interfaces.Shape;

/**
 * @see model.interfaces.Picture
 */
public class PictureImpl implements Picture {

  private final List<Shape> elements = new ArrayList<>();
  private final List<Shape> selected = new ArrayList<>();

  @Override
  public void add(Shape shape) {
    elements.add(shape);
  }

  @Override
  public void remove(Shape shape) {
    elements.remove(shape);
    selected.remove(shape);
  }

  @Override
  public void draw(Graphics2D g) {
    for (Shape s : elements) {
      s.draw(g);
    }
  }

  @Override
  public void select(Region selectedArea) {
    selected.clear();
    elements.forEach((shape) -> {
      if (selectedArea.overlaps(shape.region())) {
        selected.add(shape);
      }
    });

    System.out.println("Selected count: " + selected.size());
  }

  public int size() {
    return elements.size();
  }

  @Override
  public List<Shape> getSelected() {
    return selected;
  }
}
