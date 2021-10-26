package controller.command;

import controller.interfaces.Command;
import model.interfaces.Picture;
import model.picture.Point;

public class SelectShapeCommand implements Command {

  private Picture picture;
  private Region region;

  public SelectShapeCommand(Picture picture, Point start, Point end) {
    this.picture = picture;
    this.region = region;
  }

  @Override
  public void run() {
    picture.select(region);
  }

}
