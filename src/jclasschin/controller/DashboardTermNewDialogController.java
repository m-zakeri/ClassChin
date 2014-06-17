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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import jclasschin.model.TermManager;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class DashboardTermNewDialogController implements Initializable
{
    
    private Stage dashboardTermNewDialogStage;
    
    
    @FXML
    private TextField termNameTextField;
    @FXML
    private HBox okHBox;
    @FXML
    private ImageView okImageView;
    @FXML
    private HBox cancelHBox;
    @FXML
    private ImageView cancelImageView;
//    private Label programMessageLable;

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
         TermManager termManager;
        if (getTermNameTextField().getText() == null || "".equals(getTermNameTextField().getText()))
        {
//            programMessageLable.setTextFill(Color.RED);
//            programMessageLable.setText("Field Name can not be NULL!");

        }
        else if (getTermNameTextField().getText().matches("\\d*"))
        {
//            programMessageLable.setTextFill(Color.RED);
//            programMessageLable.setText("Field Name can not be only number!");
            
        }
        else if (getTermNameTextField().getText().matches("\\d+[a-zA-Z_$1-9]*"))
        {
//            programMessageLable.setTextFill(Color.RED);
//            programMessageLable.setText("Field Name can not be start with number!");
            
        }
        else
        {
            termManager = new TermManager();
            if (termManager.insert(getTermNameTextField().getText()))
            {
                System.out.println(getTermNameTextField().getText());
//                programMessageLable.setTextFill(Color.GREEN);
//                programMessageLable.setText("New Field add successfully!!!");
                getTermNameTextField().setText("");
                
                dashboardTermNewDialogStage.close();
                
            }
            else
            {
//                programMessageLable.setTextFill(Color.RED);
//                programMessageLable.setText("Failed to add New Field!");
            }
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
        dashboardTermNewDialogStage.close();
    }

    /**
     * @return the dashboardTermNewDialogStage
     */
    public Stage getDashboardTermNewDialogStage()
    {
        return dashboardTermNewDialogStage;
    }

    /**
     * @param dashboardTermNewDialogStage the dashboardTermNewDialogStage to set
     */
    public void setDashboardTermNewDialogStage(Stage dashboardTermNewDialogStage)
    {
        this.dashboardTermNewDialogStage = dashboardTermNewDialogStage;
    }

    /**
     * @return the termNameTextField
     */
    public TextField getTermNameTextField()
    {
        return termNameTextField;
    }
  
}
