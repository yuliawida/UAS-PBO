/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uas.DAO;

import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.sql.Statement;
import java.sql.Connection;
import java.util.List;
import uas.Koneksi.Koneksi_DB;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import uas.DAOImplement.Implement_Nilai;
import uas.Model.Model_Nilai;

/**
 *
 * @author Asus
 */
public class DAO_Nilai implements Implement_Nilai {

    Connection connection;
    final String insert = "INSERT INTO nilai (id, nim, mataKuliah, tugas, uts, uas, praktikum, nilaiAngka, nilaiHuruf) VALUES (?,?,?,?,?,?,?,?,?);";
    final String update = "UPDATE nilai SET tugas=?, uts=?, uas=?, praktikum=?, nilaiAngka=?, nilaiHuruf=? WHERE nim=? AND mataKuliah=?";
    final String deleteByNimAndMataKuliah = "DELETE FROM nilai WHERE nim = ? AND matakuliah = ?;";
    final String selectAll = "SELECT n.nim, m.nama, m.kelas, n.mataKuliah, n.tugas, n.uts, n.uas, n.praktikum, n.nilaiAngka, n.nilaiHuruf FROM nilai n JOIN mahasiswa m ON n.nim = m.nim";
    final String cariByNim = "SELECT n.id, n.nim, m.nama, m.kelas, n.mataKuliah, n.tugas, n.uts, n.uas, n.praktikum, n.nilaiAngka, n.nilaiHuruf FROM nilai n JOIN mahasiswa m ON n.nim = m.nim WHERE n.nim LIKE ?";
    final String cariByKelasDanMataKuliah = "SELECT n.id, n.nim, m.nama, m.kelas, n.mataKuliah, n.tugas, n.uts, n.uas, n.praktikum, n.nilaiAngka, n.nilaiHuruf FROM nilai n JOIN mahasiswa m ON n.nim = m.nim WHERE m.kelas LIKE ? AND n.mataKuliah LIKE ?";

    public DAO_Nilai() {
        connection = Koneksi_DB.connection();
    }

    @Override
    public void insert(Model_Nilai b) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS);
            statement.setString(2, b.getNim());
            statement.setString(3, b.getMataKuliah());
            statement.setFloat(4, b.getTugas());
            statement.setFloat(5, b.getUts());
            statement.setFloat(6, b.getUas());
            statement.setFloat(7, b.getPraktikum());
            statement.setFloat(8, b.getNilaiAngka());
            statement.setString(9, b.getNilaiHuruf());

            // Mengambil nilai id yang di-generate secara otomatis oleh database
            ResultSet generatedKeys = statement.getGeneratedKeys();
            if (generatedKeys.next()) {
                b.setId(generatedKeys.getInt(1));
            } else {
                throw new SQLException("Gagal mendapatkan ID yang di-generate secara otomatis.");
            }

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
    public void update(Model_Nilai b) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(update, Statement.RETURN_GENERATED_KEYS);
            statement.setFloat(1, b.getTugas());
            statement.setFloat(2, b.getUts());
            statement.setFloat(3, b.getUas());
            statement.setFloat(4, b.getPraktikum());
            statement.setFloat(5, b.getNilaiAngka());
            statement.setString(6, b.getNilaiHuruf());
            statement.setString(7, b.getNim());
            statement.setString(8, b.getMataKuliah());

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
    public void deleteByNimAndMataKuliah(String nim, String mataKuliah) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(deleteByNimAndMataKuliah);
            statement.setString(1, nim);
            statement.setString(2, mataKuliah);

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
    public java.util.List<Model_Nilai> getALL() {
        java.util.List<Model_Nilai> lb = null;
        try {
            lb = new ArrayList<Model_Nilai>();
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(selectAll);
            while (rs.next()) {
                Model_Nilai b = new Model_Nilai();
                b.setNim(rs.getString("nim"));
                b.setNama(rs.getString("nama"));
                b.setKelas(rs.getString("kelas"));
                b.setMataKuliah(rs.getString("mataKuliah"));
                b.setTugas(rs.getFloat("tugas"));
                b.setUts(rs.getFloat("uts"));
                b.setUas(rs.getFloat("uas"));
                b.setPraktikum(rs.getFloat("praktikum"));
                b.setNilaiAngka(rs.getFloat("nilaiAngka"));
                b.setNilaiHuruf(rs.getString("nilaiHuruf"));

                lb.add(b);
            }
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(DAO_Nilai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        return lb;
    }

    @Override
    public List<Model_Nilai> getCariNim(String nim) {
        java.util.List<Model_Nilai> lb = null;
        try {
            lb = new ArrayList<Model_Nilai>();
            PreparedStatement st = connection.prepareStatement(cariByNim);
            st.setString(1, "%" + nim + "%");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Model_Nilai b = new Model_Nilai();
                b.setId(rs.getInt("id"));
                b.setNim(rs.getString("nim"));
                b.setNama(rs.getString("nama"));
                b.setKelas(rs.getString("kelas"));
                b.setMataKuliah(rs.getString("mataKuliah"));
                b.setTugas(rs.getFloat("tugas"));
                b.setUts(rs.getFloat("uts"));
                b.setUas(rs.getFloat("uas"));
                b.setPraktikum(rs.getFloat("praktikum"));
                b.setNilaiAngka(rs.getFloat("nilaiAngka"));
                b.setNilaiHuruf(rs.getString("nilaiHuruf"));

                lb.add(b);
            }
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(DAO_Nilai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        return lb;
    }

    @Override
    public java.util.List<Model_Nilai> getCariKelasDanMataKuliah(String kelas, String mataKuliah) {
        java.util.List<Model_Nilai> lb = null;
        try {
            lb = new ArrayList<Model_Nilai>();
            PreparedStatement st = connection.prepareStatement(cariByKelasDanMataKuliah);
            st.setString(1, "%" + kelas + "%");
            st.setString(2, "%" + mataKuliah + "%");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Model_Nilai b = new Model_Nilai();
                b.setId(rs.getInt("id"));
                b.setNim(rs.getString("nim"));
                b.setNama(rs.getString("nama"));
                b.setKelas(rs.getString("kelas"));
                b.setMataKuliah(rs.getString("mataKuliah"));
                b.setTugas(rs.getFloat("tugas"));
                b.setUts(rs.getFloat("uts"));
                b.setUas(rs.getFloat("uas"));
                b.setPraktikum(rs.getFloat("praktikum"));
                b.setNilaiAngka(rs.getFloat("nilaiAngka"));
                b.setNilaiHuruf(rs.getString("nilaiHuruf"));

                lb.add(b);
            }
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(DAO_Nilai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        return lb;
    }
}
