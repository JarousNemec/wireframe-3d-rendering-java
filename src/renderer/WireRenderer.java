package renderer;

import rasterize.LineRasterizer;
import solid.Solid;

import java.util.List;

public class WireRenderer implements Renderer{

    private final LineRasterizer lineRasterizer;

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

            pA = pA.mul(solid.getModelMatrix());
            pB = pB.mul(solid.getModelMatrix());

            lineRasterizer.rasterize((int) pA.getX(), (int) pA.getY(), (int) pB.getX(), (int) pB.getY());
        }
    }

    public void render(List<Solid> solids) {
        for (var target : solids)
            render(target);
    }
}
