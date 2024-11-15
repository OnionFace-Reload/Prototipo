package com.application.widgets;

import javafx.animation.FadeTransition;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Widget {
	
	public static FadeTransition widgetTransition(Stage stage,int time, Scene scene, Scene scene1) {
		
		FadeTransition transition = new FadeTransition(Duration.millis(time), scene.getRoot());
		transition.setFromValue(1.0);
		transition.setToValue(0.0);
		transition.setOnFinished(event -> {
			
			stage.setScene(scene1);
			
		});
		
		transition.play();
		
		return transition;
		
	}

}
