package com.example.test;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

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
        clients_table.setOnAction(event -> {
            table_view.setEditable(false);
            TableColumn tableColumn1 = new TableColumn<pocket, String>("CPU");
            tableColumn1.setCellValueFactory(new PropertyValueFactory<pocket,String>("CPU"));
            tableColumn1.setText("CPU");
            database_space base = new database_space();
            ResultSet result = base.fetchThird();
            ArrayList<pocket> man = new ArrayList<>();
            while (true) {
                try {
                    if (!result.next()) break;
                    pocket peo = new pocket(result.getString(1),
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
}



