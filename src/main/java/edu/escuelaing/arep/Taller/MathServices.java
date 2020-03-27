/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.escuelaing.arep.Taller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import static spark.Spark.*;
import spark.Request;
import spark.Response;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author sarah.vieda
 */
public class MathServices {
    private static URL url;

    public static void main(String[] args) {
        port(getPort());
        get("/inputdata", (req, res) -> inputDataPage(req, res));
        get("/results", (req, res) -> {
            res.type("application/json");
            return resultDataPage(req,res);
        });
    }

    public static Integer square(Integer i) {
        return i * i;
    }

 
    private static String resultDataPage(Request req, Response res) {
      int num = Integer.parseInt(req.queryParams("numero"));
      String text = "";
      try {
          url = new URL("https://svz7imsuh3.execute-api.us-east-1.amazonaws.com/Beta" + "?value=" + num);
          String temp;
          BufferedReader reader = new BufferedReader(
                  new InputStreamReader(url.openStream()));
          while ((temp = reader.readLine()) != null) {
              text = text + temp;
          }
      } catch (MalformedURLException ex) {
          Logger.getLogger(MathServices.class.getName()).log(Level.SEVERE, null, ex);
      } catch (IOException ex) {
          Logger.getLogger(MathServices.class.getName()).log(Level.SEVERE, null, ex);
      }
      return text;
  }

    

    /**
     * Este metodo recibe los datos que el usuario desea agregar a la Linked
     * List
     *
     * @param req
     * @param res
     * @return pageC
     */
    private static String inputDataPage(Request req, Response res) {
        String pageC
                = "<!DOCTYPE html>"
                + "<html>"
                + "<body>"
                + "<h2>Bandeja de entrada de los numeros:</h2>"
                + "<h2>Introduzca el numero para calcular el cuadrado</h2>"
                + "<form action='/resultados\'>"
                + "<input type=\"text\" name='data'>"
                + "<input type=\"submit\" value=\"Continue\">"
                + "</form>"
                + "</body>"
                + "</html>";
        return pageC;
    }

    static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567;
    }

}
