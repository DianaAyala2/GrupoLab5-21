package controller;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import model.Conversor;
import model.MetrosACentimetros;
import model.CentimetrosAMetros;

public class ConversorController {

    @FXML
    private TextField txtCantidad;

    @FXML
    private ComboBox<String> cmbDe;

    @FXML
    private ComboBox<String> cmbA;

    @FXML
    private Label lblResultado;

    private final Conversor conversor = new Conversor();

    @FXML
    public void initialize() {
        cmbDe.getItems().addAll("Metros", "Centímetros");
        cmbA.getItems().addAll("Metros", "Centímetros");

        cmbDe.setValue("Metros");
        cmbA.setValue("Centímetros");
    }

    @FXML
    private void convertir() {

        try {

            double valor = Double.parseDouble(txtCantidad.getText());

            String origen = cmbDe.getValue();
            String destino = cmbA.getValue();

            if (origen.equals("Metros") && destino.equals("Centímetros")) {

                conversor.setEstrategia(new MetrosACentimetros());

            } else if (origen.equals("Centímetros") && destino.equals("Metros")) {

                conversor.setEstrategia(new CentimetrosAMetros());

            } else {

                lblResultado.setText(
                        "Resultado: " + valor + " (misma unidad)");
                return;
            }

            double resultado = conversor.convertir(valor);

            lblResultado.setText(
                    String.format("Resultado: %.2f", resultado));

        } catch (NumberFormatException e) {

            lblResultado.setText("Ingrese un número válido");
        }
    }
}
