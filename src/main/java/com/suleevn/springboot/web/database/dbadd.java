package com.suleevn.springboot.web.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import static com.suleevn.springboot.web.controller.TodoController.nbadd;
import static com.suleevn.springboot.web.controller.TodoController.nmadd;
import static com.suleevn.springboot.web.service.TodoService.todoCount;


public class dbadd
{


    public static void main(String[] args)
    {

        try
        {

            String myDriver = "com.mysql.cj.jdbc.Driver";
            String myUrl = "jdbc:mysql://localhost:3307/person_contacts";
            Class.forName(myDriver);
            Connection conn = DriverManager.getConnection(myUrl, "root", "");



            String query = " insert into person_contacts (id, name, number)"
                    + " values (?, ?, ?)";


            PreparedStatement preparedStmt = conn.prepareStatement(query);
            preparedStmt.setInt (1,todoCount );
            preparedStmt.setString (2, nmadd);
            preparedStmt.setString   (3, nbadd);


            preparedStmt.execute();

            conn.close();
        }
        catch (Exception e)
        {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());
        }
    }
}
