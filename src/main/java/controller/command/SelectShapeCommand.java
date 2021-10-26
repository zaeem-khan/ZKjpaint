package controller.command;

import controller.interfaces.Command;
import model.interfaces.Picture;
import model.interfaces.Region;
import model.picture.Point;

public class SelectShapeCommand implements Command {

  private Picture picture;
  private Region region;

  public SelectShapeCommand(Picture picture, Region region) {
    this.picture = picture;
    this.region = region;
  }

  @Override
  public void run() {
    picture.select(region);
  }

}
