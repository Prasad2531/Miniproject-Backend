package com.procure.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.Range;

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

    @NotBlank(message = "Manufacture Name is Mandatory")
    @Size(min = 3, message = "Manufacture Name should have at least 3 characters")
    String manufacturerName;

    @NotBlank(message = "Medicine Name is Mandatory")
    @Size(min = 3, message = "Medicine Name should have at least 3 characters")
    String medicineName;

    @NotNull(message = "Delivery Date is Mandatory")
    @Future(message = "Delivery Date must be in the future and date format")
    Date delivaryDate;

    @Range(min = 1, message= "Quantity may not be empty or null")
    @Positive(message = "Value must be greater than 0")
    int quantity;

    @Range(min = 1, message= "Total Bill may not be empty or null")
    @Positive(message = "Value must be greater than 0")
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
