package uas.Model;

import javax.swing.table.AbstractTableModel;

public class Tabel_Model_Nilai extends AbstractTableModel {

    java.util.List<Model_Nilai> list_nilai;

    public Tabel_Model_Nilai(java.util.List<Model_Nilai> list_nilai) {
        this.list_nilai = list_nilai;
    }

    @Override
    public int getRowCount() {
        return list_nilai.size();
    }

    @Override
    public int getColumnCount() {
        return 10; // Updated to include ID column
    }

    @Override
    public Object getValueAt(int row, int column) {
        Model_Nilai nilai = list_nilai.get(row);
        switch (column) {
            case 0:
                return nilai.getNim();
            case 1:
                return nilai.getNama();
            case 2:
                return nilai.getKelas();
            case 3:
                return nilai.getMataKuliah();
            case 4:
                return nilai.getTugas();
            case 5:
                return nilai.getUts();
            case 6:
                return nilai.getUas();
            case 7:
                return nilai.getPraktikum();
            case 8:
                return nilai.getNilaiAngka();
            case 9:
                return nilai.getNilaiHuruf();
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
            case 3:
                return "MATA KULIAH";
            case 4:
                return "NILAI TUGAS";
            case 5:
                return "NILAI UTS";
            case 6:
                return "NILAI UAS";
            case 7:
                return "NILAI PRAKTIKUM";
            case 8:
                return "NILAI ANGKA";
            case 9:
                return "NILAI HURUF";
            default:
                return null;
        }
    }
}
