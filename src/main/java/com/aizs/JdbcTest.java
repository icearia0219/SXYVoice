package com.aizs;

import java.sql.*;

public class JdbcTest {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/ai-knowledge?useSSL=false&characterEncoding=utf8";
        String user = "root";
        String password = "26229899";

        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String sql = "SELECT feedbackid, userid, content, created_at FROM feedbacks";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                System.out.println("Feedback ID: " + resultSet.getLong("feedbackid"));
                System.out.println("User ID: " + resultSet.getLong("userid"));
                System.out.println("Content: " + resultSet.getString("content"));
                System.out.println("Created At: " + resultSet.getTimestamp("created_at"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
