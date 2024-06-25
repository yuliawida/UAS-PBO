package uas.Controller;

import java.awt.BorderLayout;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import javax.swing.*;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import uas.DAO.DAO_Nilai;
import uas.DAOImplement.Implement_Nilai;
import uas.Model.Model_Nilai;
import uas.View.View_Transkrip;

public class Controller_Transkrip {

    private View_Transkrip frame_transkrip;
    private Implement_Nilai implement_nilai;
    private List<Model_Nilai> list_nilai;

    public Controller_Transkrip(View_Transkrip frame_transkrip) {
        this.frame_transkrip = frame_transkrip;
        this.implement_nilai = new DAO_Nilai();
        this.list_nilai = implement_nilai.getALL();
    }

    // Method untuk mengisi TextArea berdasarkan NIM
    public void isiTextAreaCariNim() {
        String nimCari = frame_transkrip.getCariNimTextField().getText().trim();
        list_nilai = implement_nilai.getCariNim(nimCari);

        // Membangun string hasil untuk JTextArea
        StringBuilder hasil = new StringBuilder();
        hasil.append("<html><body style='font-family: Verdana;'>");
        hasil.append("<div style='text-align:center; font-weight:bold; font-size:14pt;'>Politeknik Statistika STIS</div>");
        hasil.append("<div style='font-weight:bold;'>IDENTITAS</div><br>");
        hasil.append("<div>Nomor Induk Mahasiswa \t: ").append(nimCari).append("</div>");

        if (!list_nilai.isEmpty()) {
            Model_Nilai firstEntry = list_nilai.get(0);
            hasil.append("<div>Nama Mahasiswa    : ").append(firstEntry.getNama()).append("</div><br>");
        }

        hasil.append("<div style='font-weight:bold;'>DATA NILAI</div><br>");
        hasil.append("<table style='width:100%; border-collapse:collapse;' border='1'>");
        hasil.append("<tr><th>Mata Kuliah</th> <th>Tugas</th> <th>UTS</th> <th>UAS</th> <th>Praktikum</th> <th>Nilai Angka</th> <th>Nilai Huruf</th></tr>");

        float totalMarks = 0;
        int count = 0;
        for (Model_Nilai nilai : list_nilai) {
            hasil.append("<tr>")
                    .append("<td>").append(nilai.getMataKuliah()).append("</td>")
                    .append("<td>").append(nilai.getTugas()).append("</td>")
                    .append("<td>").append(nilai.getUts()).append("</td>")
                    .append("<td>").append(nilai.getUas()).append("</td>")
                    .append("<td>").append(nilai.getPraktikum()).append("</td>")
                    .append("<td>").append(nilai.getNilaiAngka()).append("</td>")
                    .append("<td>").append(nilai.getNilaiHuruf()).append("</td>")
                    .append("</tr>");
            totalMarks += (nilai.getNilaiAngka() / 20) - 1;
            count++;
        }

        float averageMarks = count > 0 ? (3 * totalMarks) / (3 * count) : 0; // 1 matkul dianggap 3 sks

        hasil.append("</table>");
        hasil.append("<br>");
        hasil.append("<div>Total SKS       : ").append(3 * count).append("</div>");
        hasil.append("<div>IP              : ").append(String.format("%.2f", averageMarks)).append("</div>");

        hasil.append("</body></html>");

        // Menggunakan JEditorPane untuk menampilkan HTML
        JEditorPane editorPane = new JEditorPane();
        editorPane.setContentType("text/html");
        editorPane.setEditable(false);
        editorPane.setText(hasil.toString());

        // Menambahkan editorPane ke JScrollPane
        JScrollPane scrollPane = new JScrollPane(editorPane);
        frame_transkrip.getTranskripTextArea().setText("");
        frame_transkrip.getTranskripTextArea().setLayout(new BorderLayout());
        frame_transkrip.getTranskripTextArea().add(scrollPane, BorderLayout.CENTER);
        frame_transkrip.getTranskripTextArea().revalidate();
    }

    // Method untuk melakukan pencarian berdasarkan NIM
    public void cariNim() {
        if (!frame_transkrip.getCariNimTextField().getText().trim().isEmpty()) {
            isiTextAreaCariNim();
        } else {
            JOptionPane.showMessageDialog(frame_transkrip, "Silakan masukkan NIM.");
        }
    }

    // Metode untuk mengekspor ke file PDF
    public void exportToPDF() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Specify a file to save");

        int userSelection = fileChooser.showSaveDialog(frame_transkrip);
        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File fileToSave = fileChooser.getSelectedFile();
            String filePath = fileToSave.getAbsolutePath();
            if (!filePath.toLowerCase().endsWith(".pdf")) {
                fileToSave = new File(filePath + ".pdf");
            }
            
            Document document = new Document();
            //dan seterusnya
            try {
                PdfWriter.getInstance(document, new FileOutputStream(fileToSave));
                document.open();

                // Tambahkan judul
                Paragraph title = new Paragraph("Politeknik Statistika STIS\n\n");
                title.setAlignment(Element.ALIGN_CENTER);
                document.add(title);

                if (!list_nilai.isEmpty()) {
                    Model_Nilai firstEntry = list_nilai.get(0);
                    document.add(new Paragraph("Nomor Induk Mahasiswa: " + firstEntry.getNim()));
                    document.add(new Paragraph("Nama Mahasiswa: " + firstEntry.getNama() + "\n\n"));
                }

                // Buat tabel untuk data nilai
                PdfPTable table = new PdfPTable(7);
                table.setWidthPercentage(100);
                table.setSpacingBefore(10f);
                table.setSpacingAfter(10f);

                float[] columnWidths = {1.5f, 1f, 1f, 1f, 1f, 1f, 1f};
                table.setWidths(columnWidths);

                table.addCell(new PdfPCell(new Phrase("Mata Kuliah")));
                table.addCell(new PdfPCell(new Phrase("Tugas")));
                table.addCell(new PdfPCell(new Phrase("UTS")));
                table.addCell(new PdfPCell(new Phrase("UAS")));
                table.addCell(new PdfPCell(new Phrase("Praktikum")));
                table.addCell(new PdfPCell(new Phrase("Nilai Angka")));
                table.addCell(new PdfPCell(new Phrase("Nilai Huruf")));

                for (Model_Nilai nilai : list_nilai) {
                    table.addCell(nilai.getMataKuliah());
                    table.addCell(String.valueOf(nilai.getTugas()));
                    table.addCell(String.valueOf(nilai.getUts()));
                    table.addCell(String.valueOf(nilai.getUas()));
                    table.addCell(String.valueOf(nilai.getPraktikum()));
                    table.addCell(String.valueOf(nilai.getNilaiAngka()));
                    table.addCell(nilai.getNilaiHuruf());
                }

                document.add(table);

                float totalMarks = 0;
                int count = 0;
                for (Model_Nilai nilai : list_nilai) {
                    totalMarks += (nilai.getNilaiAngka() / 20) - 1;
                    count++;
                }
                float averageMarks = count > 0 ? (3 * totalMarks) / (3 * count) : 0; // 1 matkul dianggap 3 sks

                document.add(new Paragraph("\nTotal SKS: " + (3 * count)));
                document.add(new Paragraph("IP: " + String.format("%.2f", averageMarks)));

                JOptionPane.showMessageDialog(frame_transkrip, "Data sukses disimpan di " + fileToSave.getAbsolutePath());
            } catch (DocumentException | IOException e) {
                JOptionPane.showMessageDialog(frame_transkrip, "Error ekspor data ke pdf : " + e.getMessage());
            } finally {
                document.close();
            }
        }
    }
}
