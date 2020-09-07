package com.yourssu.tools;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class WriteToClient {

    public static void send(HttpServletResponse response, org.json.simple.JSONObject jsonObject) {
        try {
            response.setCharacterEncoding("UTF-8");
            response.setContentType("application/json");
            response.getWriter().println(jsonObject.toJSONString());
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}
