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
import java.util.Date;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import jclasschin.JClassChin;
import org.controlsfx.control.RangeSlider;
import org.controlsfx.control.textfield.CustomTextField;

/**
 * FXML Controller class
 *
 * @author Ali
 */
public class ClassScheduleNewDialogController implements Initializable
{

    GridPane gridPane;
    int periodsNumber;
    Label[] periodTitle;
//    RangeSlider[] periodRangeSlider;
    Label[] fromLable;
    TextField[] startOfPeriodTextFiled;
    Label[] toLable;
    TextField[] endOfPeriodTextFiled;

    @FXML
    private ScrollPane classScheduleNewDialogScrollPane;
    @FXML
    private AnchorPane classScheduleNewDialogAnchorPane;
    @FXML
    private TextField scheduleNameTextField;
    @FXML
    private TextField periodsNumberTextField;
    @FXML
    private GridPane periodsGridPane;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        // TODO
    }

    public void initDialog()
    {
        String css = JClassChin.class.getResource("gallery/css/CSS.css").toString();
        classScheduleNewDialogScrollPane.getStylesheets().add(css);
        gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setVgap(15);
        gridPane.setHgap(15);
        gridPane.setLayoutX(36);
        gridPane.setLayoutY(170);
        //classScheduleNewDialogAnchorPane.getChildren().clear();

//        Label[] label=new Label[50];
//        for(int i=0;i<50;i++){
//            label[i]=new Label("Salam"+i);
//            gridPane.add(label[i], 0, i);
//        }
//        classScheduleNewDialogAnchorPane.getChildren().add(gridPane);
    }

    @FXML
    private void periodsNumberTextFieldOnTextChanged(InputMethodEvent event)
    {
//        periodsNumber = Integer.parseInt(periodsNumberTextField.getText());
//
//        periodTitle = new Label[periodsNumber];
//        for (int i = 0; i < periodsNumber; i++)
//        {
//            periodTitle[i] = new Label("بازه" + (i + 1) + ":");
//        }
//
//        periodRangeSlider = new RangeSlider[periodsNumber];
//        for (int i = 0; i < periodsNumber; i++)
//        {
//            periodRangeSlider[i] = new RangeSlider(0, 144, 8, 20);
//            periodRangeSlider[i].setShowTickMarks(true);
//            periodRangeSlider[i].setShowTickLabels(true);
//            periodRangeSlider[i].setBlockIncrement(10 / 6);
//            periodRangeSlider[i].setPrefWidth(200);
//        }
//
//        fromLable = new Label("از");
//
//        startOfPeriod = new Label[periodsNumber];
//        for (int i = 0; i < periodsNumber; i++)
//        {
//            startOfPeriod[i] = new Label();
//        }
//
//        toLable = new Label("به");
//
//        endOfPeriod = new Label[periodsNumber];
//        for (int i = 0; i < periodsNumber; i++)
//        {
//            endOfPeriod[i] = new Label();
//        }
//
//        for (int i = 0; i < periodsNumber; i++)
//        {
//            int j = 0;
//            gridPane.add(periodTitle[i], j++, i);
//            gridPane.add(periodRangeSlider[i], j++, i);
//            gridPane.add(fromLable, j++, i);
//            gridPane.add(startOfPeriod[i], j++, i);
//            gridPane.add(toLable, j++, i);
//            gridPane.add(endOfPeriod[i], j++, i);
//        }
//        classScheduleNewDialogAnchorPane.getChildren().clear();
//        classScheduleNewDialogBottomAnchorPane.getChildren().add(gridPane);

    }

    @FXML
    private void periodsNumberTextFieldOnAction(ActionEvent event)
    {
        periodsGridPane.getChildren().clear();
        periodsNumber = Integer.parseInt(periodsNumberTextField.getText());

        periodTitle = new Label[periodsNumber];
        for (int i = 0; i < periodsNumber; i++)
        {
            periodTitle[i] = new Label("بازه" + (i + 1) + " :");
        }

//        periodRangeSlider = new RangeSlider[periodsNumber];
//        for (int i = 0; i < periodsNumber; i++)
//        {
//            periodRangeSlider[i] = new RangeSlider(0, 24, 8, 20);
//            periodRangeSlider[i].setShowTickMarks(true);
//            periodRangeSlider[i].setShowTickLabels(true);
//            periodRangeSlider[i].setBlockIncrement(1);
//            periodRangeSlider[i].setMajorTickUnit(1);
//            periodRangeSlider[i].setSnapToTicks(true);
//            periodRangeSlider[i].setMinorTickCount(1);
//            periodRangeSlider[i].setMajorTickUnit(1);
//
//            periodRangeSlider[i].setPrefWidth(300);
//        }
        fromLable = new Label[periodsNumber];
        for (int i = 0; i < periodsNumber; i++)
        {
            fromLable[i] = new Label("از");
        }

        startOfPeriodTextFiled = new TextField[periodsNumber];
        for (int i = 0; i < periodsNumber; i++)
        {
            startOfPeriodTextFiled[i] = new TextField();
            startOfPeriodTextFiled[i].setMaxWidth(75);
            startOfPeriodTextFiled[i].setPromptText("00:00");
        }

        toLable = new Label[periodsNumber];
        for (int i = 0; i < periodsNumber; i++)
        {
            toLable[i] = new Label("تا");
        }

        endOfPeriodTextFiled = new TextField[periodsNumber];
        for (int i = 0; i < periodsNumber; i++)
        {
            endOfPeriodTextFiled[i] = new TextField();
            endOfPeriodTextFiled[i].setMaxWidth(75);
            endOfPeriodTextFiled[i].setPromptText("00:00");
        }

        for (int i = 0; i < periodsNumber; i++)
        {
            int j = 0;
            periodsGridPane.add(periodTitle[i], j++, i);
            periodsGridPane.add(fromLable[i], j++, i);
            periodsGridPane.add(startOfPeriodTextFiled[i], j++, i);
            periodsGridPane.add(toLable[i], j++, i);
            periodsGridPane.add(endOfPeriodTextFiled[i], j++, i);
        }
    //    periodsGridPane.setmi(periodsGridPane.getPrefHeight() + 10);
        //periodsGridPane.setPrefHeight(periodsGridPane.getPrefHeight() - 1);

        //classScheduleNewDialogAnchorPane.getChildren().add(gridPane);
    }

}
