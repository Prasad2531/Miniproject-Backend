package com.procure.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.Range;

import java.math.BigDecimal;
import java.sql.Date;

@Entity
@Table(name="Procure")
public class Procure {

    @Id
//    @Range(min = 1, message= "Medicine Id may not be empty or null")
//    @Positive(message = "Value must be greater than 0")
    private int medicineId;

//    @Column(name = "medicineName")
//    @NotBlank(message = "Medicine name is Mandatory")
//    @Size(min = 3, message = "Medicine name should have at least 3 characters")
//    @Size(max = 20, message = "Medicine name should not have more than 20 characters")
    private String medicineName;

//    @Column(name = "description")
//    @NotBlank(message = "Description is Mandatory")
//    @Size(min = 3, message = "Description should have at least 3 characters")
    private String description;

//    @Column(name = "dosage")
//    @NotBlank(message = "Dosage is Mandatory")
//    @Size(min = 3, message = "Dosage should have at least 3 characters")
    private String dosage;

//    @Column(name = "price")
//    @NotNull(message = "Price is Mandatory")
//    @Positive(message = "Value must be greater than 0")
//    @Digits(integer = 4, fraction = 2, message = "The field must be a number with up to 4 digits before and 2 digits after the decimal point")
    private BigDecimal price;

//    @Column(name = "manufactureDate")
//    @NotNull(message = "Manufacture Date is Mandatory")
//    @Past(message = "Manufacture Date must be in the past and date format")
    private Date manufactureDate;

//    @Column(name = "expiryDate")
//    @NotNull(message = "Expiry Date is Mandatory")
//    @Future(message = "Expiry Date must be in the future and date format")
    private Date expiryDate;

//    @Column(name = "currentStock")
//    @Range(min = 1, message= "Current Stock may not be empty or null")
//    @Positive(message = "Value must be greater than 0")
    private int currentStock;

    public Procure() {
    }

    public Procure(int medicineId, String medicineName, String description, String dosage, BigDecimal price, Date manufactureDate, Date expiryDate, int currentStock) {
        this.medicineId = medicineId;
        this.medicineName = medicineName;
        this.description = description;
        this.dosage = dosage;
        this.price = price;
        this.manufactureDate = manufactureDate;
        this.expiryDate = expiryDate;
        this.currentStock = currentStock;
    }

    public int getMedicineId() {
        return medicineId;
    }

    public void setMedicineId(int medicineId) {
        this.medicineId = medicineId;
    }

    public String getMedicineName() {
        return medicineName;
    }

    public void setMedicineName(String medicineName) {
        this.medicineName = medicineName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDosage() {
        return dosage;
    }

    public void setDosage(String dosage) {
        this.dosage = dosage;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Date getManufactureDate() {
        return manufactureDate;
    }

    public void setManufactureDate(Date manufactureDate) {
        this.manufactureDate = manufactureDate;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }

    public int getCurrentStock() {
        return currentStock;
    }

    public void setCurrentStock(int currentStock) {
        this.currentStock = currentStock;
    }

    @Override
    public String toString() {
        return "Procure{" +
                "medicineId=" + medicineId +
                ", medicineName='" + medicineName + '\'' +
                ", description='" + description + '\'' +
                ", dosage='" + dosage + '\'' +
                ", price=" + price +
                ", manufactureDate=" + manufactureDate +
                ", expiryDate=" + expiryDate +
                ", currentStock=" + currentStock +
                '}';
    }
}
