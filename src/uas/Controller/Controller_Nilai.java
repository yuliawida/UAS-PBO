/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uas.Controller;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.File;
import java.io.FileOutputStream;

import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;
import javax.swing.JFileChooser;
import javax.swing.JTable;
import javax.swing.table.TableModel;
import uas.DAO.DAO_Mahasiswa;
import uas.DAO.DAO_Nilai;
import uas.DAOImplement.Implement_Mahasiswa;
import uas.DAOImplement.Implement_Nilai;
import uas.Model.Model_Mahasiswa;
import uas.Model.Model_Nilai;
import uas.Model.Tabel_Model_MahasiswaNimKelas;
import uas.Model.Tabel_Model_Nilai;
import uas.View.View_Nilai;

/**
 *
 * @author Asus
 */
public class Controller_Nilai {

    View_Nilai frame_nilai;
    Implement_Nilai implement_nilai;
    java.util.List<Model_Nilai> list_nilai;

    Implement_Mahasiswa implement_mahasiswa;
    java.util.List<Model_Mahasiswa> list_mahasiswa;

    public Controller_Nilai(View_Nilai frame_nilai) {
        this.frame_nilai = frame_nilai;
        implement_nilai = new DAO_Nilai();
        list_nilai = implement_nilai.getALL();

        implement_mahasiswa = new DAO_Mahasiswa();
        list_mahasiswa = implement_mahasiswa.getNimKelas();
    }

    //Tombol reset
    public void reset() {
        frame_nilai.getNimTextField().setText("");
        frame_nilai.getMataKuliahComboBox().setSelectedItem("--Pilih Mata Kuliah--");
        frame_nilai.getTugasTextField().setText("");
        frame_nilai.getUtsTextField().setText("");
        frame_nilai.getUasTextField().setText("");
        frame_nilai.getPraktikumTextField().setText("");
        frame_nilai.getNilaiAngkaTextField().setText("");
        frame_nilai.getNilaiHurufTextField().setText("");
    }

    //Tampil Data Ke Tabel
    public void isiTable() {
        list_nilai = implement_nilai.getALL();
        Tabel_Model_Nilai tmb = new Tabel_Model_Nilai(list_nilai);
        frame_nilai.getNilaiTable().setModel(tmb);
    }

    public void isiTableNimKelas() {
        list_mahasiswa = implement_mahasiswa.getNimKelas();
        Tabel_Model_MahasiswaNimKelas tmb = new Tabel_Model_MahasiswaNimKelas(list_mahasiswa);
        frame_nilai.getNimKelasTable().setModel(tmb);
    }

    //Menampilkan data ke Form Ketika Data di Klik
    public void isiField(int row) {
        frame_nilai.getNimTextField().setText(list_nilai.get(row).getNim());
        frame_nilai.getMataKuliahComboBox().setSelectedItem(list_nilai.get(row).getMataKuliah().toString());
        frame_nilai.getTugasTextField().setText(String.valueOf(list_nilai.get(row).getTugas()));
        frame_nilai.getUtsTextField().setText(String.valueOf(list_nilai.get(row).getUts()));
        frame_nilai.getUasTextField().setText(String.valueOf(list_nilai.get(row).getUas()));
        frame_nilai.getPraktikumTextField().setText(String.valueOf(list_nilai.get(row).getPraktikum()));
        frame_nilai.getNilaiAngkaTextField().setText(String.valueOf(list_nilai.get(row).getNilaiAngka()));
        frame_nilai.getNilaiHurufTextField().setText(list_nilai.get(row).getNilaiHuruf());
    }

    public void isiFieldNIM(int row) {
        frame_nilai.getNimTextField().setText(list_mahasiswa.get(row).getNim());
    }

