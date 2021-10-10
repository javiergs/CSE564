import java.awt.*;

public class City {
   
    private Rectangle bounds;
    private String label;
    private final static int DEFAULT_SIZE = 10;
    
    public City (String label, int x, int y, int w, int h) {
        bounds = new Rectangle(x, y, w, h);
        this.label = label;
    }

    public City (String label, int x, int y) {
        this(label, x, y, DEFAULT_SIZE, DEFAULT_SIZE);
    }
    
    public int getX() {
        return bounds.x;
    }

    public int getY() {
        return bounds.y;
    }

    public void draw (Graphics g) {
        Color c = g.getColor();
        int x = bounds.x, y = bounds.y, h = bounds.height, w = bounds.width;
        g.drawRect(x, y, w, h);
        g.setColor(Color.WHITE);
        g.fillRect(x + 1, y + 1, w - 1, h - 1);
        g.setColor(Color.RED);
        g.setFont(new Font("Courier", Font.PLAIN, 10));
        g.drawString(label, x + w, y);
        g.setColor(c);
    }

    public void move(int x, int y) {
        bounds.x = x;
        bounds.y = y;
    }
    
    public void drawConnect(City b, Graphics2D g) {
        g.drawLine(center().x, center().y, b.center().x, b.center().y);
    }
    
    public boolean contains(int x, int y) {
        return bounds.contains(x, y);
    }
    
    public void setLabel(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
    
    private Point center() {
        return new Point(
          bounds.x + bounds.width / 2,
          bounds.y + bounds.height / 2
        );
    }
    
}
