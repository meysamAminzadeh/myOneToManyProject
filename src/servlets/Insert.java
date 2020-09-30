package servlets;

import model.BL.TblPerson;
import oracleTransaction.SaveToDB;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by asus on 5/13/2020.
 */
public class Insert extends HttpServlet {
    @Override
    public void service(HttpServletRequest request, HttpServletResponse response)throws IOException,ServletException{
      //  SaveToDB register = new SaveToDB();
        String name=request.getParameter("name");
        String family=request.getParameter("family");
        String address=request.getParameter("address");

        TblPerson tblPerson= new TblPerson();



        tblPerson.insert(name,family,address);
        tblPerson.addAddress();
        tblPerson.select();
       // tblPerson.select();
        //tblPerson.update("amweqweqwir","aghawqeqweei");

        response.sendRedirect("welcome.jsp");



    }
}
