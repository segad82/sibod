/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import javax.swing.JOptionPane;

/**
 *
 * @author kevin
 */
public class PrintMessage {
    
    protected static int ERROR = 0;
    protected static int INFORMATION = 1;
    protected static int ALERT = 2;
    protected static int QUESTION = 3;
    
    public static void showErrorMessage(String title, String message) {
        JOptionPane.showMessageDialog(null, message, title, ERROR);
    }
    
    public static void showInformationMessage(String title, String message) {
        JOptionPane.showMessageDialog(null, message, title, INFORMATION);
    }
    
    public static void showAlertMessage(String title, String message) {
        JOptionPane.showMessageDialog(null, message, title, ALERT);
    }
    
    public static void showQuestionMessage(String title, String message) {
        JOptionPane.showMessageDialog(null, message, title, QUESTION);
    }
    
}
