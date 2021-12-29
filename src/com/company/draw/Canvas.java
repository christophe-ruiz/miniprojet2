package com.company.draw;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.image.ImageObserver;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Canvas {
    private static Canvas canvasSingleton;
    private final JFrame frame = new JFrame();
    private final Canvas.CanvasPane canvas = new Canvas.CanvasPane();
    private Graphics2D graphic;
    private final Color backgroundColor;
    private Image canvasImage;
    private final List<Object> objects;
    private final HashMap<Object, Canvas.ShapeDescription> shapes;

    public static Canvas getCanvas() {
        if (canvasSingleton == null) {
            canvasSingleton = new Canvas("BlueJ Picture Demo", 2500, 100, Color.white);
        }

        canvasSingleton.setVisible(true);
        return canvasSingleton;
    }

    private Canvas(String title, int width, int height, Color bgColor) {
        this.frame.setContentPane(this.canvas);
        this.frame.setTitle(title);
        this.frame.setLocation(30, 30);

        this.canvas.setPreferredSize(new Dimension(width, height));
        this.backgroundColor = bgColor;
        this.frame.pack();
        this.objects = new ArrayList();
        this.shapes = new HashMap();
    }

    public JFrame getFrame() {
        return frame;
    }

    private void setVisible(boolean visible) {
        if (this.graphic == null) {
            Dimension size = this.canvas.getSize();
            this.canvasImage = this.canvas.createImage(size.width, size.height);
            this.graphic = (Graphics2D)this.canvasImage.getGraphics();
            this.graphic.setColor(this.backgroundColor);
            this.graphic.fillRect(0, 0, size.width, size.height);
            this.graphic.setColor(Color.black);
        }

        this.frame.setVisible(visible);
    }

    void draw(Object referenceObject, String color, Shape shape) {
        this.objects.remove(referenceObject);
        this.objects.add(referenceObject);
        this.shapes.put(referenceObject, new Canvas.ShapeDescription(shape, color));
        this.redraw();
    }

    void erase(Object referenceObject) {
        this.objects.remove(referenceObject);
        this.shapes.remove(referenceObject);
        this.redraw();
    }

    private void setForegroundColor(String colorString) {
        if (colorString.equals("red")) {
            this.graphic.setColor(new Color(235, 25, 25));
        } else if (colorString.equals("black")) {
            this.graphic.setColor(Color.black);
        } else if (colorString.equals("blue")) {
            this.graphic.setColor(new Color(30, 75, 220));
        } else if (colorString.equals("yellow")) {
            this.graphic.setColor(new Color(255, 230, 0));
        } else if (colorString.equals("green")) {
            this.graphic.setColor(new Color(80, 160, 60));
        } else if (colorString.equals("magenta")) {
            this.graphic.setColor(Color.magenta);
        } else if (colorString.equals("white")) {
            this.graphic.setColor(Color.white);
        } else {
            this.graphic.setColor(Color.black);
        }

    }

    void wait(int milliseconds) {
        try {
            Thread.sleep((long)milliseconds);
        } catch (Exception var3) {
        }

    }

    private void redraw() {
        this.erase();
        Iterator var1 = this.objects.iterator();

        while(var1.hasNext()) {
            Object shape = var1.next();
            ((Canvas.ShapeDescription)this.shapes.get(shape)).draw(this.graphic);
        }

        this.canvas.repaint();
    }

    void erase() {
        Color original = this.graphic.getColor();
        this.graphic.setColor(this.backgroundColor);
        Dimension size = this.canvas.getSize();
        this.graphic.fill(new Rectangle(0, 0, size.width, size.height));
        this.graphic.setColor(original);
    }

    private class ShapeDescription {
        private Shape shape;
        private String colorString;

        public ShapeDescription(Shape shape, String color) {
            this.shape = shape;
            this.colorString = color;
        }

        public void draw(Graphics2D graphic) {
            Canvas.this.setForegroundColor(this.colorString);
            graphic.fill(this.shape);
        }
    }

    private class CanvasPane extends JPanel {
        private CanvasPane() {
        }

        public void paint(Graphics g) {
            g.drawImage(Canvas.this.canvasImage, 0, 0, (ImageObserver)null);
        }
    }
}

