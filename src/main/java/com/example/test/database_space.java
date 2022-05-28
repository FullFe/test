package com.example.test;

import java.sql.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



public class database_space {
    Connection dbConnection;
    public Connection getDbConnection()
            throws SQLException, ClassNotFoundException{
        String LOGIN = "KURS";
        String  PASS = "KURS";
        String connectionStr = "jdbc:mysql://localhost:3306";
//        Class.forName("com.mysql.jdbc.Driver");
        Class.forName("com.mysql.cj.jdbc.Driver");

        dbConnection = DriverManager.getConnection(connectionStr,LOGIN,PASS);
        return dbConnection;
    }
    public ResultSet fetchFirst(){
        ResultSet resultSet = null;
        String select = "SELECT w.id_worker,w.post_worker, w.sal_worker, w.tax_worker FROM work.worker w;";

        try {
            PreparedStatement preparedStatement = getDbConnection().prepareStatement(select);
            resultSet = preparedStatement.executeQuery();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return resultSet;
    }
    public ResultSet fetchSecond(){
        ResultSet resultSet = null;
        String select = "SELECT c.id_clients,c.worker_clients, c.profit_clients FROM work.clients c;";
        try {
            PreparedStatement preparedStatement = getDbConnection().prepareStatement(select);
            resultSet = preparedStatement.executeQuery();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return resultSet;
    }
    public ResultSet fetchThird() {
        ResultSet resultSet = null;
        String select = "SELECT w.id_worker, w.sal_worker  * (1 -w.tax_worker)\n" +
                "FROM work.worker w;";
        try {
            PreparedStatement preparedStatement = getDbConnection().prepareStatement(select);
            resultSet = preparedStatement.executeQuery();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return resultSet;
    }
    public ResultSet fetchFourth(String nim) {
        Integer.valueOf(nim);
        ResultSet resultSet = null;
        String select = "SELECT c.worker_clients, SUM(c.profit_clients)\n" +
                "FROM work.clients c\n" +
                "where c.worker_clients  ='" + nim + "'";
        try {
            PreparedStatement preparedStatement = getDbConnection().prepareStatement(select);
            resultSet = preparedStatement.executeQuery();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return resultSet;
    }

    public ResultSet fetchFifth(String nim) {
        Integer.valueOf(nim);
        ResultSet resultSet = null;
        String select = "SELECT c.worker_clients, SUM(c.profit_clients) * 0.95\n" +
                "FROM work.clients c\n" +
                "where c.worker_clients  ='" + nim + "'";
        try {
            PreparedStatement preparedStatement = getDbConnection().prepareStatement(select);
            resultSet = preparedStatement.executeQuery();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return resultSet;
    }
}
