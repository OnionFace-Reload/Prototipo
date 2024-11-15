package com.application.menus;

import com.application.widgets.Widget;
import com.application.widgets.WidgetButton;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Sesion extends Scene{
	
	private Stage stage;
	
	private Label lbl1, lbl2;
	private Button iniciar, crear;
	
	private Region region;
	
	public Sesion(Stage stage) {
		super(new VBox(10), 700, 600);
		
		this.stage = stage;
		
		init();
		
		getStylesheets().add(getClass().getResource("/css/sesion.css").toExternalForm());
		
	}
	
	private void scenes() {
		
		Crear sesion = new Crear(stage);
		Widget.widgetTransition(stage, 500, this, sesion);
		
	}
	
	private void init() {
		
		lbl1 = new Label("Bienvenid@ a la aplicacion Sistema de Control de Calificacion");
		lbl1.getStyleClass().add("title");
		
		lbl2 = new Label("Para comenzar a trabajar debes de iniciar sesion, o crear una cuenta");
		lbl2.getStyleClass().add("info");
		
		region = new Region();
		VBox.setVgrow(region, Priority.ALWAYS);
		
		iniciar = WidgetButton.widgetButton("Iniciar sesion", "button", null);
		crear = WidgetButton.widgetButton("Crear sesion", "button", e -> {
			
			scenes();
			
		});
		
		iniciar.getStyleClass().add("iniciar");
		crear.getStyleClass().add("crear");
		
		panels();
		
	}
	
	private void panels() {
		
		VBox layout = (VBox) getRoot();
		layout.getStyleClass().add("vbox");
		layout.setAlignment(Pos.CENTER);
		layout.getChildren().addAll(lbl1, lbl2, region, crear, iniciar);
		
		
	}

}
