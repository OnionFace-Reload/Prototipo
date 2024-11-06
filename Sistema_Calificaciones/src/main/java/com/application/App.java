package com.application;

import com.application.menus.Sesion;

import como.base.Conexion;
import javafx.application.Application;
import javafx.stage.Stage;

public class App extends Application{
	
	Conexion conectar = Conexion.getInstance();
	
	public void start(Stage primaryStage){
		
		primaryStage.setTitle("Sistema de Control de Calificaciones");
		primaryStage.setScene(new Sesion(primaryStage));
		primaryStage.show();
		
	}
	
	public static void main(String[] args) {
		
		launch(args);
		
	}

}
