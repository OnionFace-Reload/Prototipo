package com.application.menus;

import javafx.animation.FadeTransition;
import javafx.animation.ScaleTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Sesion extends Scene{
	
	public Sesion(Stage stage) {
		super(new VBox(10), 700, 600);
		
		VBox layout = (VBox) getRoot();
		layout.getStyleClass().add("vbox");
		
		layout.setAlignment(Pos.CENTER);
		
		Label lbl1 = new Label("Bienvenid@ a la aplicacion Sistema de Control de Calificacion");
		lbl1.getStyleClass().add("title");
		
		Label lbl2 = new Label("Para comenzar a trabajar debes de iniciar sesion, o crear una cuenta");
		lbl2.getStyleClass().add("info");
		
		Region region = new Region();
		VBox.setVgrow(region, Priority.ALWAYS);
		
		Button iniciar = crearBoton("Iniciar sesion", null);
		Button crear = crearBoton("Crear sesion", e -> {
			
			FadeTransition cambio = new FadeTransition(Duration.millis(500), this.getRoot());
			cambio.setFromValue(1.0);
			cambio.setToValue(0.0);
			cambio.setOnFinished(event -> {
				
				Crear crearSesion = new Crear(stage);
				stage.setScene(crearSesion);
				
			});
			
			cambio.play();
			
		});
		
		iniciar.getStyleClass().add("iniciar");
		crear.getStyleClass().add("crear");
		
		layout.getChildren().addAll(lbl1, lbl2, region, crear, iniciar);
		
		getStylesheets().add(getClass().getResource("/css/sesion.css").toExternalForm());
		
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
