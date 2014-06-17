

package jclasschin.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import jclasschin.JClassChin;

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
    private TableView<?> usersTableView;

    
    
    
    
    public UsersLayoutController() throws IOException
    {
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
    private void newHBoxOnMouseClicked(MouseEvent event)
    {
        usersNewDialogController = usersNewDialogLoader.getController();
        usersNewDialogController.setUsersNewDialogStage(usersNewDialogStage);
        usersNewDialogStage.showAndWait();
        
        updateUsersTableView();
    }

    @FXML
    private void editHBoxOnMouseClicked(MouseEvent event)
    {
    }

    @FXML
    private void deleteHBoxOnMouseClicked(MouseEvent event)
    {
    }

    private void updateUsersTableView()
    {
        
    }
    
}
