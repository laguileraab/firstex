package com.avangenio.firstex.Entities;


import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import org.hibernate.validator.constraints.UniqueElements;

@Entity
@Table(name = "SECTION")
public class Section {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "SIZE")
    private double size;

    @Column(name = "TYPE", length = 20, unique = true)
    @Enumerated(EnumType.STRING)
    private ProductType type;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "section_product", joinColumns = @JoinColumn(name = "section_id"), inverseJoinColumns = @JoinColumn(name = "product_id"))
    private Set<Product> products = new HashSet<>();

    public Section(){}

    public Section(int id, double size,ProductType type){
        this.id=id;
        this.size=size;
        this.type=type;
    }

    public Section(double size,ProductType type){
        this.size=size;
        this.type=type;
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
