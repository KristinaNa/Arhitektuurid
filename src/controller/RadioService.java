package controller;

/**
 * Created by Kristina on 24/03/2016.
 */

import dao.RadioDao;
import model.Radio;
import org.apache.log4j.Logger;
import org.json.simple.JSONObject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(
        value = {"/radio/radioservice"},
        loadOnStartup = 1
)

public class RadioService extends HttpServlet {

    private static Logger logger = Logger.getLogger(RadioService.class);

    private static final long serialVersionUID = 1L;
    private static String GET_JSON = "/json.jsp";

    private RadioDao dao;

    public void init() {
        logger.error("RadioService.init(): mind loodi");
    }

    public RadioService() {
        super();
        dao = new RadioDao();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int radioId = Integer.parseInt(request.getParameter("id"));
        Radio radio = dao.getRadioById(radioId);

        response.setContentType("application/json");
        response.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        JSONObject json = new JSONObject();

        json.put("description", radio.getDescription());
        json.put("sequence", radio.getSequence());
        json.put("name", radio.getName());
        json.put("id", radio.getId());

        // finally output the json string
        out.print(json.toString());
        logger.info("Näita json view");

    }

}