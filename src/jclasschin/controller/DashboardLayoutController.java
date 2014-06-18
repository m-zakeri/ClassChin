/*
 * Complete fxids  and event functions on 1393-02-28 by Morteza!
 */
package jclasschin.controller;

import java.io.IOException;
import java.net.URL;
import java.util.List;
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
import jclasschin.entity.Status;
import jclasschin.entity.Term;
import jclasschin.model.TermManager;

/**
 * FXML Controller class
 *
 * @author Ali
 */
public class DashboardLayoutController implements Initializable
{

    private final FXMLLoader dashboardInboxNewMailDialogLoader, dashboardInboxReplyMailDialogLoader,
            dashboardInboxDeleteMailDialogLoader,dashboardTermNewDailogLoader,
            dashboardTermEditDailogLoader, dashboardTermDeleteDailogLoader;
    private final AnchorPane dashboardInboxNewMailDialogLayout, dashboardInboxReplyMailDialogLayout,
            dashboardInboxDeleteMailDialogLayout,dashboardTermNewDailogLayout,
            dashboardTermEditDailogLayout, dashboardTermDeleteDailogLayout;
    private final Scene dashboardInboxNewMailDialogScene, dashboardInboxReplyMailDialogScene,
            dashboardInboxDeleteMailDialogScene,dashboardTermNewDailogScene,
            dashboardTermEditDailogScene, dashboardTermDeleteDailogScene;
    private final Stage dashboardInboxNewMailDialogStage, dashboardInboxReplyMailDialogStage,
            dashboardInboxDeleteMailDialogStage,dashboardTermNewDailogStage,
            dashboardTermEditDailogStage, dashboardTermDeleteDailogStage;
    
    /* Mail */
    private DashboardInboxNewDialogController dashboardInboxNewMailDialogController;
    private DashboardInboxReplyDialogController dashboardInboxReplyMailDialogController;
    private DashboardInboxDeleteDialogController dashboardInboxDeleteMailDialogController;

    /* Term */
    private DashboardTermNewDialogController dashboardTermNewDialogController;
    private DashboardTermEditDialogController dashboardTermEditDialogController;
    private DashboardTermDeleteDialogController dashboardTermDeleteDialogController;
    

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
    private ComboBox<String> currentTermComboBox;
    @FXML
    private TableView<Mail> inboxTableView;
    @FXML
    private TableView<Mail> outboxTableView;
    @FXML
    private TableColumn<Mail, String> subjectTableColumn;
    @FXML
    private TableColumn<Mail, String> messegeTableColumn;
    @FXML
    private TableView<Term> termTableView;
    @FXML
    private TableColumn<Term, String> termIdTableColumn;
    @FXML
    private TableColumn<Term, String> termNameTableColumn;
    @FXML
    private TableView<Status> statusTableView;
    @FXML
    private TableColumn<Mail, String> idTableColumn;

