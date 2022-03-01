package com.avangenio.firstex.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "PRODUCT")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Integer id;
    @Column(name = "SIZE")
    private double size;
    @Column(name = "COLOR")
    private String color;
    @Column(name = "PRICE")
    private double price;
    @Column(name = "FRAGILE")
    private boolean fragile;
    @Column(name = "ENVELOP", length = 20)
    @Enumerated(EnumType.STRING)
    private EnvelopType envelop;
    @Column(name = "LOT")
    private String lot;
    @Column(name = "QUANTITY")
    private int quantity;
    
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "section_id", nullable = false)
    private Section section;

    public Product() {
    }

    public Product(int id, double size, String color, double price, boolean fragile, EnvelopType envelop, String lot,
            int quantity) {
        this.id = id;
        this.size = size;
        this.color = color;
        this.price = price;
        this.fragile = fragile;
        this.envelop = envelop;
        this.lot = lot;
        this.quantity = quantity;
    }

    public Product(double size, String color, double price, boolean fragile, EnvelopType envelop, String lot,
            int quantity) {
        this.size = size;
        this.color = color;
        this.price = price;
        this.fragile = fragile;
        this.envelop = envelop;
        this.lot = lot;
        this.quantity = quantity;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public boolean getFragile() {
        return this.fragile;
    }

    public void setFragile(boolean fragile) {
        this.fragile = fragile;
    }

    public double getSize() {
        return this.size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public String getColor() {
        return this.color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isFragile() {
        return this.fragile;
    }

    public EnvelopType getEnvelop() {
        return this.envelop;
    }

    public void setEnvelop(EnvelopType envelop) {
        this.envelop = envelop;
    }

    public String getLot() {
        return this.lot;
    }

    public void setLot(String lot) {
        this.lot = lot;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Section getSection() {
        return this.section;
    }

    public void setSection(Section section) {
        this.section = section;
    }

}
