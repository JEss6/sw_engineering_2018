package application;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;
import javafx.scene.text.Text;

public class Controller {
	
	
	@FXML private TextField Button_Left_0;
	@FXML private TextField Button_Left_1;
	@FXML private TextField Button_Left_2;
	@FXML private TextField Button_Left_3;
	@FXML private TextField Button_Left_4;
	@FXML private TextField Button_Left_5;
	@FXML private TextField Button_Left_6;
	@FXML private TextField Button_Left_7;
	@FXML private TextField Button_Left_8;
	@FXML private TextField Button_Left_9;
	@FXML private TextField Button_Left_10;
	
	@FXML private TextField Button_Right_0;
	@FXML private TextField Button_Right_1;
	@FXML private TextField Button_Right_2;
	@FXML private TextField Button_Right_3;
	@FXML private TextField Button_Right_4;
	@FXML private TextField Button_Right_5;
	@FXML private TextField Button_Right_6;
	@FXML private TextField Button_Right_7;
	@FXML private TextField Button_Right_8;
	@FXML private TextField Button_Right_9;
	@FXML private TextField Button_Right_10;
	
	
	
	@FXML
	private void Save_Left(ActionEvent event) throws IOException {
		/*Input Text*/
	    FileReader file_reader;
	    BufferedReader buffer_reader;
	    String string;
	    ArrayList<String> input;
	    String name_of_code = "Left.txt";
	 
	    input = new ArrayList<String>();
	    input.clear();
	    file_reader = new FileReader(name_of_code);
	    buffer_reader = new BufferedReader(file_reader);
	    for (int i = 0; (string = buffer_reader.readLine())!= null; i++ ) {
	     input.add(string);
	    }
	    string = "";
		TextField[] Left=new TextField[11];
		Left[0]=Button_Left_0;
		Left[1]=Button_Left_1;
		Left[2]=Button_Left_2;
		Left[3]=Button_Left_3;
		Left[4]=Button_Left_4;
		Left[5]=Button_Left_5;
		Left[6]=Button_Left_6;
		Left[7]=Button_Left_7;
		Left[8]=Button_Left_8;
		Left[9]=Button_Left_9;
		Left[10]=Button_Left_10;
				
	    for (int i = 0; i < 11; i++) {
	    	if(Left[i]!=null) {
			Left[i].setText(input.get(i));
	    	}
	    }
	    /* Change Color */
	    //Left[0].setStyle("-fx-control-inner-background: RED");
	    //Left[5].setStyle("-fx-text-fill: SKYBLUE");
	    file_reader.close();
	}
	
	@FXML
	private void Save_Right(ActionEvent event) throws IOException {
		/*Input Text*/
	    FileReader file_reader;
	    BufferedReader buffer_reader;
	    String string;
	    ArrayList<String> input;
	    String name_of_code = "Right.txt";
	 
	    input = new ArrayList<String>();
	    input.clear();
	    file_reader = new FileReader(name_of_code);
	    buffer_reader = new BufferedReader(file_reader);
	    for (int i = 0; (string = buffer_reader.readLine())!= null; i++ ) {
	     input.add(string);
	    }
	    string = "";
	    
		TextField[] Right=new TextField[11];
		Right[0]=Button_Right_0;
		Right[1]=Button_Right_1;
		Right[2]=Button_Right_2;
		Right[3]=Button_Right_3;
		Right[4]=Button_Right_4;
		Right[5]=Button_Right_5;
		Right[6]=Button_Right_6;
		Right[7]=Button_Right_7;
		Right[8]=Button_Right_8;
		Right[9]=Button_Right_9;
		Right[10]=Button_Right_10;
		
	    for (int i = 0; i < 11; i++) {
	    	if(Right[i]!=null) {
			Right[i].setText(input.get(i));
	    	}
	    } 
	    Right[5].setStyle("-fx-control-inner-background: SKYBLUE");
	    file_reader.close();
	}

}
