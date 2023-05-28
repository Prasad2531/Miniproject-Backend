package com.sale.entity;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Builder;
import org.hibernate.validator.constraints.Range;


/**
 * This class represents a Sales entity which contains information about sales such as sales id, date, list of customers, total cost,
 * created by, modified by, created timestamp, and modified timestamp.
 */
@Entity
@Table(name="Sales")
@Builder
public class Sales {
    @Id
    @GeneratedValue
    int saleId;

    @Column
    @NotBlank(message = "Medicine name is Mandatory")
    @Size(min = 3, message = "Medicine name should have at least 3 characters")
    @Size(max = 20, message = "Medicine name should not have more than 20 characters")
    String medicineName;

    @Column
    @Range(min = 1, message= "Quantity may not be empty or null")
    @Positive(message = "Value must be greater than 0")
    int medicineQunatity;

    @Column
    @NotNull(message = "Price is Mandatory")
    @Positive(message = "Value must be greater than 0")
    int price;

    @Override
    public String toString() {
        return "Sales{" +
                "saleId=" + saleId +
                ", medicineName='" + medicineName + '\'' +
                ", medicineQunatity=" + medicineQunatity +
                ", price=" + price +
                ", date=" + date +
                '}';
    }

    public Sales() {
    }

    @Column

    Date date;

    public Sales(int saleId, String medicineName, int medicineQunatity, int price, Date date) {
        this.saleId = saleId;
        this.medicineName = medicineName;
        this.medicineQunatity = medicineQunatity;
        this.price = price;
        this.date = date;
    }

    public int getSaleId() {
        return saleId;
    }

    public void setSaleId(int saleId) {
        this.saleId = saleId;
    }

    public String getMedicineName() {
        return medicineName;
    }

    public void setMedicineName(String medicineName) {
        this.medicineName = medicineName;
    }

    public int getMedicineQunatity() {
        return medicineQunatity;
    }

    public void setMedicineQunatity(int medicineQunatity) {
        this.medicineQunatity = medicineQunatity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}

