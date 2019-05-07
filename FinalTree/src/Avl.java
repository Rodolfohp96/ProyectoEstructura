
public class Avl<T extends Comparable<T>> {
	
	private int[] preOrder;
	private int pos;
	private int tam = 0;
	private Node<T> raiz;
	public Node<T> getRaiz() {
		return raiz;
	}
	
	
	public void insertarElemento(T elemento) {
		raiz= insertaRecursivo(elemento,raiz);
		tam++;
	}
	
	
	public Node<T> insertaRecursivo(T elemento,Node<T> raiz) {
		if(raiz==null) {
			raiz= new Node<T>(elemento);
		}else {
			if(elemento.compareTo(raiz.getElemento())>0) {
				raiz.setDerecha(insertaRecursivo(elemento, raiz.getDerecha()));
				if(altura(raiz.getIzquierda())-altura(raiz.getDerecha())==-2) {
					if(elemento.compareTo(raiz.getDerecha().getElemento())>0) {
						raiz= rotaSimpleALaIzquierda(raiz);
					}else {
						raiz= rotarDobleALaIzquierda(raiz);
					}
				}
			}
			if(elemento.compareTo(raiz.getElemento())<0) {
				raiz.setIzquierda(insertaRecursivo(elemento, raiz.getIzquierda()));
				if(altura(raiz.getIzquierda())-altura(raiz.getDerecha())==2) {
					if(elemento.compareTo(raiz.getIzquierda().getElemento())<0) {
						raiz= rotaSimpleALaDerecha(raiz);
					}else {
						raiz= rotarDobleALaDerecha(raiz);
					}
				}	
			}
		}
		
		int altura= max(altura (raiz.getIzquierda()),altura(raiz.getDerecha()));
		raiz.setAltura(altura+1);
		return raiz;
	}
	
	private Node<T> rotaSimpleALaIzquierda(Node<T> raiz){
		Node<T> temp= raiz.getDerecha();
		raiz.setDerecha(temp.getIzquierda());
		temp.setIzquierda(raiz);
		raiz.setAltura(max(altura(raiz.getIzquierda()),altura(raiz.getDerecha()))+1);
		temp.setAltura(max(altura(temp.getDerecha()),altura(raiz))+1);
		return temp;
	}
	private Node<T> rotaSimpleALaDerecha(Node<T> raiz){
		Node<T> temp= raiz.getIzquierda();
		raiz.setIzquierda(temp.getDerecha());
		temp.setDerecha(raiz);
		raiz.setAltura(max(altura(raiz.getIzquierda()),altura(raiz.getDerecha()))+1);
		temp.setAltura(max(altura(temp.getIzquierda()),altura(raiz))+1);
		return temp;
	}	
	
	private Node<T> rotarDobleALaIzquierda(Node<T> raiz){
		raiz.setDerecha(rotaSimpleALaDerecha(raiz.getDerecha()));
		return rotaSimpleALaIzquierda(raiz);
	}
	private Node<T> rotarDobleALaDerecha(Node<T> raiz){
		raiz.setIzquierda(rotaSimpleALaIzquierda(raiz.getIzquierda()));
		return rotaSimpleALaDerecha(raiz);
	}
	private int max(int a, int b) {
		if(a>b) {
			return a;
		}else {
			return b;
		}
	}
	
	private int altura(Node<T> nodo) {
		if(nodo==null) {
			return -1;
		}else {
			return nodo.getAltura();
		}
	}
	
	public void recorreEnPreOrden() {
		preOrder = new int[tam];
		pos = 0;
		recorreEnPreOrdenRec(raiz);
		
	}
	
	private void recorreEnPreOrdenRec(Node<T> nodo) {
		if(nodo!=null) {
			preOrder[pos] = (int) nodo.getElemento();
			pos++;
			recorreEnPreOrdenRec(nodo.getIzquierda());
			recorreEnPreOrdenRec(nodo.getDerecha());
		}
	}


	public int[] getPreOrder() {
		return preOrder;
	}


	public void setPreOrder(int[] preOrder) {
		this.preOrder = preOrder;
	}
	
	public int[] arrayEliminado(int elem){
		int[] intArr = preOrder;
		int[] newArr = new int[preOrder.length-1];
		for(int i = 0; i < intArr.length; i++){
			
            if(intArr[i] == elem){
                for(int j = i; j < intArr.length - 1; j++){
                    newArr[j] = intArr[j+1];
                }
                
                break;
            }else{
            	newArr[i] = intArr[i];
            }
        }
		return newArr;
	}
	
	public void eliminarArbol(){
		tam = 0;
		raiz = null;
	}
	
	
	
	
}
