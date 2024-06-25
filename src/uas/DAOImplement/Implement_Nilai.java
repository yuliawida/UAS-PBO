/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package uas.DAOImplement;

import uas.Model.Model_Nilai;

/**
 *
 * @author Asus
 */
public interface Implement_Nilai {

    public void insert(Model_Nilai b);

    public void update(Model_Nilai b);

    public void deleteByNimAndMataKuliah(String nim, String mataKuliah);

    public java.util.List<Model_Nilai> getALL();

    public java.util.List<Model_Nilai> getCariNim(String nim);

    public java.util.List<Model_Nilai> getCariKelasDanMataKuliah(String kelas, String mataKuliah);

}
