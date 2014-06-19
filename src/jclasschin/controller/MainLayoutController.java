/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jclasschin.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.FadeTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.util.Duration;
import jclasschin.JClassChin;
import jclasschin.entity.User;
import jclasschin.model.Effect;
//import org.controlsfx.control.Notifications;

/**
 * FXML Controller class
 *
 * @author Ali
 */
public class MainLayoutController implements Initializable {

    private BorderPane objectLayout;
    private BorderPane mainLayout;

    private AnchorPane dashboardLayout,
            fieldsLayout,
            usersLayout,
            groupsLayout,
            classLayout;
//            scheduleLayout,
//            reportsLayout;

    private FXMLLoader dashboardLayoutLoader,
            fieldsLayoutLoader,
            usersLayoutLoader,
            groupsLayoutLoader,
            classLayoutLoader;

    private DashboardLayoutController dashboardLayoutController;
    private FieldsLayoutController fieldsLayoutController;
    private UsersLayoutController usersLayoutController;
    private GroupsLayoutController groupsLayoutController;
    private ClassLayoutController classLayoutController;

    private final Image homeButton,
            homeButtonOnMouseEntered,
            homeButtonOnMouseClicked,
            fieldButton,
            fieldButtonOnMouseEntered,
            fieldButtonOnMouseClicked,
            userButton,
            userButtonOnMouseEntered,
            userButtonOnMouseClicked,
            courseGroupButton,
            courseGroupButtonOnMouseEntered,
            courseGroupButtonOnMouseClicked,
            classButton,
            classButtonOnMouseEntered,
            classButtonOnMouseClicked;
//            scheduleButton,
//            scheduleOnMouseEntered,
//            scheduleOnMouseClicked,
//            reportButton,
//            reportOnMouseEntered,
//            reportOnMouseClicked;

    private boolean dashboardHBoxOnMouseClickedFlag,
            fieldsHBoxOnMouseClickedFlag,
            usersHBoxOnMouseClickedFlag,
            groupsHBoxOnMouseClickedFlag,
            classHBoxOnMouseClickedFlag,
            scheduleHBoxOnMouseClickedFlag,
            reportsHBoxOnMouseClickedFlag;

    //private FadeTransition fadeTransition;
    @FXML
    private ImageView dashboardImageView;
    @FXML
    private ImageView fieldsImageView;
    @FXML
    private ImageView usersImageView;
    @FXML
    private ImageView groupsImageView;
    @FXML
    private ImageView classImageView;
    @FXML
    private ImageView scheduleImageView;
    @FXML
    private ImageView reportsImageView;
    @FXML
    private Label dataAndTimeLable;
    @FXML
    private HBox dashboardHBox;
    @FXML
    private HBox fieldsHBox;
    @FXML
    public Label statusBarLable;

