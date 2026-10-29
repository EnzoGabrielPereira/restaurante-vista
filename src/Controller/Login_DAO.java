/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import static View.Login_GUI.login_txt;
import static View.Login_GUI.senha_txt;
import View.Menu_GUI;
import javax.swing.JOptionPane;

/**
 *
 * @author enzog
 */
public class Login_DAO {
     public static void validar(){
        String login = login_txt.getText();
        long senha = Long.parseLong(senha_txt.getText());
       
        if(login.equals("garcom1") && senha == 123){
           JOptionPane.showMessageDialog(null, "Seja Bem Vindo!"); 
           new Menu_GUI().setVisible(true);
        }else{
            JOptionPane.showMessageDialog(null, "Senha ou Login Incorretos");
            System.exit(0);
        }
    }
    
}
