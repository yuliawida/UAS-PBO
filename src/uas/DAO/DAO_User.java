/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uas.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import uas.DAOImplement.Implement_User;
import uas.Koneksi.Koneksi_DB;
import uas.Model.Model_Mahasiswa;
import uas.Model.Model_User;

/**
 *
 * @author Asus
 */
public class DAO_User implements Implement_User {

    Connection connection;
    final String insert = "INSERT INTO user (username, password) VALUES (?,?);";
    final String select = "SELECT * FROM user;";

    public DAO_User() {
        connection = Koneksi_DB.connection();
    }

    @Override
    public void insert(Model_User b) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(insert);
            statement.setString(1, b.getUsername());
            statement.setString(2, b.getPassword());

            statement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                statement.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    @Override
    public List<Model_User> getALL() {

        java.util.List<Model_User> lb = null;
        try {
            lb = new ArrayList<Model_User>();
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(select);
            while (rs.next()) {
                Model_User b = new Model_User();
                b.setUsername(rs.getString("username"));
                b.setPassword(rs.getString("password"));
                lb.add(b);
            }
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(DAO_User.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        return lb;
    }

}
