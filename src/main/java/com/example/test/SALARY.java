package com.example.test;

public class SALARY {
    private String id;
    private Integer salaryM;
    private Integer salaryY;
    public SALARY(String str1, Integer str2) {
        this.id = str1;
        this.salaryM = str2;
        this.salaryY = str2 * 12;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getSalaryM() {
        return salaryM;
    }

    public void setSalaryM(Integer salaryM) {
        this.salaryM = salaryM;
    }

    public Integer getSalaryY() {
        return salaryY;
    }

    public void setSalaryY(Integer salaryY) {
        this.salaryY = salaryY;
    }

    @Override
    public String toString() {
        return
                id  + " " + salaryM + " "+salaryY + " " ;
    }
}