    public MainLayoutController() throws IOException {

        dashboardLayoutLoader = new FXMLLoader(JClassChin.class.getResource("view/DashboardLayout.fxml"));
        dashboardLayout = (AnchorPane) dashboardLayoutLoader.load();
        dashboardLayoutController = dashboardLayoutLoader.getController();

        fieldsLayoutLoader = new FXMLLoader(JClassChin.class.getResource("view/FieldsLayout.fxml"));
        fieldsLayout = new AnchorPane((AnchorPane) fieldsLayoutLoader.load());
        fieldsLayoutController = fieldsLayoutLoader.getController();

        usersLayoutLoader = new FXMLLoader(JClassChin.class.getResource("view/UsersLayout.fxml"));
        usersLayout = new AnchorPane((AnchorPane) usersLayoutLoader.load());
        usersLayoutController = usersLayoutLoader.getController();

        groupsLayoutLoader = new FXMLLoader(JClassChin.class.getResource("view/GroupsLayout.fxml"));
        groupsLayout = new AnchorPane((AnchorPane) groupsLayoutLoader.load());
        groupsLayoutController = groupsLayoutLoader.getController();

        classLayoutLoader = new FXMLLoader(JClassChin.class.getResource("view/ClassLayout.fxml"));
        classLayout = new AnchorPane((AnchorPane) classLayoutLoader.load());
        classLayoutController = classLayoutLoader.getController();

//        FXMLLoader scheduleLayoutLoader = new FXMLLoader(JClassChin.class.getResource("view/ScheduleLayout.fxml"));
//        scheduleLayout = new AnchorPane((AnchorPane) scheduleLayoutLoader.load());
//        FXMLLoader reportsLayoutLoader = new FXMLLoader(JClassChin.class.getResource("view/ReportsLayout.fxml"));
//        reportsLayout = new AnchorPane((AnchorPane) reportsLayoutLoader.load());
        homeButton = new Image("jclasschin/gallery/image/homeButton.png");
        homeButtonOnMouseEntered = new Image("jclasschin/gallery/image/homeButtonEntered.png");
        homeButtonOnMouseClicked = new Image("jclasschin/gallery/image/homeButtonClicked.png");

        fieldButton = new Image("jclasschin/gallery/image/fieldButton.png");
        fieldButtonOnMouseEntered = new Image("jclasschin/gallery/image/fieldButtonEntered.png");
        fieldButtonOnMouseClicked = new Image("jclasschin/gallery/image/fieldButtonClicked.png");

        userButton = new Image("jclasschin/gallery/image/userButton.png");
        userButtonOnMouseEntered = new Image("jclasschin/gallery/image/userButtonEntered.png");
        userButtonOnMouseClicked = new Image("jclasschin/gallery/image/userButtonClicked.png");

        courseGroupButton = new Image("jclasschin/gallery/image/courseGroupButton.png");
        courseGroupButtonOnMouseEntered = new Image("jclasschin/gallery/image/courseGroupButtonEntered.png");
        courseGroupButtonOnMouseClicked = new Image("jclasschin/gallery/image/courseGroupButtonClicked.png");

        classButton = new Image("jclasschin/gallery/image/classButton.png");
        classButtonOnMouseEntered = new Image("jclasschin/gallery/image/classButtonEntered.png");
        classButtonOnMouseClicked = new Image("jclasschin/gallery/image/classButtonClicked.png");

//        scheduleButton = new Image("jclasschin/gallery/image/scheduleButton.png");
//        scheduleButtonOnMouseEntered = new Image("jclasschin/gallery/image/scheduleButtonEntered.png");
//        scheduleButtonOnMouseClicked = new Image("jclasschin/gallery/image/scheduleButtonClicked.png");
//        reportButton = new Image("jclasschin/gallery/image/reportButton.png");
//        reportButtonOnMouseEntered = new Image("jclasschin/gallery/image/reportButtonEntered.png");
//        reportButtonOnMouseClicked = new Image("jclasschin/gallery/image/reportButtonClicked.png");
        dashboardHBoxOnMouseClickedFlag = false;
        fieldsHBoxOnMouseClickedFlag = false;
        usersHBoxOnMouseClickedFlag = false;
        groupsHBoxOnMouseClickedFlag = false;
        classHBoxOnMouseClickedFlag = false;
        scheduleHBoxOnMouseClickedFlag = false;
        reportsHBoxOnMouseClickedFlag = false;

    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    void start() {
        new Effect().fadeInTransition(dashboardLayout, 1000);
        mainLayout.setCenter(dashboardLayout);
        dashboardImageView.setImage(homeButtonOnMouseClicked);
        dashboardHBoxOnMouseClickedFlag = true;
        dashboardLayoutController.updateTermTableView();
    }

    private void resetAllButtons() {
        if (dashboardHBoxOnMouseClickedFlag) {
            dashboardImageView.setImage(homeButton);
            dashboardHBoxOnMouseClickedFlag = false;
        } else if (fieldsHBoxOnMouseClickedFlag) {
            fieldsImageView.setImage(fieldButton);
            fieldsHBoxOnMouseClickedFlag = false;
        } else if (usersHBoxOnMouseClickedFlag) {
            usersImageView.setImage(userButton);
            usersHBoxOnMouseClickedFlag = false;
        } else if (groupsHBoxOnMouseClickedFlag) {
            groupsImageView.setImage(courseGroupButton);
            groupsHBoxOnMouseClickedFlag = false;
        } else if (classHBoxOnMouseClickedFlag) {
            classImageView.setImage(classButton);
            classHBoxOnMouseClickedFlag = false;
        }
//        else if (scheduleHBoxOnMouseClickedFlag) {
//            scheduleImageView.setImage(scheduleButton);
//            scheduleHBoxOnMouseClickedFlag = false;
//        } else if (reportsHBoxOnMouseClickedFlag) {
//            reportsImageView.setImage(reportButton);
//            reportsHBoxOnMouseClickedFlag = false;
//        }

    }

    //___________________________________________________________________
    // FADE TRANSTION
    private void playFadeTransition(Node node) {
        FadeTransition fadeTransition = new FadeTransition(Duration.millis(1000), node);
        fadeTransition.setFromValue(0.0);
        fadeTransition.setToValue(1.0);
        fadeTransition.play();
    }

    //___________________________________________________________________
    //  DASHBOARD HBOX
    @FXML
    private void dashboardHBoxOnMouseEntered(MouseEvent event) {
        dashboardImageView.setImage(homeButtonOnMouseEntered);

    }

    @FXML
    private void dashboardHBoxOnMouseExited(MouseEvent event) {
        if (!dashboardHBoxOnMouseClickedFlag) {
            dashboardImageView.setImage(homeButton);
        } else {
            dashboardImageView.setImage(homeButtonOnMouseClicked);
        }
    }

    @FXML
    private void dashboardHBoxOnMouseClicked(MouseEvent event) throws IOException {

        resetAllButtons();
        playFadeTransition(dashboardLayout);
        mainLayout.setCenter(dashboardLayout);
        dashboardImageView.setImage(homeButtonOnMouseClicked);
        dashboardHBoxOnMouseClickedFlag = true;

        DashboardLayoutController dlc = dashboardLayoutLoader.getController();
        dlc.updateTermTableView();
    }

    //___________________________________________________________________
    //  FIELDS HBOX
    @FXML
    private void fieldsHBoxOnMouseEntered(MouseEvent event) {
        fieldsImageView.setImage(fieldButtonOnMouseEntered);
    }

    @FXML
    private void fieldsHBoxOnMouseExited(MouseEvent event) {
        if (!fieldsHBoxOnMouseClickedFlag) {
            fieldsImageView.setImage(fieldButton);
        } else {
            fieldsImageView.setImage(fieldButtonOnMouseClicked);
        }
    }

    @FXML
    private void fieldsHBoxOnMouseClicked(MouseEvent event) throws IOException {
        resetAllButtons();
        playFadeTransition(fieldsLayout);
        mainLayout.setCenter(fieldsLayout);
        fieldsImageView.setImage(fieldButtonOnMouseClicked);
        fieldsHBoxOnMouseClickedFlag = true;

        /* update field tableview  */
        FieldsLayoutController flc = fieldsLayoutLoader.getController();
        flc.updateFieldTableView();
    }

    //___________________________________________________________________
    //  USERS HBOX
    @FXML
    private void usersHBoxOnMouseEntered(MouseEvent event) {
        usersImageView.setImage(userButtonOnMouseEntered);
    }

    @FXML
    private void usersHBoxOnMouseExited(MouseEvent event) {
        if (!usersHBoxOnMouseClickedFlag) {
            usersImageView.setImage(userButton);
        } else {
            usersImageView.setImage(userButtonOnMouseClicked);
        }
    }

    @FXML
    private void usersHBoxOnMouseClicked(MouseEvent event) throws IOException {
        resetAllButtons();
        playFadeTransition(usersLayout);
        mainLayout.setCenter(usersLayout);
        usersImageView.setImage(userButtonOnMouseClicked);
        usersHBoxOnMouseClickedFlag = true;

        UsersLayoutController ulc = usersLayoutLoader.getController();
        ulc.updateUsersTableView();
    }

//___________________________________________________________________
    //  GROUPS HBOX
    @FXML
    private void groupsHBoxOnMouseEntered(MouseEvent event) {
        groupsImageView.setImage(courseGroupButtonOnMouseEntered);
    }

    @FXML
    private void groupsHBoxOnMouseExited(MouseEvent event) {
        if (!groupsHBoxOnMouseClickedFlag) {
            groupsImageView.setImage(courseGroupButton);
        } else {
            groupsImageView.setImage(courseGroupButtonOnMouseClicked);
        }
    }

    @FXML
    private void groupsHBoxOnMouseClicked(MouseEvent event) throws IOException {
        resetAllButtons();
        playFadeTransition(groupsLayout);
        mainLayout.setCenter(groupsLayout);
        groupsImageView.setImage(courseGroupButtonOnMouseClicked);
        groupsHBoxOnMouseClickedFlag = true;
    }

    @FXML
    private void classHBoxOnMouseEntered(MouseEvent event) {
        classImageView.setImage(classButtonOnMouseEntered);
    }

    @FXML
    private void classHBoxOnMouseExited(MouseEvent event) {
        if (!classHBoxOnMouseClickedFlag) {
            classImageView.setImage(classButton);
        } else {
            classImageView.setImage(classButtonOnMouseClicked);
        }
    }

    @FXML
    private void classHBoxOnMouseClicked(MouseEvent event) {
        resetAllButtons();
        new Effect().fadeInTransition(classLayout, 1000);
        mainLayout.setCenter(classLayout);
        classImageView.setImage(classButtonOnMouseClicked);
        classHBoxOnMouseClickedFlag = true;
    }

    @FXML
    private void scheduleHBoxOnMouseClicked(MouseEvent event) {
    }

//    public void start() {
//        mainLayout.setCenter(dashboardLayout);
//        dashboardImageView.setImage(homeButtonOnMouseClicked);
//        dashboardHBoxOnMouseClickedFlag = true;
//
////        DashboardLayoutController dlc = dashboardLayoutLoader.getController();
////        dlc.updateTermTableView();
//    }
    public void setObjectLayout(BorderPane objectLayout) {
        this.objectLayout = objectLayout;
    }

    public void setLayout(BorderPane mainLayout) {
        this.mainLayout = mainLayout;
    }

}
