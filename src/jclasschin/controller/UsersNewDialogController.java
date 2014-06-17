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
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.NodeOrientation;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import jclasschin.entity.Field;
import jclasschin.entity.User;
import jclasschin.model.FieldManager;
import jclasschin.model.JobManager;
import jclasschin.model.UserManager;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class UsersNewDialogController implements Initializable {

    private Stage usersNewDialogStage;
    private User newUser;
    private UserManager userManager;

    private ToggleGroup sexToggelGroup;

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
    private CheckBox activeCheckBox;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    /**
     * @return the usersNewDialogStage
     */
    public Stage getUsersNewDialogStage() {
        return usersNewDialogStage;
    }

    /**
     * @param usersNewDialogStage the usersNewDialogStage to set
     */
    public void setUsersNewDialogStage(Stage usersNewDialogStage) {
        this.usersNewDialogStage = usersNewDialogStage;
    }

    /**
     * @return the newUser
     */
    public User getNewUser() {
        return newUser;
    }

    /**
     * @param newUser the newUser to set
     */
    public void setNewUser(User newUser) {
        this.newUser = newUser;
    }

    @FXML
    private void okHBoxOnMouseClicked(MouseEvent event) {
        userManager = new UserManager();
        
        userManager.insert(titleComboBox.getValue(), firstNameTextField.getText(),
                lastNameTextField.getText(), maleSexRadioButton.isSelected(),
                phoneTextField.getText(), userNameTextField.getText(),
                passwordField.getText(), activeCheckBox.isSelected(),
                jobComboBox.getValue(), fieldComboBox.getValue()
        );
        
        usersNewDialogStage.close();
    }

    @FXML
    private void cancelHBoxOnMouseClicked(MouseEvent event) {
        usersNewDialogStage.close();
    }

    void initDialog() {
        titleComboBox.getItems().addAll("آقا", "خانم", "دکتر", "مهندس");

        FieldManager fm = new FieldManager();
        List fl = fm.selectAll();
        fl.stream().forEach((f) -> {
            fieldComboBox.getItems().add(((Field) f).getName());
        });
        
        JobManager jm = new JobManager();
        List jl = jm.selectAll();
        jl.stream().forEach((j) -> {
            jobComboBox.getItems().add(((Job) j).getTitle());
        });
        
        sexToggelGroup = new ToggleGroup();
        maleSexRadioButton.setToggleGroup(sexToggelGroup);
        femaleSexRadioButton.setToggleGroup(sexToggelGroup);

        userNameTextField.setNodeOrientation(NodeOrientation.LEFT_TO_RIGHT);
        passwordField.setNodeOrientation(NodeOrientation.LEFT_TO_RIGHT);
    }

    @FXML
    private void activeCheckBoxOnMouseClicked(MouseEvent event) {
        if (activeCheckBox.isSelected()) {
            activeCheckBox.setText("کاربر فعال است.");
        } else {
            activeCheckBox.setText("کاربر فعال نیست.");
        }
    }


}
