package dbService;

import dbService.dao.UsersDAO;
import dbService.dataSets.UsersDataSet;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBService {
    private final Connection connection;

    public DBService() {
//        this.connection = getH2Connection();
        this.connection = getMysqlConnection();
        System.out.println("Соединение с СУБД выполнено.");
    }

    public UsersDataSet getUser(String login) throws DBException {
        try {
            return (new UsersDAO(connection).getUser(login));
        } catch (SQLException e) {
            throw new DBException(e);
        }
    }

    public boolean checkUserExists(String login) throws DBException {
        try {
            return (new UsersDAO(connection).checkUserExists(login));
        } catch (SQLException e) {
            throw new DBException(e);
        }
    }

    public void addUser(UsersDataSet usersDataSet) throws DBException {
        try {
            connection.setAutoCommit(false);
            UsersDAO dao = new UsersDAO(connection);
            dao.createTable();
            dao.insertUser(usersDataSet.getLogin(), usersDataSet.getPassword(), usersDataSet.getEmail());
            connection.commit();
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ignore) {
            }
            throw new DBException(e);
        } finally {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException ignore) {
            }
        }
    }


    public void cleanUp() throws DBException {
        UsersDAO dao = new UsersDAO(connection);
        try {
            dao.dropTable();
        } catch (SQLException e) {
            throw new DBException(e);
        }
    }

    public static Connection getMysqlConnection() {
        try {
            DriverManager.registerDriver((Driver) Class.forName("com.mysql.cj.jdbc.Driver").newInstance());

            StringBuilder url = new StringBuilder();

            url.
                    append("jdbc:mysql://").        //db type
                    append("localhost:").           //host name
                    append("3306/").                //port
                    append("servletwithjsp?").          //db name
                    append("user=root&").          //login
                    append("password=root&").   //password
                    append("serverTimezone=UTC");

            System.out.println("URL: " + url + "\n");

            return DriverManager.getConnection(url.toString());
        } catch (SQLException | InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
