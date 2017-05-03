package com.example.domain;

import org.mongodb.morphia.annotations.Id;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

public class Tender {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @Column(name = "investDays")
    private Integer investdays;

    private String view;

    private Integer status;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * @return investDays
     */
    public Integer getInvestdays() {
        return investdays;
    }

    /**
     * @param investdays
     */
    public void setInvestdays(Integer investdays) {
        this.investdays = investdays;
    }

    /**
     * @return view
     */
    public String getView() {
        return view;
    }

    /**
     * @param view
     */
    public void setView(String view) {
        this.view = view == null ? null : view.trim();
    }

    /**
     * @return status
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * @param status
     */
    public void setStatus(Integer status) {
        this.status = status;
    }


    @Override
    public String toString() {
        return "Tender{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", investdays=" + investdays +
                ", view='" + view + '\'' +
                ", status=" + status +
                '}';
    }
}