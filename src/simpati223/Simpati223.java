/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simpati223;

/**
 *
 * @author Ikhsan Abdillah
 */
public class Simpati223 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        FLogin form_login = new FLogin();
        form_login.setVisible(true);
        form_login.setSize(715, 500);
        form_login.setLocationRelativeTo(null);
        form_login.setTitle("Form Login");
    }
    
}
