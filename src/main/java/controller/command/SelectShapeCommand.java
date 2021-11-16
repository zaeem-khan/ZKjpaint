package controller.command;

import controller.interfaces.Command;
import view.interfaces.Picture;
import model.interfaces.Region;

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
