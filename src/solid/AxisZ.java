package solid;

import transforms.Point3D;
import utils.ColorUtil;

public class AxisZ extends Solid{
    public AxisZ(){
        vb.add(new Point3D(0,0,0));
        vb.add(new Point3D(0,0,1));
        addIndices(0,1);
        setColor(ColorUtil.hexToInteger("#0000ff"));
    }
}
