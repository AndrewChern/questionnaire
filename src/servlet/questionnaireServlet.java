package servlet;
import entity.Person;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "Questionnaire", urlPatterns = {"/questionnaire"})
public class questionnaireServlet extends  HttpServlet {

    static final String TEMPLATE = "<html>" +
            "<head><title>questionnarie</title></head>" +
            "<body><h1>%s</h1></body></html>";

    static final Map<Integer, String> persons = new HashMap<Integer, String>();

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
       String name = req.getParameter("name");
       String lastName = req.getParameter("lastname");
       int age = Integer.parseInt(req.getParameter("age"));
       String questionOne = req.getParameter("questionOne");
       String questionTwo = req.getParameter("questionTwo");

    if(name==null||lastName==null||questionOne==null||questionTwo==null) {
        String exception = "You didn't fill all fields of questionnaire";
        resp.getWriter().println(String.format(TEMPLATE, exception));
    }else if(age<=0){
        String exception = "Wrong age";
        resp.getWriter().println(String.format(TEMPLATE, exception));
        }else {
        Person person = new Person(name, lastName, age,questionOne, questionTwo);
        resp.getWriter().print(String.format(TEMPLATE, person));
        resp.getWriter().close();
        persons.put(person.hashCode(),person.toString());
    }

    }
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        persons.forEach((k, v) -> {
            try {
                resp.getWriter().print(String.format(TEMPLATE, v));
                resp.getWriter().close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
}

