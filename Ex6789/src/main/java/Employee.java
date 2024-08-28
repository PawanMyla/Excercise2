package com.tcs.Ex2;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Employee {

    @Id
    private Integer id;
    private String name;
    private Integer basic;
    private Integer hra;
    private Integer da;
    private Integer deductions;

    // Constructors
    public Employee() {}

    public Employee(Integer id, String name, Integer basic, Integer hra, Integer da, Integer deductions) {
        this.id = id;
        this.name = name;
        this.basic = basic;
        this.hra = hra;
        this.da = da;
        this.deductions = deductions;
    }

    // Getters and Setters
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public Integer getBasic() {
        return basic;
    }
    public void setBasic(Integer basic) {
        this.basic = basic;
    }

    public Integer getHra() {
        return hra;
    }
    public void setHra(Integer hra) {
        this.hra = hra;
    }

    public Integer getDa() {
        return da;
    }
    public void setDa(Integer da) {
        this.da = da;
    }

    public Integer getDeductions() {
        return deductions;
    }
    public void setDeductions(Integer deductions) {
        this.deductions = deductions;
    }
}
