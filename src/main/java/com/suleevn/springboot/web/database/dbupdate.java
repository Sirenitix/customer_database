package com.suleevn.springboot.web.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static com.suleevn.springboot.web.controller.TodoController.*;


public class dbupdate {

    public static void main(String[] args) {
        String jdbcUrl = "jdbc:mysql://localhost:3307/person_contacts";
        String username = "root";
        String password = "";
        String setnamesql = "update person_contacts set name=?, number=? where id=?";
        String setnumbersql = "update person_contacts set number=? where id=?";

        try (Connection conn = DriverManager.getConnection(jdbcUrl, username, password);
             PreparedStatement stmt = conn.prepareStatement(setnamesql);) {
            stmt.setString(1, nmupd);
            stmt.setInt(3, idupd);
            stmt.setString(2, nbupd);

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
