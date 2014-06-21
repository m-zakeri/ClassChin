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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.NodeOrientation;
import javafx.geometry.Pos;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import jclasschin.JClassChin;
import org.controlsfx.control.CheckListView;

/**
 * FXML Controller class
 *
 * @author Ali
 */
public class ClassDedicateEditDialogController implements Initializable
{
    @FXML
    private AnchorPane classDedicateEditDialogAnchorPane;
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
    }

    @FXML
    private void cancelHBoxOnMouseClicked(MouseEvent event)
    {
    }

    void initDialog()
    {
 String css = JClassChin.class.getResource("gallery/css/CSS.css").toString();
        classDedicateEditDialogAnchorPane.getStylesheets().add(css);
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.TOP_CENTER);
        gridPane.setLayoutX(30);
        gridPane.setLayoutY(30);
        gridPane.setVgap(15);
        gridPane.setHgap(15);

        Label fieldLabel = new Label("رشته :");
        ComboBox<String> fieldsComboBox = new ComboBox<>();
        Label classLabel = new Label("کلاس ها :");


        CheckListView<String> checkListView;
        ObservableList<String> strings = FXCollections.observableArrayList();
        for (int i = 0; i <= 100; i++)
        {
            strings.add("Item " + i);
        }
        checkListView = new CheckListView<String>(strings);

        fieldsComboBox.setMinWidth(200);
        fieldsComboBox.setMaxWidth(200);

        checkListView.setMinWidth(200);
        checkListView.setMaxWidth(200);

        gridPane.add(fieldLabel, 0, 0);
        gridPane.add(fieldsComboBox, 1, 0);
        gridPane.add(classLabel, 0, 1);
        gridPane.add(checkListView, 1, 1);

//        checkComboBox.getCheckModel().getSelectedItems().addListener(new ListChangeListener<String>() {
//            @Override public void onChanged(ListChangeListener.Change<? extends String> c) {
//                updateText(checkedItemsLabel, c.getList());
//            }
//        });
        classDedicateEditDialogAnchorPane.getChildren().add(gridPane);
        classDedicateEditDialogAnchorPane.setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
    
    }
    
}