    public DashboardLayoutController() throws IOException
    {
        /* Inbox New Dialog   */
        dashboardInboxNewMailDialogLoader
                = new FXMLLoader(JClassChin.class.getResource("view/DashboardInboxNewDialog.fxml"));
        dashboardInboxNewMailDialogLayout = (AnchorPane) dashboardInboxNewMailDialogLoader.load();
        dashboardInboxNewMailDialogScene = new Scene(dashboardInboxNewMailDialogLayout);
        dashboardInboxNewMailDialogStage = new Stage();
        dashboardInboxNewMailDialogStage.setScene(dashboardInboxNewMailDialogScene);
        dashboardInboxNewMailDialogStage.setTitle("نامه جدید");
        dashboardInboxNewMailDialogStage.initModality(Modality.WINDOW_MODAL);
        dashboardInboxNewMailDialogStage.initOwner(JClassChin.getMainStage());
        dashboardInboxNewMailDialogStage.setResizable(false);
        dashboardInboxNewMailDialogStage.initStyle(StageStyle.UTILITY);

        /* Inbox Reply Dialog */
        dashboardInboxReplyMailDialogLoader
                = new FXMLLoader(JClassChin.class.getResource("view/DashboardInboxReplyDialog.fxml"));
        dashboardInboxReplyMailDialogLayout = (AnchorPane) dashboardInboxReplyMailDialogLoader.load();
        dashboardInboxReplyMailDialogScene = new Scene(dashboardInboxReplyMailDialogLayout);
        dashboardInboxReplyMailDialogStage = new Stage();
        dashboardInboxReplyMailDialogStage.setScene(dashboardInboxReplyMailDialogScene);
        dashboardInboxReplyMailDialogStage.setTitle("پاسخ به نامه");
        dashboardInboxReplyMailDialogStage.initModality(Modality.WINDOW_MODAL);
        dashboardInboxReplyMailDialogStage.initOwner(JClassChin.getMainStage());
        dashboardInboxReplyMailDialogStage.setResizable(false);
        dashboardInboxReplyMailDialogStage.initStyle(StageStyle.UTILITY);

        /* Inbox Delete Dialog */
        dashboardInboxDeleteMailDialogLoader
                = new FXMLLoader(JClassChin.class.getResource("view/DashboardInboxDeleteDialog.fxml"));
        dashboardInboxDeleteMailDialogLayout = (AnchorPane) dashboardInboxDeleteMailDialogLoader.load();
        dashboardInboxDeleteMailDialogScene = new Scene(dashboardInboxDeleteMailDialogLayout);
        dashboardInboxDeleteMailDialogStage = new Stage();
        dashboardInboxDeleteMailDialogStage.setScene(dashboardInboxDeleteMailDialogScene);
        dashboardInboxDeleteMailDialogStage.setTitle("حذف نامه");
        dashboardInboxDeleteMailDialogStage.initModality(Modality.WINDOW_MODAL);
        dashboardInboxDeleteMailDialogStage.initOwner(JClassChin.getMainStage());
        dashboardInboxDeleteMailDialogStage.setResizable(false);
        dashboardInboxDeleteMailDialogStage.initStyle(StageStyle.UTILITY);
        
        
        /* Term New Dialog */
        dashboardTermNewDailogLoader
                = new FXMLLoader(JClassChin.class.getResource("view/DashboardTermNewDialog.fxml"));
        dashboardTermNewDailogLayout = (AnchorPane) dashboardTermNewDailogLoader.load();
        dashboardTermNewDailogScene = new Scene(dashboardTermNewDailogLayout);
        dashboardTermNewDailogStage = new Stage();
        dashboardTermNewDailogStage.setScene(dashboardTermNewDailogScene);
        dashboardTermNewDailogStage.setTitle("ترم جدید");
        dashboardTermNewDailogStage.initModality(Modality.WINDOW_MODAL);
        dashboardTermNewDailogStage.initOwner(JClassChin.getMainStage());
        dashboardTermNewDailogStage.setResizable(false);
        dashboardTermNewDailogStage.initStyle(StageStyle.UTILITY);

        /* Term Edit Dialog */
        dashboardTermEditDailogLoader
                = new FXMLLoader(JClassChin.class.getResource("view/DashboardTermEditDialog.fxml"));
        dashboardTermEditDailogLayout = (AnchorPane) dashboardTermEditDailogLoader.load();
        dashboardTermEditDailogScene = new Scene(dashboardTermEditDailogLayout);
        dashboardTermEditDailogStage = new Stage();
        dashboardTermEditDailogStage.setScene(dashboardTermEditDailogScene);
        dashboardTermEditDailogStage.setTitle("ویرایش ترم");
        dashboardTermEditDailogStage.initModality(Modality.WINDOW_MODAL);
        dashboardTermEditDailogStage.initOwner(JClassChin.getMainStage());
        dashboardTermEditDailogStage.setResizable(false);
        dashboardTermEditDailogStage.initStyle(StageStyle.UTILITY);

        /* Term Delete Dialog */
        dashboardTermDeleteDailogLoader
                = new FXMLLoader(JClassChin.class.getResource("view/DashboardTermDeleteDialog.fxml"));
        dashboardTermDeleteDailogLayout = (AnchorPane) dashboardTermDeleteDailogLoader.load();
        dashboardTermDeleteDailogScene = new Scene(dashboardTermDeleteDailogLayout);
        dashboardTermDeleteDailogStage = new Stage();
        dashboardTermDeleteDailogStage.setScene(dashboardTermDeleteDailogScene);
        dashboardTermDeleteDailogStage.setTitle("حذف ترم");
        dashboardTermDeleteDailogStage.initModality(Modality.WINDOW_MODAL);
        dashboardTermDeleteDailogStage.initOwner(JClassChin.getMainStage());
        dashboardTermDeleteDailogStage.setResizable(false);
        dashboardTermDeleteDailogStage.initStyle(StageStyle.UTILITY);

    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {

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
        dashboardInboxNewMailDialogController = dashboardInboxNewMailDialogLoader.getController();
        dashboardInboxNewMailDialogController.initialize(null, null);
        dashboardInboxNewMailDialogController.setDashboardIboxNewDialogStage(dashboardInboxNewMailDialogStage);

        dashboardInboxNewMailDialogStage.showAndWait();

        updateInboxTableView();
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
        dashboardInboxReplyMailDialogController = dashboardInboxReplyMailDialogLoader.getController();
        dashboardInboxReplyMailDialogController.setDashboardInboxReplyMailDialogStage(dashboardInboxReplyMailDialogStage);
        dashboardInboxReplyMailDialogController.initialize(null, null);
        dashboardInboxReplyMailDialogStage.showAndWait();
        
        updateOutboxTableView();
    }

    @FXML
    private void deleteHBoxOnMouseEntered(MouseEvent event)
    {
    }

    @FXML
    private void deleteHBoxOnMouseClicked(MouseEvent event)
    {
        dashboardInboxDeleteMailDialogController = dashboardInboxDeleteMailDialogLoader.getController();
        dashboardInboxDeleteMailDialogController.initialize(null, null);
        dashboardInboxDeleteMailDialogController.setDashboardInboxDeleteDialogStage(dashboardInboxDeleteMailDialogStage);

        dashboardInboxNewMailDialogStage.showAndWait();

        updateInboxTableView();
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
        /* Refersh mail inbox table */
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
        dashboardInboxNewMailDialogController = dashboardInboxNewMailDialogLoader.getController();
        dashboardInboxNewMailDialogController.initialize(null, null);
        dashboardInboxNewMailDialogController.setDashboardIboxNewDialogStage(dashboardInboxNewMailDialogStage);

        dashboardInboxNewMailDialogStage.showAndWait();

        updateInboxTableView();
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
         /* Refersh status table */
    }

    @FXML
    private void newTermHBoxOnMouseClicked(MouseEvent event)
    {
        //dashboardTermNewDialogController = new DashboardTermNewDialogController();
        dashboardTermNewDialogController = dashboardTermNewDailogLoader.getController();
        dashboardTermNewDialogController.initialize(null, null);
        dashboardTermNewDialogController.setDashboardTermNewDialogStage(dashboardTermNewDailogStage);
        dashboardTermNewDailogStage.showAndWait();
        updateTermTableView();
    }

    @FXML
    private void editTermHBoxOnMouseClicked(MouseEvent event)
    {
        if (termTableView.getSelectionModel().getSelectedIndex() != -1)
        {
            Term t = termTableView.getSelectionModel().getSelectedItem();
            //dashboardTermEditDialogController = new DashboardTermEditDialogController();
            dashboardTermEditDialogController = dashboardTermEditDailogLoader.getController();
            dashboardTermEditDialogController.initialize(null, null);
            dashboardTermEditDialogController.setDashboardTermEditDialogStage(dashboardTermEditDailogStage);
            dashboardTermEditDialogController.setEditableTerm(t);
            dashboardTermEditDailogStage.showAndWait();

            updateTermTableView();
        }
    }

    @FXML
    private void deleteTermHBoxOnMouseClicked(MouseEvent event)
    {
        if (termTableView.getSelectionModel().getSelectedIndex() != -1)
        {
            Term t = termTableView.getSelectionModel().getSelectedItem();
            //dashboardTermDeleteDialogController = new DashboardTermDeleteDialogController();
            dashboardTermDeleteDialogController = dashboardTermDeleteDailogLoader.getController();
            dashboardTermDeleteDialogController.initialize(null, null);
            dashboardTermDeleteDialogController.setDashboardTermDeleteDailogStage(dashboardTermDeleteDailogStage);
            dashboardTermDeleteDialogController.setEditableTerm(t);
            dashboardTermDeleteDailogStage.showAndWait();

            updateTermTableView();
        }
    }

    public void updateTermTableView()
    {
        currentTermComboBox.getItems().clear();
        //TermManager tm = new TermManager();
        ObservableList<Term> termList = FXCollections.observableArrayList();

        termIdTableColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        termNameTableColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        List l = TermManager.selectAll();
        l.stream().forEach((t) ->
        {
            termList.add((Term) t);
            currentTermComboBox.getItems().add(((Term) t).getName());
            currentTermComboBox.setValue(((Term) t).getName());
        });

        termTableView.setItems(termList);
    }

    private void updateInboxTableView()
    {

    }

    private void updateOutboxTableView()
    {

    }
}
