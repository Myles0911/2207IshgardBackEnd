package dev.walker.daos.ishgardian;

import dev.walker.entities.Ishgardians;
import dev.walker.utils.connectionUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class IshgardiansDAOPostgres implements IshgardiansDAO {

    @Override
    public Ishgardians getIshgardianByName(String name) {
        try (Connection connection = connectionUtil.createConnection()) {
            String sql = "select * from Ishgardians where name = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, name);

            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();

            Ishgardians ishgardians = new Ishgardians();
            ishgardians.setUserid(resultSet.getInt("user_id"));
            ishgardians.setName(resultSet.getString("name"));
            ishgardians.setPassword(resultSet.getString("password"));
            ishgardians.setRole(resultSet.getString("role"));

            return ishgardians;

        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return null;
    }

    @Override
    public Ishgardians createIshgardians(Ishgardians ishgardians) {
        try (Connection conn = connectionUtil.createConnection()) {
            String sql = "insert into Ishgardians values (default, ?, ?, ?)";
            PreparedStatement preparedStatement = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, ishgardians.getName());
            preparedStatement.setString(2, ishgardians.getPassword());
            preparedStatement.setString(3, ishgardians.getRole());


            preparedStatement.execute();

            ResultSet rs = preparedStatement.getGeneratedKeys();
            rs.next();

            int generatedKey = rs.getInt("user_id");
            ishgardians.setUserid(generatedKey);
            return ishgardians;


        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Ishgardians> getAllIshgardians() {
        try (Connection connection = connectionUtil.createConnection()) {
            String sql = "select * from Ishgardians";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();

            List<Ishgardians> ishgardiansList = new ArrayList();
            while (rs.next()) {
                Ishgardians ishgardians = new Ishgardians();
                ishgardians.setUserid(rs.getInt("user_id"));
                ishgardians.setName(rs.getString("name"));
                ishgardians.setPassword(rs.getString("password"));
                ishgardians.setRole(rs.getString("role"));
                ishgardiansList.add(ishgardians);
            }
            return ishgardiansList;

        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return null;
    }


    @Override
    public Ishgardians updateIshgardiansRole(Ishgardians ishgardians) {
        try(Connection conn = connectionUtil.createConnection()) {
            String sql = "update Ishgardians set name = ?, password = ?, role = ? where user_id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,ishgardians.getName());
            ps.setString(2,ishgardians.getPassword());
            ps.setString(3,ishgardians.getRole());
            ps.setInt(4,ishgardians.getUserid());

            ps.executeUpdate();
            return ishgardians;


        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return null;
    }
}




