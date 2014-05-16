/*
 * The MIT License
 *
 * Copyright 2014 HP.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
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
         //newFieldDialogStage.close();

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
       // newFieldDialogStage.close();
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
