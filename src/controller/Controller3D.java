package controller;

import rasterize.LineRasterizer;
import rasterize.LineRasterizerTrivial;
import renderer.Renderer;
import renderer.WireRenderer;
import solid.Arrow;
import transforms.Mat4RotZ;
import transforms.Mat4Scale;
import transforms.Mat4Transl;
import view.CanvasPanel;
import view.Window;

public class Controller3D {
    private final Window window;
    private final CanvasPanel canvasPanel;

    // Rasterizers
    private final LineRasterizer lineRasterizer;

    //Arrow
    private final Arrow arrow;

    //Renderer
    private final Renderer renderer;

    public Controller3D(Window window) {
        this.window = window;
        this.canvasPanel = this.window.getPanel();
        this.arrow = new Arrow();
        lineRasterizer = new LineRasterizerTrivial(canvasPanel.getRaster());

        renderer = new WireRenderer(lineRasterizer);

        drawScene();
    }

    private void drawScene() {
        canvasPanel.getRaster().clear();

        arrow.setModelMatrix(new Mat4Scale(0.5));
        renderer.render(arrow);

        canvasPanel.repaint();
    }
}
