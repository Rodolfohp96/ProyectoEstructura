
import java.util.Objects;

public final class ArbolBinario {

	public Nodo root;

	public ArbolBinario() {
		this.root = null;
	}
	
	public void insertItem(Circulo newCirculo) {
		root = insertItem(root, newCirculo);
	}
	
	public Nodo insertItem(Nodo nodo, Circulo newCirculo) {
		Nodo newSubtree;
		
		if (nodo == null) {
			nodo = new Nodo(newCirculo);
			return nodo;
		}
		
		Circulo nodeItem = nodo.rootCircle;

		if(Objects.equals(newCirculo.getSearchKey(), nodeItem.getSearchKey())) {
		    return nodo;
        }

		if (newCirculo.getSearchKey() < nodeItem.getSearchKey()) {
			newSubtree = insertItem(nodo.leftCircle, newCirculo);
			nodo.leftCircle = newSubtree;
			return nodo;
		}
		
		newSubtree = insertItem(nodo.rightCircle, newCirculo);
		nodo.rightCircle = newSubtree;
		return nodo;
	}
	
	public Integer retrieveItem(Integer searchKey) {
		return retrieveItem(root, searchKey);
	}
	
	public Integer retrieveItem(Nodo nodo, Integer searchKey) {
		Integer treeItem;
		if (nodo == null) {
			treeItem = null;

		} else {
			nodo.highlightFlag = true;
			Circulo nodeItem = nodo.rootCircle;
			if (Objects.equals(searchKey, nodeItem.getSearchKey())) {
				nodo.highlightFlag = true;
				treeItem = nodo.rootCircle.getSearchKey();
			} else if (searchKey < nodeItem.getSearchKey()) {
				nodo.leftCircle.highlightFlag = true;
				treeItem = retrieveItem(nodo.leftCircle, searchKey);
			} else {
				nodo.rightCircle.highlightFlag = true;
				treeItem = retrieveItem(nodo.rightCircle, searchKey);
			}
		}

		return treeItem;
	}
	
	public void setResetColor(Nodo nodo) {
		 resetColor(nodo);
	}
	
	public void resetColor(Nodo nodo) {
		if (nodo != null) {
			nodo.highlightFlag = false;

			if (nodo.leftCircle != null) {
				nodo.leftCircle.highlightFlag = false;
			}

			if (nodo.rightCircle != null) {
				nodo.rightCircle.highlightFlag = false;
			}
			resetColor(nodo.leftCircle);
			resetColor(nodo.rightCircle);
		}
	}

	public int getHeight(Nodo root) {
		if (root == null)
			return 0;
		return Math.max(getHeight(root.leftCircle), getHeight(root.rightCircle)) + 1;
	}
	
	public int getSize(Nodo root) {
		if (root == null)
			return 0;
		return (getSize(root.leftCircle) + getSize(root.rightCircle)) + 1;
	}
	
	public void setRootItem(Circulo newItem) {
		root = new Nodo(newItem);
	}
	
	public Nodo getRoot() {
		return root;
	}
	public void makeEmpty() {
		root = null;
	}
}
