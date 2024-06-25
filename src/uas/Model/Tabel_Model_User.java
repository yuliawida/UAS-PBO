package uas.Model;

import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Asus
 */
public class Tabel_Model_User extends AbstractTableModel {

    java.util.List<Model_User> list_user;

    public Tabel_Model_User(java.util.List<Model_User> list_user) {
        this.list_user = list_user;
    }

    @Override
    public int getRowCount() {
        return list_user.size();
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public Object getValueAt(int row, int column) {
        switch (column) {
            case 0:
                return list_user.get(row).getUsername();
            case 1:
                return list_user.get(row).getPassword();
            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "USERNAME";
            case 1:
                return "PASSWORD";
            default:
                return null;
        }
    }
}
