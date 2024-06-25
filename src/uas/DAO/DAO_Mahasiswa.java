/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uas.DAO;

import java.sql.Statement;
import java.sql.Connection;
import java.util.List;
import uas.DAOImplement.Implement_Mahasiswa;
import uas.Koneksi.Koneksi_DB;
import uas.Model.Model_Mahasiswa;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Asus
 */
public class DAO_Mahasiswa implements Implement_Mahasiswa {

    Connection connection;
    final String insert = "INSERT INTO mahasiswa (nim, nama, kelas, semester, provinsi, email) VALUES (?,?,?,?,?,?);";
    final String update = "UPDATE mahasiswa set nim=?, nama=?, kelas=?, semester=?, provinsi=?, email=? WHERE nim=?;";
    final String delete = "DELETE FROM mahasiswa WHERE nim=?;";
    final String select = "SELECT * FROM mahasiswa;";
    final String carinim = "SELECT * FROM mahasiswa WHERE nim LIKE ?";
    final String carikelas = "SELECT * FROM mahasiswa WHERE kelas LIKE ?";

    public DAO_Mahasiswa() {
        connection = Koneksi_DB.connection();
    }

    @Override
    public void insert(Model_Mahasiswa b) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(insert);
            statement.setString(1, b.getNim());
            statement.setString(2, b.getNama());
            statement.setString(3, b.getKelas());
            statement.setInt(4, b.getSemester());
            statement.setString(5, b.getProvinsi());
            statement.setString(6, b.getEmail());
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
    public void update(Model_Mahasiswa b) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(update);
            statement.setString(1, b.getNim());
            statement.setString(2, b.getNama());
            statement.setString(3, b.getKelas());
            statement.setInt(4, b.getSemester());
            statement.setString(5, b.getProvinsi());
            statement.setString(6, b.getEmail());
            statement.setString(7, b.getNim()); // Parameter untuk klausa WHERE
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
    public void delete(String nim) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(delete);
            statement.setString(1, nim);
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
    public java.util.List<Model_Mahasiswa> getALL() {
        java.util.List<Model_Mahasiswa> lb = null;
        try {
            lb = new ArrayList<Model_Mahasiswa>();
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(select);
            while (rs.next()) {
                Model_Mahasiswa b = new Model_Mahasiswa();
                b.setNim(rs.getString("nim"));
                b.setNama(rs.getString("nama"));
                b.setKelas(rs.getString("kelas"));
                b.setSemester(rs.getInt("semester"));
                b.setProvinsi(rs.getString("provinsi"));
                b.setEmail(rs.getString("email"));
                lb.add(b);
            }
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(DAO_Mahasiswa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        return lb;
    }

    @Override
    public java.util.List<Model_Mahasiswa> getCariNim(String nim) {
        java.util.List<Model_Mahasiswa> lb = null;
        try {
            lb = new ArrayList<Model_Mahasiswa>();
            PreparedStatement st = connection.prepareStatement(carinim);
            st.setString(1, "%" + nim + "%");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Model_Mahasiswa b = new Model_Mahasiswa();
                b.setNim(rs.getString("nim"));
                b.setNama(rs.getString("nama"));
                b.setKelas(rs.getString("kelas"));
                b.setSemester(rs.getInt("semester"));
                b.setProvinsi(rs.getString("provinsi"));
                b.setEmail(rs.getString("email"));
                lb.add(b);
            }
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(DAO_Mahasiswa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        return lb;
    }

    @Override
    public List<Model_Mahasiswa> getCariKelas(String kelas) {
        java.util.List<Model_Mahasiswa> lb = null;
        try {
            lb = new ArrayList<Model_Mahasiswa>();
            PreparedStatement st = connection.prepareStatement(carikelas);
            st.setString(1, "%" + kelas + "%");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Model_Mahasiswa b = new Model_Mahasiswa();
                b.setNim(rs.getString("nim"));
                b.setNama(rs.getString("nama"));
                b.setKelas(rs.getString("kelas"));
                b.setSemester(rs.getInt("semester"));
                b.setProvinsi(rs.getString("provinsi"));
                b.setEmail(rs.getString("email"));
                lb.add(b);
            }
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(DAO_Mahasiswa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        return lb;
    }

    @Override
    public List<Model_Mahasiswa> getNimKelas() {
        java.util.List<Model_Mahasiswa> lb = null;
        try {
            lb = new ArrayList<Model_Mahasiswa>();
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(select);
            while (rs.next()) {
                Model_Mahasiswa b = new Model_Mahasiswa();
                b.setNim(rs.getString("nim"));
                b.setNama(rs.getString("nama"));
                b.setKelas(rs.getString("kelas"));
                lb.add(b);
            }
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(DAO_Mahasiswa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        return lb;
    }

}
