package com.yourssu.tools;

public class ObjectMaker {

    public static org.json.simple.JSONObject getSimpleJSONObject() {
        return new org.json.simple.JSONObject();
    }

    public static org.json.simple.JSONArray getSimpleJSONArray() {
        return new org.json.simple.JSONArray();
    }

    public static org.json.simple.JSONObject getSimpleJSONObjectWithException(Exception exception) {
        org.json.simple.JSONObject jsonObject = new org.json.simple.JSONObject();
        jsonObject.put("result", false);
        jsonObject.put("message", exception.getMessage());
        return jsonObject;
    }
}
