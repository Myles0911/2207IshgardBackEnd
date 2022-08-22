package daos.ishgardian;

import entities.Ishgardian;
import utils.connectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class IshgardianDAOPostgres implements IshgardianDAO {

    @Override
    public Ishgardian getIshgardianByName(String name) {
        try (Connection connection = connectionUtil.ConnectionUtil.createConnection()) {
            String sql = "select * from Ishgardian where name = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, name);

            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();

            Ishgardian ishgardian = new Ishgardian();
            ishgardian.setUserid(resultSet.getInt("user_id"));
            ishgardian.setName(resultSet.getString("name"));
            ishgardian.setPassword(resultSet.getString("password"));
            ishgardian.setRole(resultSet.getString("role"));

            return ishgardian;

        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return null;
    }
}



