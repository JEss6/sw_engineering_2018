package application;

import java.awt.Desktop;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
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
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;
import java.lang.Math;

public class Controller2 implements Initializable{
	int Compare_Check=0;
	int compare_index_Left=0;
	int compare_start_Left=0;
	int compare_index_Right=0;
	int compare_start_Right=0;
	ArrayList<Number> compare_list=new ArrayList<Number>();
	@FXML
	private ImageView Left_Arrow;
	
	@FXML
	private ImageView Right_Arrow;
	
	@FXML
	private ImageView Up_Arrow_Left;
	
	@FXML
	private ImageView Up_Arrow_Right;
	
	@FXML
	private ImageView Down_Arrow_Left;
	
	@FXML
	private ImageView Down_Arrow_Right;
	
	@FXML
	private InlineCssTextArea T1;
	
	@FXML
	private InlineCssTextArea T2;

    @SuppressWarnings("unchecked")//임시 코드
	@Override
    public void initialize(URL loc, ResourceBundle res) {
    	T1.setEditable(false);
    	T1.setEditable(false);
    	
    	 Left_Arrow.setOnMouseClicked( new EventHandler() {
             @Override
             public void handle(Event event ) {
                 if(Compare_Check==1) {
                	 ;
                 }
                 else System.out.println("Compare First");
               System.out.println("Left Arrow");
             }
    	 });
    	 Right_Arrow.setOnMouseClicked( new EventHandler() {
             @Override
             public void handle(Event event ) {
            	 if(Compare_Check==1) {
                	 ;
                 }
                 else System.out.println("Compare First");
            	 System.out.println("Right Arrow");
             }
    	 });
    	 Up_Arrow_Left.setOnMouseClicked( new EventHandler() {
             @Override
             public void handle(Event event ) {
            	 if(Compare_Check==1) {
             		if(compare_start_Left==0) compare_start_Left=1;
             		else compare_index_Left--;
             		if(compare_index_Left==-1) compare_index_Left=compare_list.size()-1;
             		T1.setParagraphStyle(((int)compare_list.get((compare_index_Left+1)%compare_list.size())), "-fx-background-color:rgba(255, 0, 0, 0.3);");
                 	T1.setParagraphStyle((int)compare_list.get((compare_index_Left)%compare_list.size()), "-fx-background-color:yellow;");
                  }
                 else System.out.println("Compare First");
            	 System.out.println("Up Arrow Left");
             }
    	 });
    	 Down_Arrow_Left.setOnMouseClicked( new EventHandler() {
             @Override
             public void handle(Event event ) {
            	 if(Compare_Check==1) {
            		if(compare_start_Left==0) compare_start_Left=1;
            		else compare_index_Left++;
            		T1.setParagraphStyle(((int)compare_list.get((compare_index_Left+compare_list.size()-1)%compare_list.size())), "-fx-background-color:rgba(255, 0, 0, 0.7);");
                	T1.setParagraphStyle((int)compare_list.get(compare_index_Left%compare_list.size()), "-fx-background-color:yellow;");
                 }
                 else System.out.println("Compare First");
            	 System.out.println("Down Arrow Left");
             }
    	 });
    	 Up_Arrow_Right.setOnMouseClicked( new EventHandler() {
             @Override
             public void handle(Event event ) {
            	 if(Compare_Check==1) {
              		if(compare_start_Right==0) compare_start_Right=1;
              		else compare_index_Right--;
              		if(compare_index_Right==-1) compare_index_Right=compare_list.size()-1;
              		T2.setParagraphStyle(((int)compare_list.get((compare_index_Right+1)%compare_list.size())), "-fx-background-color:rgba(0, 100, 100, 0.5);");
                  	T2.setParagraphStyle((int)compare_list.get((compare_index_Right)%compare_list.size()), "-fx-background-color:yellow;");
                   }
                  else System.out.println("Compare First");
             	 System.out.println("Up Arrow Right");
              }
    	 });
    	 Down_Arrow_Right.setOnMouseClicked( new EventHandler() {
             @Override
             public void handle(Event event ) {
            	 if(Compare_Check==1) {
             		if(compare_start_Right==0) compare_start_Right=1;
             		else compare_index_Right++;
             		T2.setParagraphStyle(((int)compare_list.get((compare_index_Right+compare_list.size()-1)%compare_list.size())), "-fx-background-color:rgba(0, 100, 100, 0.5);");
                 	T2.setParagraphStyle((int)compare_list.get(compare_index_Right%compare_list.size()), "-fx-background-color:yellow;");
                  }
                  else System.out.println("Compare First");
             	 System.out.println("Down Arrow Right");
              }
    	 });
    }
    private Stage primaryStage;
    
    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }
    
    
    
    /* Load File */
    
    public void Load_Left(ActionEvent e) {
    	Compare_Check=0;
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
    	Compare_Check=0;
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
    	Compare_Check=0;
    	T1.setEditable(true);
    }
    public void Edit_Right(ActionEvent e){
    	Compare_Check=0;
    	T2.setEditable(true);
    }
    
    /* Save File */

    public void Save_Left(ActionEvent e) throws FileNotFoundException {
    	FileChooser fileChooser = new FileChooser();
    	FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt");
    	fileChooser.getExtensionFilters().add(extFilter);
    	File file = fileChooser.showSaveDialog(primaryStage);
    	String string = null;
    	string = T1.getText();
    	List<String> list = new ArrayList<String>();
    	list.clear();
    	list=Arrays.asList(string.split("\n"));
    	string="";
    	for(int i=0;i<list.size();i++) {
    		string=string+"\r\n"+list.get(i);
    	}
    	System.out.println(string);
    	if (file != null) {
   	     saveFile(string, file);
    	}
    	T1.setEditable(false);
    }
    
    public void Save_Right(ActionEvent e) {
    	FileChooser fileChooser = new FileChooser();
    	FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt");
    	fileChooser.getExtensionFilters().add(extFilter);
    	File file = fileChooser.showSaveDialog(primaryStage);
    	String string = null;
    	string = T2.getText();
    	List<String> list = new ArrayList<String>();
    	list.clear();
    	list=Arrays.asList(string.split("\n"));
    	string="";
    	for(int i=0;i<list.size();i++) {
    		string=string+"\r\n"+list.get(i);
    	}
    	System.out.println(string);
    	if (file != null) {
   	     saveFile(string, file);
    	}
    	T2.setEditable(false);
    }
    
    private void saveFile(String content, File file){
        try{
          FileWriter writer;
          writer = new FileWriter(file);
          
          writer.write(content);
          writer.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    /* Compare and Merge */
    
    
    public void Compare(ActionEvent e) {
    	compare_list.clear();
    	Compare_Check=1;
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
	    		T1.setEditable(true);
	            T1.setParagraphStyle(i,"-fx-background-color:rgba(0, 100, 100, 0.5);");
	            compare_list.add(i);
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
		if(Compare_Check==1) {
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
	    		T1.setEditable(true);
	    		T2.setEditable(true);
	            T1.replaceText(i, 0, i, string_Left.length(), string_Right);
	            T1.setEditable(false);
	            T2.setEditable(false);
	    	}
	    }
	    System.out.println("Copy to Left Complete");
		}
		else System.out.println("Compare First");
    }
    
    public void Copy_to_Right(ActionEvent e) {
    	if(Compare_Check==1) {
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
	    		T1.setEditable(true);
	    		T2.setEditable(true);
	            T2.replaceText(i, 0, i, string_Right.length(), string_Left);
	            T1.setEditable(false);
	            T2.setEditable(false);
	    	}
	    }
	    System.out.println("Copy to Right Complete");
    	}
    	else System.out.println("Compare First");
    }
    }
