

import java.util.Arrays;

import javafx.collections.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.*;

public class RealEstateGUIView {
	
	private BorderPane mainPane;
	private Text topText, counterText, lastProperty;
	private TextField addressField, listingField, valueField;
	private ComboBox<PropertyType> typeChoice;
	private Button submitButton;
	
	public RealEstateGUIView () {
		
		mainPane = new BorderPane();
		setTopBorder();
		setCenterBox();
		setBottomCounter();
	}
	
	//Top Box with instructions
	private void setTopBorder() {
		VBox topBorder = new VBox();
		topBorder.setAlignment(Pos.CENTER);
		topBorder.setPadding(new Insets(10, 10, 10, 10));
		
		topText = new Text ("Please enter information about the property below.");
		topText.setFont(Font.font("Bauhaus 93", FontWeight.BOLD, 24));
		topText.setFill(Color.rgb(100, 0, 150));
		topBorder.getChildren().add(topText);
		
		mainPane.setTop(topBorder);
	}
	
	//Center Box with fields and submit button
	private void setCenterBox() {
		VBox centerBox = new VBox();
		centerBox.setAlignment(Pos.TOP_CENTER);
		centerBox.setPadding(new Insets(10, 0, 0, 30));
		centerBox.setSpacing(20);
		
		//add Property Address Field to input screen
		HBox addressBox = new HBox();
		addressBox.setAlignment(Pos.CENTER);
		Text propertyText = new Text("Property Address: ");
		propertyText.setFont(Font.font("TimesNewRoman", FontWeight.BOLD, 24));
		propertyText.setFill(Color.BLACK);
		addressBox.getChildren().add(propertyText);
		
		addressField = new TextField();
		addressField.setMaxWidth(300);
		HBox.setMargin(addressField, new Insets(5, 0 ,0, 0));
		HBox.setHgrow(addressField, Priority.ALWAYS);
		addressBox.getChildren().add(addressField);
		
		//add Property Type Field to input screen
		HBox typeBox = new HBox();
		typeBox.setAlignment(Pos.CENTER);
		typeBox.setPadding(new Insets(0, 145, 0, 0));
		Text typeText = new Text("Property Type: ");
		typeText.setFont(Font.font("TimesNewRoman", FontWeight.BOLD, 24));
		typeText.setFill(Color.BLACK);
		typeBox.getChildren().add(typeText);
		
		ObservableList<PropertyType> listItems = FXCollections.observableArrayList(Arrays.asList(PropertyType.values()));
		typeChoice = new ComboBox<PropertyType>(listItems);
		typeBox.getChildren().add(typeChoice);
		
		//add Property Listing Number Field to input screen
		HBox listingBox = new HBox();
		listingBox.setAlignment(Pos.CENTER);
		listingBox.setPadding(new Insets(0, 130, 0, 0));
		
		Text listingText = new Text("Listing Number: ");
		listingText.setFont(Font.font("TimesNewRoman", FontWeight.BOLD, 24));
		listingText.setFill(Color.BLACK);
		listingBox.getChildren().add(listingText);
		
		listingField = new TextField();
		listingField.setMaxWidth(300);
		listingBox.getChildren().add(listingField);
		
		//add Property Value Field to input screen
		HBox valueBox = new HBox();
		valueBox.setAlignment(Pos.CENTER);
		valueBox.setPadding(new Insets(0, 125, 0, 0));
		
		Text valueText = new Text("Property Value: ");
		valueText.setFont(Font.font("TimesNewRoman", FontWeight.BOLD, 24));
		valueText.setFill(Color.BLACK);
		valueBox.getChildren().add(valueText);
		
		valueField = new TextField();
		valueField.setMaxWidth(300);
		valueBox.getChildren().add(valueField);
		
		//add Submit Button
		submitButton = new Button("Submit");
		submitButton.setAlignment(Pos.BOTTOM_CENTER);
		
		centerBox.getChildren().addAll(addressBox, typeBox, listingBox, valueBox, submitButton);
		mainPane.setCenter(centerBox);
	}
	
	//Bottom Box for static counter and that shows the last successful entry
	private void setBottomCounter() {
		VBox bottomBox = new VBox();
		bottomBox.setAlignment(Pos.BOTTOM_CENTER);
		bottomBox.setPadding(new Insets(10, 10, 10, 10));
		bottomBox.setSpacing(5);
		
		lastProperty = new Text("");
		lastProperty.setFont(Font.font("TimesNewRoman", FontWeight.BOLD, 24));
		lastProperty.setFill(Color.GREEN);
		
		counterText = new Text("Total number of properties listed: " + Property.getTotalProperties());
		counterText.setFont(Font.font("Bauhaus 93", FontWeight.BOLD, 24));
		counterText.setFill(Color.rgb(100, 0, 150));
		
		
		bottomBox.getChildren().addAll(lastProperty, counterText);
		
		mainPane.setBottom(bottomBox);
		
	}
	
	public Parent getParent() {
		return mainPane;
	}
	
	public void setSubmitProperty(EventHandler<ActionEvent> handler) {
		submitButton.setOnAction(handler);
	}
	
	public String getPropertyAddress() {
		return addressField.getText();
	}
	
	public PropertyType getPropertyType() {
		return typeChoice.getValue();
	}
	
	public String getListingNumber() {
		return listingField.getText();
	}
	
	public String getValue() {
		return valueField.getText();
	}
	
	public void setPropertyCounter() {
		counterText.setText("Total number of properties listed: " + Property.getTotalProperties());
	}
	
	public void setLastProperty() {
		lastProperty.setText("Listing Successful!\r\nAddress: " + getPropertyAddress() + "\r\nListing Number: " + 
							  getListingNumber() + "\r\nValue: " + getValue());	
	}
	
	
	
	

}
