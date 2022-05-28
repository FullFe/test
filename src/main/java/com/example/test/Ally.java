package com.example.test;

public class Ally {
    private String id_worker;
    private String post_worker;
    private String sal_worker;
    private String tax_worker;


    public Ally(String id_worker, String post_worker, String sal_worker, String tax_worker) {
        this.id_worker = id_worker;
        this.post_worker = post_worker;
        this.sal_worker = sal_worker;
        this.tax_worker = tax_worker;
    }

    public void setPost_worker(String post_worker) {
        this.post_worker = post_worker;
    }

    public String getPost_worker() {
        return post_worker;
    }

    public void setId_worker(String id_worker) {
        this.id_worker = id_worker;
    }

    public String getId_worker() {
        return id_worker;
    }

    public void setSal_worker(String sal_worker) {
        this.sal_worker = sal_worker;
    }

    public String getSal_worker() {
        return sal_worker;
    }

    public String getTax_worker() {
        return tax_worker;
    }

    public void setTax_worker(String tax_worker) {
        this.tax_worker = tax_worker;
    }

    @Override
    public String toString() {
        return id_worker + " " + post_worker + " " + sal_worker + tax_worker + '\n';
    }


}


