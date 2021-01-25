package com.elsevier.scibi;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class QuestionTest {

  @Test
  void test_me() {
    assertEquals("54",
        Question.ask(Constants.QUERY_DAVID_CAMERON_AGE));
    assertEquals("67",
        Question.ask(Constants.QUERY_TONY_BLAIR_AGE));
    assertEquals("David William Donald Cameron",
        Question.ask(Constants.QUERY_DAVID_CAMERON_BIRTH_NAME));
    assertEquals(Constants.RESULT_NOT_FOUND,
        Question.ask(Constants.QUERY_TONY_BLAIR_BIRTH_NAME));
  }

}