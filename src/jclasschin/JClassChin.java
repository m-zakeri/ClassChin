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
import javafx.geometry.NodeOrientation;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 *
 * @author Ali
 */
public class JClassChin extends Application
{

    private static Stage mainStage;
    private static BorderPane mainLayout;
    private static AnchorPane dashboardLayout;

    /**
     * @return the mainStage
     */
    public static Stage getMainStage()
    {
        return mainStage;
    }

    /**
     * @return the mainLayout
     */
    public static BorderPane getMainLayout()
    {
        return mainLayout;
    }

    @Override
    public void start(Stage mainStage) throws IOException
    {

        JClassChin.mainStage = mainStage;

        mainStage.setTitle("JClassChin");

        FXMLLoader mainLayoutLoader
                = new FXMLLoader(JClassChin.class.getResource("view/MainLayout.fxml"));

        mainLayout = (BorderPane) mainLayoutLoader.load();
        mainLayout.setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
        Scene mainScene = new Scene(getMainLayout());
        mainStage.setScene(mainScene);
        mainStage.setResizable(false);
        mainStage.centerOnScreen();

//        FXMLLoader dashboardLayoutLoader=new FXMLLoader(JClassChin.class.getResource("view/DashboardLayout.fxml"));
//        dashboardLayout=(AnchorPane) dashboardLayoutLoader.load();
//        mainLayout.setCenter(dashboardLayout);
        mainStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        launch(args);
    }

}
