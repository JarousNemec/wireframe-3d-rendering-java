package renderer;

import rasterize.LineRasterizer;
import solid.Solid;
import transforms.Camera;
import transforms.Mat4;
import transforms.Mat4Identity;
import transforms.Vec3D;

import java.util.List;

public class WireRenderer implements Renderer {

    private final LineRasterizer lineRasterizer;
    private Mat4 viewMatrix = new Mat4Identity();
    private Mat4 projMatrix = new Mat4Identity();

    private int height = 1;
    private int width = 1;

    public WireRenderer(LineRasterizer lineRasterizer) {
        this.lineRasterizer = lineRasterizer;
    }

    public void render(Solid solid) {
        var vertices = solid.getVb();
        var indexes = solid.getIb();
        for (int i = 0; i < indexes.size() - 1; i = i + 2) {

            var indexA = indexes.get(i);
            var indexB = indexes.get(i + 1);

            var pA = vertices.get(indexA);
            var pB = vertices.get(indexB);
            //model space -> world space -> view camera space -> clip space
            pA = pA.mul(solid.getModelMatrix()).mul(viewMatrix).mul(projMatrix);
            pB = pB.mul(solid.getModelMatrix()).mul(viewMatrix).mul(projMatrix);

            //TODO ořezání prostě jsme clipspace takže nějaký shuterland atd...

            //dehomogenizace -> vydělení w
            if (pA.getW() == 0.0 || pB.getW() == 0.0)
                continue;
            Vec3D vA = pA.mul(1 / pA.getW()).ignoreW();
            Vec3D vB = pB.mul(1 / pB.getW()).ignoreW();

            //transform to window
            vA = vA.mul(new Vec3D(1, -1, 1))
                    .add(new Vec3D(1, 1, 0))
                    .mul(new Vec3D(((double) width - 1) / 2, ((double) height - 1) / 2, 1));

            vB = vB.mul(new Vec3D(1, -1, 1))
                    .add(new Vec3D(1, 1, 0))
                    .mul(new Vec3D(((double) width - 1) / 2, ((double) height - 1) / 2, 1));

            lineRasterizer.setColor(solid.getColor());
            lineRasterizer.rasterize((int) vA.getX(), (int) vA.getY(), (int) vB.getX(), (int) vB.getY());
            lineRasterizer.resetColor();
        }
    }

    public void render(List<Solid> solids) {
        for (var target : solids)
            render(target);
    }

    public void setViewMatrix(Mat4 viewMatrix) {
        this.viewMatrix = viewMatrix;
    }

    public void setProjMatrix(Mat4 projMatrix) {
        this.projMatrix = projMatrix;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }
}
