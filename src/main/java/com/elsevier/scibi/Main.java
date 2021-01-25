package com.elsevier.scibi;

public class Main {

  public static void main(String[] args) {
    System.out.println(Constants.QUERY_DAVID_CAMERON_AGE + "\n" +
        Question.ask(Constants.QUERY_DAVID_CAMERON_AGE) + "\n");

    System.out.println(Constants.QUERY_DAVID_CAMERON_BIRTH_NAME + "\n" +
        Question.ask(Constants.QUERY_DAVID_CAMERON_BIRTH_NAME) + "\n");

    System.out.println(Constants.QUERY_TONY_BLAIR_AGE + "\n" +
        Question.ask(Constants.QUERY_TONY_BLAIR_AGE) + "\n");

    System.out.println(Constants.QUERY_TONY_BLAIR_BIRTH_NAME + "\n" +
        Question.ask(Constants.QUERY_TONY_BLAIR_BIRTH_NAME) + "\n");
  }

}