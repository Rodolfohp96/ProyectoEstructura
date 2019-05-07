import com.sun.javafx.tk.FontMetrics;
import com.sun.javafx.tk.Toolkit;
import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;



@SuppressWarnings("restriction")
public final class Circulo {
	

	final Font font =  Font.font("Dialog", 35);
	final FontMetrics fm = Toolkit.getToolkit().getFontLoader().getFontMetrics(font);

	private static final int RADIUS = 50;
	
	private final Integer searchKey;
	
	private Point2D point;
	private Color backgroundColor;
	private Color borderColor;
	private Color fontColor;

	public Circulo(Integer searchKey) {
		this.searchKey = searchKey;
		this.backgroundColor = Color.web("#FCFCFC");
	}
	

	public Circulo(Integer searchKey, Point2D point) {
		this.searchKey = searchKey;
		this.point = point;
		this.backgroundColor = Color.rgb(49, 116, 222);
		this.setBorderColor(Color.rgb(99, 99, 99));
		this.fontColor = Color.web("#FCFCFC");
		 
		
	}


	public void draw(GraphicsContext gc) {
		gc.setLineWidth(3);
		gc.setFill(backgroundColor);
		gc.fillOval(point.getX() - RADIUS, point.getY() - RADIUS, 2 * RADIUS, 2 * RADIUS);
		gc.setStroke(borderColor);
		gc.strokeOval(point.getX() - RADIUS, point.getY() - RADIUS, 2 * RADIUS, 2 * RADIUS);
		gc.setFont(font);
		gc.setFill(getFontColor());
		gc.fillText(getKey(),
				 point.getX() - (fm.computeStringWidth(getKey()) / 2),
				 point.getY() + (fm.getAscent() / 4));
	}

	public String getKey() {
		return Integer.toString(getSearchKey());
	}
	
	public Integer getSearchKey() {
		return this.searchKey;
	}
	
	public Color getBorderColor() {
		return borderColor;
	}
	
	public void setBorderColor(Color borderColor) {
		this.borderColor = borderColor;
	}
	
	public Point2D getPoint() {
		return point;
	}
	
	public void setPoint(Point2D point) {
		this.point = point;
	}
	
	public Color getBackgroundColor() {
		return backgroundColor;
	}
	
	public void setBackgroundColor(Color color) {
		this.backgroundColor = color;
	}

	public int getRadius() {
		return RADIUS;
	}
	

	public Color getFontColor() {
		return this.fontColor;
	}
	
	public void setFontColor(Color fontColor) {
		this.fontColor = fontColor;
	}
	
	public void setHighlighter(boolean highlight) {
		if (highlight) {
			setFontColor(Color.rgb(49, 116, 222));
			setBackgroundColor(Color.rgb(122, 144, 255));
			setBorderColor(Color.rgb(255, 119, 0));
	
		} else {
			setFontColor(Color.web("#FCFCFC"));
			setBackgroundColor(Color.rgb(0, 31, 188));
			setBorderColor(Color.rgb(0, 0, 0));
		}
	}
	@Override
	public String toString() {
		
		return "Search Key# " + searchKey  + 
				" (x,y) = ("  + point.getX() + ", " + point.getY() + ")";
	}
}