import javafx.geometry.Point2D;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;


public class ArbolGrafico extends Canvas {

	private ArbolBinario tree;  	 
	private Circulo insertCircle;
	
	public ArbolGrafico() {

		widthProperty().addListener(evt -> drawTree());
		heightProperty().addListener(evt -> drawTree());

		createTree();
	}
	
	public void setTree(ArbolBinario root) {  
		tree = root; 
	}

	public void createTree() {

		tree = new ArbolBinario();
		drawTree();
	}

	public void search(Integer searchKey) {
		tree.retrieveItem(searchKey); 
		drawTree();
	}



	public void insert(Integer searchKey) {
		insertCircle = new Circulo(searchKey);
		tree.insertItem(insertCircle);
		drawTree();

	}


	public void makeEmpty() {
		tree.makeEmpty();
        getGraphicsContext2D().clearRect(0, 0, getWidth(), getHeight());
	}

	public void drawTree() {
		double width = getWidth();
		double height = getHeight();

		GraphicsContext gc = getGraphicsContext2D();
		gc.clearRect(0, 0, width, height);

		if (tree.root != null) {
			int treeHeight = tree.getHeight(tree.root);
			drawLines(gc, tree.getRoot(), 0, this.getWidth(), 0, this.getHeight() / treeHeight);
			drawCircles(gc, tree.getRoot(), 0, this.getWidth(), 0, this.getHeight() / treeHeight);
		}
	}
	
	public void drawLines(GraphicsContext gc, Nodo treeNode, double xMin, double xMax, double yMin, double yMax) {

		Point2D linePoint1;
		Point2D linePoint2;
		Linea newLine = new Linea();
		
		if (treeNode.leftCircle != null) {
			
			linePoint1 = new Point2D(((xMin + xMax) / 2), yMin + yMax / 2);
			linePoint2 = new Point2D(((xMin + (xMin + xMax) / 2) / 2), yMin + yMax + yMax / 2);
			newLine.setPoint(linePoint1, linePoint2);
			newLine.draw(gc);
			
			drawLines(gc, treeNode.leftCircle, xMin, (xMin + xMax) / 2, yMin + yMax, yMax);
		}

		if (treeNode.rightCircle != null) {
			
			linePoint1 = new Point2D((xMin + xMax) / 2, yMin + yMax / 2);
			linePoint2 = new Point2D((xMax + (xMin + xMax) / 2) / 2, yMin + yMax + yMax / 2);
			newLine.setPoint(linePoint1, linePoint2);
			newLine.draw(gc);
		
			drawLines(gc, treeNode.rightCircle, (xMin + xMax) / 2, xMax, yMin + yMax, yMax);
		}
	}

	public void drawCircles(GraphicsContext gc, Nodo treeNode, double xMin, double xMax, double yMin, double yMax) {

		Point2D point = new Point2D((xMin + xMax) / 2, yMin + yMax / 2);
		if (treeNode.highlightFlag) {
			insertCircle = null;
			treeNode.highlightFlag = false;
			treeNode.rootCircle.setHighlighter(true);
			treeNode.rootCircle.setPoint(point); 	

		} else {
			treeNode.rootCircle.setHighlighter(false);
			treeNode.rootCircle.setPoint(point);
		}
		
		treeNode.rootCircle.draw(gc);
		
		if (treeNode.leftCircle != null) {
			drawCircles(gc, treeNode.leftCircle, xMin, (xMin + xMax) / 2, yMin + yMax,	yMax);
		}
		
		if (treeNode.rightCircle != null) {
			drawCircles(gc, treeNode.rightCircle, (xMin + xMax) / 2, xMax, yMin + yMax, yMax);
		}
	}

	public void clearCanvas() {
		getGraphicsContext2D().clearRect(0, 0, this.getWidth(), this.getHeight());
	}
}

