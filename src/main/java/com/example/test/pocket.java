package com.example.test;

public class pocket {
    private String worker_moneys;
     private String month_moneys;
    private String group_moneys;
    pocket(String worker_moneys, String month_moneys, String group_moneys){
        this.worker_moneys = worker_moneys;
        this.month_moneys =month_moneys;
        this.group_moneys = group_moneys;
    }

    public String getWorker_moneys() {
        return worker_moneys;
    }

    public void setWorker_moneys(String worker_moneys) {
        this.worker_moneys = worker_moneys;
    }

    public String getMonth_moneys() {
        return month_moneys;
    }

    public void setMonth_moneys(String month_moneys) {
        this.month_moneys = month_moneys;
    }

    public String getGroup_moneys() {
        return group_moneys;
    }

    public void setGroup_moneys(String group_moneys) {
        this.group_moneys = group_moneys;
    }
}
