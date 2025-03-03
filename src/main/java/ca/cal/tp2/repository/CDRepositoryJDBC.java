package ca.cal.tp1.repository;

import ca.cal.tp1.modele.CD;

import java.sql.*;

public class CDRepositoryJDBC extends RepositoryParentJDBC implements CDRepository {

    @Override
    protected String getSqlInsert() {
        return "INSERT INTO CD VALUES(?,?,?,?,?,?)";
    }



    @Override
    protected <T> void getPreparedStatementParameters(PreparedStatement preparedStatement, T t) throws SQLException {
        CD cd = (CD) t;
        preparedStatement.setLong(1, cd.getId());
        preparedStatement.setString(2, cd.getTitre());
        preparedStatement.setInt(3, cd.getNbExemplaires());
        preparedStatement.setString(4, cd.getArtiste());
        preparedStatement.setInt(5, cd.getDuree());
        preparedStatement.setString(6, cd.getGenre());
    }

    @Override
    public void saveCD(CD cd) {
        executePreparedStatementInsert(cd);
    }



    @Override
    protected String getSqlSelect() {
        return "SELECT * FROM CD WHERE id = ?";
    }

    @Override
    public CD getCD(long id) {
        return executePreparedStatementSelect(id);
    }

    @Override
    protected <T> T getFromResultSet(ResultSet resultSet) throws SQLException {
        CD cd = new CD(resultSet.getLong("id"),
                resultSet.getString("titre"),
                resultSet.getInt("nbExemplaires"),
                resultSet.getString("artiste"),
                resultSet.getInt("duree"),
                resultSet.getString("genre"));
        return (T) cd;
    }
}
