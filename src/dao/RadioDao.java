package dao;

/**
 * Created by Kristina on 24/03/2016.
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Radio;
import util.DbUtil;


public class RadioDao {

    private Connection connection;

    public RadioDao() {
        connection = DbUtil.getConnection();
    }

 /*   public void addRadio(Radio radio) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("insert into radios(firstname,lastname,dob,email) values (?, ?, ?, ? )");
            // Parameters start with 1
            preparedStatement.setString(1, radio.getFirstName());
            preparedStatement.setString(2, radio.getLastName());
            preparedStatement.setDate(3, new java.sql.Date(radio.getDob().getTime()));
            preparedStatement.setString(4, radio.getEmail());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteRadio(int radioId) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("delete from radios where radioid=?");
            // Parameters start with 1
            preparedStatement.setInt(1, radioId);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateRadio(Radio radio) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("update radios set firstname=?, lastname=?, dob=?, email=?" +
                            "where radioid=?");
            // Parameters start with 1
            preparedStatement.setString(1, radio.getFirstName());
            preparedStatement.setString(2, radio.getLastName());
            preparedStatement.setDate(3, new java.sql.Date(radio.getDob().getTime()));
            preparedStatement.setString(4, radio.getEmail());
            preparedStatement.setInt(5, radio.getRadioid());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
*/
    public List<Radio> getAllRadios() {
        List<Radio> radios = new ArrayList<Radio>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from radio");
            while (rs.next()) {
                Radio radio = new Radio();
              //  radio.setId(rs.getInt("id"));
                radio.setName(rs.getString("name"));
                radio.setSequence(rs.getInt("sequence"));
                radio.setDescription(rs.getString("description"));
                radios.add(radio);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return radios;
    }
/*
    public Radio getRadioById(int radioId) {
        Radio radio = new Radio();
        try {
            PreparedStatement preparedStatement = connection.
                    prepareStatement("select * from radios where radioid=?");
            preparedStatement.setInt(1, radioId);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                radio.setRadioid(rs.getInt("radioid"));
                radio.setFirstName(rs.getString("firstname"));
                radio.setLastName(rs.getString("lastname"));
                radio.setDob(rs.getDate("dob"));
                radio.setEmail(rs.getString("email"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return radio;
    }
    */
}