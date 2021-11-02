package model.picture;

import java.awt.BasicStroke;
import java.awt.Graphics2D;
import model.interfaces.Region;
import model.interfaces.Shape;

public class DrawExpert {
  final static float dash[] = { 10.0f };
  final static BasicStroke dashed = new BasicStroke(3.0f,
      BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 10.0f, dash, 0.0f);

}
