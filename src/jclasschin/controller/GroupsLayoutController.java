/*
 * Last edit by Morteza
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
public class GroupsLayoutController implements Initializable {

    private FXMLLoader profNewDialogLoader, profEditDailogLoader,
            profDeleteDailogLoader, courseNewDialogLoader,
            courseEditDailogLoader, courseDeleteDailogLoader;
    private AnchorPane profNewDialogLayout, profEditDailogLayout,
            profDeleteDailogLayout, courseNewDialogLayout,
            courseEditDailogLayout, courseDeleteDailogLayout;
    private Scene profNewDialogScene, profEditDailogScene,
            profDeleteDailogScene, courseNewDialogScene,
            courseEditDailogScene, courseDeleteDailogScene;
    private Stage profNewDialogStage, profEditDailogStage,
            profDeleteDailogStage, courseNewDialogStage,
            courseEditDailogStage, courseDeleteDailogStage;

    private GroupsProferssorsNewDialogController profNewDialogController;
    private GroupsProferssorsEditDialogController profEditDialogController;
    private GroupsProferssorsDeleteDialogController profDeleteDialogController;
    private GroupsCoursesNewDialogController courseNewDialogController;
    private GroupsCoursesNewDialogController courseEditDialogController;
    private GroupsCoursesNewDialogController courseDeleteDialogController;

    public GroupsLayoutController() throws IOException {
        //_____________________________________________________________________
        // Courses New Dialog

        courseNewDialogLoader
                = new FXMLLoader(JClassChin.class.getResource("view/GroupsCoursesNewDialog.fxml"));
        courseNewDialogLayout = (AnchorPane) courseNewDialogLoader.load();
        courseNewDialogScene = new Scene(courseNewDialogLayout);
        courseNewDialogStage = new Stage();
        courseNewDialogStage.setScene(courseNewDialogScene);
        courseNewDialogStage.setTitle("واحد درسی جدید");
        courseNewDialogStage.initModality(Modality.WINDOW_MODAL);
        courseNewDialogStage.initOwner(JClassChin.getMainStage());
        courseNewDialogStage.setResizable(false);
        courseNewDialogStage.initStyle(StageStyle.UTILITY);
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void newHBoxOnMouseClicked(MouseEvent event) {

        courseNewDialogController = new GroupsCoursesNewDialogController();
        courseNewDialogController = courseNewDialogLoader.getController();
        courseNewDialogController.initialize(null, null);
        courseNewDialogController.setGroupsCoursesNewDialog(courseNewDialogStage);
        
        courseNewDialogStage.showAndWait();
        updateCourseTableView();

    }

    @FXML
    private void editHBoxOnMouseClicked(MouseEvent event) {
    }

    @FXML
    private void deleteHBoxOnMouseClicked(MouseEvent event) {
    }

    private void updateCourseTableView()
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
