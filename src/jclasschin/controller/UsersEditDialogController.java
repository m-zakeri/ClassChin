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
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.NodeOrientation;
import javafx.geometry.Point2D;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import jclasschin.entity.Field;
import jclasschin.entity.Job;
import jclasschin.entity.User;
import jclasschin.model.FieldManager;
import jclasschin.model.JobManager;
import jclasschin.model.UserManager;

/**
 * FXML Controller class
 *
 * @author Ali
 */
public class UsersEditDialogController implements Initializable
{

    private Stage usersEditDialogStage;
    private User editableUser;
    private UserManager userManager;

    private ToggleGroup sexToggleGroup, activeToggleGroup;

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
    private ComboBox<String> fieldComboBox;
    @FXML
    private ComboBox<String> jobComboBox;
    @FXML
    private HBox okHBox;
    @FXML
    private ImageView okImageView;
    @FXML
    private HBox cancelHBox;
    @FXML
    private ImageView cancelImageView;
    @FXML
    private PasswordField passwordField;
    @FXML
    private TextField userNameTextField;
    @FXML
    private RadioButton activeRadioButton;
    @FXML
    private RadioButton deActiveRadioButton;

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

        userManager = new UserManager();
        userManager.update(editableUser.getId(), editableUser.getPerson().getId(), titleComboBox.getValue(),
                firstNameTextField.getText(), lastNameTextField.getText(), maleSexRadioButton.isSelected(),
                phoneTextField.getText(), userNameTextField.getText(), passwordField.getText(),
                activeRadioButton.isSelected(), jobComboBox.getValue(), fieldComboBox.getValue());

        usersEditDialogStage.close();
    }

    @FXML
    private void cancelHBoxOnMouseClicked(MouseEvent event)
    {
        usersEditDialogStage.close();
    }

    /**
     * @return the usersEditDialogStage
     */
    public Stage getUsersEditDialogStage()
    {
        return usersEditDialogStage;
    }

    /**
     * @param usersEditDialogStage the usersEditDialogStage to set
     */
    public void setUsersEditDialogStage(Stage usersEditDialogStage)
    {
        this.usersEditDialogStage = usersEditDialogStage;
    }

    void initDialog()
    {
        clearDialogFields();

        titleComboBox.getItems().addAll("آقا", "خانم", "دکتر", "مهندس");
        titleComboBox.setValue(editableUser.getPerson().getTitle());

        FieldManager fm = new FieldManager();
        List fl = fm.selectAll();
        fl.stream().forEach((f) ->
        {
            fieldComboBox.getItems().add(((Field) f).getName());
        });
        fieldComboBox.setValue(editableUser.getPerson().getField().getName());

        JobManager jm = new JobManager();
        List jl = jm.selectAll();
        jl.stream().forEach((j) ->
        {
            jobComboBox.getItems().add(((Job) j).getTitle());
        });
        jobComboBox.setValue(editableUser.getPerson().getJob().getTitle());

        sexToggleGroup = new ToggleGroup();
        maleSexRadioButton.setToggleGroup(sexToggleGroup);
        femaleSexRadioButton.setToggleGroup(sexToggleGroup);
        if (editableUser.getPerson().isSex())
        {
            maleSexRadioButton.setSelected(true);
        }
        else
        {
            femaleSexRadioButton.setSelected(true);
        }

        activeToggleGroup = new ToggleGroup();
        activeRadioButton.setToggleGroup(activeToggleGroup);
        deActiveRadioButton.setToggleGroup(activeToggleGroup);
        if (editableUser.isState())
        {
            activeRadioButton.setSelected(true);
        }
        else
        {
            deActiveRadioButton.setSelected(true);
        }

        userNameTextField.setText(editableUser.getUsername());
        passwordField.setText(editableUser.getPassword());

        userNameTextField.setNodeOrientation(NodeOrientation.LEFT_TO_RIGHT);
        passwordField.setNodeOrientation(NodeOrientation.LEFT_TO_RIGHT);
    }

    private void clearDialogFields()
    {
        titleComboBox.getItems().clear();
        fieldComboBox.getItems().clear();
        jobComboBox.getItems().clear();

        firstNameTextField.setText(editableUser.getPerson().getFirstName());
        lastNameTextField.setText(editableUser.getPerson().getLastName());
        phoneTextField.setText(editableUser.getPerson().getPhone());
        phoneTextField.setPrefColumnCount(11);

        // phoneTextField.getText().length()>11
        phoneTextField.setPromptText("حداکثر طول مجاز 11 عدد است.");
        userNameTextField.setText("");
        passwordField.setText("");

    }

    /**
     * @return the editableUser
     */
    public User getEditableUser()
    {
        return editableUser;
    }

    /**
     * @param editableUser the editableUser to set
     */
    public void setEditableUser(User editableUser)
    {
        this.editableUser = editableUser;
    }

    @FXML
    private void phoneTextFieldOnKeyTyped(KeyEvent event)
    {
//        String stringTyped=null;
//        if(phoneTextField.getText().length() == 11)
//        {
//            stringTyped=phoneTextField.getText();
//        }
//        else if(phoneTextField.getText().length() > 11)
//            phoneTextField.setText(stringTyped);

        if (phoneTextField.getText().length() > 11)
        {
            String s = phoneTextField.getText();
            String substring = s.substring(0, 11);
            phoneTextField.setText(substring);
        }
    }
}
