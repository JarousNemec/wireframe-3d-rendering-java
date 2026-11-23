package solid;

import transforms.Point3D;
import utils.ColorUtil;

public class AxisY extends Solid {
    public AxisY() {
        vb.add(new Point3D(0, 0, 0));
        vb.add(new Point3D(0, 1, 0));
        addIndices(0, 1);
        setColor(ColorUtil.hexToInteger("#00ff00"));
    }
}
