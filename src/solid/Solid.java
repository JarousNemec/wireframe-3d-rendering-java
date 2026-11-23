package solid;

import transforms.Mat4;
import transforms.Mat4Identity;
import transforms.Point2D;
import transforms.Point3D;
import utils.ColorUtil;

import java.util.ArrayList;
import java.util.Arrays;

public abstract class Solid {
    protected ArrayList<Point3D> vb = new ArrayList<>();
    protected ArrayList<Integer> ib = new ArrayList<>();
    protected int color = ColorUtil.DEFAULT_LINE_COLOR;
    protected Mat4 modelMatrix = new Mat4Identity();

    public ArrayList<Point3D> getVb(){
        return vb;
    }

    public ArrayList<Integer> getIb(){
        return ib;
    }

    public void setColor(int color){
        this.color = color;
    }

    public int getColor(){
        return this.color;
    }

    protected void addIndices(Integer... i){
        ib.addAll(Arrays.asList(i));
    }

    public Mat4 getModelMatrix(){
        return modelMatrix;
    }

    public void setModelMatrix(Mat4 modelMatrix){
        if(modelMatrix != null)
            this.modelMatrix = modelMatrix;
    }
}
