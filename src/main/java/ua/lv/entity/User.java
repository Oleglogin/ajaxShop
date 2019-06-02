package ua.lv.entity;


import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by User on 18.05.2019.
 */
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String username;
    private String password;
    @Transient
    private String confirmPassword;

    private Date dateOfRegistration = new Date();

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER,mappedBy = "user")
    private List<Product> products;

    public User() {
    }

    public User(String username, String password, String confirmPassword, Date dateOfRegistration, List<Product> products) {
        this.username = username;
        this.password = password;
        this.confirmPassword = confirmPassword;
        this.dateOfRegistration = dateOfRegistration;
        this.products = products;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public Date getDateOfRegistration() {
        return dateOfRegistration;
    }

    public void setDateOfRegistration(Date dateOfRegistration) {
        this.dateOfRegistration = dateOfRegistration;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
