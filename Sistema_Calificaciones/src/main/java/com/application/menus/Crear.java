package com.application.menus;

import com.application.widgets.Widget;
import com.application.widgets.WidgetButton;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Crear extends Scene{
	
	private Stage stage;
	private VBox vbox;
	
	private Button atras, crear;
	
	public Crear(Stage stage) {
		super(new StackPane(), 700, 600);
		
		this.stage = stage;
		
		init();
		
		getStylesheets().add(getClass().getResource("/css/crear.css").toExternalForm());
		
	}
	
	private void scenes() {
		
		Sesion sesion = new Sesion(stage);
		Widget.widgetTransition(stage, 500, this, sesion);
		
	}
	
	private void init() {
		
		Label usser = new Label("Nombre del Profesor:");
		Label email = new Label("Correo electronico:");
		Label pass = new Label("Crear una contraseña:");
		Label school = new Label("Nombre de la escuela:");
		
		TextField nombre = new TextField();
		nombre.setPromptText("Nombre Completo y en Mayusculas...");
		
		TextField correo = new TextField();
		correo.setPromptText("Utiliza un correo institucional...");
		correo.getStyleClass().add("correo");
		
		PasswordField contra = new PasswordField();
		contra.setPromptText("No compartas la contraseña con nadie(Utiliza numeros, simbolos y mayusculas)");
		
		TextField escuela = new TextField();
		escuela.setPromptText("Nombre en mayusculas o siglas en mayusculas");
		escuela.getStyleClass().add("escuela");
		
		vbox = new VBox(15, usser, nombre, email, correo, pass, contra, school, escuela);
		
		atras = WidgetButton.widgetButton("Regresar", "button", e -> {
			
			scenes();
			
		});
		
		crear = WidgetButton.widgetButton("Crear cuenta", "button", null);
		
		panels();
		
	}
	
	private void panels() {
		
		StackPane pane = (StackPane) getRoot();
		pane.getStyleClass().add("pane");
		
		HBox hbox = new HBox(atras, new Region(), crear);
		hbox.setHgrow(hbox.getChildren().get(1), Priority.ALWAYS);
		
		vbox.getChildren().add(hbox);
		pane.getChildren().add(vbox);
		
	}

}
