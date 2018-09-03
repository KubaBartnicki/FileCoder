package jfx;



import java.io.IOException;

import engine.Coder;
import engine.SimpleCodec;
import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Menu extends Application {
	private Coder coder = new Coder(new SimpleCodec());
	private String head = "Coder";
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setScene(getScene());
		primaryStage.show();
		primaryStage.setTitle(head);
	}

	public static void main(String[] args) {
		launch(args);

	}
	
	private Scene getScene() {
		GridPane root = new GridPane();
		Scene scene = new Scene(root,300, 80);
		root.setHgap(10);
		root.setVgap(10); 
		root.setPadding(new Insets(10, 10, 10, 10));
		TextField path = new TextField();
		root.add(path, 0, 0);
		Button encode = new Button("encode");
		root.add(encode, 1, 0);
		Button decode = new Button("decode");
		root.add(decode, 2, 0);	
		ProgressBar progresBar = new ProgressBar(0);

		root.add(progresBar,0,1);
		encode.setOnMouseClicked(new EventHandler<Event>() {

			@Override
			public void handle(Event event) {
				try {
					coder.codeFile(path.getText());
					progresBar.setProgress(coder.getProgress());
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setTitle(head);
					alert.setHeaderText(null);
					alert.setContentText("done!");

					alert.showAndWait();
					progresBar.setProgress(0.0);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		decode.setOnMouseClicked(new EventHandler<Event>() {

			@Override
			public void handle(Event event) {
				try {
					coder.decodeFile(path.getText());
					progresBar.setProgress(coder.getProgress());
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setTitle(head);
					alert.setHeaderText(null);
					alert.setContentText("done!");

					alert.showAndWait();
					progresBar.setProgress(0.0);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		
		return scene;
	}
	


}
