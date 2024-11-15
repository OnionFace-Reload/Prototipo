package com.application.menus;

import java.util.HashMap;
import java.util.Map;

import com.application.widgets.WidgetButton;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.MapValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Menu extends Scene{
	
	private TextField nom, grad, grup;
	private Button buscar, agregar;
	
	private TableView tableView;
	
	public Menu(Stage stage) {
		super(new VBox(), 700, 600);
		
		init();
		
		getStylesheets().add(getClass().getResource("/css/menu.css").toExternalForm());
		getStylesheets().add(getClass().getResource("/css/buttonStyle.css").toExternalForm());
		getStylesheets().add(getClass().getResource("/css/textFieldStyle.css").toExternalForm());
		getStylesheets().add(getClass().getResource("/css/tableField.css").toExternalForm());
		
	}
	
	private void init() {
		
		nom = new TextField();
		nom.setPromptText("Buscar Alumnos...");
		nom.getStyleClass().add("textfield-1");
		
		grad = new TextField();
		grad.setPromptText("Grado...");
		grad.getStyleClass().add("textfield-2");
		
		grup = new TextField();
		grup.setPromptText("Grupo...");
		grup.getStyleClass().add("textfield-2");
		
		tableView = new TableView();
		
		TableColumn<Map, String> nombreColumn = new TableColumn<>("Nombre del alumno");
		nombreColumn.setCellValueFactory(new MapValueFactory<>("aluName"));
		nombreColumn.getStyleClass().add("column");
		
		TableColumn<Map, String> gradoColumn = new TableColumn<>("Grado");
		gradoColumn.setCellValueFactory(new MapValueFactory<>("gardName"));
		gradoColumn.getStyleClass().add("column");
		
		TableColumn<Map, String> grupoColumn = new TableColumn<>("Grupo");
		grupoColumn.setCellValueFactory(new MapValueFactory<>("grupName"));
		grupoColumn.getStyleClass().add("column");
		
		TableColumn<Map, String> espeColumn = new TableColumn<>("Especialidad");
		espeColumn.setCellValueFactory(new MapValueFactory<>("espName"));
		espeColumn.getStyleClass().add("column");
		
		tableView.getColumns().addAll(nombreColumn, gradoColumn, grupoColumn, espeColumn);
		
		ObservableList<Map<String, Object>> item = FXCollections.<Map<String, Object>>observableArrayList();
		
		tableView.setItems(item);
		
		tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
		
		buscar = WidgetButton.widgetButton("Buscar", "button", null);
		
		agregar = WidgetButton.widgetButton("Agregar", "button", e -> {
			
			String nomb = nom.getText();
			String gra = grad.getText();
			String gru = grup.getText();
			
			Map<String, Object> item1 = new HashMap<>();
			
			item1.put("aluName", nomb);
			item1.put("gardName", gra);
			item1.put("grupName", gru);
			item.add(item1);
			
		});
		
		panels();
		
	}
	
	private void table() {
		
	}
	
	private void panels() {
		
		HBox hbox = new HBox(10);
		hbox.getChildren().addAll(nom, grad, grup, buscar, agregar);
		
		VBox layout = (VBox) getRoot();
		layout.setSpacing(10);
		
		layout.requestFocus();
		
		layout.getStyleClass().add("hbox");
		
		layout.getChildren().clear();
		layout.getChildren().addAll(hbox, tableView);
		
	}

}
