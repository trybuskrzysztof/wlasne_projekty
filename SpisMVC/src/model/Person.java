package model;

import javafx.beans.property.SimpleStringProperty;

public class Person {
  private String firstName;
  private String lastName;
  private String roomNumber;
  private String hourBeginning;
  private String hourEnd;
  private SimpleStringProperty f1, f2, f3, f4, f5, f6;
  
  public Person(String firstName, String lastName, String roomNumber, String hourBegginning, String hourEnd){
	  this.firstName=firstName;
	  this.lastName=lastName;
	  this.roomNumber=roomNumber;
	  this.hourBeginning=hourBegginning;
	  this.hourEnd=hourEnd;
  }
  
  public Person(String firstName){
	  this.firstName=firstName;
  }
  
  public Person(String firstName, String lastName){
	  this.firstName=firstName;
	  this.lastName=lastName;
  }
  
  public Person(String firstName, String lastName, String roomNumber){
	  this.firstName=firstName;
	  this.lastName=lastName;
	  this.roomNumber=roomNumber;
  }
  
  public Person(String firstName, String lastName, String roomNumber, String hourBeginning){
	  this.firstName=firstName;
	  this.lastName=lastName;
	  this.roomNumber=roomNumber;
	  this.hourBeginning=hourBeginning;
  }
  
  public String getFirstName(){
	  return firstName;
  }
  
  public String getLastName(){
	  return lastName;
  }
  
  public String getRoomNumber(){
	  return roomNumber;
  }
  
  public String getHourBeginning(){
	  return hourBeginning;
  }
  
  public String getHourEnd(){
	  return hourEnd;
  }
  
  public void setFirstName(String firstName){
	  this.firstName=firstName;
  }
  
  public void setLastName(String lastName){
	  this.lastName=lastName;
  }
  
  public void setRoomNumber(String roomNumber){
	  this.roomNumber=roomNumber;
  }
  
  public void setHourBeginning(String hourBeginning){
	  this.hourBeginning=hourBeginning;
  }
  
  public void setHourEnd (String hourEnd){
	  this.hourEnd=hourEnd;
  }
  
  public String getF1() {
      return f1.get();
  }

  public String getF2() {
      return f2.get();
  }

  public String getF3() {
      return f3.get();
  }

  public String getF4() {
      return f4.get();
  }

  public String getF5() {
      return f5.get();
  }

  public String getF6() {
      return f6.get();
  }

  Person(String f1, String f2, String f3, String f4,
          String f5, String f6) {
      this.f1 = new SimpleStringProperty(f1);
      this.f2 = new SimpleStringProperty(f2);
      this.f3 = new SimpleStringProperty(f3);
      this.f4 = new SimpleStringProperty(f4);
      this.f5 = new SimpleStringProperty(f5);
      this.f6 = new SimpleStringProperty(f6);
  }
}