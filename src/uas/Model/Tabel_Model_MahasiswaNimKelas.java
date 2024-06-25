/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uas.Model;

import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Asus
 */
public class Tabel_Model_MahasiswaNimKelas extends AbstractTableModel {

    java.util.List<Model_Mahasiswa> list_mahasiswa;

    public Tabel_Model_MahasiswaNimKelas(java.util.List<Model_Mahasiswa> list_mahasiswa) {
        this.list_mahasiswa = list_mahasiswa;
    }

    @Override
    public int getRowCount() {
        return list_mahasiswa.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int row, int column) {
        switch (column) {
            case 0:
                return list_mahasiswa.get(row).getNim();
            case 1:
                return list_mahasiswa.get(row).getNama();
            case 2:
                return list_mahasiswa.get(row).getKelas();
            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "NIM";
            case 1:
                return "NAMA";
            case 2:
                return "KELAS";
            default:
                return null;
        }
    }
}
