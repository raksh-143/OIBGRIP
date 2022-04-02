package oasis1;
import java.util.Random;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
public class NumberGuess extends Application {
	int count = 1;
	int flag = 0;
	public static void main(String args[]){
	      Application.launch(args);
	}
   @Override
   public void start(Stage stage) {
	   	Random rand = new Random();
	   	int number = rand.nextInt(100);
	   	VBox screen = new VBox();
		Label l = new Label("Welcome to Guess the Number!");
		Label l1 = new Label("Please guess a random number between 0 to 100.");
		Label l6 = new Label("You will have 5 chances to guess.");
		TextField num = new TextField();
		num.setPromptText("Enter the number");
		num.setFocusTraversable(false);
		Button check = new Button("CHECK");	
		ObservableList list = screen.getChildren();  
	    list.addAll(l,l1,l6,num,check);
	    Scene s = new Scene(screen,600,600);
		s.getStylesheets().add("style1.css");
		stage.setTitle("Guess the Number");
		stage.setScene(s);
		stage.show();
		check.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent arg0) {
				int val;
				String guess = num.getText();
				num.setText("");
				int guess1 = Integer.valueOf(guess);
				Label l2 = new Label();
				if(guess1 == number) {
					l2 = new Label("Try "+guess1+" : Correct Answer!!");
					ObservableList list = screen.getChildren();  
				    list.addAll(l2);
				    Scene s1 = new Scene(screen,200,200);
					stage.setTitle("Guess the Number");
					stage.setScene(s1);
					stage.show();
					flag = 1;
				}
				else if(guess1<number) {
					list.remove(l2);
					l2 = new Label("Try "+guess1+" : Too Low!");
					ObservableList list = screen.getChildren();  
				    list.addAll(l2);
				    Scene s1 = new Scene(screen,200,200);
					stage.setTitle("Guess the Number");
					stage.setScene(s1);
					stage.show();
				}
				else {
					list.remove(l2);
					l2 = new Label("Try "+guess1+" : Too High!");
					ObservableList list = screen.getChildren();  
				    list.addAll(l2);
				    Scene s1 = new Scene(screen,200,200);
					stage.setTitle("Guess the Number");
					stage.setScene(s1);
					stage.show();
				}
			}
		});
   }
}