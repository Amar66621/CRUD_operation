package org.doctor.bean;

public class Doctor {

  private int id;
  private String name;
  private String specialist;
  private String email;
  private String city;
  private String country;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getSpecialist() {
    return specialist;
  }

  public void setSpecialist(String specialist) {
    this.specialist = specialist;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  public Doctor(int id, String name, String specialist, String email, String city, String country) {
    super();
    this.id = id;
    this.name = name;
    this.specialist = specialist;
    this.email = email;
    this.city = city;
    this.country = country;
  }

  public Doctor() {
    super();
    // TODO Auto-generated constructor stub
  }

}