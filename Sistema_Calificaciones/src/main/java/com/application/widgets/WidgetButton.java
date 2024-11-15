package com.application.widgets;

import javafx.animation.ScaleTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.util.Duration;

public class WidgetButton {
	
	public static Button widgetButton(String name, String id, EventHandler<ActionEvent> event) {
		
		Button button = new Button(name);
		button.getStyleClass().add(id);
		
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
		
		button.setOnAction(event);
		
		return button;
		
	}

}
