
public class Nodo {
	
	public Circulo rootCircle;
	public Nodo leftCircle;
	public Nodo rightCircle;
	public boolean highlightFlag;
	
	public Nodo(Circulo rootCircle) {
		this.rootCircle = rootCircle;
		this.leftCircle = null;
		this.rightCircle = null;
	}	
}
