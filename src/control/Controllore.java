
package control;

import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class Controllore implements Initializable {

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //
    }
    
    private Random estrattore = new Random();
    
    private int cartaVincente;
    
    private int totale = 1;
    private int vinte = 0;   
    
    @FXML private Label lblTotPartite;
    @FXML private Label lblTotVittorie;
    @FXML private Label lblPercentVittorie;
    @FXML private Label lblInfo;
    
    @FXML private Button btnCarta1;
    @FXML private Button btnCarta2;
    @FXML private Button btnCarta3;
    
    @FXML
    private void nuovaPartita (ActionEvent ae) {
        totale ++;
        cartaVincente = estrattore.nextInt(3);
        
        lblInfo.setText("");
        this.setStats();
        
        btnCarta1.setDisable(false);
        btnCarta2.setDisable(false);
        btnCarta3.setDisable(false);
        
        btnCarta1.setText("Carta 1");
        btnCarta2.setText("Carta 2");
        btnCarta3.setText("Carta 3");
        
        btnCarta1.setStyle("-fx-base: #E6E6E6;");
        btnCarta2.setStyle("-fx-base: #E6E6E6;");
        btnCarta3.setStyle("-fx-base: #E6E6E6;");
    }   
        
    @FXML
    private void premi_0 () { 
        this.setButton(0);
    }
    
    @FXML
    private void premi_1 () { 
        this.setButton(1);
    }
    
    @FXML
    private void premi_2 () { 
        this.setButton(2);
    }
    
    private void setStats () {
        lblTotPartite.setText(String.valueOf(this.totale));
        lblTotVittorie.setText(String.valueOf(this.vinte));
        if (this.totale != 0){
            lblPercentVittorie.setText(String.valueOf(this.vinte*100/this.totale));
        }
        else {
            lblPercentVittorie.setText(String.valueOf(this.vinte*100));
        }
    }
    
    private void setButton (int b) {
        btnCarta1.setDisable(true);
        btnCarta2.setDisable(true);
        btnCarta3.setDisable(true);
        
        switch (b) {
            case 0:  
                btnCarta2.setStyle("-fx-base: #669999;");
                btnCarta3.setStyle("-fx-base: #669999;");
                if (this.cartaVincente == 0) {
                    lblInfo.setText("HAI VINTO!");
                    vinte ++;
                    btnCarta1.setStyle("-fx-base: #00FF00;");
                }
                else {
                    lblInfo.setText("HAI PERSO!");
                    btnCarta1.setStyle("-fx-base: #FF0000;");
                }
                break;
            case 1:
                btnCarta1.setStyle("-fx-base: #669999;");
                btnCarta3.setStyle("-fx-base: #669999;");
                if (this.cartaVincente == 1) {
                    lblInfo.setText("HAI VINTO!");
                    vinte ++;
                    btnCarta2.setStyle("-fx-base: #00FF00;");
                }
                else {
                    lblInfo.setText("HAI PERSO!"); 
                    btnCarta2.setStyle("-fx-base: #FF0000;");
                }
                break;                
            case 2:
                btnCarta1.setStyle("-fx-base: #669999;");
                btnCarta2.setStyle("-fx-base: #669999;");
                if (this.cartaVincente == 2) {
                    lblInfo.setText("HAI VINTO!");
                    vinte ++;
                    btnCarta3.setStyle("-fx-base: #00FF00;");
                }
                else {
                    lblInfo.setText("HAI PERSO!");
                    btnCarta3.setStyle("-fx-base: #FF0000;");
                }
                break;                
        }
        
        switch (this.cartaVincente) {
            case 0:
                btnCarta1.setText("Asso");
                btnCarta2.setText("Fante");
                btnCarta3.setText("Cavallo");
                break;
            case 1:
                btnCarta1.setText("Fante");
                btnCarta2.setText("Asso");                
                btnCarta3.setText("Cavallo");
                break;
            case 2:
                btnCarta1.setText("Cavallo");
                btnCarta2.setText("Fante");
                btnCarta3.setText("Asso");
                break;
        }
        
        this.setStats();
    }
    
}
