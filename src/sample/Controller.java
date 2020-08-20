package sample;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.text.DecimalFormat;
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

	DecimalFormat df = new DecimalFormat("$#,##0.00");

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

		btnTotal.setOnAction(event -> {
			double pretaxOrderPrice = 0.0D;
			double salesTax = 0.0D;
			double totalOrderPrice = 0.0D;

			int chickenCount = parseFieldInteger(fieldChicken.getText());
			int salmonCount = parseFieldInteger(fieldSalmon.getText());
			int regularCount = parseFieldInteger(fieldRegular.getText());
			int cappaccinoCount = parseFieldInteger(fieldCapp.getText());
			int cafeLaitCount = parseFieldInteger(fieldCafe.getText());

			pretaxOrderPrice = chickenCount * chickenSandwichPrice + salmonCount * salmonSandwichPrice
					+ regularCount * regularCoffeePrice + cappaccinoCount * cappuccinoPrice
					+ cafeLaitCount * cafeAuLaitPrice;
			if (chBlueberry.isSelected()) {
				pretaxOrderPrice += blueberryJamPrice;
			}
			if (chButter.isSelected()) {
				pretaxOrderPrice += butterPrice;
			}
			if (chCreamCheese.isSelected()) {
				pretaxOrderPrice += creamCheesePrice;
			}
			if (chPeach.isSelected()) {
				pretaxOrderPrice += peachJellyPrice;
			}
			if (chRaspberry.isSelected()) {
				pretaxOrderPrice += raspberryJamPrice;
			}

			salesTax = pretaxOrderPrice * 0.13D;
			totalOrderPrice = pretaxOrderPrice + salesTax;

			System.out.println(totalOrderPrice + " " + pretaxOrderPrice + " " + salesTax);

			lbSubtotal.setText(df.format(pretaxOrderPrice));
			lbSalesTax.setText(df.format(salesTax));
			lbTotalSale.setText(df.format(totalOrderPrice));
		});

		btnReset.setOnAction(event -> {
			double pretaxOrderPrice = 0.0D;
			double salesTax = 0.0D;
			double totalOrderPrice = 0.0D;
			disablePickSection(true);
			checkBoxEnable(true);
			disableCafeFields(true);
			lbSubtotal.setText(df.format(pretaxOrderPrice));
			lbSalesTax.setText(df.format(salesTax));
			lbTotalSale.setText(df.format(totalOrderPrice));
		});

		btnExit.setOnAction(event -> {
			Platform.exit();
		});
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

	private Integer parseFieldInteger(String value) {
		Integer converted = 0;
		try {
			if (value.trim().length() > 0) {
				converted = Integer.valueOf(value);
			}
		} catch (NumberFormatException e) {
			converted = -1;
		} catch (Exception e) {
			converted = -1;
		}
		return converted;
	}

	@FXML
	private void rdNone() {
		Boolean value = rdNone.selectedProperty().get();
		disablePickSection(value);
		checkBoxEnable(value);
		if (value) {
			rdNone.setSelected(value);
		}

	}

	@FXML
	private void rdSalmonSandwich() {
		Boolean value = rdSalmonSandwich.selectedProperty().get();
		disablePickSection(value);
		checkBoxEnable(!value);
		if (value) {
			rdSalmonSandwich.setSelected(true);
			fieldSalmon.setDisable(false);
			fieldSalmon.setText("1");
		}
	}

	@FXML
	private void rdChickenSandwich() {
		Boolean value = rdChickenSandwich.selectedProperty().get();
		disablePickSection(value);
		checkBoxEnable(!value);
		if (value) {
			rdChickenSandwich.setSelected(true);
			fieldChicken.setDisable(false);
			fieldChicken.setText("1");
		}
	}

	@FXML
	private void rdCoffeeNone() {

		Boolean value = rdCoffeeNone.selectedProperty().get();
		disableCafeFields(true);
		if (value) {
			rdCoffeeNone.setSelected(value);
		}

	}

	@FXML
	private void rdRegular() {
		Boolean value = rdRegular.selectedProperty().get();
		disableCafeFields(true);
		if (value) {
			rdRegular.setSelected(value);
			fieldRegular.setDisable(false);
			fieldRegular.setText("1");
		}

	}

	@FXML
	private void rdCappaccino() {
		Boolean value = rdCappaccino.selectedProperty().get();
		disableCafeFields(true);
		if (value) {
			rdCappaccino.setSelected(value);
			fieldCapp.setDisable(false);
			fieldCapp.setText("1");
		}

	}

	@FXML
	private void rdCafeAuLait() {
		Boolean value = rdCafeAuLait.selectedProperty().get();
		disableCafeFields(true);
		if (value) {
			rdCafeAuLait.setSelected(value);
			fieldCafe.setDisable(false);
			fieldCafe.setText("1");
		}
	}

}