    // insert data dari form ke database
    public void insert() {
        try {
            // Validasi input tidak boleh kosong
            if (!frame_nilai.getNimTextField().getText().trim().isEmpty()
                    && !frame_nilai.getMataKuliahComboBox().getSelectedItem().toString().equals("--Pilih Mata Kuliah--")
                    && !frame_nilai.getTugasTextField().getText().trim().isEmpty()
                    && !frame_nilai.getUtsTextField().getText().trim().isEmpty()
                    && !frame_nilai.getUasTextField().getText().trim().isEmpty()
                    && !frame_nilai.getPraktikumTextField().getText().trim().isEmpty()
                    && !frame_nilai.getNilaiAngkaTextField().getText().trim().isEmpty()
                    && !frame_nilai.getNilaiHurufTextField().getText().trim().isEmpty()) {

                // Ambil nilai dari komponen-komponen form
                String nim = frame_nilai.getNimTextField().getText();
                String mataKuliah = (String) frame_nilai.getMataKuliahComboBox().getSelectedItem();
                float tugas = Float.parseFloat(frame_nilai.getTugasTextField().getText());
                float uts = Float.parseFloat(frame_nilai.getUtsTextField().getText());
                float uas = Float.parseFloat(frame_nilai.getUasTextField().getText());
                float praktikum = Float.parseFloat(frame_nilai.getPraktikumTextField().getText());
                float nilaiAngka = Float.parseFloat(frame_nilai.getNilaiAngkaTextField().getText());
                String nilaiHuruf = frame_nilai.getNilaiHurufTextField().getText();

                // Validasi nilai numerik jika diperlukan
                if (tugas < 0 || tugas > 100 || uts < 0 || uts > 100 || uas < 0 || uas > 100 || praktikum < 0 || praktikum > 100 || nilaiAngka < 0 || nilaiAngka > 100) {
                    JOptionPane.showMessageDialog(frame_nilai, "Nilai harus berada di antara 0 dan 100");
                    return;
                }

                // Periksa apakah NIM dan mata kuliah sudah ada di tabel
                boolean alreadyExists = false;
                for (Model_Nilai nilai : list_nilai) {
                    if (nilai.getNim().equals(nim) && nilai.getMataKuliah().equals(mataKuliah)) {
                        alreadyExists = true;
                        break;
                    }
                }

                if (alreadyExists) {
                    JOptionPane.showMessageDialog(frame_nilai, "Data dengan NIM dan Mata Kuliah ini sudah ada.");
                } else {
                    // Buat objek Model_Nilai dan set nilainya
                    Model_Nilai b = new Model_Nilai();
                    b.setNim(nim);
                    b.setMataKuliah(mataKuliah);
                    b.setTugas(tugas);
                    b.setUts(uts);
                    b.setUas(uas);
                    b.setPraktikum(praktikum);
                    b.setNilaiAngka(nilaiAngka);
                    b.setNilaiHuruf(nilaiHuruf);

                    // Panggil method insert dari implement_nilai
                    implement_nilai.insert(b);

                    // Tampilkan pesan sukses
                    JOptionPane.showMessageDialog(null, "Data Berhasil disimpan");
                }
            } else {
                JOptionPane.showMessageDialog(frame_nilai, "Harap lengkapi semua field");
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(frame_nilai, "Input tugas, uts, uas, praktikum, dan nilai angka harus berupa angka");
        }
    }

    public void update() {
        try {
            // Periksa apakah semua field sudah diisi
            if (!frame_nilai.getNimTextField().getText().trim().isEmpty()
                    && !frame_nilai.getMataKuliahComboBox().getSelectedItem().toString().equals("--Pilih Mata Kuliah--")
                    && !frame_nilai.getTugasTextField().getText().trim().isEmpty()
                    && !frame_nilai.getUtsTextField().getText().trim().isEmpty()
                    && !frame_nilai.getUasTextField().getText().trim().isEmpty()
                    && !frame_nilai.getPraktikumTextField().getText().trim().isEmpty()
                    && !frame_nilai.getNilaiAngkaTextField().getText().trim().isEmpty()
                    && !frame_nilai.getNilaiHurufTextField().getText().trim().isEmpty()) {

                // Ambil nilai dari form
                String nim = frame_nilai.getNimTextField().getText();
                String mataKuliah = (String) frame_nilai.getMataKuliahComboBox().getSelectedItem();
                float tugas = Float.parseFloat(frame_nilai.getTugasTextField().getText());
                float uts = Float.parseFloat(frame_nilai.getUtsTextField().getText());
                float uas = Float.parseFloat(frame_nilai.getUasTextField().getText());
                float praktikum = Float.parseFloat(frame_nilai.getPraktikumTextField().getText());
                float nilaiAngka = Float.parseFloat(frame_nilai.getNilaiAngkaTextField().getText());
                String nilaiHuruf = frame_nilai.getNilaiHurufTextField().getText();

                // Validasi nilai numerik
                if (tugas < 0 || tugas > 100 || uts < 0 || uts > 100 || uas < 0 || uas > 100 || praktikum < 0 || praktikum > 100 || nilaiAngka < 0 || nilaiAngka > 100) {
                    JOptionPane.showMessageDialog(frame_nilai, "Nilai harus berada di antara 0 dan 100");
                    return;
                }

                // Periksa apakah kombinasi nim dan mata kuliah sudah ada di tabel
                boolean exists = false;
                for (Model_Nilai nilai : list_nilai) {
                    if (nilai.getNim().equals(nim) && nilai.getMataKuliah().equals(mataKuliah)) {
                        exists = true;
                        break;
                    }
                }

                if (exists) {
                    // Buat objek Model_Nilai dan set nilainya
                    Model_Nilai b = new Model_Nilai();
                    b.setNim(nim);
                    b.setMataKuliah(mataKuliah);
                    b.setTugas(tugas);
                    b.setUts(uts);
                    b.setUas(uas);
                    b.setPraktikum(praktikum);
                    b.setNilaiAngka(nilaiAngka);
                    b.setNilaiHuruf(nilaiHuruf);

                    // Panggil method update dari implement_nilai
                    implement_nilai.update(b);

                    // Tampilkan pesan sukses
                    JOptionPane.showMessageDialog(null, "Data Berhasil diupdate");
                } else {
                    JOptionPane.showMessageDialog(frame_nilai, "Data dengan NIM dan Mata Kuliah ini tidak ditemukan.");
                }
            } else {
                JOptionPane.showMessageDialog(frame_nilai, "Harap lengkapi semua field");
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(frame_nilai, "Input tugas, uts, uas, praktikum, dan nilai angka harus berupa angka");
        }
    }

    // Hapus data pada tabel nilai berdasarkan nim dan matakuliah
    public void deleteByNimAndMataKuliah() {
        String nim = frame_nilai.getNimTextField().getText();
        String mataKuliah = (String) frame_nilai.getMataKuliahComboBox().getSelectedItem();

        if (!nim.isEmpty() && !mataKuliah.isEmpty()) {
            implement_nilai.deleteByNimAndMataKuliah(nim, mataKuliah);

            JOptionPane.showMessageDialog(null, "Data Berhasil dihapus");
        } else {
            JOptionPane.showMessageDialog(frame_nilai, "Pilih data yang akan dihapus !");
        }
    }

    // cari data berdasar nim
    public void isiTableCariNim() {
        String nimCari = frame_nilai.getTampilNilaiByNimTextField().getText().trim();
        list_nilai = implement_nilai.getCariNim(nimCari); // Sesuaikan dengan metode yang ada di DAO_Nilai
        Tabel_Model_Nilai tmb = new Tabel_Model_Nilai(list_nilai);
        frame_nilai.getNilaiTable().setModel(tmb);
    }

    // metode untuk melakukan pencarian berdasarkan NIM
    public void cariNim() {
        if (!frame_nilai.getTampilNilaiByNimTextField().getText().trim().isEmpty()) {
            isiTableCariNim();
        } else {
            JOptionPane.showMessageDialog(frame_nilai, "Silakan masukkan NIM untuk melakukan pencarian.");
        }
    }

    // cari data berdasar kelas dan mata kuliah
    // mengisi tabel dengan data hasil pencarian berdasarkan kelas dan mata kuliah
    public void isiTableCariKelasDanMataKuliah() {
        String kelasCari = frame_nilai.getTampilNilaiByKelasTextField().getText().trim();
        String mataKuliahCari = (String) frame_nilai.getTampilNilaiByMataKuliahComboBox().getSelectedItem();

        list_nilai = implement_nilai.getCariKelasDanMataKuliah(kelasCari, mataKuliahCari);

        Tabel_Model_Nilai tmb = new Tabel_Model_Nilai(list_nilai);
        frame_nilai.getNilaiTable().setModel(tmb);
    }

    // metode untuk melakukan pencarian berdasarkan kelas dan mata kuliah
    public void cariKelasDanMataKuliah() {
        String kelasCari = frame_nilai.getTampilNilaiByKelasTextField().getText().trim();

        System.out.println("Nilai kelasCari setelah trim: '" + kelasCari + "'");
        System.out.println("Nilai kelasCari setelah trim: '" + kelasCari + "'");
        if (!kelasCari.isEmpty()) {
            isiTableCariKelasDanMataKuliah();
        } else {
            JOptionPane.showMessageDialog(frame_nilai, "Silakan masukkan kelas untuk melakukan pencarian.");
        }
    }

    //menghitung nilaiAngka dan nilaiHuruf
    public void calculate() {
        try {
            float tugas = Float.parseFloat(frame_nilai.getTugasTextField().getText());
            float uts = Float.parseFloat(frame_nilai.getUtsTextField().getText());
            float uas = Float.parseFloat(frame_nilai.getUasTextField().getText());
            float praktikum = Float.parseFloat(frame_nilai.getPraktikumTextField().getText());

            float nilaiAngka = (float) (0.1 * tugas + 0.3 * uts + 0.3 * uas + 0.3 * praktikum);

            String nilaiHuruf;
            if (nilaiAngka >= 85) {
                nilaiHuruf = "A";
            } else if (nilaiAngka >= 80) {
                nilaiHuruf = "A-";
            } else if (nilaiAngka >= 75) {
                nilaiHuruf = "B+";
            } else if (nilaiAngka >= 70) {
                nilaiHuruf = "B";
            } else if (nilaiAngka >= 65) {
                nilaiHuruf = "C+";
            } else if (nilaiAngka >= 60) {
                nilaiHuruf = "C";
            } else if (nilaiAngka >= 55) {
                nilaiHuruf = "D+";
            } else {
                nilaiHuruf = "D";
            }

            frame_nilai.getNilaiAngkaTextField().setText(String.valueOf(nilaiAngka));
            frame_nilai.getNilaiHurufTextField().setText(nilaiHuruf);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(frame_nilai, "Masukkan angka yang valid untuk nilai.");
        }
    }

    // ekspor format csv
    public void exportTableToCSV() throws IOException {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Simpan file");

        int userSelection = fileChooser.showSaveDialog(frame_nilai);
        if (userSelection == JFileChooser.APPROVE_OPTION) {
            java.io.File fileToSave = fileChooser.getSelectedFile();
            String filePath = fileToSave.getAbsolutePath();
            if (!filePath.toLowerCase().endsWith(".csv")) {
                fileToSave = new File(filePath + ".csv");
            }

            try (FileWriter fileWriter = new FileWriter(fileToSave)) {
                fileWriter.write("Data Nilai Mahasiswa\n\n");

                JTable table = frame_nilai.getNilaiTable();
                TableModel model = table.getModel();

                for (int i = 0; i < model.getColumnCount(); i++) {
                    fileWriter.write(model.getColumnName(i) + (i < model.getColumnCount() - 1 ? "," : "\n"));
                }

                for (int i = 0; i < model.getRowCount(); i++) {
                    for (int j = 0; j < model.getColumnCount(); j++) {
                        fileWriter.write(model.getValueAt(i, j).toString() + (j < model.getColumnCount() - 1 ? "," : "\n"));
                    }
                }

                JOptionPane.showMessageDialog(frame_nilai, "Data sukses disimpan di " + fileToSave.getAbsolutePath());
            }
        }
    }

    //ekspor format pdf
    public void exportTableToPDF() throws IOException {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Simpan file");

        int userSelection = fileChooser.showSaveDialog(frame_nilai);
        if (userSelection == JFileChooser.APPROVE_OPTION) {
            java.io.File fileToSave = fileChooser.getSelectedFile();
            String filePath = fileToSave.getAbsolutePath();
            if (!filePath.toLowerCase().endsWith(".pdf")) {
                fileToSave = new File(filePath + ".pdf");
            }

            Document document = new Document();
            try {
                PdfWriter.getInstance(document, new FileOutputStream(fileToSave.getAbsolutePath()));
                document.open();

                document.add(new Paragraph("Data Nilai Mahasiswa"));

                JTable table = frame_nilai.getNilaiTable();
                TableModel model = table.getModel();

                PdfPTable pdfTable = new PdfPTable(model.getColumnCount());
                pdfTable.setWidthPercentage(100);
                pdfTable.setSpacingBefore(10f);
                pdfTable.setSpacingAfter(10f);

                for (int i = 0; i < model.getColumnCount(); i++) {
                    PdfPCell cell = new PdfPCell(new Paragraph(model.getColumnName(i)));
                    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                    pdfTable.addCell(cell);
                }

                for (int i = 0; i < model.getRowCount(); i++) {
                    for (int j = 0; j < model.getColumnCount(); j++) {
                        PdfPCell cell = new PdfPCell(new Paragraph(model.getValueAt(i, j).toString()));
                        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                        pdfTable.addCell(cell);
                    }
                }

                document.add(pdfTable);
                document.close();
                JOptionPane.showMessageDialog(frame_nilai, "Data sukses disimpan di " + fileToSave.getAbsolutePath());

            } catch (DocumentException | IOException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(frame_nilai, "Error ekspor data ke pdf: " + e.getMessage());
            }
        }
    }

}
