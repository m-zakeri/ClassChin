/*
 *   ClassChin Main Class. 
 *   First Create by Ali @ 1392-02-20
 *   Last Edit by Morteza, Add some Comment! and Fix Import!
 *   Ready to Connect to DataBase! 
 */
package jclasschin;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import jclasschin.controller.ObjectLayoutController;

/**
 *
 * @author Ali
 */
public class JClassChin extends Application {

    private static Stage objectStage;

    private Scene objectScene;
    private BorderPane objectLayout;
    private FXMLLoader objectLayoutLoader;
    private ObjectLayoutController objectLayoutController;

//    private Scene preloaderScene;
//    private AnchorPane preloaderLayout;
//    private FXMLLoader preloaderLayoutLoader;
//    private PreloaderLayoutController preloaderLayoutController;
    private static Stage mainStage;
    private static BorderPane mainLayout;
    private static AnchorPane dashboardLayout;

    /**
     * @return the mainStage
     *
     */
    public static Stage getMainStage() {
        return objectStage;
    }

    /**
     * @return the mainLayout
     */
    public static BorderPane getMainLayout() {
        return mainLayout;
    }

    @Override
    public void start(Stage stage) throws IOException, InterruptedException {

        objectStage = stage;
//        mainStage = stage;

        objectLayoutLoader = new FXMLLoader(JClassChin.class.getResource("view/ObjectLayout.fxml"));
        objectLayout = (BorderPane) objectLayoutLoader.load();
        objectLayoutController = objectLayoutLoader.getController();
        objectScene = new Scene(objectLayout);

//        preloaderLayoutLoader = new FXMLLoader(JClassChin.class.getResource("view/PreloaderLayout.fxml"));
//        preloaderLayout = (AnchorPane) preloaderLayoutLoader.load();
//        preloaderLayoutController = preloaderLayoutLoader.getController();
//        preloaderScene = new Scene(preloaderLayout);
//        objectStage.setScene(preloaderScene);
//
        objectStage.setTitle("کلاس چین");
        objectStage.setResizable(false);
        objectStage.centerOnScreen();
        objectStage.setScene(objectScene);
        objectStage.show();
        objectLayoutController.setObjectLayout(objectLayout);
        objectLayoutController.start();
//        objectLayout.setCenter(preloaderLayout);
//        objectLayoutController.start(preloaderLayoutController);
//        FXMLLoader mainLayoutLoader
//                = new FXMLLoader(JClassChin.class.getResource("view/MainLayout.fxml"));
//
//        FXMLLoader preloaderLayoutLoader
//                = new FXMLLoader(JClassChin.class.getResource("view/PreloaderLayout.fxml"));
//        mainLayout = (BorderPane) mainLayoutLoader.load();
//
//        preloaderLayout = (AnchorPane) preloaderLayoutLoader.load();
//        preloaderLayoutController = preloaderLayoutLoader.getController();
//        Scene mainScene = new Scene(getMainLayout());
//
//        Scene preloaderScene = new Scene(preloaderLayout);
//        mainStage.setScene(mainScene);
//
//        mainStage.setScene(preloaderScene);
//        mainStage.setResizable(false);
//        mainStage.centerOnScreen();
//        mainStage.show();

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
