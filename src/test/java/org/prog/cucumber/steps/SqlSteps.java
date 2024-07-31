package org.prog.cucumber.steps;

import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;
import org.prog.util.CucumberStorage;
import org.testng.Assert;

import java.sql.*;


public class SqlSteps {
    private Connection connection;
    private Statement statement;
    public ResultSet resultSet;
    public ResultSet resultSet1;
    private WebDriver driver;
    private final static String INSERT_PATTERN = "INSERT INTO IPhoneTable (NamePhone,PrisePhone)" +
            "VALUES ('%s', '%s')";

    @Given("I check phone, compare him and change DB value")
    public void createDbvalue() throws SQLException, ClassNotFoundException {
        connectionToDB();
        try {
            resultSet1 = statement.executeQuery("SELECT NamePhone FROM IPhoneTable WHERE NamePhone='"
                    +(String)CucumberStorage.HOLDER.get("nameSomePhone").toString() +"'");
                Assert.assertTrue(resultSet1.next() );

            resultSet = statement.executeQuery("SELECT PrisePhone FROM IPhoneTable WHERE NamePhone='"
                    +(String)CucumberStorage.HOLDER.get("nameSomePhone").toString() +"'");
            while (resultSet.next()) {
                Assert.assertEquals(CucumberStorage.HOLDER.get("PricePhone").toString().toUpperCase(),
                        resultSet.getString("PrisePhone").toUpperCase() ,
                        "телефон в базі має іншу ціну");
                if(!resultSet.getString("PrisePhone").toUpperCase().
                        contains(CucumberStorage.HOLDER.get("PricePhone").toString().toUpperCase()) ){
                    statement.execute("DELETE FROM IPhoneTable WHERE NamePhone=" +
                            "'"+(String)CucumberStorage.HOLDER.get("nameSomePhone").toString() +"'");
                    statement.execute(String.format(INSERT_PATTERN,
                            CucumberStorage.HOLDER.get("nameSomePhone").toString(),
                                    CucumberStorage.HOLDER.get("PricePhone").toString()));
                }
            }

        } finally {
            closeConnection();
        }
    }

    private void connectionToDB() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        connection =
                DriverManager.getConnection("jdbc:mysql://localhost:3306/db", "user", "password");
        statement = connection.createStatement();
    }

    private void closeConnection() throws SQLException {
        if (resultSet != null) {
            resultSet.close();
        }
        if (resultSet1 != null) {
            resultSet1.close();
        }
        if (statement != null) {
            statement.close();
        }
        if (connection != null) {
            connection.close();
        }
    }
}

