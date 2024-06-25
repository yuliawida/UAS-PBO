/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uas.Controller;

import javax.swing.JOptionPane;
import uas.DAO.DAO_Mahasiswa;
import uas.DAOImplement.Implement_Mahasiswa;
import uas.Model.Model_Mahasiswa;
import uas.Model.Tabel_Model_Mahasiswa;
import uas.View.View_Mahasiswa;

/**
 *
 * @author Asus
 */
public class Controller_Mahasiswa {

    View_Mahasiswa frame_mahasiswa;
    Implement_Mahasiswa implement_mahasiswa;
    java.util.List<Model_Mahasiswa> list_mahasiswa;

    public Controller_Mahasiswa(View_Mahasiswa frame_mahasiswa) {
        this.frame_mahasiswa = frame_mahasiswa;
        implement_mahasiswa = new DAO_Mahasiswa();
        list_mahasiswa = implement_mahasiswa.getALL();
    }

    //Tombol reset
    public void reset() {
        frame_mahasiswa.getNimTextField().setText("");
        frame_mahasiswa.getNamaTextField().setText("");
        frame_mahasiswa.getKelasTextField().setText("");
        frame_mahasiswa.getSemesterSpinner().setValue(1);
        frame_mahasiswa.getProvinsiComboBox().setSelectedItem("--Pilih Provinsi--");
        frame_mahasiswa.getEmailTextField().setText("");
    }

    //Tampil Data Ke Tabel
    public void isiTable() {
        list_mahasiswa = implement_mahasiswa.getALL();
        Tabel_Model_Mahasiswa tmb = new Tabel_Model_Mahasiswa(list_mahasiswa);
        frame_mahasiswa.getMahasiswaTable().setModel(tmb);
    }

    //Menampilkan data ke Form Ketika Data di Klik
    public void isiField(int row) {
        frame_mahasiswa.getNimTextField().setText(list_mahasiswa.get(row).getNim());
        frame_mahasiswa.getNamaTextField().setText(list_mahasiswa.get(row).getNama());
        frame_mahasiswa.getKelasTextField().setText(list_mahasiswa.get(row).getKelas());
        frame_mahasiswa.getSemesterSpinner().setValue(list_mahasiswa.get(row).getSemester());
        frame_mahasiswa.getProvinsiComboBox().setSelectedItem(list_mahasiswa.get(row).getProvinsi().toString());
        frame_mahasiswa.getEmailTextField().setText(list_mahasiswa.get(row).getEmail());
    }

    //insert data dari form ke database
    public void insert() {
        if (!frame_mahasiswa.getNimTextField().getText().trim().isEmpty() & !frame_mahasiswa.getNamaTextField().getText().trim().isEmpty() & !frame_mahasiswa.getKelasTextField().getText().trim().isEmpty() & !frame_mahasiswa.getEmailTextField().getText().trim().isEmpty()) {
            Model_Mahasiswa b = new Model_Mahasiswa();
            b.setNim(frame_mahasiswa.getNimTextField().getText());
            b.setNama(frame_mahasiswa.getNamaTextField().getText());
            b.setKelas(frame_mahasiswa.getKelasTextField().getText());
            b.setSemester((Integer) frame_mahasiswa.getSemesterSpinner().getValue());
            b.setProvinsi(frame_mahasiswa.getProvinsiComboBox().getSelectedItem().toString());
            b.setEmail(frame_mahasiswa.getEmailTextField().getText());

            implement_mahasiswa.insert(b);
            JOptionPane.showMessageDialog(null, "Data Berhasil disimpan");
        } else {
            JOptionPane.showMessageDialog(frame_mahasiswa, "Data Tidak Boleh Kosong");
        }
    }

    //update data dari tabel ke database
    public void update() {
        if (!frame_mahasiswa.getNimTextField().getText().trim().isEmpty()) {
            Model_Mahasiswa b = new Model_Mahasiswa();
            b.setNim(frame_mahasiswa.getNimTextField().getText());
            b.setNama(frame_mahasiswa.getNamaTextField().getText());
            b.setKelas(frame_mahasiswa.getKelasTextField().getText());
            b.setSemester((Integer) frame_mahasiswa.getSemesterSpinner().getValue());
            b.setProvinsi(frame_mahasiswa.getProvinsiComboBox().getSelectedItem().toString());
            b.setEmail(frame_mahasiswa.getEmailTextField().getText());

            System.out.println("Updating student: " + b);
            
            implement_mahasiswa.update(b);
            JOptionPane.showMessageDialog(null, "Data Berhasil diupdate");
        } else {
            JOptionPane.showMessageDialog(frame_mahasiswa, "Pilih data yang akan diupdate !");
        }
    }

    //hapus data pada tabel
    public void delete() {
        if (!frame_mahasiswa.getNimTextField().getText().isEmpty()) {
            String nim = frame_mahasiswa.getNimTextField().getText();
            implement_mahasiswa.delete(nim);

            JOptionPane.showMessageDialog(null, "Data Berhasil dihapus");
        } else {
            JOptionPane.showMessageDialog(frame_mahasiswa, "Pilih data yang akan dihapus !");
        }
    }

    //cari data berdasar nim
    public void isiTableCariNim() {
        list_mahasiswa = implement_mahasiswa.getCariNim(frame_mahasiswa.getTampilMhsByNimTextField().getText());
        Tabel_Model_Mahasiswa tmb = new Tabel_Model_Mahasiswa(list_mahasiswa);
        frame_mahasiswa.getMahasiswaTable().setModel(tmb);
    }

    public void carinim() {
        if (!frame_mahasiswa.getTampilMhsByNimTextField().getText().trim().isEmpty()) {
            implement_mahasiswa.getCariNim(frame_mahasiswa.getTampilMhsByNimTextField().getText());
            isiTableCariNim();
        } else {
            JOptionPane.showMessageDialog(frame_mahasiswa, "Silakan Pilih Data !");
        }
    }

    //cari data berdasar kelas
    public void isiTableCariKelas() {
        list_mahasiswa = implement_mahasiswa.getCariKelas(frame_mahasiswa.getTampilMhsByKelasTextField().getText());
        Tabel_Model_Mahasiswa tmb = new Tabel_Model_Mahasiswa(list_mahasiswa);
        frame_mahasiswa.getMahasiswaTable().setModel(tmb);
    }

    public void carikelas() {
        if (!frame_mahasiswa.getTampilMhsByKelasTextField().getText().trim().isEmpty()) {
            implement_mahasiswa.getCariKelas(frame_mahasiswa.getTampilMhsByKelasTextField().getText());
            isiTableCariKelas();
        } else {
            JOptionPane.showMessageDialog(frame_mahasiswa, "Silakan Pilih Data !");
        }
    }
}
