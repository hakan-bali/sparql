package com.elsevier.scibi;

import com.bordercloud.sparql.SparqlClient;
import com.bordercloud.sparql.SparqlClientException;
import com.bordercloud.sparql.SparqlResultModel;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Question {

  public static String ask(String query) {
    if (query.equalsIgnoreCase(Constants.QUERY_DAVID_CAMERON_AGE)) {
      return queryAge(Constants.DAVID_CAMERON);
    } else if (query.equalsIgnoreCase(Constants.QUERY_TONY_BLAIR_AGE)) {
      return queryAge(Constants.TONY_BLAIR);
    } else if (query.equalsIgnoreCase(Constants.QUERY_DAVID_CAMERON_BIRTH_NAME)) {
      return queryBirthName(Constants.DAVID_CAMERON);
    } else if (query.equalsIgnoreCase(Constants.QUERY_TONY_BLAIR_BIRTH_NAME)) {
      return queryBirthName(Constants.TONY_BLAIR);
    }
    return Constants.RESULT_NOT_FOUND;
  }

  public static String queryAge(String name) {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.ENGLISH);
    LocalDate date = LocalDate.parse(query(name, "P569"), formatter);
    return String.valueOf(Period.between(date, LocalDate.now()).getYears());
  }

  public static String queryBirthName(String name) {
    return query(name, "P1477");
  }

  public static String query(String name, String property) {
    try {
      SparqlClient sc = new SparqlClient(false);
      sc.setEndpointRead(new URI(Constants.URI_WIKIDATA));
      String query =
          "select ?a where {\n" +
              "?z rdfs:label \"" + name + "\"@en .\n" +
              "?z wdt:" + property + "?a .\n" +
              "}";
      SparqlResultModel resultModel = sc.query(query).getModel();
      if (resultModel.getVariables().size() > 0 && resultModel.getRows().size() > 0) {
        String variable = resultModel.getVariables().get(0);
        return (String) resultModel.getRows().get(0).get(variable);
      }
    } catch (URISyntaxException | SparqlClientException e) {
      System.out.println(e);
      e.printStackTrace();
    }
    return Constants.RESULT_NOT_FOUND;
  }

}