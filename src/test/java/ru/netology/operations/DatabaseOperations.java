package ru.netology.operations;

import lombok.SneakyThrows;
import lombok.Value;
import lombok.val;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.junit.jupiter.api.AfterAll;

import java.sql.DriverManager;

@Value
public class DatabaseOperations {
    private DatabaseOperations() {
    }

    @SneakyThrows
    public static String getVerificationCode() {
        QueryRunner runner = new QueryRunner();
        String verificationCode = "";
        var codeSQL = "SELECT auth_codes.code FROM users JOIN auth_codes " +
                "ON users.id = auth_codes.user_id AND users.login = 'vasya'";
        try (
                var conn = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/app", "app", "pass"
                );
        ) {
            val code = runner.query(conn, codeSQL, new ScalarHandler<>());
            System.out.println("код верификации " + code);
            verificationCode = (String) code;
        }
        return verificationCode;
    }

    @SneakyThrows
    @AfterAll
    public static void cleanData() {
        QueryRunner runner = new QueryRunner();
        var cleanCards = "DELETE FROM cards";
        var cleanUsers = "DELETE FROM users";
        var cleanCardTransactions = "DELETE FROM card_transactions";
        var cleanAuthCodes = "DELETE FROM auth_codes";

        try (
                var conn = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/app", "app", "pass"
                );

        ) {
            runner.update(conn, cleanAuthCodes);
            runner.update(conn, cleanCards);
            runner.update(conn, cleanCardTransactions);
            runner.update(conn, cleanUsers);
        }
    }
}


