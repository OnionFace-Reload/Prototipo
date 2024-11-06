package com.application.menus;

import javafx.animation.FadeTransition;
import javafx.animation.ScaleTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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
import javafx.util.Duration;

public class Crear extends Scene{
	
	public Crear(Stage stage) {
		super(new StackPane(), 700, 600);
		
		StackPane pane = (StackPane) getRoot();
		pane.getStyleClass().add("pane");
		
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
		
		VBox vbox = new VBox(15, usser, nombre, email, correo, pass, contra, school, escuela);
		
		Button atras = crearBoton("Regresar", e -> {
			
			FadeTransition cambio = new FadeTransition(Duration.millis(500), this.getRoot());
			cambio.setFromValue(1.0);
			cambio.setToValue(0.0);
			cambio.setOnFinished(event -> {
				
				Sesion sesion = new Sesion(stage);
				stage.setScene(sesion);
				
			});
			
			cambio.play();
			
		});
		Button crear = crearBoton("Crear cuenta", null);
		
		HBox hbox = new HBox(atras, new Region(), crear);
		hbox.setHgrow(hbox.getChildren().get(1), Priority.ALWAYS);
		
		vbox.getChildren().add(hbox);
		pane.getChildren().add(vbox);
		getStylesheets().add(getClass().getResource("/css/crear.css").toExternalForm());
		
	}
	
	private Button crearBoton(String text, EventHandler<ActionEvent> action) {
		
		Button button = new Button(text);
		button.getStyleClass().add("button");
		
		ScaleTransition Transicion = new ScaleTransition(Duration.millis(100), button);
		
		button.setOnMouseEntered(e -> {
			
			Transicion.setToX(1.1);
			Transicion.setToY(1.1);
			Transicion.play();
			
		});
		
		button.setOnMouseExited(e -> {
			
			Transicion.setToX(1.0);
			Transicion.setToY(1.0);
			Transicion.play();
			
		});
		
		button.setOnMousePressed(e -> {
			
			Transicion.setToX(1.0);
			Transicion.setToY(1.0);
			Transicion.play();
			
		});
		
		button.setOnMouseReleased(e -> {
			
			Transicion.setToX(1.1);
			Transicion.setToY(1.1);
			Transicion.play();
			
		});
		
		button.setOnAction(action);
		
		return button;
		
	}

}
