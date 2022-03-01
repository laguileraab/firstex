package com.avangenio.firstex.Entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "SECTION")
public class Section {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Integer id;

    @Column(name = "SIZE")
    private double size;

    @Column(name = "TYPE", length = 20)
    @Enumerated(EnumType.STRING)
    private ProductType type;

    // @JoinTable(name = "section_product", joinColumns = @JoinColumn(name =
    // "section_id"), inverseJoinColumns = @JoinColumn(name = "product_id"))
    // @OneToMany(fetch = FetchType.LAZY, mappedBy = "section", cascade = {
    // CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
    //  @JoinColumn(name = "section_id")

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "section", cascade = CascadeType.ALL)
    private Set<Product> products = new HashSet<>();

    public Section() {
    }

    public Section(int id, double size, ProductType type) {
        this.id = id;
        this.size = size;
        this.type = type;
    }

    public Section(double size, ProductType type) {
        this.size = size;
        this.type = type;
    }

    public Section(double size, ProductType type, Set<Product> products) {
        this.size = size;
        this.type = type;
        this.products = products;
    }

    public Section(int id, double size, ProductType type, Set<Product> products) {
        this.id = id;
        this.size = size;
        this.type = type;
        this.products = products;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public double getSize() {
        return this.size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public ProductType getType() {
        return this.type;
    }

    public void setType(ProductType type) {
        this.type = type;
    }
    
    public Set<Product> getProducts() {
        return this.products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

}
