package controller;

import rasterize.LineRasterizer;
import rasterize.LineRasterizerTrivial;
import renderer.Renderer;
import renderer.WireRenderer;
import solid.Arrow;
import solid.AxisX;
import solid.AxisY;
import solid.AxisZ;
import transforms.*;
import view.CanvasPanel;
import view.Window;

import javax.swing.plaf.basic.BasicListUI;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public class Controller3D {
    private final Window window;
    private final CanvasPanel canvasPanel;

    // Rasterizers
    private final LineRasterizer lineRasterizer;

    //Arrow
    private final Arrow arrow;

    //Axes
    private final AxisX axisX;
    private final AxisY axisY;
    private final AxisZ axisZ;
    //Renderer
    private final WireRenderer renderer;

    //Camera
    private final Camera camera;

    private final Mat4 projMat;

    public Controller3D(Window window) {
        this.window = window;
        this.canvasPanel = this.window.getPanel();
        this.arrow = new Arrow();

        this.axisX = new AxisX();
        this.axisY = new AxisY();
        this.axisZ = new AxisZ();

        this.camera = new Camera()
                .withPosition(new Vec3D(0.2, -1.5,1))
                .withAzimuth(Math.toRadians(90)) //horizontal rotation
                .withZenith(Math.toRadians(-25)) //vertical rotation
                .withFirstPerson(true);

        this.projMat = new Mat4PerspRH(Math.toRadians(90),
                (double) canvasPanel.getRaster().getHeight() / canvasPanel.getRaster().getWidth(),
                0.1,
                100);

        lineRasterizer = new LineRasterizerTrivial(canvasPanel.getRaster());



        renderer = new WireRenderer(this.lineRasterizer);
        renderer.setViewMatrix(this.camera.getViewMatrix());
        renderer.setProjMatrix(this.projMat);
        renderer.setWidth(canvasPanel.getRaster().getWidth());
        renderer.setHeight(canvasPanel.getRaster().getHeight());
        drawScene();
        initListeners();
    }

    private void initListeners() {
        window.getPanel().addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                //todo add control
            }
            @Override
            public void mouseDragged(MouseEvent e){
                //todo add control
            }
        });

        window.getPanel().addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                //todo add control
            }

            @Override
            public void keyReleased(KeyEvent e){
                //todo add control
            }
        });
    }

    private void drawScene() {
        canvasPanel.getRaster().clear();

        arrow.setModelMatrix(new Mat4Transl(0,0,0.5));

        renderer.render(arrow);
        renderer.render(axisX);
        renderer.render(axisY);
        renderer.render(axisZ);

        canvasPanel.repaint();
    }
}
