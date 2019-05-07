public class Node<T> {
	
	private T elemento;
	private Node<T> izquierda;
	private Node<T> derecha;
	private int altura;
	
	
	public Node(T elemento) {
		this.elemento=elemento;
	}
	public T getElemento() {
		return elemento;
	}
	public void setElemento(T elemento) {
		this.elemento = elemento;
	}
	public Node<T> getIzquierda() {
		return izquierda;
	}
	public void setIzquierda(Node<T> izquierda) {
		this.izquierda = izquierda;
	}
	public Node<T> getDerecha() {
		return derecha;
	}
	public void setDerecha(Node<T> derecha) {
		this.derecha = derecha;
	}
	public int getAltura() {
		return altura;
	}
	public void setAltura(int altura) {
		this.altura = altura;
	}
}