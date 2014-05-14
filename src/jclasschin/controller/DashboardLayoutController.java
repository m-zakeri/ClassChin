/*
 * Complete fxids  and event functions on 1393-02-28 by Morteza!
 */

package jclasschin.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import jclasschin.JClassChin;
import jclasschin.entity.Mail;

/**
 * FXML Controller class
 *
 * @author Ali
 */
public class DashboardLayoutController implements Initializable {
    
    private final FXMLLoader inboxNewMailDialogLoader;
    private final AnchorPane inboxNewMailDialogLayout;
    private final Scene inboxNewMailDialogScene;
    private final Stage inboxNewMailDialogStage;
    private DashboardInboxNewMailDialogController inboxNewMailDialogController;
    
    private ObservableList<Mail> mailList = FXCollections.observableArrayList();
    
    
    
    
    
    @FXML
    private AnchorPane dashboardAnchorPane;
    @FXML
    private HBox newHBox;
    @FXML
    private HBox replyHBox;
    @FXML
    private HBox deleteHBox;
    @FXML
    private HBox refreshHBox;
    @FXML
    private HBox new2HBox;
    @FXML
    private HBox delete2HBox;
    @FXML
    private HBox refresh2HBox;
    @FXML
    private HBox newTermHBox;
    @FXML
    private HBox editTermHBox;
    @FXML
    private HBox deleteTermHBox;
    @FXML
    private ComboBox<?> currentTermComboBox;
    @FXML
    private TableView<Mail> inboxTableView;
    @FXML
    private TableColumn<Mail, String> subjectTableColumn;
    @FXML
    private TableColumn<Mail, String> messegeTableColumn;

    public DashboardLayoutController() throws IOException{
           inboxNewMailDialogLoader=new FXMLLoader(JClassChin.class.getResource("view/DashboardInboxNewMailDialog.fxml"));
           inboxNewMailDialogLayout=(AnchorPane)inboxNewMailDialogLoader.load();
           inboxNewMailDialogScene=new Scene(inboxNewMailDialogLayout);
           inboxNewMailDialogStage=new Stage();
           inboxNewMailDialogStage.setScene(inboxNewMailDialogScene);
           inboxNewMailDialogStage.setTitle("New Mail");
           inboxNewMailDialogStage.initModality(Modality.WINDOW_MODAL);
           inboxNewMailDialogStage.initOwner(JClassChin.getMainStage());
           inboxNewMailDialogStage.setResizable(false);
           inboxNewMailDialogStage.initStyle(StageStyle.UTILITY);
           inboxNewMailDialogStage.close();
           
           Mail mail=new Mail();
           mail.setType("New Class Needed");
           mail.setText("Salam Chetori AKBARI! Class MIKHAYYYMM!!!");
           mailList.add(mail);
           
           
           

    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {    
        subjectTableColumn.setCellValueFactory(new PropertyValueFactory<Mail,String>("type"));
        messegeTableColumn.setCellValueFactory(new PropertyValueFactory<Mail,String>("text"));

        
        inboxTableView.setItems(mailList);
    }    

    @FXML
    private void newHBoxOnMouseExited(MouseEvent event)
    {
        
    }

    @FXML
    private void newHBoxOnMouseEntered(MouseEvent event)
    {
    }

    @FXML
    private void newHBoxOnMouseClicked(MouseEvent event)
    {
        inboxNewMailDialogController=new DashboardInboxNewMailDialogController();
        inboxNewMailDialogController=inboxNewMailDialogLoader.getController();
        inboxNewMailDialogController.initialize(null, null);
        inboxNewMailDialogStage.showAndWait();
        
    }

    @FXML
    private void replyHBoxOnMouseExited(MouseEvent event)
    {
    }

    @FXML
    private void replyHBoxOnMouseEntered(MouseEvent event)
    {
    }

    @FXML
    private void replyHBoxOnMouseClicked(MouseEvent event)
    {
    }

    @FXML
    private void deleteHBoxOnMouseEntered(MouseEvent event)
    {
    }

    @FXML
    private void deleteHBoxOnMouseClicked(MouseEvent event)
    {
    }

    @FXML
    private void refreshHBoxMouseExited(MouseEvent event)
    {
    }

    @FXML
    private void refreshHBoxMouseEntered(MouseEvent event)
    {
    }

    @FXML
    private void refreshHBoxOnMouseClicked(MouseEvent event)
    {
    }

    @FXML
    private void new2HBoxOnMouseExited(MouseEvent event)
    {
    }

    @FXML
    private void new2HBoxOnMouseEntered(MouseEvent event)
    {
    }

    @FXML
    private void new2HBoxOnMouseClicked(MouseEvent event)
    {
    }

    @FXML
    private void delete2HBoxOnMouseExited(MouseEvent event)
    {
    }

    @FXML
    private void delete2HBoxOnMouseEntered(MouseEvent event)
    {
    }

    @FXML
    private void delete2HBoxOnMouseClicked(MouseEvent event)
    {
    }

    @FXML
    private void refresh2HBoxOnMouseExited(MouseEvent event)
    {
    }

    @FXML
    private void refresh2HBoxOnMouseEntered(MouseEvent event)
    {
    }

    @FXML
    private void refresh2HBoxOnMouseClicked(MouseEvent event)
    {
    }

    @FXML
    private void newTermHBoxOnMouseClicked(MouseEvent event)
    {
    }

    @FXML
    private void editTermHBoxOnMouseClicked(MouseEvent event)
    {
    }

    @FXML
    private void deleteTermHBoxOnMouseClicked(MouseEvent event)
    {
    }
    
}
