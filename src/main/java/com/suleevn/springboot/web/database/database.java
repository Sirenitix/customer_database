package com.suleevn.springboot.web.database;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class database {
    public static Connection connect = null;
    public static Statement statement = null;
    public static ResultSet resultSet = null;

    public static String url = "jdbc:mariadb://localhost:3307/person_contacts";
    public static String user = "root", pass = "";
    public static int iddb;
    public static String namedb;
    public static String numberdb;
    public static int countdb1;
    public static int countdb;
    public static int ind;
    public static int indf;
    public static List<String>  namedbl = new ArrayList<String>();
    public static List<String>  numberdbl = new ArrayList<String>();
    public static List<Integer>  iddbl = new ArrayList<Integer>();





    public static void main(String[] args) {


        try {
            Class.forName("org.mariadb.jdbc.Driver");
            connect = DriverManager.getConnection(url, user, pass);
            statement = connect.createStatement();
            resultSet = statement.executeQuery("select * from person_contacts");




            while(resultSet.next()){
                iddb = resultSet.getInt(1);
                iddbl.add(iddb);
                namedb = resultSet.getString(2);
                namedbl.add(namedb);
                numberdb = resultSet.getString(3);
                numberdbl.add(numberdb);

                countdb1 = countdb1 + 1;
            }
            countdb = countdb1;
            if(countdb != 0){
            ind = iddbl.get(iddbl.size() - 1);
            indf = ind + 1;}
            else{indf = 1;}



        }
        catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }






    }

}





