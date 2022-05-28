package com.example.test;

public class Slave {
    private String id_clients;
    private String worker_clients;
    private String profit_clients;
    public Slave(String id_clients, String worker_clients, String profit_clients){
        this.id_clients = id_clients;
        this.worker_clients = worker_clients;
        this.profit_clients = profit_clients;
    }

    public String getId_clients() {
        return id_clients;
    }

    public void setId_clients(String id_clients) {
        this.id_clients = id_clients;
    }

    public String getWorker_clients() {
        return worker_clients;
    }

    public void setWorker_clients(String worker_clients) {
        this.worker_clients = worker_clients;
    }

    public String getProfit_clients() {
        return profit_clients;
    }

    public void setProfit_clients(String profit_clients) {
        this.profit_clients = profit_clients;
    }
}
