/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uas.Model;

/**
 *
 * @author Asus
 */
public class Model_Nilai {

    private Integer id;
    private String nim;
    private String nama; //dari tabel mahasiswa
    private String kelas; //dari tabel mahasiswa
    private String mataKuliah;
    private float tugas;
    private float uts;
    private float uas;
    private float praktikum;
    private float nilaiAngka;
    private String nilaiHuruf;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getKelas() {
        return kelas;
    }

    public void setKelas(String kelas) {
        this.kelas = kelas;
    }

    public String getMataKuliah() {
        return mataKuliah;
    }

    public void setMataKuliah(String mataKuliah) {
        this.mataKuliah = mataKuliah;
    }

    public float getTugas() {
        return tugas;
    }

    public void setTugas(float tugas) {
        this.tugas = tugas;
    }

    public float getUts() {
        return uts;
    }

    public void setUts(float uts) {
        this.uts = uts;
    }

    public float getUas() {
        return uas;
    }

    public void setUas(float uas) {
        this.uas = uas;
    }

    public float getPraktikum() {
        return praktikum;
    }

    public void setPraktikum(float praktikum) {
        this.praktikum = praktikum;
    }

    public float getNilaiAngka() {
        return nilaiAngka;
    }

    public void setNilaiAngka(float nilaiAngka) {
        this.nilaiAngka = nilaiAngka;
    }

    public String getNilaiHuruf() {
        return nilaiHuruf;
    }

    public void setNilaiHuruf(String nilaiHuruf) {
        this.nilaiHuruf = nilaiHuruf;
    }

}
