package jclasschin.controller;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import jclasschin.JClassChin;
import jclasschin.entity.Classroom;
import jclasschin.entity.Course;
import jclasschin.model.ClassManager;
import jclasschin.model.CourseManager;
import jclasschin.model.Login;

/**
 * FXML Controller class
 *
 * @author Ali
 */
public class ClassLayoutController implements Initializable
{

    private FXMLLoader classListNewDialogLoader, classListEditDialogLoader,
            classListDeleteDialogLoader, classDedicateNewDialogLoader, classDedicateEditDialogLoader,
            classDedicateDeleteDialogLoader;

    private AnchorPane classListNewDialogLayout, classListEditDialogLayout,
            classListDeleteDialogLayout, classDedicateNewDialogLayout, classDedicateEditDialogLayout,
            classDedicateDeleteDialogLayout;

    private Scene classListNewDialogScene, classListEditDialogScene,
            classListDeleteDialogScene, classDedicateNewDialogScene, classDedicateEditDialogScene,
            classDedicateDeleteDialogScene;

    private Stage classListNewDialogStage, classListEditDialogStage,
            classListDeleteDialogStage, classDedicateNewDialogStage, classDedicateEditDialogStage,
            classDedicateDeleteDialogStage;

    private ClassListNewDialogController classListNewDialogController;
    private ClassListEditDialogController classListEditDialogController;
    private ClassListDeleteDialogController classListDeleteDialogController;
    private ClassDedicateNewDialogController classDedicateNewDialogController;
//    private ClassDedicateEditDialogController classDedicateEditDialogController;
//    private ClassDedicateDeleteDialogController classDedicateDeleteDialogController;
    @FXML
    private TableView<Classroom> classTableView;
    @FXML
    private TableColumn<Classroom, Integer> classIdTableColumn;
    @FXML
    private TableColumn<Classroom, String> classNameTableColumn;
    @FXML
    private TableColumn<Classroom, String> floorTableColumn;
    @FXML
    private TableColumn<Classroom, Integer> capacityTableColumn;
    @FXML
    private TableColumn<Classroom, Boolean> videoProjectTableColumn;
    @FXML
    private TableColumn<Classroom, Boolean> whiteBoardTableColumn;
    @FXML
    private TableColumn<Classroom, Boolean> blackBoardTableColumn;

    public ClassLayoutController() throws IOException
    {

        /* Class New Dialog */
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

        /* Class Edit Dialog   */
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

        /* Class Delete Dialog   */
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

        /* List New Dialog */
        classDedicateNewDialogLoader
                = new FXMLLoader(JClassChin.class.getResource("view/ClassDedicateNewDialog.fxml"));
        classDedicateNewDialogLayout = (AnchorPane) classDedicateNewDialogLoader.load();
        classDedicateNewDialogScene = new Scene(classDedicateNewDialogLayout);
        classDedicateNewDialogStage = new Stage();
        classDedicateNewDialogStage.setScene(classDedicateNewDialogScene);
        classDedicateNewDialogStage.setTitle("تخصیص جدید");
        classDedicateNewDialogStage.initModality(Modality.WINDOW_MODAL);
        classDedicateNewDialogStage.initOwner(JClassChin.getMainStage());
        classDedicateNewDialogStage.setResizable(false);
        classDedicateNewDialogStage.initStyle(StageStyle.UTILITY);

        classDedicateNewDialogController = classDedicateNewDialogLoader.getController();

    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        // TODO
    }

    @FXML
    private void newClassHBoxOnMouseClicked(MouseEvent event)
    {
        classListNewDialogController.setClassListNewDialogStage(classListNewDialogStage);
        classListNewDialogController.initDialog();
        classListNewDialogStage.showAndWait();

        updateClassListTableView();
    }

    @FXML
    private void editClassHBoxOnMouseClicked(MouseEvent event)
    {

        if (classTableView.getSelectionModel().getSelectedIndex() != -1)
        {
            Classroom c = classTableView.getSelectionModel().getSelectedItem();
            classListEditDialogController.setClassEditDialogStage(classListEditDialogStage);
            classListEditDialogController.setEditableClass(c);
            classListEditDialogController.initDialog();
            classListEditDialogStage.showAndWait();
            updateClassListTableView();
        }

    }

    @FXML
    private void deleteClassHBoxOnMouseClicked(MouseEvent event)
    {

        if (classTableView.getSelectionModel().getSelectedIndex() != -1)
        {
            Classroom c = classTableView.getSelectionModel().getSelectedItem();
            classListDeleteDialogController.setClassListDeleteDialogStage(classListDeleteDialogStage);
            classListDeleteDialogController.setEditableClass(c);
            classListDeleteDialogStage.showAndWait();

            updateClassListTableView();
        }
    }

    @FXML
    private void newDedicateHBoxOnMouseClicked(MouseEvent event)
    {
        classDedicateNewDialogController.createClassDedicateCheckListBox();
        classDedicateNewDialogStage.showAndWait();
    }

    @FXML
    private void editDedicateHBoxOnMouseClicked(MouseEvent event)
    {
    }

    @FXML
    private void deleteDedicateHBoxOnMouseClicked(MouseEvent event)
    {
    }

    public void updateClassListTableView()
    {
        ClassManager cm = new ClassManager();
        ObservableList<Classroom> classList = FXCollections.observableArrayList();
        classIdTableColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        classNameTableColumn.setCellValueFactory((TableColumn.CellDataFeatures<Classroom, String> c) -> new ReadOnlyObjectWrapper(c.getValue().getName()));
        floorTableColumn.setCellValueFactory((TableColumn.CellDataFeatures<Classroom, String> c) -> new ReadOnlyObjectWrapper(c.getValue().getFloor()));
        capacityTableColumn.setCellValueFactory((TableColumn.CellDataFeatures<Classroom, Integer> c) -> new ReadOnlyObjectWrapper(c.getValue().getCapacity()));
        videoProjectTableColumn.setCellValueFactory((TableColumn.CellDataFeatures<Classroom, Boolean> c) -> new ReadOnlyObjectWrapper(c.getValue().getDataProjector() ? "دارد" : "ندارد"));
        whiteBoardTableColumn.setCellValueFactory((TableColumn.CellDataFeatures<Classroom, Boolean> c) -> new ReadOnlyObjectWrapper(c.getValue().getWhiteboard() ? "دارد" : "ندارد"));
        blackBoardTableColumn.setCellValueFactory((TableColumn.CellDataFeatures<Classroom, Boolean> c) -> new ReadOnlyObjectWrapper(c.getValue().getBlackboard() ? "دارد" : "ندارد"));
        List l = cm.selectAll();
        l.stream().forEach((c) ->
        {
            classList.add((Classroom) c);
        });
        classTableView.setItems(classList);
    }

}
