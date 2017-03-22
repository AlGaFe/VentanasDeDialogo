/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicioventanasdialogo;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.control.Label;
import javafx.scene.control.TextInputDialog;
import javafx.scene.image.ImageView;

/**
 *
 * @author daw
 */
public class FXMLDocumentController implements Initializable {

    private Label label;
    @FXML
    private Button MostrarInputDialog;
    @FXML
    private Button MostrarAlertaConfirmacion;
    @FXML
    private Button MostrarAlertaWarning;
    @FXML
    private Button MostrarInputDialogVarios;
    @FXML
    private Button MostrarAlerteInfromación;
    @FXML
    private Button MostrarAlertaConfirmacionVarios;
    @FXML
    private Label Label;

    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void VentanasEmergenes(ActionEvent event) {
        if (event.getSource() == MostrarAlerteInfromación) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Módulo de Programación");
            alert.setHeaderText("Bienvenido al curso de Java FX");
            alert.setContentText("En este tema veremos las ventanas de dialogo");
            alert.showAndWait();

        }
        if (event.getSource() == MostrarAlertaWarning) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Módulo de Programación");
            alert.setHeaderText("Ventana de aviso algún peligro (Warning)");
            alert.setContentText("Si te equivocas saldrá esta ventana");
            alert.showAndWait();
        }
        if (event.getSource() == MostrarAlertaConfirmacion) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Módulo de Programación");
            alert.setHeaderText("Encuesta sobre el curso de Java FX");
            alert.setContentText("¿Te gusta el curso de Java FX?");

            ButtonType buttonOne = new ButtonType("Si");
            ButtonType buttonTwo = new ButtonType("No");
            ButtonType buttonThree = new ButtonType("Me abstengo");

            alert.getButtonTypes().setAll(buttonOne, buttonTwo, buttonThree);

            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == buttonOne) {
                Alert alertSi = new Alert(Alert.AlertType.INFORMATION);
                alertSi.setTitle("Módulo de Programación");
                alertSi.setHeaderText("Has pulsado SI");
                alertSi.setContentText("Me alegro");
                alertSi.showAndWait();
            }
            if (result.get() == buttonTwo) {
                Alert alert2 = new Alert(Alert.AlertType.ERROR);
                alert2.setTitle("Módulo de Programación");
                alert2.setHeaderText("Has pulsado NO");
                alert2.setContentText("Intentaremos mejorar");
                alert2.showAndWait();
            }
            if (result.get() == buttonThree) {
                Alert alert3 = new Alert(Alert.AlertType.WARNING);
                alert3.setTitle("Módulo de Programación");
                alert3.setHeaderText("Has pulsado ME ABSTENGO");
                alert3.setContentText("Necesitamos tu opinión");
                alert3.showAndWait();
            }

        }
        if (event.getSource() == MostrarInputDialogVarios) {
            TextInputDialog dialog = new TextInputDialog(" ");
            dialog.setGraphic(new ImageView("file:user.png"));

            dialog.setTitle("Módulo de Programación");
            dialog.setHeaderText("Ventana para solicitar nombre");
            dialog.setContentText("Por favor, introduce tu nombre:");
            Optional<String> result = dialog.showAndWait();
            if (result.isPresent()) {
                this.Label.setText("Gracias " + result.get());
            } else {
                this.Label.setText("Debes introducir un nombre");
            }
        }
        if (event.getSource() == MostrarAlertaConfirmacionVarios) {
            List<String> choices = new ArrayList<>();

            choices.add("Muy Bueno");
            choices.add("Bueno");
            choices.add("Malo");
            choices.add("Muy Malo");

            ChoiceDialog<String> dialog = new ChoiceDialog<>("Muy Bueno", choices);
            dialog.setTitle("Módulo de Programación");
            dialog.setHeaderText("Deseamos tu opinión");
            dialog.setContentText("Elije tu opción:");

            Optional<String> result = dialog.showAndWait();
            if (result.isPresent()) {
                this.Label.setText("Tu elección: " + result.get());
            }

        }
        if (event.getSource() == MostrarInputDialog) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Módulo de Programación");
            alert.setHeaderText("Danos tu opinión sobre el curso");
            alert.setContentText("Elije una opción");

            ButtonType buttonOne = new ButtonType("Muy Bueno");
            ButtonType buttonTwo = new ButtonType("Bueno");
            ButtonType buttonThree = new ButtonType("Malo");
            ButtonType buttonFour = new ButtonType("Muy Malo");

            alert.getButtonTypes().setAll(buttonOne, buttonTwo, buttonThree, buttonFour);

            Optional<ButtonType> result = alert.showAndWait();

            Alert alert2 = new Alert(Alert.AlertType.INFORMATION);
            alert2.setTitle("Módulo de Programación");
            alert2.setHeaderText("Su valoración a sido introducida, gracias por valorarnos");
            alert2.setContentText("Su valoración es: " + result.get().getText());
            alert2.showAndWait();

        }
    }
}
