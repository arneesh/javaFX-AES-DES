package application;


import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

import application.Encrypter;
import javafx.application.Application;  
import javafx.stage.Stage;  
import javafx.scene.control.Button;
import javafx.scene.Scene; 
import javafx.event.ActionEvent;  
import javafx.event.EventHandler;  
import javafx.scene.text.Text;
import javafx.scene.paint.Color;  
import javafx.scene.text.Font;  
import javafx.scene.text.FontPosture; 
import javafx.scene.Group; 
import javafx.scene.effect.InnerShadow;
import javafx.scene.control.TextField;
import javafx.scene.control.RadioButton;  
import javafx.scene.control.ToggleGroup;  

public class CryptoKitArny extends Application{  
	
	
	byte[] encrypted;
    SecretKey key;
    @Override  
    public void start(Stage primaryStage) throws Exception {  
        // TODO Auto-generated method stub  
    	
    	 Text text = new Text(); 
    	 text.setStyle("-fx-background-color:blue;");
    	 InnerShadow is = new InnerShadow();
    	 is.setOffsetX(4.0f);
    	 is.setOffsetY(4.0f);
    	 //Text t = new Text();
    	 text.setEffect(is);
    	
    	// text.setTranslateX(300);
    	 //text.setTranslateY(300);
    	// text.setFill(Color.YELLOW);
    	 
    	 
    	 text.setX(30);  
    	    text.setY(30);  
    	    text.setFont(Font.font("Tahoma",FontPosture.REGULAR,25));
    	//    text.setUnderline(true);
    	    text.setFill(Color.BLUE);// setting colour of the text to blue   
    	    text.setStroke(Color.BLUE); // setting the stroke for the text    // OUTLINE
    	    text.setStrokeWidth(1); // setting stroke width to 2   
    	    text.setText("Cryptography : KIT");   
    	    
    	    // PLAIN TEXT - TEXT
    	    Text plain = new Text();
    	    plain.setX(20);
    	    plain.setY(100);
    	    plain.setFont(Font.font("Tahoma",FontPosture.REGULAR,16));  
    	    plain.setFill(Color.BLACK);// setting colour of the text to blue   
    	    plain.setStroke(Color.BLACK); // setting the stroke for the text    // OUTLINE
    	    plain.setStrokeWidth(1); // setting stroke width to 2   
    	    plain.setText("Plain Text :");   
    	    
    	    //CIPHER TEXT - TEXT
    	    
    	 
    	    Text ctext = new Text();
    	    ctext.setX(20);
    	    ctext.setY(200);
    	    ctext.setFont(Font.font("Tahoma",FontPosture.REGULAR,16));  
    	    ctext.setFill(Color.BLACK);// setting colour of the text to blue   
    	    ctext.setStroke(Color.BLACK); // setting the stroke for the text    // OUTLINE
    	    ctext.setStrokeWidth(1); // setting stroke width to 2   
    	    ctext.setText("Cipher Text :"); 
    	    
    	    // PLAIN TEXT - TEXT DECRYPTED
    	    Text plain1 = new Text();
    	    plain1.setX(20);
    	    plain1.setY(300);
    	    plain1.setFont(Font.font("Tahoma",FontPosture.REGULAR,16));  
    	    plain1.setFill(Color.BLACK);// setting colour of the text to blue   
    	    plain1.setStroke(Color.BLACK); // setting the stroke for the text    // OUTLINE
    	    plain1.setStrokeWidth(1); // setting stroke width to 2   
    	    plain1.setText("Plain Text :");  
    	    
    	    
    	    // COPY RIGHT
    	    
    	 // PLAIN TEXT - TEXT DECRYPTED
    	    Text cpyrt = new Text();
    	    cpyrt.setX(200);
    	    cpyrt.setY(360);
    	    cpyrt.setFont(Font.font("Tahoma",FontPosture.REGULAR,10));  
    	    cpyrt.setFill(Color.BLACK);// setting colour of the text to blue   
    	 //   cpyrt.setStroke(Color.BLACK); // setting the stroke for the text    // OUTLINE
    	 //   cpyrt.setStrokeWidth(1); // setting stroke width to 2   
    	    cpyrt.setText(" © Arneesh");
    	    
    	    
    	    
    	    
    	    
    	Button btn1=new Button("Apply Encryption"); 
        
        // TEXT FIELD 1 
        
        TextField tf1=new TextField(); 
        tf1.setLayoutY(82);
        tf1.setLayoutX(110);
        
        // TEXT FIELD 2 - CIPHER
        
        TextField tf2=new TextField(); 
        tf2.setLayoutY(184);
        tf2.setLayoutX(120);
        
        
 
        
        // TEXT FIELD 3 - DECRYTED
        
        TextField tf3=new TextField(); 
        tf3.setLayoutY(280);
        tf3.setLayoutX(110);
        
    //    StackPane root=new StackPane();
        
        
      
        
        btn1.setLayoutX(100);
        btn1.setLayoutY(140);
        
        // RADIO BUTTON - SELECT ENCRYPTION 
        ToggleGroup group = new ToggleGroup();  
        RadioButton button1 = new RadioButton("DES");  
        RadioButton button2 = new RadioButton("AES");  
        button1.setToggleGroup(group);  
        button2.setToggleGroup(group);  
        button1.setLayoutX(40);
        button1.setLayoutY(57);
        button2.setLayoutX(180);
        button2.setLayoutY(57);
        button1.setSelected(true);
        
        
        btn1.setOnAction(new EventHandler<ActionEvent>() {  
            
            @Override  
            public void handle(ActionEvent arg0) {  
				try {
					String algo;
					if(button1.isSelected()){
						algo = "DES";
					}else{
						algo = "AES";
					}
					key = KeyGenerator.getInstance(algo).generateKey();
	                Encrypter encrypter = new Encrypter(key,algo);
	            	encrypted = encrypter.encrypt(tf1.getText());
	                tf2.setText(new String(encrypted,StandardCharsets.UTF_8));
				} catch (Exception e) {
					e.printStackTrace();
				}
            }  
        });  

        
        // BUTTON 2 - FOR DECRYPTION
        
        Button btn2=new Button("Apply Decryption"); 
    	
        
        btn2.setOnAction(new EventHandler<ActionEvent>() {  
            
            @Override  
            public void handle(ActionEvent arg0) {  
				try {
					String algo;
					if(button1.isSelected()){
						algo = "DES";
					}else{
						algo = "AES";
					}

	                Encrypter encrypter = new Encrypter(key,algo);
	            	byte[] decrypted = encrypter.decrypt(encrypted);
	                tf3.setText(new String(decrypted,StandardCharsets.UTF_8));
				} catch (Exception e) {
					e.printStackTrace();
				}
            }  
        });  

        
        btn2.setLayoutX(100);
        btn2.setLayoutY(240);
        
        
        Group root = new Group(); 
        root.getChildren().add(btn1); 
        root.getChildren().add(text);       
        root.getChildren().add(plain);
        root.getChildren().add(ctext);
        root.getChildren().add(plain1);
        root.getChildren().add(btn2); 
        root.getChildren().add(tf1); 
        root.getChildren().add(tf2);
        root.getChildren().add(tf3);
        root.getChildren().add(cpyrt);
        root.getChildren().addAll(button1,button2); 
        Scene scene=new Scene(root,300,400);  
        primaryStage.setScene(scene);  
        primaryStage.setTitle("Arneesh Crypto Kit");  
        primaryStage.show();  
        
    }  
    
    
    
    
    
    public static void main (String[] args)  
    {  
        launch(args);    
}  
}
