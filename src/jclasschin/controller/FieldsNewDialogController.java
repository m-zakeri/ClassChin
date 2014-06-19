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
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import jclasschin.model.FieldManager;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class FieldsNewDialogController implements Initializable
{

    private Stage newFieldDialogStage;

    private FieldManager fieldManager;

    private final Image okButton, okButtonOnMouseEntered, okButtonOnMouseClicked,
            cancelButton, cancelButtonOnMouseEntered, cancelButtonOnMouseClicked;

    @FXML
    private HBox okHBox;
    @FXML
    private HBox cancelHBox;
    @FXML
    private ImageView okImageView;
    @FXML
    private ImageView cancelImageView;
    @FXML
    private TextField fieldNameTextField;

    public FieldsNewDialogController() throws IOException
    {

        okButton = new Image("jclasschin/gallery/image/okButton.png");
        okButtonOnMouseClicked = new Image("jclasschin/gallery/image/okButtonClicked.png");
        okButtonOnMouseEntered = new Image("jclasschin/gallery/image/okButtonEntered.png");

        cancelButton = new Image("jclasschin/gallery/image/cancelButton.png");
        cancelButtonOnMouseClicked = new Image("jclasschin/gallery/image/cancelButtonClicked.png");
        cancelButtonOnMouseEntered = new Image("jclasschin/gallery/image/cancelButtonEntered.png");

    }

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        // TODO
//        programMessageLable.setText("");
    }

    @FXML
    private void okHBoxOnMouseClicked(MouseEvent event) throws IOException
    {

//        if (fieldNameTextField.getText() == null || "".equals(fieldNameTextField.getText())) {
////            programMessageLable.setTextFill(Color.RED);
////            programMessageLable.setText("Field Name can not be NULL!");
//           
//           // mainLayoutController.statusBarLable.setTextFill(Color.RED);
//            //mainLayoutController.statusBarLable.setText("texttttt");
//
//        } else if (fieldNameTextField.getText().matches("\\d*")) {
////            programMessageLable.setTextFill(Color.RED);
////            programMessageLable.setText("Field Name can not be only number!");
//
//        } else if (fieldNameTextField.getText().matches("\\d+[a-zA-Z_$1-9]*")) {
////            programMessageLable.setTextFill(Color.RED);
////            programMessageLable.setText("Field Name can not be start with number!");
//
//        } else {
        fieldManager = new FieldManager();
        fieldManager.insert(fieldNameTextField.getText());
            //      programMessageLable.setTextFill(Color.GREEN);
//                programMessageLable.setText("New Field add successfully!!!");
        //fieldNameTextField.setText("");

        newFieldDialogStage.close();

//                programMessageLable.setTextFill(Color.RED);
//                programMessageLable.setText("Failed to add New Field!");
//        }
    }

    @FXML
    private void okHBoxOnMouseExited(MouseEvent event)
    {
        okImageView.setImage(okButton);
    }

    @FXML
    private void okHBoxOnMouseEntered(MouseEvent event)
    {
        okImageView.setImage(okButtonOnMouseEntered);
    }

    @FXML
    private void cancelHBoxOnMouseClicked(MouseEvent event)
    {
        newFieldDialogStage.close();
    }

    @FXML
    private void cancelHBoxOnMouseEntered(MouseEvent event)
    {
        cancelImageView.setImage(cancelButtonOnMouseEntered);
    }

    @FXML
    private void cancelHBoxOnMouseExited(MouseEvent event)
    {
        cancelImageView.setImage(cancelButton);
    }

    /**
     * @return the newFieldDialogStage
     */
    public Stage getNewFieldDialogStage()
    {
        return newFieldDialogStage;
    }

    /**
     * @param newFieldDialogStage the newFieldDialogStage to set
     */
    public void setNewFieldDialogStage(Stage newFieldDialogStage)
    {
        this.newFieldDialogStage = newFieldDialogStage;
    }

}
