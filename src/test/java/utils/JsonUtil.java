package utils;


import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;

public class JsonUtil {

    private static ObjectMapper mapper;

    static {

        mapper = new ObjectMapper();
    }

    //1.Method: Json datasini Java Objesine cevirir.(De-Serialization)
    public static <T> T convertJsonJavaObject(String json, Class<T> cls) {
        T javaResult = null;

        try {
            mapper.readValue(json, cls);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return javaResult;
    }


    //2.Method : Java objesini Json Dataya cevirir(Serialization)

    public String convertJavaObjectToJson(Object obj) {

        String jsonresult = null;
        try {
            jsonresult = mapper.writeValueAsString(obj);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return jsonresult;
    }
}
