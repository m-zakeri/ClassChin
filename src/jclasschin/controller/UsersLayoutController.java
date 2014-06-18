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
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import jclasschin.JClassChin;
import jclasschin.entity.User;
import jclasschin.model.UserManager;

/**
 * FXML Controller class
 *
 * @author Ali
 */
public class UsersLayoutController implements Initializable {

    private final FXMLLoader usersNewDialogLoader;
    private final AnchorPane usersNewDialogLayout;
    private final Scene usersNewDialogScene;
    private final Stage usersNewDialogStage;

    private UsersNewDialogController usersNewDialogController;

    @FXML
    private HBox newHBox;
    @FXML
    private HBox editHBox;
    @FXML
    private HBox deleteHBox;
    @FXML
    private TableView<User> usersTableView;
    @FXML
    private TableColumn<User, String> idTableColumn;
    @FXML
    private TableColumn<User, String> nameTableColumn;
    @FXML
    private TableColumn<User, String> fieldTableColumn;
    @FXML
    private TableColumn<User, String> jobTableColumn;
    @FXML
    private TableColumn<User, String> stateTableColumn;

    public UsersLayoutController() throws IOException {
        usersNewDialogLoader = new FXMLLoader(JClassChin.class.getResource("view/UsersNewDialog.fxml"));
        usersNewDialogLayout = (AnchorPane) usersNewDialogLoader.load();
        usersNewDialogScene = new Scene(usersNewDialogLayout);
        usersNewDialogStage = new Stage();
        usersNewDialogStage.setScene(usersNewDialogScene);
        usersNewDialogStage.setTitle(" کاربر جدید");
        usersNewDialogStage.initModality(Modality.WINDOW_MODAL);
        usersNewDialogStage.initOwner(JClassChin.getMainStage());
        usersNewDialogStage.setResizable(false);
        usersNewDialogStage.initStyle(StageStyle.UTILITY);
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
        usersNewDialogController = usersNewDialogLoader.getController();
        usersNewDialogController.setUsersNewDialogStage(usersNewDialogStage);
        usersNewDialogController.initDialog();
        usersNewDialogStage.showAndWait();

        updateUsersTableView();
    }

    @FXML
    private void editHBoxOnMouseClicked(MouseEvent event) {
    }

    @FXML
    private void deleteHBoxOnMouseClicked(MouseEvent event) {
    }

    private boolean isNull(String string){
        return (string.equals(null));
    }
    
    public void updateUsersTableView() {

        UserManager um = new UserManager();
        ObservableList<User> userList = FXCollections.observableArrayList();

        um.selectAll();

        idTableColumn.setCellValueFactory(new PropertyValueFactory<>("id"));

        nameTableColumn.setCellValueFactory((CellDataFeatures<User, String> u) -> new ReadOnlyObjectWrapper(u.getValue().getPerson().getFirstName() + " " + u.getValue().getPerson().getLastName()));
        fieldTableColumn.setCellValueFactory((CellDataFeatures<User, String> u) -> new ReadOnlyObjectWrapper(u.getValue().getPerson().getField().getName()));
        jobTableColumn.setCellValueFactory((CellDataFeatures<User, String> u) -> new ReadOnlyObjectWrapper(u.getValue().getPerson().getJob().getTitle()));
        stateTableColumn.setCellValueFactory((CellDataFeatures<User, String> u) -> new ReadOnlyObjectWrapper(u.getValue().isState() ? "فعال" : "غیر فعال"));

        //fieldTableColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        List l = um.selectAll();
        l.stream().forEach((u) -> {
            userList.add((User) u);

        });
        usersTableView.setItems(userList);
    }

}
