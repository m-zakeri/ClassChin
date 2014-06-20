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
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import jclasschin.entity.Person;
import jclasschin.model.PersonManager;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class GroupsProferssorsNewDialogController implements Initializable
{
    private Stage groupProferssorsNewDialogStage;
    private Person person;
    private PersonManager personManager;

    @FXML
    private TextField lastNameTextField;
    @FXML
    private TextField firstNameTextField;
    @FXML
    private ComboBox<String> titleComboBox;
    @FXML
    private TextField phoneTextField;
    @FXML
    private RadioButton maleSexRadioButton;
    @FXML
    private RadioButton femaleSexRadioButton;
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
        personManager = new PersonManager();
        personManager.insert(titleComboBox.getValue(), firstNameTextField.getText(), 
                lastNameTextField.getText(),maleSexRadioButton.isSelected(), phoneTextField.getText());
        
        groupProferssorsNewDialogStage.close();
    }

    @FXML
    private void cancelHBoxOnMouseClicked(MouseEvent event)
    {
        groupProferssorsNewDialogStage.close();
    }

    /**
     * @return the groupProferssorsNewDialogStage
     */
    public Stage getGroupProferssorsNewDialogStage()
    {
        return groupProferssorsNewDialogStage;
    }

    /**
     * @param groupProferssorsNewDialogStage the groupProferssorsNewDialogStage to set
     */
    public void setGroupProferssorsNewDialogStage(Stage groupProferssorsNewDialogStage)
    {
        this.groupProferssorsNewDialogStage = groupProferssorsNewDialogStage;
    }

    void initDialog()
    {
        titleComboBox.getItems().clear();
        titleComboBox.getItems().addAll("آقا","خانم","دکتر","مهندس");
        firstNameTextField.setText("");
        lastNameTextField.setText("");
        phoneTextField.setText("");
        
        ToggleGroup toggleGroup = new ToggleGroup();
        maleSexRadioButton.setToggleGroup(toggleGroup);
        femaleSexRadioButton.setToggleGroup(toggleGroup);
        maleSexRadioButton.setSelected(false);
        femaleSexRadioButton.setSelected(false);
    }

}
