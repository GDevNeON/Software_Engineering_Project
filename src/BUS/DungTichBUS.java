/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DTO.DungTichDTO;
import DAO.DungTichDAO;
import java.util.ArrayList;

public class DungTichBUS {

    public final DungTichDAO dtDAO = new DungTichDAO();
    private ArrayList<DungTichDTO> listDT = new ArrayList<DungTichDTO>();

    public DungTichBUS() {
        listDT = dtDAO.selectAll();
    }

    public ArrayList<DungTichDTO> getAll() {
        return this.listDT;
    }

    public DungTichDTO getByIndex(int index) {
        return this.listDT.get(index);
    }

    public int getIndexByMaLH(int ma) {
        int i = 0;
        int vitri = -1;
        while (i < this.listDT.size() && vitri == -1) {
            if (listDT.get(i).getMadungtich() == ma) {
                vitri = i;
            } else {
                i++;
            }
        }
        return vitri;
    }

    public Boolean add(DungTichDTO lsp) {
        boolean check = dtDAO.insert(lsp) != 0;
        if (check) {
            this.listDT.add(lsp);
        }
        return check;
    }

    public Boolean delete(DungTichDTO lh) {
        boolean check = dtDAO.delete(lh) != 0;
        if (check) {
            this.listDT.remove(lh);
        }
        return check;
    }

    public Boolean update(DungTichDTO lsp) {
        boolean check = dtDAO.update(lsp) != 0;
        if (check) {
            this.listDT.set(getIndexByMaLH(lsp.getMadungtich()), lsp);
        }
        return check;
    }

    public ArrayList<DungTichDTO> search(String text) {
        text = text.toLowerCase();
        ArrayList<DungTichDTO> result = new ArrayList<>();
        for (DungTichDTO i : this.listDT) {
            if (Integer.toString(i.getMadungtich()).toLowerCase().contains(text) || i.getTendungtich().toLowerCase().contains(text)) {
                result.add(i);
            }
        }
        return result;
    }

    public String[] getArrTenLoai() {
        int size = listDT.size();
        String[] result = new String[size];
        for (int i = 0; i < size; i++) {
            result[i] = listDT.get(i).getTendungtich();
        }
        return result;
    }

    public String getTenLoai(int maloai) {
        return this.listDT.get(this.getIndexByMaLH(maloai)).getTendungtich();
    }

    public boolean checkDup(String name) {
        boolean check = true;
        int i = 0;
        while (i <= this.listDT.size() && check == true) {
            if (this.listDT.get(i).getTendungtich().toLowerCase().contains(name.toLowerCase())) {
                check = false;
            } else {
                i++;
            }
        }
        return check;
    }
}
