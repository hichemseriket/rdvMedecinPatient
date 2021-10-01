package hichem.lightecomv1.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
public class Product implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProduct;
    private String name;
    private String description;
    private double currentPrice;
    private boolean promotion;
    private boolean selected;
    private boolean available;
    private String photoName;
    @Transient
    private int quantity=1;
    @ManyToOne
    private  Category category;
//    @ManyToMany(mappedBy = "product")
//    @JsonIgnore
//    private List<Client> clients;

    public Product() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Category category = (Category) o;
        return Objects.equals(idProduct, category.getIdCategory());
    }

    public Product(Long idProduct, String name, String description, double currentPrice, boolean promotion, boolean selected, boolean available, String photoName, int quantity, Category category) {
        this.idProduct = idProduct;
        this.name = name;
        this.description = description;
        this.currentPrice = currentPrice;
        this.promotion = promotion;
        this.selected = selected;
        this.available = available;
        this.photoName = photoName;
        this.quantity = quantity;
        this.category = category;
    }

    public Long getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(Long idProduct) {
        this.idProduct = idProduct;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(double currentPrice) {
        this.currentPrice = currentPrice;
    }

    public boolean isPromotion() {
        return promotion;
    }

    public void setPromotion(boolean promotion) {
        this.promotion = promotion;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public String getPhotoName() {
        return photoName;
    }

    public void setPhotoName(String photoName) {
        this.photoName = photoName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Product{" +
                "idProduct=" + idProduct +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", currentPrice=" + currentPrice +
                ", promotion=" + promotion +
                ", selected=" + selected +
                ", available=" + available +
                ", photoName='" + photoName + '\'' +
                ", quantity=" + quantity +
                ", category=" + category +
                '}';
    }
}