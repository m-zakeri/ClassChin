/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import jclasschin.JClassChin;

/**
 * FXML Controller class
 *
 * @author Ali
 */
public class ClassLayoutController implements Initializable {

    private final FXMLLoader classListNewDialogLoader, classListEditDialogLoader,
            classListDeleteDialogLoader;

    private final AnchorPane classListNewDialogLayout, classListEditDialogLayout,
            classListDeleteDialogLayout;

    private final Scene classListNewDialogScene, classListEditDialogScene,
            classListDeleteDialogScene;

    private final Stage classListNewDialogStage, classListEditDialogStage,
            classListDeleteDialogStage;

    private ClassListNewDialogController classListNewDialogController;
    private ClassListEditDialogController classListEditDialogController;
    private ClassListDeleteDialogController classListDeleteDialogController;

    public ClassLayoutController() throws IOException {

        /* List New Dialog */
        classListNewDialogLoader
                = new FXMLLoader(JClassChin.class.getResource("view/ClassListNewDialog.fxml"));
        classListNewDialogLayout = (AnchorPane) classListNewDialogLoader.load();
        classListNewDialogScene = new Scene(classListNewDialogLayout);
        classListNewDialogStage = new Stage();
        classListNewDialogStage.setScene(classListNewDialogScene);
        classListNewDialogStage.setTitle("کلاس جدید");
        classListNewDialogStage.initModality(Modality.WINDOW_MODAL);
        classListNewDialogStage.initOwner(JClassChin.getMainStage());
        classListNewDialogStage.setResizable(false);
        classListNewDialogStage.initStyle(StageStyle.UTILITY);

        classListNewDialogController = classListNewDialogLoader.getController();

        /* List Edit Dialog   */
        classListEditDialogLoader
                = new FXMLLoader(JClassChin.class.getResource("view/ClassListEditDialog.fxml"));
        classListEditDialogLayout = (AnchorPane) classListEditDialogLoader.load();
        classListEditDialogScene = new Scene(classListEditDialogLayout);
        classListEditDialogStage = new Stage();
        classListEditDialogStage.setScene(classListEditDialogScene);
        classListEditDialogStage.setTitle("ویرایش کلاس");
        classListEditDialogStage.initModality(Modality.WINDOW_MODAL);
        classListEditDialogStage.initOwner(JClassChin.getMainStage());
        classListEditDialogStage.setResizable(false);
        classListEditDialogStage.initStyle(StageStyle.UTILITY);

        classListEditDialogController = classListEditDialogLoader.getController();

        /* List Delete Dialog   */
        classListDeleteDialogLoader
                = new FXMLLoader(JClassChin.class.getResource("view/ClassListDeleteDialog.fxml"));
        classListDeleteDialogLayout = (AnchorPane) classListDeleteDialogLoader.load();
        classListDeleteDialogScene = new Scene(classListDeleteDialogLayout);
        classListDeleteDialogStage = new Stage();
        classListDeleteDialogStage.setScene(classListDeleteDialogScene);
        classListDeleteDialogStage.setTitle("حذف کلاس");
        classListDeleteDialogStage.initModality(Modality.WINDOW_MODAL);
        classListDeleteDialogStage.initOwner(JClassChin.getMainStage());
        classListDeleteDialogStage.setResizable(false);
        classListDeleteDialogStage.initStyle(StageStyle.UTILITY);

        classListDeleteDialogController = classListDeleteDialogLoader.getController();
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void newClassHBoxOnMouseClicked(MouseEvent event) {
        
        classListNewDialogStage.showAndWait();
        
        //updateClassListTableView();
    }

    @FXML
    private void editClassHBoxOnMouseClicked(MouseEvent event) {
        classListEditDialogStage.showAndWait();
        
        //updateClassListTableView();
    }

    @FXML
    private void deleteClassHBoxOnMouseClicked(MouseEvent event) {
        classListDeleteDialogStage.showAndWait();
        
        //updateClassListTableView();
    }

}
