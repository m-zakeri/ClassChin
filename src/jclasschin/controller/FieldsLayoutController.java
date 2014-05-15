/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jclasschin.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import jclasschin.JClassChin;
import jclasschin.entity.Mail;

/**
 * FXML Controller class
 *
 * @author Ali
 */
public class FieldsLayoutController implements Initializable
{

    private final FXMLLoader newFieldDialogLoader;
    private final AnchorPane newFieldDialogAnchorPane;
    private final Scene newFieldDialogScene;
    private final Stage newFieldDialogStage;

    private NewFieldDialogController newFieldDialogController;

    @FXML
    private HBox newHBox;
    @FXML
    private HBox editHBox;
    @FXML
    private HBox deleteHBox;
    
     /**
     * Initializes the controller class constructor
     * @throws java.io.IOException
     */

    public FieldsLayoutController() throws IOException
    {
        newFieldDialogLoader = new FXMLLoader(JClassChin.class.getResource("view/NewFieldDialog.fxml"));

        newFieldDialogAnchorPane = (AnchorPane) newFieldDialogLoader.load();

        newFieldDialogScene = new Scene(newFieldDialogAnchorPane);

        newFieldDialogStage = new Stage();
        newFieldDialogStage.setScene(newFieldDialogScene);
        newFieldDialogStage.setTitle("New Field");
        newFieldDialogStage.initModality(Modality.WINDOW_MODAL);
        newFieldDialogStage.initOwner(JClassChin.getMainStage());
        newFieldDialogStage.setResizable(false);
        newFieldDialogStage.initStyle(StageStyle.UTILITY);
      //  newFieldDialogStage.close();

    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        // TODO
    }

    @FXML
    private void newHBoxOnMouseClicked(MouseEvent event)
    {
        //newFieldDialogController = new NewFieldDialogController();
        
        newFieldDialogController = newFieldDialogLoader.getController();
        newFieldDialogStage.showAndWait();
    }

    @FXML
    private void editHBoxOnMouseClicked(MouseEvent event)
    {
    }

    @FXML
    private void deleteHBoxOnMouseClicked(MouseEvent event)
    {

    }

    @FXML
    private void newHBoxOnMouseExited(MouseEvent event)
    {
    }

    @FXML
    private void newHBoxOnMouseEntered(MouseEvent event)
    {
    }

}
