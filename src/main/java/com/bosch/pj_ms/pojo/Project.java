package com.bosch.pj_ms.pojo;

import java.sql.Date;

public class Project {
    private Integer pj_id;
    private String mcr_id;
    private String pj_name;
    private String pj_des;
    private Date pj_date;

    public Integer getPj_id() {
        return pj_id;
    }

    public void setPj_id(Integer pj_id) {
        this.pj_id = pj_id;
    }

    public String getMcr_id() {
        return mcr_id;
    }

    public void setMcr_id(String mcr_id) {
        this.mcr_id = mcr_id;
    }

    public String getPj_name() {
        return pj_name;
    }

    public void setPj_name(String pj_name) {
        this.pj_name = pj_name;
    }

    public String getPj_des() {
        return pj_des;
    }

    public void setPj_des(String pj_des) {
        this.pj_des = pj_des;
    }

    public Date getPj_date() {
        return pj_date;
    }

    public void setPj_date(Date pj_date) {
        this.pj_date = pj_date;
    }
}
