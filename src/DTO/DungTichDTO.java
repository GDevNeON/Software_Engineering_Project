/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author ASUS
 */
public class DungTichDTO {

    private int madungtich;
    private String tendungtich;
    private int trangthai;

    public DungTichDTO() {
    }

    public DungTichDTO(int madungtich, String tendungtich, int trangthai) {
        this.madungtich = madungtich;
        this.tendungtich = tendungtich;
        this.trangthai = trangthai;
    }

    public DungTichDTO(int madungtich, String tendungtich) {
        this.madungtich = madungtich;
        this.tendungtich = tendungtich;
    }

    public void setMadungtich(int madungtich) {
        this.madungtich = madungtich;
    }

    public String getTendungtich() {
        return tendungtich;
    }

    public void setTendungtich(String tendungtich) {
        this.tendungtich = tendungtich;
    }

    public int getMadungtich() {
        return madungtich;
    }

    public int getTrangthai() {
        return trangthai;
    }

    public void setTrangthai(int trangthai) {
        this.trangthai = trangthai;
    }

    @Override
    public String toString() {
        return "DungTichDTO{" + "madungtich=" + madungtich + ", tendungtich=" + tendungtich + '}';
    }
    
}