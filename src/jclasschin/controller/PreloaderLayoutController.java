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

import java.net.URL;
import java.util.ResourceBundle;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ProgressIndicator;
import jclasschin.model.*;

/**
 * FXML Controller class
 *
 * @author Ali
 */
public class PreloaderLayoutController implements Initializable {

    @FXML
    private ProgressIndicator progressIndicator;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        progressIndicator.setProgress(0.0F);
    }

    public void loading() throws InterruptedException {

        Task task = new Task<Void>() {
            @Override
            public Void call() {
                /*
                 int max=999999999;
                 for (int i = 1; i <= max; i++) {
                 if (isCancelled()) {
                 break;
                 }
                
                 updateProgress(i, max);
                 }*/

                System.out.println("START TASK1");
                //System.out.println(this.getProgress() + "");

                TermManager.selectAll();
                //System.out.println(this.getProgress() + "");

                FieldManager.selectAll();
                //System.out.println(this.getProgress() + "");

                System.out.println("FINISH TASK1");
               // System.out.println(this.getProgress() + "");

                return null;
            }
        };

        Task task2 = new Task<Void>() {
            @Override
            public Void call() throws InterruptedException {

                double max = 10000000;
                for (double i = 0; i <= max; i+=0.1) {
                    if (isCancelled()) {
                        break;
                    }
                    //System.out.println(i);
                    updateProgress(i, max);
                }
//                System.out.println("SALAM");    
//                System.out.println(task.getProgress()+"");
//                int i = 0;
//                while (i < 10000000) {
////                    System.out.println("SALAM");
//                    System.out.println(task.getProgress() + "");
//                    updateProgress(task.getProgress(), 1);
//                    i++;
//                }

//                TermManager.selectAll();
//                FieldManager.selectAll();
                return null;
            }
        };

        progressIndicator.progressProperty().bind(task2.progressProperty());
        Thread task1Thread = new Thread(task);
        Thread task2Thread = new Thread(task2);

        //task1Thread.setPriority(Thread.MAX_PRIORITY);
        //task2Thread.setPriority(Thread.MIN_PRIORITY);
        task1Thread.start();
        task2Thread.start();

//        task1Thread.
//        ThreadGroup threadGroup=new ThreadGroup("TASKS");
//        threadGroup.
    }

}
