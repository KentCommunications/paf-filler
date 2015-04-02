package com.kentcommunications.pdf;

public interface Pdf {

  public String[] listOfFields();

  public void setField(String field, String value);

}
