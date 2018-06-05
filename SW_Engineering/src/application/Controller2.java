package application;

import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.Reader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

import org.fxmisc.richtext.InlineCssTextArea;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;
import java.lang.Math;
public class Controller2 implements Initializable{
	
	@FXML
	private InlineCssTextArea T1;
	@FXML
	private InlineCssTextArea T2;

    @Override
    public void initialize(URL loc, ResourceBundle res) {
        
    }
    private Stage primaryStage;
    
    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }
    
    /* Load File */
    
    public void Load_Left(ActionEvent e) {
        FileChooser fileChooser = new FileChooser();
        
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt");
        fileChooser.getExtensionFilters().add(extFilter);
        
        File selectedFile = fileChooser.showOpenDialog(primaryStage);
        if (selectedFile != null) {
        	openFile(selectedFile,1);
        }
        T1.setEditable(false);
        }
 
    public void Load_Right(ActionEvent e) {
        FileChooser fileChooser = new FileChooser();
        
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt");
        fileChooser.getExtensionFilters().add(extFilter);
        
        File selectedFile = fileChooser.showOpenDialog(primaryStage);
        if (selectedFile != null) {
        	openFile(selectedFile,2);
        }
        T2.setEditable(false);
        }
    
    public void openFile(File file,int choice) {
    	StringBuilder stringBuffer = new StringBuilder();
        BufferedReader br = null;
        try{
          br = new BufferedReader(new FileReader(file));
          String line;
          ArrayList<String> input=new ArrayList<String>();
          while((line=br.readLine())!=null) {
        	  input.add(line);
          }
          /**/
          if(choice==1) {
        	  T1.clear();
        	  for(int i=0;i<input.size();i++) {
        		  T1.appendText(input.get(i) + "\n");
        	  }
          }
          else {
        	  T2.clear();
        	  for(int i=0;i<input.size();i++) {
        		  T2.appendText(input.get(i) + "\n");
        	  }
          }

        } catch (FileNotFoundException e) {
          e.printStackTrace();
        } catch (IOException e) {
          e.printStackTrace();
        }

    }
    
    /* Edit File */
    public void Edit_Left(ActionEvent e){
    	T1.setEditable(true);
    }
    public void Edit_Right(ActionEvent e){
    	T2.setEditable(true);
    }
    
    /* Save File */
    public void Save_Left(ActionEvent e) throws FileNotFoundException {
    	if(T1.isEditable()==true) {
    	    String string = null;
    	    string=T1.getText();
    	    List<String> list=new ArrayList<String>();
    	    list.clear();
    	    list=Arrays.asList(string.split("\n"));
    	    String Output_name ="output_test.txt";
    	    PrintWriter output = new PrintWriter(Output_name);
    	    for(int i=0;i<list.size();i++) {
    	    	output.println(list.get(i));
    	    }
    	    System.out.println("Save Complete!");
    	    output.close();
    	}
    	else {System.out.println("Can not Save, File is UnEditable");}
    }
    public void Save_Right(ActionEvent e) throws FileNotFoundException {
    	if(T2.isEditable()==true) {
    	    String string = null;
    	    string=T2.getText();
    	    List<String> list=new ArrayList<String>();
    	    list.clear();
    	    list=Arrays.asList(string.split("\n"));
    	    String Output_name ="output_test.txt";
    	    PrintWriter output = new PrintWriter(Output_name);
    	    for(int i=0;i<list.size();i++) {
    	    	output.println(list.get(i));
    	    }
    	    System.out.println("Save Complete!");
    	    output.close();
    	}
    	else {System.out.println("Can not Save, File is UnEditable");}
    	}
    
    /* Compare and Merge */
    public void Compare(ActionEvent e) {
    	String string_Left = null;
	    string_Left=T1.getText();
	    List<String> list_Left=new ArrayList<String>();
	    list_Left.clear();
	    list_Left=Arrays.asList(string_Left.split("\n"));
	    
	    String string_Right = null;
	    string_Right=T2.getText();
	    List<String> list_Right=new ArrayList<String>();
	    list_Right.clear();
	    list_Right=Arrays.asList(string_Right.split("\n"));
	    
	    for (int i=0;i<min(list_Left.size(),list_Right.size());i++) {
	    	string_Left="";
	    	string_Right="";
	    	string_Left=list_Left.get(i);
	    	string_Right=list_Right.get(i);
	    	if(string_Left.equals(string_Right)) {
	    		;
	    	}
	    	else {
	    		//T1.setStyle(3,"-fx-fill:red;");
	    		T1.setEditable(true);
	            T1.setParagraphStyle(i,"-fx-background-color:yellow;");
	            T1.setEditable(false);
 	            T2.setEditable(true);
	            T2.setParagraphStyle(i,"-fx-background-color:yellow;");
	            T2.setEditable(false);
	    	}
	    }
	    System.out.println("Compare Complete");
    }
    
    private int min(int a, int b) {
		if(a<b) return a;
		else return b;
	}

	public void Copy_to_Left(ActionEvent e) {
		String string_Left = null;
	    string_Left=T1.getText();
	    List<String> list_Left=new ArrayList<String>();
	    list_Left.clear();
	    list_Left=Arrays.asList(string_Left.split("\n"));
	    
	    String string_Right = null;
	    string_Right=T2.getText();
	    List<String> list_Right=new ArrayList<String>();
	    list_Right.clear();
	    list_Right=Arrays.asList(string_Right.split("\n"));
	    
	    for (int i=0;i<min(list_Left.size(),list_Right.size());i++) {
	    	string_Left="";
	    	string_Right="";
	    	string_Left=list_Left.get(i);
	    	string_Right=list_Right.get(i);
	    	if(string_Left.equals(string_Right)) {
	    		;
	    	}
	    	else {
	    		//T1.setStyle(3,"-fx-fill:red;");
	    		T1.setEditable(true);
	    		T2.setEditable(true);
	            //list_Right.set(i,string_Left);
	            T1.replaceText(i, 0, i, string_Left.length(), string_Right);
	            T1.setEditable(false);
	            //T2.setParagraphStyle(i,"-fx-background-color:yellow;");
	            T2.setEditable(false);
	    	}
	    }
	    System.out.println("Copy to Left Complete");
    }
    
    public void Copy_to_Right(ActionEvent e) {
    	String string_Left = null;
	    string_Left=T1.getText();
	    List<String> list_Left=new ArrayList<String>();
	    list_Left.clear();
	    list_Left=Arrays.asList(string_Left.split("\n"));
	    
	    String string_Right = null;
	    string_Right=T2.getText();
	    List<String> list_Right=new ArrayList<String>();
	    list_Right.clear();
	    list_Right=Arrays.asList(string_Right.split("\n"));
	    
	    for (int i=0;i<min(list_Left.size(),list_Right.size());i++) {
	    	string_Left="";
	    	string_Right="";
	    	string_Left=list_Left.get(i);
	    	string_Right=list_Right.get(i);
	    	if(string_Left.equals(string_Right)) {
	    		;
	    	}
	    	else {
	    		//T1.setStyle(3,"-fx-fill:red;");
	    		T1.setEditable(true);
	    		T2.setEditable(true);
	            //list_Right.set(i,string_Left);
	            T2.replaceText(i, 0, i, string_Right.length(), string_Left);
	            T1.setEditable(false);
	            //T2.setParagraphStyle(i,"-fx-background-color:yellow;");
	            T2.setEditable(false);
	    	}
	    }
	    System.out.println("Copy to Right Complete");
    }
    }
