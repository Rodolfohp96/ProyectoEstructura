
import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;


public final class Linea {

	private static final Color UI_DEFAULT_COLOR = Color.rgb(255, 0, 0);
	
	private Point2D point, point2;
	private Color color;
	
	public Linea() {
		this.color = UI_DEFAULT_COLOR;
	}
	
	public Linea(Point2D point, Point2D point2) {
		this.point = point;
		this.point2 = point;
		this.color = UI_DEFAULT_COLOR;
	}

	public void draw(GraphicsContext gc) {

		gc.setLineWidth(20); 
		gc.setStroke(color);
		gc.strokeLine(point.getX(), point.getY(), point2.getX(), point2.getY());
	}
	
	public Point2D getPoint() {
		return point;
	}
	
	public void setPoint(Point2D point, Point2D point2) {
		this.point = point;
		this.point2 = point2;
	}

	public Point2D getPoint2() {
		return point2;
	}

	@Override
	public String toString() {
		
		return " (x,y) = ("  + point.getX() + ", " + point.getY() + ")"
			+  " (x,y) = ("  + point2.getX() + ", " + point2.getY()+ ")";
	}
}
