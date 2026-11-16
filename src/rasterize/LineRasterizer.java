package rasterize;

import raster.Raster;
import transforms.Point2D;
import utils.ColorUtil;


public abstract class LineRasterizer implements Rasterizer {
    protected Raster raster;
    protected int defaultColor = ColorUtil.DEFAULT_LINE_COLOR;
    protected int color = defaultColor;


    public LineRasterizer(Raster raster) {
        this.raster = raster;
    }

    public LineRasterizer(Raster raster, int defaultColor) {
        this.raster = raster;
        this.defaultColor = defaultColor;
    }

    public int getColor() {
        return color;
    }

    public int getDefaultColor() {
        return defaultColor;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public void setDefaultColor(int defaultColor) {
        this.defaultColor = defaultColor;
    }

    public void resetColor() {
        this.color = defaultColor;
    }

    //Point2D from transforms has double coordinates, so they are rounded to the nearest pixel
    public void rasterize(Point2D p1, Point2D p2) {
        rasterize(round(p1.getX()), round(p1.getY()), round(p2.getX()), round(p2.getY()));
    }

    public void rasterize(int x1, int y1, Point2D p2) {
        rasterize(x1, y1, round(p2.getX()), round(p2.getY()));
    }

    public void rasterize(Point2D p1, int x2, int y2) {
        rasterize(round(p1.getX()), round(p1.getY()), x2, y2);
    }

    private static int round(double value) {
        return (int) Math.round(value);
    }

    // Every rasterize method overload uses this method in result
    public abstract void rasterize(int x1, int y1, int x2, int y2);

    public boolean isPointInRaster(int x, int y) {
        return (x >= 0 && y >= 0 && x < raster.getWidth() && y < raster.getHeight());
    }
}
