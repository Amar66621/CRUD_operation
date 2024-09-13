package org.doctor.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.doctor.DBconnect.DBConnection;
import org.doctor.bean.Doctor;

public class DoctorDao {

  public boolean addDoctor(Doctor doctor) {
    // TODO Auto-generated method stub
    Connection con = DBConnection.getConn();
    String sql = "insert into doctor_table (id,name,specialist,email,city,country) values (NULL,?,?,?,?,?) ";
    int i = 0;
    try {
      PreparedStatement preparedStatement = con.prepareStatement(sql);
      preparedStatement.setString(1, doctor.getName());
      preparedStatement.setString(2, doctor.getSpecialist());
      preparedStatement.setString(3, doctor.getEmail());
      preparedStatement.setString(4, doctor.getCity());
      preparedStatement.setString(5, doctor.getCountry());
      i = preparedStatement.executeUpdate();
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    if (i == 0) {
      return false;
    } else {
      return true;
    }
  }

  public boolean editDoctor(Doctor doctor) {
    Connection connection = DBConnection.getConn();
    String sql = "update doctor_table set email=?, city=?, country=?";
    sql += " where id=? ";
    int i = 0;
    try {
      PreparedStatement preparedStatement = connection.prepareStatement(sql);

      preparedStatement.setString(1, doctor.getEmail());
      preparedStatement.setString(2, doctor.getCity());
      preparedStatement.setString(3, doctor.getCountry());
      preparedStatement.setInt(4, doctor.getId());
      i = preparedStatement.executeUpdate();
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    if (i == 0) {
      return false;
    } else {
      return true;
    }
  }

  public void deleteDoctor(int id) {
    Connection connection = DBConnection.getConn();
    String sql = "delete from doctor_table where id=?";
    try {
      PreparedStatement preparedStatement = connection.prepareStatement(sql);
      preparedStatement.setInt(1, id);
      preparedStatement.executeUpdate();
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

}