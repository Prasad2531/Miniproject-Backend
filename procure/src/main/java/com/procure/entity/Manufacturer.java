package com.procure.entity;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.List;

@Entity
@Table(name="OnlyManufacturer")
public class Manufacturer {
    @Id
    @GeneratedValue
    int id;

    public Manufacturer(int i, String tesla, String number, List<Medicine> medicines) {
    }



    public int getTotalBill() {
        return totalBill;
    }

    public void setTotalBill(int totalBill) {
        this.totalBill = totalBill;
    }

    @Column
    String manufacturerName;
    @Column
    String medicineName;
    @Column
    Date delivaryDate;
    @Column
    int quantity;

    int totalBill;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMedicineName() {
        return medicineName;
    }

    public Manufacturer(int id, String manufacturerName, String medicineName, Date delivaryDate, int quantity) {
        this.id = id;
        this.manufacturerName = manufacturerName;
        this.medicineName = medicineName;
        this.delivaryDate = delivaryDate;
        this.quantity = quantity;
    }

    public void setMedicineName(String medicineName) {
        this.medicineName = medicineName;
    }

    public Manufacturer() {
    }

    @Override
    public String toString() {
        return "Manufacturer{" +
                "Id=" + id +
                ", manufacturerName='" + manufacturerName + '\'' +
                ", medicineName='" + medicineName + '\'' +
                ", delivaryDate=" + delivaryDate +
                ", quantity=" + quantity +
                ", totalBill=" + totalBill +
                '}';
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Date getDelivaryDate() {
        return delivaryDate;
    }

    public void setDelivaryDate(Date delivaryDate) {
        this.delivaryDate = delivaryDate;
    }

    public String getManufacturerName() {
        return manufacturerName;
    }

    public void setManufacturerName(String manufacturerName) {
        this.manufacturerName = manufacturerName;
    }

}
