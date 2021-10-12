/*
 * Zaeem Khan
 * SE350
 *  Assignment 1
 */
package model.picture;

public class Point {
  private int x;
  private int y;
  private Point point;

  public Point(int x, int y) {
    this.x = x;
    this.y = y;
  }

  public int getX() {
    return x;
  }

  public void setX(int x) {
    this.x = x;
  }

  public int getY() {
    return y;
  }

  public void setY(int y) {
    this.y = y;
  }

  public Point getPoint() {
    return point;
  }
}
