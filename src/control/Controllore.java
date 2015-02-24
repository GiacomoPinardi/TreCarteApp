
package control;

import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Controllore implements Initializable {

    @Override
    public void initialize(URL url, ResourceBundle rb) {        
        this.nuovaPartita(null);
    }
    
    private Random estrattore = new Random();
    
    private int cartaVincente;
    
    private int totale = 0;
    private int vinte = 0;   
    
    @FXML private Label lblTotPartite;
    @FXML private Label lblTotVittorie;
    @FXML private Label lblPercentVittorie;
    @FXML private Label lblInfo;
    
    @FXML private Button btnCarta1;
    @FXML private Button btnCarta2;
    @FXML private Button btnCarta3;
    
    Image retroCartaImg = new Image(getClass().getResourceAsStream("../view/carta.jpg"));
    Image assoCartaImg = new Image(getClass().getResourceAsStream("../view/asso.jpg"));
    Image fanteCartaImg = new Image(getClass().getResourceAsStream("../view/fante.jpg"));
    Image donnaCartaImg = new Image(getClass().getResourceAsStream("../view/donna.jpg"));
    
    ImageView retroCarta1 = new ImageView(retroCartaImg);
    ImageView retroCarta2 = new ImageView(retroCartaImg);
    ImageView retroCarta3 = new ImageView(retroCartaImg);  
    
    ImageView assoCarta = new ImageView(assoCartaImg);
    ImageView fanteCarta = new ImageView(fanteCartaImg);
    ImageView donnaCarta = new ImageView(donnaCartaImg); 
    
    @FXML
    private void nuovaPartita (ActionEvent ae) {
        totale ++;
        cartaVincente = estrattore.nextInt(3);
        
        lblInfo.setText("");
        this.setStats();
        
        btnCarta1.setDisable(false);
        btnCarta2.setDisable(false);
        btnCarta3.setDisable(false);
        
        btnCarta1.setStyle("-fx-base: #E6E6E6;");
        btnCarta2.setStyle("-fx-base: #E6E6E6;");
        btnCarta3.setStyle("-fx-base: #E6E6E6;");
                
        btnCarta1.setText("");
        btnCarta2.setText("");
        btnCarta3.setText("");
        
        btnCarta1.setGraphic(retroCarta1);
        btnCarta2.setGraphic(retroCarta2);
        btnCarta3.setGraphic(retroCarta3);
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
    
    private void setButton (int button) {
        btnCarta1.setDisable(true);
        btnCarta2.setDisable(true);
        btnCarta3.setDisable(true);
        
        switch (button) {
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
        
        boolean b = estrattore.nextBoolean();
        
        switch (this.cartaVincente) {
            case 0:
                btnCarta1.setGraphic(assoCarta);
                if (b) {
                    btnCarta2.setGraphic(fanteCarta);
                    btnCarta3.setGraphic(donnaCarta);
                }
                else {
                    btnCarta2.setGraphic(donnaCarta);
                    btnCarta3.setGraphic(fanteCarta);
                }
                break;
            case 1:                
                btnCarta2.setGraphic(assoCarta);
                if (b) {
                    btnCarta1.setGraphic(fanteCarta);
                    btnCarta3.setGraphic(donnaCarta);
                }
                else {
                    btnCarta1.setGraphic(donnaCarta);
                    btnCarta3.setGraphic(fanteCarta);
                }
                break;
            case 2:                
                btnCarta3.setGraphic(assoCarta);
                if (b) {
                    btnCarta1.setGraphic(donnaCarta);
                    btnCarta2.setGraphic(fanteCarta);
                }
                else {
                    btnCarta1.setGraphic(fanteCarta);
                    btnCarta2.setGraphic(donnaCarta);
                }
                break;
        }
        
        this.setStats();
    }
    
}
