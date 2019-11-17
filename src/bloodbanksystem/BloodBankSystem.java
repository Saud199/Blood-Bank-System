/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bloodbanksystem;

/**
 *
 * @author ABC
 */
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
public class BloodBankSystem {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        try {
            for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
                // If Nimbus is not available, you can set the GUI to another look and feel.
                JOptionPane.showMessageDialog(null, ""+e);
        }
        
        SplashScreen splash = new SplashScreen();
        splash.setLocationRelativeTo(null);
        splash.setVisible(true);
        
        LoginPage loginScreen = new LoginPage();
        
        try {
            
            for (int i =0 ; i<=100 ; i++) {
                Thread.sleep(40);
                splash.loadingnum.setText(Integer.toString(i)+"%");
                splash.loadingbar.setValue(i);
                
                if (i==100) {
                    splash.dispose();
                    loginScreen.setLocationRelativeTo(null);
                    loginScreen.setVisible(true);
                }
           
            }
            
        } catch (Exception e) {
            
        }
        
    }
    
}
