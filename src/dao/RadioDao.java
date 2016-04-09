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
import org.apache.log4j.Logger;
import org.json.JSONObject;
import util.DbUtil;
import org.json.JSONArray;


public class RadioDao {
    private static Logger logger = Logger.getLogger(RadioDao.class);

    private Connection connection;

    public RadioDao() {
        connection = DbUtil.getConnection();
    }

    public int addRadio(Radio radio) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("insert into radio(name,sequence,description) values (?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
            // Parameters start with 1
            preparedStatement.setString(1, radio.getName());
            preparedStatement.setInt(2, radio.getSequence());
            preparedStatement.setString(3, radio.getDescription());
            preparedStatement.executeUpdate();

            try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    return generatedKeys.getInt(1);
                }
                else {
                    return -1;
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }

    public void updateRadio(Radio radio) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("update radio set name=?, sequence=?, description=?" + " where radio=?");
            // Parameters start with 1
            preparedStatement.setString(1, radio.getName());
            preparedStatement.setInt(2, radio.getSequence());
            preparedStatement.setString(3, radio.getDescription());
            preparedStatement.setInt(4, radio.getId());
            preparedStatement.executeUpdate();
            System.out.println(preparedStatement);
            logger.info("Kirje muutmine");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Radio> getAllRadios() {
        List<Radio> radios = new ArrayList<Radio>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from radio order by radio asc");
            while (rs.next()) {
                Radio radio = new Radio();
                radio.setId(rs.getInt("radio"));
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
    public Radio getRadioById(int radioId) {
        Radio radio = new Radio();
        try {
            PreparedStatement preparedStatement = connection.
                    prepareStatement("select * from radio where radio=?");
            preparedStatement.setInt(1, radioId);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                radio.setId(rs.getInt("radio"));
                radio.setName(rs.getString("name"));
                radio.setSequence(rs.getInt("sequence"));
                radio.setDescription(rs.getString("description"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return radio;
    }

}