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

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import jclasschin.entity.Field;
import jclasschin.model.FieldManager;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class FieldsEditDialogController implements Initializable
{

    private Stage fieldsEditDialogStage;
    private Field field;
    private FieldManager fieldManager;

//    private TextField fieldNameTextField;
    @FXML
    private HBox okHBox;
    @FXML
    private ImageView okImageView;
    @FXML
    private HBox cancelHBox;
    @FXML
    private ImageView cancelImageView;
    @FXML
    private TextField fieldNameTextField;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        // TODO
    }

    @FXML
    private void okHBoxOnMouseExited(MouseEvent event)
    {

    }

    @FXML
    private void okHBoxOnMouseEntered(MouseEvent event)
    {
    }

    @FXML
    private void okHBoxOnMouseClicked(MouseEvent event)
    {
        if (fieldNameTextField.getText() != null)
        {
            fieldManager = new FieldManager();
            fieldManager.update(field.getId(), fieldNameTextField.getText());
            
            fieldsEditDialogStage.close();
        }
        
    }

    @FXML
    private void cancelHBoxOnMouseExited(MouseEvent event)
    {
    }

    @FXML
    private void cancelHBoxOnMouseEntered(MouseEvent event)
    {
    }

    @FXML
    private void cancelHBoxOnMouseClicked(MouseEvent event)
    {
        fieldsEditDialogStage.close();
    }

    /**
     * @return the fieldsEditDialogStage
     */
    public Stage getFieldsEditDialogStage()
    { 
            return fieldsEditDialogStage; 
    }

    /**
     * @param fieldsEditDialogStage the fieldsEditDialogStage to set
     */
    public void setFieldsEditDialogStage(Stage fieldsEditDialogStage)
    {
        this.fieldsEditDialogStage = fieldsEditDialogStage;
    }

    /**
     * @return the field
     */
    public Field getField()
    {
        return field;
    }

    /**
     * @param field the field to set
     */
    public void setField(Field field)
    {
        this.field = field;
        fieldNameTextField.setText(this.field.getName());
    }

}
