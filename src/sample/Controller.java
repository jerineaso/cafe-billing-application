package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

	private final double chickenSandwichPrice = 1.25D;
	private final double salmonSandwichPrice = 1.5D;
	private final double creamCheesePrice = 0.5D;
	private final double butterPrice = 0.25D;
	private final double blueberryJamPrice = 0.75D;
	private final double raspberryJamPrice = 0.75D;
	private final double peachJellyPrice = 0.75D;
	private final double regularCoffeePrice = 1.25D;
	private final double cappuccinoPrice = 2.0D;
	private final double cafeAuLaitPrice = 1.75D;

	@FXML
	private Button btnTotal;
	@FXML
	private Button btnReset;
	@FXML
	private Button btnExit;
	@FXML
	private RadioButton rdNone;
	@FXML
	private RadioButton rdChickenSandwich;
	@FXML
	private RadioButton rdSalmonSandwich;
	@FXML
	private RadioButton rdCoffeeNone;
	@FXML
	private RadioButton rdRegular;
	@FXML
	private RadioButton rdCappaccino;
	@FXML
	private RadioButton rdCafeAuLait;
	@FXML
	private CheckBox chCreamCheese;
	@FXML
	private CheckBox chButter;
	@FXML
	private CheckBox chBlueberry;
	@FXML
	private CheckBox chRaspberry;
	@FXML
	private CheckBox chPeach;
	@FXML
	private Label lbSubtotal;
	@FXML
	private Label lbSalesTax;
	@FXML
	private Label lbTotalSale;

	@FXML
	private TextField fieldRegular;
	@FXML
	private TextField fieldCapp;
	@FXML
	private TextField fieldCafe;
	@FXML
	private TextField fieldChicken;
	@FXML
	private TextField fieldSalmon;

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		disablePickSection(true);
		disableCafeFields(true);
		checkBoxEnable(true);
	}

	private void checkBoxEnable(boolean b) {
		chPeach.setDisable(b);
		chCreamCheese.setDisable(b);
		chBlueberry.setDisable(b);
		chButter.setDisable(b);
		chRaspberry.setDisable(b);

	}

	private void disableCafeFields(boolean b) {
		fieldCafe.setDisable(b);
		fieldCapp.setDisable(b);
		fieldRegular.setDisable(b);

		fieldCafe.setText("");
		fieldCapp.setText("");
		fieldRegular.setText("");

		rdCoffeeNone.setSelected(false);
		rdRegular.setSelected(false);
		rdCappaccino.setSelected(false);
		rdCafeAuLait.setSelected(false);

	}

	private void disablePickSection(boolean b) {
		fieldChicken.setDisable(b);
		fieldSalmon.setDisable(b);
		fieldChicken.setText("");
		fieldSalmon.setText("");

		chCreamCheese.setSelected(false);
		chButter.setSelected(false);
		chBlueberry.setSelected(false);
		chRaspberry.setSelected(false);
		chPeach.setSelected(false);

		rdNone.setSelected(false);
		rdChickenSandwich.setSelected(false);
		rdSalmonSandwich.setSelected(false);
	}
}
