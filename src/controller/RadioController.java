package controller;

/**
 * Created by Kristina on 24/03/2016.
 */
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.RadioDao;
import model.Radio;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import util.RadioValidator;

@WebServlet(
        value = {"/radio/s"},
        loadOnStartup = 1
)

public class RadioController extends HttpServlet {

    private static Logger logger = Logger.getLogger(RadioController.class);

    private static final long serialVersionUID = 1L;
    private static String INSERT_OR_EDIT = "/radio.jsp";
    private static String LIST_RADIO = "/listRadio.jsp";
    //private static String GET_JSON = "/json.jsp";

    private RadioDao dao;

    public void init() {
        logger.error("RadioController.init(): mind loodi");
    }

    public RadioController() {
        super();
        dao = new RadioDao();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String forward="";
        String action = request.getParameter("action");

        if(action == null || action.isEmpty()) {
            forward = LIST_RADIO;
            request.setAttribute("radios", dao.getAllRadios());
            RequestDispatcher view = request.getRequestDispatcher(forward);
            view.forward(request, response);
            logger.info("Näita kõik kirjed");
        } else {

            if(action.equalsIgnoreCase("edit")) {
                forward = INSERT_OR_EDIT;
                int radioId = Integer.parseInt(request.getParameter("id"));
                Radio radio = dao.getRadioById(radioId);
                if(radio.getId() == 0) {
                    Map<String, String> val_list = new HashMap<String, String>();
                    val_list.put("Viga", "Sellise ID'ga objekte ei ole");

                    request.setAttribute("radioerrors", val_list);
                } else {
                    request.setAttribute("radio", radio);
                }

                RequestDispatcher view = request.getRequestDispatcher(forward);
                view.forward(request, response);
            } else {
                forward = LIST_RADIO;
                request.setAttribute("radios", dao.getAllRadios());
                RequestDispatcher view = request.getRequestDispatcher(forward);
                view.forward(request, response);
                logger.info("Näita kõik kirjed");
            }
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Radio radio = new Radio();
        radio.setId(Integer.parseInt(request.getParameter("radio")));
        radio.setName(request.getParameter("name"));
        radio.setDescription(request.getParameter("description"));
        radio.setSequence(Integer.parseInt(request.getParameter("sequence")));
        request.setAttribute("radio", radio);

        RadioValidator validator = new RadioValidator();
        HashMap val_list = validator.Validate(radio);

        String redirect_to = LIST_RADIO;
        if (val_list.size() > 0) {
            request.setAttribute("radioerrors", val_list);
            redirect_to = INSERT_OR_EDIT;
        } else {
            dao.updateRadio(radio);
        }

        RequestDispatcher view = request.getRequestDispatcher(redirect_to);
        request.setAttribute("radios", dao.getAllRadios());
        view.forward(request, response);
    }
}