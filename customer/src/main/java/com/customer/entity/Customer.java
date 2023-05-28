package com.customer.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Builder;
import org.hibernate.validator.constraints.Range;

import java.sql.Date;
import java.util.List;

/**
 * The Customer class represents a customer entity in the system.
 * It includes information such as the customer's name, contact information, email, medicine prescriptions,
 * date of birth, and timestamps for creation and modification.
 */
@Entity
@Table(name="Customer")
@Builder
public class Customer {

    @Id
    @Range(min = 1, message= "Customer Id may not be empty or null")
    @Positive(message = "Value must be greater than 0")
    int customerId;

    @Column
    @NotBlank(message = "Customer Name is Mandatory")
    @Size(min = 3, message = "Customer Name should have at least 3 characters")
    @Size(max = 30, message = "Customer Name should not have more than 30 characters")
    @Pattern(regexp = "^[^0-9]*$", message = "Customer Name only contain character")
    String customerName;

    @Column
    @NotBlank(message = "Contact is Mandatory")
    @Size(min = 7, message = "Contact should have at least 3 characters")
    @Size(max = 12, message = "Contact should not have more than 12 characters")
    @Pattern(regexp = "^[0-9]+$", message = "Contact must contain only integer")
    String contact;

    @Column
    @NotNull(message = "Buying Date is Mandatory")
    @Past(message = "Buying Date must be in the past and date format")
    Date buyingDate;

    @Column
    @Range(min = 1, message= "Medicine Id may not be empty or null")
    @Positive(message = "Value must be greater than 0")
    int medicineId;

    @Column
    @NotBlank(message = "Medicine Name is Mandatory")
    @Size(min = 3, message = "Medicine Name should have at least 3 characters")
    @Size(max = 30, message = "Medicine Name should not have more than 30 characters")
    @Pattern(regexp = "^[^0-9]*$", message = "Medicine Name only contain character")
    String medicineName;

    @Column
    @Range(min = 1, message= "Quantity may not be empty or null")
    @Positive(message = "Value must be greater than 0")
    int quantity;

    @Column
    @Range(min = 1, message= "Price may not be empty or null")
    @Positive(message = "Value must be greater than 0")
    int price;

    public Customer() {
    }

    public Customer(int customerId, String customerName, String contact, Date buyingDate, int medicineId, String medicineName, int quantity, int price) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.contact = contact;
        this.buyingDate = buyingDate;
        this.medicineId = medicineId;
        this.medicineName = medicineName;
        this.quantity = quantity;
        this.price = price;
    }

    @Override
    public String toString() {
        return "CustomerEntity{" +
                "customerId=" + customerId +
                ", customerName='" + customerName + '\'' +
                ", contact='" + contact + '\'' +
                ", buyingDate=" + buyingDate +
                ", medicineId=" + medicineId +
                ", medicineName='" + medicineName + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                '}';
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public Date getBuyingDate() {
        return buyingDate;
    }

    public void setBuyingDate(Date buyingDate) {
        this.buyingDate = buyingDate;
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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}

