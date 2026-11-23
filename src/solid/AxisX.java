package solid;

import transforms.Point3D;
import utils.ColorUtil;

public class AxisX extends Solid{
    public AxisX(){
        vb.add(new Point3D(0,0,0));
        vb.add(new Point3D(1,0,0));
        addIndices(0,1);
        setColor(ColorUtil.hexToInteger("#ff0000"));
    }
}
