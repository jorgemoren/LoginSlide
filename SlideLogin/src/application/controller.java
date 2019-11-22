package application;

import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Duration;

public class controller {

	@FXML
	private Pane panel1;

	@FXML
	private Pane panel2;

	@FXML
	private Pane panel3;

	@FXML
	private Pane panel4;
	
//	@FXML
//	private URL location;
//	
//	@FXML
//	private ResourceBundle resources;

	@FXML
	private void reportButtonHandler(ActionEvent event) {
	    FXMLLoader fxmlLoader = new 
	        FXMLLoader(getClass().getResource("HomePage.fxml"));
	   try {
		   Parent root1 = (Parent) fxmlLoader.load();
		    Stage stage = new Stage();
		    //set what you want on your stage
		    stage.initModality(Modality.APPLICATION_MODAL);
		    stage.setTitle("Home Page");
		    stage.setScene(new Scene(root1));
		    stage.setResizable(false);
		    stage.show();
	} catch (Exception e) {		
	}
	}
	public void initialize() {

		//pane1.setStyle("-fx-background-image: url('sample/1.jpg')");
		//pane2.setStyle("-fx-background-image: url('sample/2.jpg')");
		//pane3.setStyle("-fx-background-image: url('sample/3.jpg')");
		//pane4.setStyle("-fx-background-image: url('sample/4.jpg')");

		backgroundAnimation();

	}

	private void backgroundAnimation() {

		FadeTransition fadeTransition = new FadeTransition(Duration.seconds(5),
				panel4);
		fadeTransition.setFromValue(1);
		fadeTransition.setToValue(0);
		fadeTransition.play();

		fadeTransition
				.setOnFinished(event -> {

					FadeTransition fadeTransition1 = new FadeTransition(
							Duration.seconds(3), panel3);
					fadeTransition1.setFromValue(1);
					fadeTransition1.setToValue(0);
					fadeTransition1.play();

					fadeTransition1.setOnFinished(event1 -> {
						FadeTransition fadeTransition2 = new FadeTransition(
								Duration.seconds(3), panel2);
						fadeTransition2.setFromValue(1);
						fadeTransition2.setToValue(0);
						fadeTransition2.play();

						fadeTransition2.setOnFinished(event2 -> {

							FadeTransition fadeTransition0 = new FadeTransition(
									Duration.seconds(3), panel2);
							fadeTransition0.setFromValue(0);
							fadeTransition0.setToValue(1);
							fadeTransition0.play();

							fadeTransition0.setOnFinished(event3 -> {

								FadeTransition fadeTransition11 = new FadeTransition(
										Duration.seconds(3), panel3);

								fadeTransition11.setFromValue(0);
								fadeTransition11.setToValue(1);
								fadeTransition11.play();

								fadeTransition11.setOnFinished(event4 -> {

									FadeTransition fadeTransition22 = new FadeTransition(
											Duration.seconds(3), panel4);

									fadeTransition22.setFromValue(0);
									fadeTransition22.setToValue(1);
									fadeTransition22.play();

									fadeTransition22.setOnFinished(event5 -> {

										backgroundAnimation();
									});

								});

							});

						});
					});

				});

	}
}