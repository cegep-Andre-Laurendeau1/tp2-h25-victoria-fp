package ca.cal.tp2.repository;

import ca.cal.tp2.modele.CD;

import java.sql.*;

public abstract class RepositoryParentJDBC {
    static final String JDBC_DRIVER = "org.h2.Driver";
    static final String DB_URL = "jdbc:h2:mem:tp1;DB_CLOSE_DELAY=-1";
    static final String USER = "sa";
    static final String PASS = "";
    static Connection conn = null;

    static {
        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement statement = conn.createStatement();
            String sql =  "CREATE TABLE   CD " +
                    "(id INTEGER not NULL, " +
                    " titre VARCHAR(255), " +
                    " nbExemplaires INTEGER, " +
                    " artiste VARCHAR(255), " +
                    " duree INTEGER, " +
                    " genre VARCHAR(255), " +
                    " PRIMARY KEY ( id ))";
            statement.executeUpdate(sql);
            statement.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }



    protected <T> void executePreparedStatementInsert(T t) {
        try(PreparedStatement preparedStatement = conn.prepareStatement(getSqlInsert())) {
            getPreparedStatementParameters(preparedStatement, t);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    protected abstract <T> void getPreparedStatementParameters(PreparedStatement preparedStatement, T t) throws SQLException;
    protected abstract String getSqlInsert();



    protected <T> T executePreparedStatementSelect(long id) {
        T t = null;
        try (PreparedStatement ps = conn.prepareStatement(getSqlSelect())) {
            ps.setLong(1, id);
            ResultSet resultSet = ps.executeQuery();
            if (resultSet.next()) {
                t = getFromResultSet(resultSet);
            }
            return t;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    protected abstract String getSqlSelect();
    protected abstract <T> T getFromResultSet(ResultSet resultSet) throws SQLException;
}
