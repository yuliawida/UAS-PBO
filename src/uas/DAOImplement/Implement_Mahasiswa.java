/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package uas.DAOImplement;

import java.util.List;
import uas.Model.Model_Mahasiswa;

/**
 *
 * @author Asus
 */
public interface Implement_Mahasiswa {
    public void insert(Model_Mahasiswa b);
    
    public void update(Model_Mahasiswa b);
    
    public void delete(String nim);
    
    public java.util.List<Model_Mahasiswa> getALL();
    
    public java.util.List<Model_Mahasiswa> getNimKelas();
    
    public java.util.List<Model_Mahasiswa> getCariNim(String nim);
    
    public java.util.List<Model_Mahasiswa> getCariKelas(String kelas);
}
