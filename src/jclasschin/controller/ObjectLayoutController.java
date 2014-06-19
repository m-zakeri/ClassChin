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
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import jclasschin.JClassChin;
import jclasschin.model.Effect;

/**
 * FXML Controller class
 *
 * @author Ali
 */
public class ObjectLayoutController implements Initializable {

    private BorderPane objectLayout;

//    private FXMLLoader loginLayoutLoader;
//    private AnchorPane loginLayout;
//    private LoginLayoutController loginLayoutController;
    private AnchorPane preloaderLayout;
    private FXMLLoader preloaderLayoutLoader;
    private PreloaderLayoutController preloaderLayoutController;


    public ObjectLayoutController() throws IOException {

//        loginLayoutLoader = new FXMLLoader(JClassChin.class.getResource("view/LoginLayout.fxml"));
//        loginLayout = (AnchorPane) loginLayoutLoader.load();
//        loginLayoutController = loginLayoutLoader.getController();
        preloaderLayoutLoader = new FXMLLoader(JClassChin.class.getResource("view/PreloaderLayout.fxml"));
        preloaderLayout = (AnchorPane) preloaderLayoutLoader.load();
        preloaderLayoutController = preloaderLayoutLoader.getController();

    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public void start() {
        new Effect().fadeInTransition(preloaderLayout, 1000);
        objectLayout.setCenter(preloaderLayout);
        preloaderLayoutController.setObjectLayout(objectLayout);
        preloaderLayoutController.start();
    }

    public void setObjectLayout(BorderPane objectLayout) {
        this.objectLayout = objectLayout;
    }
//
//    private void end() throws InterruptedException {
// preloaderLayoutController.startThreads();
//    }
//
//    private void end2() throws InterruptedException {
//
//    Task layoutTask = new Task<Void>() {
//            @Override
//            public Void call() {
//                System.out.println("TASK 5 STARTED");
//                objectLayout.setCenter(preloaderLayout);
//                System.out.println("TASK 5 FINISHED");
//                return null;
////            }
////        };
//    
//            Thread layoutThread = new Thread(layoutTask);
//layoutThread.start();
//layoutThread.join();
//    
//    
//    }

}
