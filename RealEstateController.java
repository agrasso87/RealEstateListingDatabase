

import java.util.*;

import javafx.application.*;
import javafx.collections.*;
import javafx.event.*;
import javafx.event.*;
import javafx.geometry.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.*;
import javafx.scene.text.*;
import javafx.stage.*;


public class RealEstateController extends Application {

	private Property newProperty;
	private ArrayList<Property> propertyListings; 
	private RealEstateGUIView inputView;
	
	public RealEstateController() { //constructor
		
		propertyListings = new ArrayList<>();
		inputView = new RealEstateGUIView();
		
		inputView.setSubmitProperty(this::submitProperty);
	}
	
	//creates a new Property Listing once the Submit button is pushed; updates static counter and last property text
	//needs exception handling
	private void submitProperty(ActionEvent event) {
		String address = inputView.getPropertyAddress();
		PropertyType type = inputView.getPropertyType();
		int listing = Integer.parseInt(inputView.getListingNumber());
		int value = Integer.parseInt(inputView.getValue());
		
		//uses PropertyType enum to initialize the appropriate child class
		if(type.equals(PropertyType.RESIDENTIAL)) {
			newProperty = new ResidentialProperty(address, value, listing, 0);
			propertyListings.add(newProperty);
		} else if (type.equals(PropertyType.COMMERCIAL)) {
			newProperty = new CommercialProperty(address, value, listing, null);
			propertyListings.add(newProperty);
		} else if (type.equals(PropertyType.INDUSTRIAL)) {
			newProperty = new IndustrialProperty(address, value, listing, null);
			propertyListings.add(newProperty);
		}
		
		inputView.setPropertyCounter();
		inputView.setLastProperty();	
	}
	
	public void start(Stage primaryStage) {
		System.setProperty("glass.accessible.force", "false");
		
		RealEstateController controller = new RealEstateController();
		
		Scene scene = new Scene(controller.inputView.getParent(), 640, 480, Color.rgb(210, 220, 190));
		primaryStage.setTitle("Real Property Creator");
		primaryStage.setScene(scene);
		primaryStage.setResizable(true);
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
} 
