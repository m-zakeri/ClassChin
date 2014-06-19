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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import jclasschin.JClassChin;
import jclasschin.entity.Course;
import jclasschin.entity.Person;
import jclasschin.entity.User;

/**
 * FXML Controller class
 *
 * @author Ali
 */
public class GroupsLayoutController implements Initializable {

    private final FXMLLoader profNewDialogLoader, profEditDialogLoader,
            profDeleteDialogLoader, courseNewDialogLoader,
            courseEditDialogLoader, courseDeleteDialogLoader;
    private final AnchorPane profNewDialogLayout, profEditDialogLayout,
            profDeleteDialogLayout, courseNewDialogLayout,
            courseEditDialogLayout, courseDeleteDialogLayout;
    private final Scene profNewDialogScene, profEditDialogScene,
            profDeleteDialogScene, courseNewDialogScene,
            courseEditDialogScene, courseDeleteDialogScene;
    private final Stage profNewDialogStage, profEditDialogStage,
            profDeleteDialogStage, courseNewDialogStage,
            courseEditDialogStage, courseDeleteDialogStage;

    private GroupsProferssorsNewDialogController profNewDialogController;
    private GroupsProferssorsEditDialogController profEditDialogController;
    private GroupsProferssorsDeleteDialogController profDeleteDialogController;

    private GroupsCoursesNewDialogController courseNewDialogController;
    private GroupsCoursesEditDialogController courseEditDialogController;
    private GroupsCoursesDeleteDialogController courseDeleteDialogController;

    @FXML
    private HBox profNewHBox;
    @FXML
    private TableView<Person> profTableView;
    @FXML
    private TableColumn<Person, String> profIdTableColumn;
    @FXML
    private TableColumn<Person, String> profFirstAndLastNameTableColumn;
    @FXML
    private TableColumn<Person, String> profFieldTableColumn;
    @FXML
    private TableColumn<Person, String> profPhoneTableColumn;

    @FXML
    private TableView<Course> courseTableView;
    @FXML
    private TableColumn<Course, String> idTableColumn;
    @FXML
    private TableColumn<Course, String> nameTableColumn;
    @FXML
    private TableColumn<Course, String> typeTableColumn;

    public GroupsLayoutController() throws IOException {

        /* Professor New Dialog */
        profNewDialogLoader
                = new FXMLLoader(JClassChin.class.getResource("view/GroupsProferssorsNewDialog.fxml"));
        profNewDialogLayout = (AnchorPane) profNewDialogLoader.load();
        profNewDialogScene = new Scene(profNewDialogLayout);
        profNewDialogStage = new Stage();
        profNewDialogStage.setScene(profNewDialogScene);
        profNewDialogStage.setTitle("استاد جدید");
        profNewDialogStage.initModality(Modality.WINDOW_MODAL);
        profNewDialogStage.initOwner(JClassChin.getMainStage());
        profNewDialogStage.setResizable(false);
        profNewDialogStage.initStyle(StageStyle.UTILITY);

        /* Professor Edit Dialog */
        profEditDialogLoader
                = new FXMLLoader(JClassChin.class.getResource("view/GroupsProferssorsEditDialog.fxml"));
        profEditDialogLayout = (AnchorPane) profEditDialogLoader.load();
        profEditDialogScene = new Scene(profEditDialogLayout);
        profEditDialogStage = new Stage();
        profEditDialogStage.setScene(profEditDialogScene);
        profEditDialogStage.setTitle("ویرایش استاد");
        profEditDialogStage.initModality(Modality.WINDOW_MODAL);
        profEditDialogStage.initOwner(JClassChin.getMainStage());
        profEditDialogStage.setResizable(false);
        profEditDialogStage.initStyle(StageStyle.UTILITY);

        /* Professor Delete Dialog */
        profDeleteDialogLoader
                = new FXMLLoader(JClassChin.class.getResource("view/GroupsProferssorsDeleteDialog.fxml"));
        profDeleteDialogLayout = (AnchorPane) profDeleteDialogLoader.load();
        profDeleteDialogScene = new Scene(profDeleteDialogLayout);
        profDeleteDialogStage = new Stage();
        profDeleteDialogStage.setScene(profDeleteDialogScene);
        profDeleteDialogStage.setTitle("حذف استاد");
        profDeleteDialogStage.initModality(Modality.WINDOW_MODAL);
        profDeleteDialogStage.initOwner(JClassChin.getMainStage());
        profDeleteDialogStage.setResizable(false);
        profDeleteDialogStage.initStyle(StageStyle.UTILITY);

        /* Courses New Dialog */
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

        /* Courses Edit Dialog */
        courseEditDialogLoader
                = new FXMLLoader(JClassChin.class.getResource("view/GroupsCoursesEditDialog.fxml"));
        courseEditDialogLayout = (AnchorPane) courseEditDialogLoader.load();
        courseEditDialogScene = new Scene(courseEditDialogLayout);
        courseEditDialogStage = new Stage();
        courseEditDialogStage.setScene(courseEditDialogScene);
        courseEditDialogStage.setTitle("ویرایش واحد درسی");
        courseEditDialogStage.initModality(Modality.WINDOW_MODAL);
        courseEditDialogStage.initOwner(JClassChin.getMainStage());
        courseEditDialogStage.setResizable(false);
        courseEditDialogStage.initStyle(StageStyle.UTILITY);

        /* Courses Delete Dialog */
        courseDeleteDialogLoader
                = new FXMLLoader(JClassChin.class.getResource("view/GroupsCoursesDeleteDialog.fxml"));
        courseDeleteDialogLayout = (AnchorPane) courseDeleteDialogLoader.load();
        courseDeleteDialogScene = new Scene(courseDeleteDialogLayout);
        courseDeleteDialogStage = new Stage();
        courseDeleteDialogStage.setScene(courseDeleteDialogScene);
        courseDeleteDialogStage.setTitle("حذف واحد درسی");
        courseDeleteDialogStage.initModality(Modality.WINDOW_MODAL);
        courseDeleteDialogStage.initOwner(JClassChin.getMainStage());
        courseDeleteDialogStage.setResizable(false);
        courseDeleteDialogStage.initStyle(StageStyle.UTILITY);

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
        courseNewDialogController.initDialog();        
        courseNewDialogStage.showAndWait();
        updateCourseTableView();

    }

    @FXML
    private void editHBoxOnMouseClicked(MouseEvent event) {
        courseEditDialogController = new GroupsCoursesEditDialogController();
        courseEditDialogController = courseEditDialogLoader.getController();
        courseEditDialogController.initialize(null, null);
        courseEditDialogController.setGroupsCoursesEditDialogStage(courseEditDialogStage);
        courseEditDialogController.initDialog();
        courseEditDialogStage.showAndWait();

        updateCourseTableView();
    }

    @FXML
    private void deleteHBoxOnMouseClicked(MouseEvent event) {
        courseDeleteDialogController = new GroupsCoursesDeleteDialogController();
        courseDeleteDialogController = courseDeleteDialogLoader.getController();
        courseDeleteDialogController.initialize(null, null);
        courseDeleteDialogController.setGroupsCoursesDeleteDialogStage(courseDeleteDialogStage);

        courseDeleteDialogStage.showAndWait();
        updateCourseTableView();
    }

    @FXML
    private void profNewHBoxOnMouseClicked(MouseEvent event) {
    }

    @FXML
    private void profEditHBoxOnMouseClicked(MouseEvent event) {
    }

    @FXML
    private void profDeleteHBoxOnMouseClicked(MouseEvent event) {
    }

    private void updateProfTableView() {

    }

    private void updateCourseTableView() {

    }


}
