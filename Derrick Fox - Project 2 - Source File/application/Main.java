/*
 * Derrick Fox
 * CS 214 - Advanced Java
 * Project 2 - Try / Catch
 * February 16, 2015
 * Java 1.8 JavaFX 2.2
 */

package application;
	
import java.util.Random;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;


public class Main extends Application {
	
	//Declare private variables for the two text fields. 
	private TextField tfElementInput = new TextField();
	private TextField labelIt = new TextField();
	
	@Override
	public void start(Stage primaryStage) {
		
		//Constant declared for the size of the array
		final int SIZE = 101;
		//Array declared to hold a series of randomly generated integers
		int[] arrayOfHundred = new int[SIZE];
		//For-loop to generate and store random numbers
		for (int i = 0; i <= SIZE-1; i++) {
			Random randomNum = new Random();
			arrayOfHundred[i] = randomNum.nextInt((100) + 1) + 1;
		}
		//Create pane to hold elements and add the elements to the pane		
		GridPane pane = new GridPane();
		pane.setAlignment(Pos.CENTER);
		pane.setPadding(new Insets( 11.5, 12.5, 13.5, 14.5));
		pane.setHgap(5.5);
		pane.setVgap(5.5);
		
		pane.add(new Label("Array Index"), 0, 0);
		pane.add(tfElementInput, 1, 0);
		pane.add(new Label("Array Element"), 0, 1);
		pane.add(labelIt, 1, 1);
		
		//Create Show Element button 
		Button showButton = new Button("Show Element");
		pane.add(showButton, 1, 3);
		GridPane.setHalignment(showButton, HPos.CENTER);
						
		//Set event listener via an annoymous function
		showButton.setOnAction(e -> showElement(arrayOfHundred));
		
		//Add pane to scene and show scene
		Scene scene = new Scene(pane);
		primaryStage.setTitle("Project 2");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	//Method created as action for event listener
	public void showElement(int[] arr) {
		
		//Try-Catch statement to catch element out of bounds error
		try{
		Integer eleNum = Integer.parseInt(tfElementInput.getText());
		labelIt.setText(""+ arr[eleNum]);
		}
		catch (IndexOutOfBoundsException e) {
			labelIt.setText("Out of Bounds");
		}
	}
}



