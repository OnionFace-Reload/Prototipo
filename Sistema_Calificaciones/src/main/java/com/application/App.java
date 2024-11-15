package com.application;

import com.application.menus.Menu;

import como.base.Conexion;
import javafx.application.Application;
import javafx.stage.Stage;

public class App extends Application{
	
	Conexion conectar = Conexion.getInstance();
	
	public void start(Stage primaryStage){
		
		primaryStage.setTitle("Prototipo-C");
		primaryStage.setScene(new Menu(primaryStage));
		
		primaryStage.setFullScreen(true);
		
		primaryStage.show();
		
	}
	
	public static void main(String[] args) {
		
		launch(args);
		
	}

}
