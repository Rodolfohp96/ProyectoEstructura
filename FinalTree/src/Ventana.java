import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;


import java.net.URL;
import java.util.ResourceBundle;


public final class Ventana implements Initializable {

	@FXML private BorderPane root_container;
	@FXML private TextField input_field;

	private ArbolGrafico graphicsTree;
	Avl<Integer> arbol= new Avl<>();

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		graphicsTree = new ArbolGrafico();
		root_container.setCenter(graphicsTree);

		graphicsTree.widthProperty().bind(root_container.widthProperty());
		graphicsTree.heightProperty().bind(root_container.heightProperty().subtract(50));
	}

	@FXML private void searchOnAction(ActionEvent event) {
		try {
			graphicsTree.search(Integer.parseInt(input_field.getText().trim()));
		} catch (NumberFormatException nfe) {

		}
	}

	@FXML private void deleteOnAction(ActionEvent event) {
		try {
			int[] nuevo = arbol.arrayEliminado(Integer.parseInt(input_field.getText().trim()));
			arbol.eliminarArbol();
			graphicsTree.makeEmpty();
			for(int i = 0;i < nuevo.length;i++) {
				arbol.insertarElemento(nuevo[i]);
			}
			arbol.recorreEnPreOrden();
			for(int i = 0;i < arbol.getPreOrder().length;i++) {
				graphicsTree.insert(arbol.getPreOrder()[i]);
			}
		} catch (NumberFormatException nfe) {
		}
	}

	@FXML private void insertOnAction(ActionEvent event) {
		try {
			arbol.insertarElemento(Integer.parseInt(input_field.getText().trim()));
			graphicsTree.makeEmpty();
			arbol.recorreEnPreOrden();
			
			for(int i = 0;i < arbol.getPreOrder().length;i++) {
				graphicsTree.insert(arbol.getPreOrder()[i]);
			}
		} catch (NumberFormatException nfe) {
		}
	}


}