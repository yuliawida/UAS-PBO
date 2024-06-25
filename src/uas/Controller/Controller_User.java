package uas.Controller;

import javax.swing.JOptionPane;
import uas.DAO.DAO_User;
import uas.DAOImplement.Implement_User;
import uas.Model.Model_User;
import uas.View.View_UserLogin;

public class Controller_User {

    private View_UserLogin frame_user_login;
    private Implement_User implement_user;
    private java.util.List<Model_User> list_user;
    private boolean loggedIn = false;

    // Constructor
    public Controller_User(View_UserLogin frame_user_login) {
        this.frame_user_login = frame_user_login;
        implement_user = new DAO_User();
        list_user = implement_user.getALL();
    }

    // Check login status
    public boolean isLoggedIn() {
        return loggedIn;
    }

    // Set login status
    public void setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
    }

    // hapus isian 
    public void reset() {
        frame_user_login.getUsernameTextField().setText("");
        frame_user_login.getPasswordField().setText("");
    }

    // login
    public void login() {
        String username = frame_user_login.getUsernameTextField().getText();
        String password = new String(frame_user_login.getPasswordField().getPassword());

        // cek username dan password
        for (Model_User user : list_user) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                loggedIn = true;
                break;
            }
        }

        if (loggedIn) {
            JOptionPane.showMessageDialog(frame_user_login, "Login berhasil!");
        } else {
            JOptionPane.showMessageDialog(frame_user_login, "Username atau password salah!");
        }
    }
}
