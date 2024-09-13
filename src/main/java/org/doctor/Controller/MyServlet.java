package org.doctor.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.doctor.Dao.DoctorDao;
import org.doctor.bean.Doctor;

/**
 * Servlet implementation class MyServlet
 */

public class MyServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  /**
   * @see HttpServlet#HttpServlet()
   */
  public MyServlet() {
    super();
    // TODO Auto-generated constructor stub
  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    // TODO Auto-generated method stub
    if (request.getParameter("Action").equals("Add Doctor")) {
      System.out.println("in");
      PrintWriter printWriter = response.getWriter();
      Doctor doctor = new Doctor();
      DoctorDao dao = new DoctorDao();
      doctor.setName((request.getParameter("name")));
      doctor.setSpecialist((request.getParameter("speciality")));
      doctor.setEmail((request.getParameter("email")));
      doctor.setCity((request.getParameter("city")));
      doctor.setCountry((request.getParameter("country")));
      @SuppressWarnings("unused")
	boolean result = dao.addDoctor(doctor);

      RequestDispatcher dispatcher = request.getRequestDispatcher("addDoctor.jsp");
      dispatcher.include(request, response);
      printWriter.print("<br><h2>Doctor added Successfully!!</h2>");
    }
    
    
    
    

    if (request.getParameter("Action").equals("Edit")) {
      PrintWriter printWriter = response.getWriter();
      Doctor doctor = new Doctor();
      DoctorDao dao = new DoctorDao();
      doctor.setId(Integer.parseInt(request.getParameter("id")));
      doctor.setEmail(request.getParameter("email"));
      doctor.setCity(request.getParameter("city"));
      doctor.setCountry(request.getParameter("country"));
      boolean result = dao.editDoctor(doctor);
      System.out.println(result);
      RequestDispatcher dispatcher = request.getRequestDispatcher("edit.jsp");
      dispatcher.include(request, response);
      printWriter.print("<br><h2>Doctor Edited Successfully!!</h2>");

    }
    
    
    

    if (request.getParameter("Action").equals("Delete")) {
      PrintWriter printWriter = response.getWriter();
      @SuppressWarnings("unused")
	Doctor doctor = new Doctor();
      DoctorDao dao = new DoctorDao();
      dao.deleteDoctor(Integer.parseInt(request.getParameter("id")));
      RequestDispatcher dispatcher = request.getRequestDispatcher("delete.jsp");
      dispatcher.include(request, response);
      printWriter.print("<br><h2>Doctor Deleted Successfully!!</h2>");
    }

  }

}