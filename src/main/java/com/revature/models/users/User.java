package com.revature.models.users;

import com.revature.models.items.OrderList;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users", uniqueConstraints = @UniqueConstraint(columnNames = {"username", "email"}))
public class User extends AnonymousUser {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id", insertable = false, updatable = false)
    private Integer id;

    @Column(name = "username", unique = true, nullable = false)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "email", unique = true, nullable = false)
    private String email;

    @Column(name = "lab_name", nullable = false)
    private String labName;

    @Column(name = "contact_name", nullable = false)
    private String contactName;

    @Column(name = "is_manager", nullable = false )
    private Boolean isManager = false;
    @Column(name = "shipping_address")
    private String shippingAddress;

    @Column(name = "payment_info")
    private String paymentInfo;


    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<OrderList> history;

    public User() {
        history = new ArrayList<>();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLabName() {
        return labName;
    }

    public void setLabName(String labName) {
        this.labName = labName;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(String shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public String getPaymentInfo() {
        return paymentInfo;
    }

    public void setPaymentInfo(String paymentInfo) {
        this.paymentInfo = paymentInfo;
    }

    public List<OrderList> getHistory() {
        return history;
    }

    public void setHistory(List<OrderList> history) {
        this.history = history;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", labName='" + labName + '\'' +
                ", contactName='" + contactName + '\'' +
                ", shippingAddress='" + shippingAddress + '\'' +
                ", paymentInfo='" + paymentInfo + '\'' +
                ", history=" + history +
                '}';
    }
}
