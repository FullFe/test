package com.example.test;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class HelloController extends database_space {
    @FXML
    private Button clients_table;
    @FXML
    private TableColumn col1;
    @FXML
    private TableColumn col2;
    @FXML
    private TableColumn col3;
    @FXML
    private TableColumn col4;
    @FXML
    private TextField textField;
    @FXML
    private Button moneys_table;
    @FXML
    private TableView table_view;
    @FXML
    private Button profit;



    @FXML
    private Button work_table;
    public void show_work_table() {
        work_table.setOnAction(event -> {
            table_view.setEditable(false);
           // TableColumn col1 = new TableColumn<Ally, String>("id_worker");
            //col1.setCellValueFactory(new PropertyValueFactory<Ally, String>("id_worker"));
            col1 = new TableColumn<Ally, String>("id_worker");
            col1.setCellValueFactory(new PropertyValueFactory<Ally, String>("id_worker"));
            col2 = new TableColumn<Ally, String>("post_worker");
            col2.setCellValueFactory(new PropertyValueFactory<Ally, String>("post_worker"));
            col3 = new TableColumn<Ally, String>("sal_worker");
            col3.setCellValueFactory(new PropertyValueFactory<Ally, String>("sal_worker"));
            col4 = new TableColumn<Ally, String>("tax_worker");
            col4.setCellValueFactory(new PropertyValueFactory<Ally, String>("tax_worker"));
            table_view.getColumns().addAll(col1,col2,col3,col4);




            database_space base = new database_space();
            ResultSet result = base.fetchFirst();
            ArrayList<Ally> man = new ArrayList<>();
            while (true) {
                try {
                    if (!result.next()) break;
                    Ally peo = new Ally(result.getString(1),
                            result.getString(2),
                            result.getString(3),
                            result.getString(4)
                    );
                    man.add(peo);
                    table_view.getItems().add(peo);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        });
    }
    public void WASH(){
        table_view.getColumns().clear();
        table_view.getItems().clear();
    }
    public void show_clients_table() {
        clients_table.setOnAction(event -> {
            table_view.setEditable(false);
            col1 = new TableColumn<Ally, String>("id_clients");
            col1.setCellValueFactory(new PropertyValueFactory<Ally, String>("id_clients"));
            col2 = new TableColumn<Ally, String>("worker_clients");
            col2.setCellValueFactory(new PropertyValueFactory<Ally, String>("worker_clients"));
            col3 = new TableColumn<Ally, String>("profit_clients");
            col3.setCellValueFactory(new PropertyValueFactory<Ally, String>("profit_clients"));
            table_view.getColumns().addAll(col1, col2, col3);

            database_space base = new database_space();
            ResultSet result = base.fetchSecond();
            ArrayList<Slave> man = new ArrayList<>();
            while (true) {
                try {
                    if (!result.next()) break;
                    Slave peo = new Slave(result.getString(1),
                            result.getString(2),
                            result.getString(3)
                    );
                    man.add(peo);
                    table_view.getItems().add(peo);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        });
    }
    public void check_cash(){
        moneys_table.setOnAction(event -> {
            table_view.setEditable(false);
            col1 = new TableColumn<SALARY, String>("id");
            col1.setCellValueFactory(new PropertyValueFactory<SALARY,String>("id"));
            col2 = new TableColumn<SALARY, Integer>("salaryM");
            col2.setCellValueFactory(new PropertyValueFactory<SALARY,Integer>("salaryM"));
            col3 =  new TableColumn<SALARY, Integer>("salaryY");
            col3.setCellValueFactory(new PropertyValueFactory<SALARY,Integer>("salaryY"));
            table_view.getColumns().addAll(col1, col2, col3);
            database_space base = new database_space();
            ResultSet result = base.fetchThird();
            ArrayList<SALARY> man = new ArrayList<>();
            while (true) {
                try {
                    if (!result.next()) break;
                    SALARY salary = new SALARY(result.getString(1),
                            result.getInt(2)
                    );
                    man.add(salary);
                    table_view.getItems().add(salary);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            for (int i = 0; i<man.size();i++){
                System.out.print(man.get(i).toString());
            }
        });
    }

    public void setProfit(){
        profit.setOnAction(event -> {
            table_view.setEditable(false);
            col1 = new TableColumn<SALARY, String>("id");
            col1.setCellValueFactory(new PropertyValueFactory<SALARY,String>("id"));
            col2 = new TableColumn<SALARY, Integer>("sum");
            col2.setCellValueFactory(new PropertyValueFactory<SALARY,Integer>("sum"));
            table_view.getColumns().addAll(col1, col2);

            database_space base = new database_space();
            ResultSet result = base.fetchFourth( textField.getText().trim());
            textField.clear();
            ArrayList<PROFIT> man = new ArrayList<>();
            while (true) {
                try {
                    if (!result.next()) break;
                    PROFIT profit1 = new PROFIT(result.getString(1),
                            result.getString(2)
                    );
                    man.add(profit1);
                    table_view.getItems().add(profit1);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            for (int i = 0; i<man.size();i++){
                System.out.print(man.get(i));
            }
        });
    }
}



