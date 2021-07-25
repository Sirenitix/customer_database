package com.suleevn.springboot.web.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static com.suleevn.springboot.web.controller.TodoController.*;

public class dbupdate_v2 {
    public static void main(String[] args) {
        String jdbcUrl = "jdbc:mysql://localhost:3307/person_contacts";
        String username = "root";
        String password = "";
        String sql = "update person_contacts set number=? where id=?";

        try (Connection conn = DriverManager.getConnection(jdbcUrl, username, password);
             PreparedStatement stmt = conn.prepareStatement(sql);) {
            stmt.setString(1, nbupd);
            stmt.setInt(2, idupd);

            stmt.executeUpdate();

            System.out.println("Database updated successfully ");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
