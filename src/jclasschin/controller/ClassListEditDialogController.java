/*
 * The MIT License
 *
 * Copyright 2014 Ali.
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
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import jclasschin.entity.Classroom;
import jclasschin.model.ClassManager;

/**
 * FXML Controller class
 *
 * @author Ali
 */
public class ClassListEditDialogController implements Initializable
{

    private Stage classEditDialogStage;
    private Classroom editableClass;
    private ClassManager classManager;
    
    @FXML
    private TextField floorTextField;
    @FXML
    private TextField capacityTextField;
    @FXML
    private TextField classNameTextField;
    @FXML
    private CheckBox videoProjectorCheckBox;
    @FXML
    private CheckBox whiteBoardCheckBox;
    @FXML
    private CheckBox blackBoardCheckBox;
    @FXML
    private HBox okHBox;
    @FXML
    private ImageView okImageView;
    @FXML
    private HBox cancelHBox;
    @FXML
    private ImageView cancelImageView;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        // TODO
    }
    
    @FXML
    private void okHBoxOnMouseClicked(MouseEvent event)
    {
        ClassManager cm = new ClassManager();
        cm.update(editableClass.getId(),classNameTextField.getText(),floorTextField.getText(),Integer.parseInt(capacityTextField.getText()),
                videoProjectorCheckBox.isSelected(),whiteBoardCheckBox.isSelected(),blackBoardCheckBox.isSelected());
       
        classEditDialogStage.close();
    }
    
    @FXML
    private void cancelHBoxOnMouseClicked(MouseEvent event)
    {
        classEditDialogStage.close();
    }

    /**
     * @return the classEditDialogStage
     */
    public Stage getClassEditDialogStage()
    {
        return classEditDialogStage;
    }

    /**
     * @param classEditDialogStage the classEditDialogStage to set
     */
    public void setClassEditDialogStage(Stage classEditDialogStage)
    {
        this.classEditDialogStage = classEditDialogStage;
    }

    /**
     * @return the editableClass
     */
    public Classroom getEditableClass()
    {
        return editableClass;
    }

    /**
     * @param editableClass the editableClass to set
     */
    public void setEditableClass(Classroom editableClass)
    {
        this.editableClass = editableClass;
    }
    
    public void initDialog()
    {
        classNameTextField.setText(editableClass.getName());
        floorTextField.setText(editableClass.getFloor());
        capacityTextField.setText(editableClass.getCapacity() + "");
        videoProjectorCheckBox.setSelected(editableClass.getDataProjector());
        whiteBoardCheckBox.setSelected(editableClass.getWhiteboard());
        blackBoardCheckBox.setSelected(editableClass.getBlackboard());
    }
    
}
