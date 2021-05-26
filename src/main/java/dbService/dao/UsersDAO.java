package dbService.dao;

import dbService.dataSets.UsersDataSet;
import dbService.executor.Executor;

import java.sql.Connection;
import java.sql.SQLException;

public class UsersDAO {

    private Executor executor;

    public UsersDAO(Connection connection) {
        this.executor = new Executor(connection);
    }

    public UsersDataSet getUser(String login) throws SQLException {
        return executor.execQuery("select * from users where user_login='" + login + "'", result -> {
            result.next();
            return new UsersDataSet(result.getString(2),
                    result.getString(3),
                    result.getString(4));
        });
    }

    public boolean checkUserExists(String login) throws SQLException {
        return executor.execQuery("select exists (select * from users where user_login='" + login + "')", result -> {
            result.next();
            return result.getBoolean(1);
        });
    }

    public void insertUser(String login, String password, String email) throws SQLException {
        executor.execUpdate("insert into users (user_login, user_pass, user_email) values ('" + login + "', '" + password + "', '" + email + "')");
    }

    public void createTable() throws SQLException {
        executor.execUpdate("create table if not exists users (id bigint auto_increment primary key, user_login varchar(255), user_pass varchar(255), user_email varchar(255))");
    }

    public void dropTable() throws SQLException {
        executor.execUpdate("drop table users");
    }
}
