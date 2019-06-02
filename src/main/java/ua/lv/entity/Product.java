package ua.lv.entity;

import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.io.File;
import java.io.IOException;
import java.util.Date;

/**
 * Created by User on 18.05.2019.
 */
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String productBrand;
    private String productModel;
    private String category;
    private String subCategory;
    private String productImg;
    private int price;
    private boolean available;
    @Column(columnDefinition = "text")
    private String description;
    private Date dateOfSave = new Date();
    private int countLike;

    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    private User user;

    public Product() {
    }

    public Product(String productBrand, String productModel, String category, String subCategory, String productImg, int price, boolean available, String description) {
        this.productBrand = productBrand;
        this.productModel = productModel;
        this.category = category;
        this.subCategory = subCategory;
        this.productImg = productImg;
        this.price = price;
        this.available = available;
        this.description = description;
    }

    public Product(String productBrand, String productModel, String category, String subCategory, String productImg, int price, boolean available, String description, Date dateOfSave, int countLike, User user) {
        this.productBrand = productBrand;
        this.productModel = productModel;
        this.category = category;
        this.subCategory = subCategory;
        this.productImg = productImg;
        this.price = price;
        this.available = available;
        this.description = description;
        this.dateOfSave = dateOfSave;
        this.countLike = countLike;
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductBrand() {
        return productBrand;
    }

    public void setProductBrand(String productBrand) {
        this.productBrand = productBrand;
    }

    public String getProductModel() {
        return productModel;
    }

    public void setProductModel(String productModel) {
        this.productModel = productModel;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getSubCategory() {
        return subCategory;
    }

    public void setSubCategory(String subCategory) {
        this.subCategory = subCategory;
    }

    public String getProductImg() {
        return productImg;
    }

    public void setProductImg(MultipartFile multipartFile) {
        String path = System.getProperty("user.home") + File.separator + "Pictures\\";
        try {
            multipartFile.transferTo(new File(path + multipartFile.getOriginalFilename()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.productImg = "\\workImg\\" + multipartFile.getOriginalFilename();
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDateOfSave() {
        return dateOfSave;
    }

    public void setDateOfSave(Date dateOfSave) {
        this.dateOfSave = dateOfSave;
    }

    public int getCountLike() {
        return countLike;
    }

    public void setCountLike(int countLike) {
        this.countLike = countLike;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
