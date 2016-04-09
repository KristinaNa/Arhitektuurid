package test;

import org.junit.AfterClass;
import org.junit.Test;

import static org.junit.Assert.*;

import dao.RadioDao;
import model.Radio;
import util.DbUtil;

import java.sql.*;
import java.util.List;

/**
 * Created by Kristina on 09/04/2016.
 */

public class RadioDaoTest {

    private RadioDao dao;
    public RadioDaoTest() {
        super();
        dao = new RadioDao();
    }

    @AfterClass
    public static void cleanUpClass() throws SQLException {
        Connection connection = DbUtil.getConnection();

        PreparedStatement preparedStatement = connection
                .prepareStatement("DELETE FROM radio WHERE name = 'Test radio' OR name = 'Test radio 2'");
        preparedStatement.executeUpdate();

        System.out.println("Clean up database after test run");
    }

    @Test
    public void testAddRadio() {
        Radio radio = new Radio();

        radio.setName("Test radio");
        radio.setDescription("Test radio description");
        radio.setSequence(152);
        int id = dao.addRadio(radio);

        assertNotEquals(-1, id);
    }

    @Test
    public void testGetRadioById() {
        Radio new_radio = new Radio();
        new_radio.setName("Test radio");
        new_radio.setDescription("Test radio description");
        new_radio.setSequence(152);
        int id = dao.addRadio(new_radio);

        Radio radio = dao.getRadioById(id);

        assertEquals("Test radio", radio.getName());
        assertEquals(152, radio.getSequence());
        assertEquals("Test radio description", radio.getDescription());
    }

    @Test
    public void testGetAllRadios() {
        List radios = dao.getAllRadios();
        Radio last_radio = (Radio) radios.get(radios.size()-1);

        assertTrue(radios.size() > 0);

        assertEquals("Test radio", last_radio.getName());
        assertEquals(152, last_radio.getSequence());
        assertEquals("Test radio description", last_radio.getDescription());
    }

    @Test
    public void testUpdateRadio() {
        testAddRadio();

        List radios = dao.getAllRadios();
        Radio last_radio = (Radio) radios.get(radios.size()-1);

        // Verify that before update name is Test radio
        assertEquals("Test radio", last_radio.getName());
        assertEquals(152, last_radio.getSequence());
        assertEquals("Test radio description", last_radio.getDescription());

        last_radio.setName("Test radio 2");
        last_radio.setSequence(111);
        last_radio.setDescription("Updated radio description");
        dao.updateRadio(last_radio);

        // Verify that all information was updated
        assertEquals("Test radio 2", last_radio.getName());
        assertEquals(111, last_radio.getSequence());
        assertEquals("Updated radio description", last_radio.getDescription());
    }
}
