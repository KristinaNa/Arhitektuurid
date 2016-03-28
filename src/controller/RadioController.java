package controller;

/**
 * Created by Kristina on 24/03/2016.
 */
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.RadioDao;
import model.Radio;
import org.json.JSONArray;
import java.io.PrintWriter;
import org.json.simple.JSONObject;

public class RadioController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static String INSERT_OR_EDIT = "/radio.jsp";
    private static String LIST_RADIO = "/listRadio.jsp";
    private static String GET_JSON = "/json.jsp";

    private RadioDao dao;

    public RadioController() {
        super();
        dao = new RadioDao();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String forward="";
        String action = request.getParameter("action");

  /*      if (action.equalsIgnoreCase("delete")){
            int userId = Integer.parseInt(request.getParameter("userId"));
            dao.deleteUser(userId);
            forward = LIST_USER;
            request.setAttribute("users", dao.getAllUsers());
        } else if (action.equalsIgnoreCase("edit")){
            forward = INSERT_OR_EDIT;
            int userId = Integer.parseInt(request.getParameter("userId"));
            User user = dao.getUserById(userId);
            request.setAttribute("user", user);
        } else if (action.equalsIgnoreCase("listUser")){
            forward = LIST_USER;
            request.setAttribute("users", dao.getAllUsers());
        } else {
            forward = INSERT_OR_EDIT;
        }
*/
        if(action.equalsIgnoreCase("edit")) {
            forward = INSERT_OR_EDIT;
            int radioId = Integer.parseInt(request.getParameter("radio"));
            Radio radio = dao.getRadioById(radioId);
            request.setAttribute("radio", radio);
            RequestDispatcher view = request.getRequestDispatcher(forward);
            view.forward(request, response);

        } else if(action.equalsIgnoreCase("data")){
            int radioId = Integer.parseInt(request.getParameter("radio"));
            Radio radio = dao.getRadioById(radioId);

           /* forward = GET_JSON;
            int radioId = Integer.parseInt(request.getParameter("radio"));
            Radio radio = dao.getRadioById(radioId);
            request.setAttribute("radio", radio);
            */
            response.setContentType("application/json");
            response.setCharacterEncoding("utf-8");
            PrintWriter out = response.getWriter();
            //create Json Object
            JSONObject json = new JSONObject();
            // put some value pairs into the JSON object .

            json.put("description", radio.getDescription());
            json.put("sequence", radio.getSequence());
            json.put("name", radio.getName());
            json.put("id", radio.getId());

            // finally output the json string
            out.print(json.toString());

        }else {
            forward = LIST_RADIO;
            request.setAttribute("radios", dao.getAllRadios());
            RequestDispatcher view = request.getRequestDispatcher(forward);
            view.forward(request, response);
        }
/*
        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
        */
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Radio radio = new Radio();
        radio.setId(Integer.parseInt(request.getParameter("radio")));
        radio.setName(request.getParameter("name"));
        radio.setDescription(request.getParameter("description"));
        radio.setSequence(Integer.parseInt(request.getParameter("sequence")));

        dao.updateRadio(radio);


       /* try {
            Date dob = new SimpleDateFormat("MM/dd/yyyy").parse(request.getParameter("dob"));
            radio.setDob(dob);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        String id = request.getParameter("radio");

        if(id == null || id.isEmpty())
        {
            dao.addRadio(radio);
        }
        else
        {
            radio.setId(Integer.parseInt(id));
            dao.updateRadio(radio);
        }
*/


        RequestDispatcher view = request.getRequestDispatcher(LIST_RADIO);
        request.setAttribute("radios", dao.getAllRadios());
        view.forward(request, response);
    }
}