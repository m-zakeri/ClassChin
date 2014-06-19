/*
 * The MIT License
 *
 * Copyright 2014 Ali.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package jclasschin.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import jclasschin.JClassChin;
import jclasschin.model.Effect;

/**
 * FXML Controller class
 *
 * @author Ali
 */
public class PreloaderLayoutController implements Initializable {

    private BorderPane objectLayout;
//    private AnchorPane preloaderLayout;

    private FXMLLoader loginLayoutLoader;
    private AnchorPane loginLayout;
    private LoginLayoutController loginLayoutController;

//    private FXMLLoader mainLayoutLoader;
//    private BorderPane mainLayout;
//    private MainLayoutController mainLayoutController;
    @FXML
    private ProgressIndicator progressIndicator;

    public PreloaderLayoutController() throws IOException {
//
//        mainLayoutLoader = new FXMLLoader(JClassChin.class.getResource("view/MainLayout.fxml"));
//        mainLayout = (BorderPane) mainLayoutLoader.load();
//        mainLayoutController = mainLayoutLoader.getController();
        loginLayoutLoader = new FXMLLoader(JClassChin.class.getResource("view/LoginLayout.fxml"));
        loginLayout = (AnchorPane) loginLayoutLoader.load();
        loginLayoutController = loginLayoutLoader.getController();

    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        progressIndicator.setProgress(0.001F);
    }

    public void start() {
        new Effect().fadeInTransition(loginLayout, 1000);
        objectLayout.setCenter(loginLayout);
        loginLayoutController.setObjectLayout(objectLayout);
        //loginLayout.getStylesheets().add("..\gallery\css\CSS.css");
        loginLayoutController.start();
    }

    public void setObjectLayout(BorderPane objectLayout) {
        this.objectLayout = objectLayout;
    }

//    public void start() throws InterruptedException {
//
//        Task loadingTask = new Task<Void>() {
//            @Override
//            public Void call() {
//                System.out.println("TASK 1 STARTED");
//                TermManager.selectAll();
//                FieldManager.selectAll();
//                System.out.println("TASK 1 FINISHED");
//                return null;
//            }
//        };
//
//        Task progressIndicatorTask = new Task<Void>() {
//            @Override
//            public Void call() throws InterruptedException {
//
//                System.out.println("TASK 2 STARTED");
//                double max = 10000000;
//                for (double i = 0; i <= max; i += 0.1) {
//                    if (isCancelled()) {
//                        break;
//                    }
//
//                    updateProgress(i, max);
//                }
//                System.out.println("TASK 2 FINISHED");
//
//                return null;
//            }
//        };
//        Task layoutTask = new Task<Void>() {
//            @Override
//            public Void call() {
//                System.out.println("TASK 3 STARTED");
//                objectLayout.setCenter(preloaderLayout);
//                System.out.println("TASK 3 FINISHED");
//                return null;
//            }
//        };
//        progressIndicator.progressProperty().bind(progressIndicatorTask.progressProperty());
//        Thread progressIndicatorThread = new Thread(progressIndicatorTask);
//        Thread loadingThread = new Thread(loadingTask);
//        Thread layoutThread = new Thread(layoutTask);
    //layoutThread.start();
//        progressIndicatorThread.start();
//        loadingThread.start();
    //PlatformImpl.runAndWait(layoutTask);
//        progressIndicatorThread.wait();
    //loadingThread.wait();
//        progressIndicatorThread.notify();
//          progressIndicatorThread.join();
    // pro
    // Thread.sleep(2000);
//        //   progressIndicatorThread.start();
//        loadingThread.start();
//        
//       // layoutThread.join();
//        //loadingThread.join();
//       progressIndicatorThread.join();
    //    layoutThread.join();
    //progressIndicatorThread.join();
    // layoutThread.join();
//    public void addProgress() {
//        progressIndicator.setProgress(progressIndicator.getProgress()+0.000001F);
//        System.out.println(progressIndicator.getProgress());
//    }
//    public void start() {
//
//        new Effect().fadeInTransition(mainLayout, 1000);
//        objectLayout.setCenter(mainLayout);
//        mainLayoutController.setObjectLayout(objectLayout);
//        mainLayoutController.setLayout(mainLayout);
//        mainLayoutController.start();
//    }
}
