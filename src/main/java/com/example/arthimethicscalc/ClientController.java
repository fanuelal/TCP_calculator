package com.example.arthimethicscalc;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

import java.io.*;
import java.net.Socket;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.ResourceBundle;

public class ClientController implements Initializable {
    @FXML
    private Button clearBtn;

    @FXML
    private Label displayScreen;

    @FXML
    private Button dividBtn;

    @FXML
    private Button equalBtn;

    @FXML
    private void HandleAdd(){
        if(displayScreen.getText().equals("0")){displayScreen.setText("");}
        displayScreen.setText(displayScreen.getText() + " + ");}
    @FXML
    private void HandleClear(){
        displayScreen.setText("0");
    }
    @FXML
    private void HandleNum1(){
        if(displayScreen.getText().equals("0")){displayScreen.setText("");}
        displayScreen.setText(displayScreen.getText() + "1");}
    @FXML
    private void HandleNum2(){
        if(displayScreen.getText().equals("0")){displayScreen.setText("");}
        displayScreen.setText(displayScreen.getText() + "2");}
    @FXML
    private void HandleNum3(){
        if(displayScreen.getText().equals("0")){displayScreen.setText("");}
        displayScreen.setText(displayScreen.getText() + "3");}
    @FXML
    private void HandleNum4(){
        if(displayScreen.getText().equals("0")){displayScreen.setText("");}
        displayScreen.setText(displayScreen.getText() + "4");}
    @FXML
    private void HandleNum5(){
        if(displayScreen.getText().equals("0")){displayScreen.setText("");}
        displayScreen.setText(displayScreen.getText() + "5");}
    @FXML
    private void HandleNum6(){
        if(displayScreen.getText().equals("0")){displayScreen.setText("");}
        displayScreen.setText(displayScreen.getText() + "6");}
    @FXML
    private void HandleNum7(){
        if(displayScreen.getText().equals("0")){displayScreen.setText("");}
        displayScreen.setText(displayScreen.getText() + "7");}
    @FXML
    private void HandleNum8(){
        if(displayScreen.getText().equals("0")){displayScreen.setText("");}
        displayScreen.setText(displayScreen.getText() + "8");}
    @FXML
    private void HandleNum9(){
        if(displayScreen.getText().equals("0")){displayScreen.setText("");}
        displayScreen.setText(displayScreen.getText() + "9");}
    @FXML
    private void HandleNum0(){
        if(displayScreen.getText().equals("0")){displayScreen.setText("");}
        displayScreen.setText(displayScreen.getText() + "0");}
    @FXML
    private void HandleMinus(){
        if(displayScreen.getText().equals("0")){displayScreen.setText("");}
        displayScreen.setText(displayScreen.getText() + " - ");}
    @FXML
    private void HandleDivide(){
        if(displayScreen.getText().equals("0")){displayScreen.setText("");}
        displayScreen.setText(displayScreen.getText() + " / ");}
    @FXML
    private void HandleTimes(){
        if(displayScreen.getText().equals("0")){displayScreen.setText("");}
        displayScreen.setText(displayScreen.getText() + " * ");}
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        equalBtn.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    int Port = 6798;
                    Socket client = null;
                    try {
                        client = new Socket("10.161.76.83", Port);//192.168.45.69
                    } catch (IOException e) {
                        System.out.println("socket connection Interrupted");
                    }
                    Socket finalClient = client;
                    try {
                        OutputStream Out =  finalClient.getOutputStream();
                        BufferedReader ConIn = new BufferedReader(new InputStreamReader(finalClient.getInputStream()));
                        PrintWriter out = new PrintWriter(finalClient.getOutputStream(), true);
                        String send = "";
                            send = displayScreen.getText();
                            out.println(send);
                            String result = ConIn.readLine();
                            displayScreen.setText("= " + result);
                            out.println("stop");
                    } catch (UnknownHostException e) {
                        System.out.println("Unknown host");
                    } catch (IOException e) {
                        System.out.println("Invalid IO");
                    }
                }

            });
    }
}