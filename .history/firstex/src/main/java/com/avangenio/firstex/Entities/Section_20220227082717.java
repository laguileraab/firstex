package com.avangenio.firstex.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "SECTION")
public class Section {

    @Id
    @Column(name = "ID")
    private int id;
    @Column(name = "SIZE")
    private double size;
    @Column(name = "TYPE")
    private String type;

    public Section(){}

    public Section(int id, double size,String type){
        this.id=id;
        this.size=size;
        this.type=type;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getSize() {
        return this.size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
