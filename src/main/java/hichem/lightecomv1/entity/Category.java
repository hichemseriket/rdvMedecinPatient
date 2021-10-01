package hichem.lightecomv1.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.ToString;

import javax.persistence.*;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import static javax.persistence.CascadeType.ALL;

@Entity
public class Category implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCategory;
    private String name;
    private String photo;
    private String description;
    @OneToMany(cascade=ALL,mappedBy = "category")
    @JsonIgnore
//    @ToString.Exclude
    private Collection<Product> products;
    public Category() {
    }

    public Category(Integer idCategory, String name, String photo, String description, Collection<Product> products) {
        this.idCategory = idCategory;
        this.name = name;
        this.photo = photo;
        this.description = description;
        this.products = products;
    }

    public Integer getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(Integer idCategory) {
        this.idCategory = idCategory;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Collection<Product> getProducts() {
        return products;
    }

    public void setProducts(Collection<Product> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + idCategory +
                ", name=" + name +
                ", photo='" + photo + '\'' +
                ", description=" + description +
                '}';
    }
}
