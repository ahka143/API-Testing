import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.*;

public class Get01 {
    /*
    POSTMAN, manuel olarak API testi yapmak için kullanılır.
    API otomasyonda ise REST Assured Library kullanacağız
    REST API kullanmamızın sebebi hem Json hem de Xml olarak kullanılabiliyor olmasıdır.
    Otomasyon kodlarının yazımı için şu adımları izliyoruz;

    a) -->  Gereksinimleri anlama
    b) -->  Test case'leri yazma
    _______ Test case yazımı için Gherkin plugin kullanılacaktır.
    _______ Given, Then, And, But gibi keywodler kullanılacaktır.
    _______ Given (ön koşullar)
    ________ When (aksiyonlar)
    ________ Then (dönütler, doğrulama, response gibi)
    ________ And (çoklu işlemeler için)

    c) -->  Otomasyonda test kodunun yazımı yapılacak
            1) Set the URL (URl'yi kurmak)
            2) Set the expected Data (beklenen datanın oluşturulması)   """POST, PUT PATCH"""
            3) Type code to send request (talep göndermek için kod yazma)
            4) Do Assertion (doğrulama yapma)
     */


    /*
    Given
            https://restful-booker.herokuapp.com/booking/3
        When
            User sends a GET Request to the url
        Then
            HTTP Status Code should be 200
        And
            Content Type should be JSON
        And
            Status Line should be HTTP/1.1 200 OK
     */
   @Test
    public void get01(){

       // 1) Set the URL (URl'yi kurmak)
       String url="https://restful-booker.herokuapp.com/booking/555";
       //  2) Set the expected Data (beklenen datanın oluşturulması)   """POST, PUT PATCH"""
       //  3) Type code to send request (talep göndermek için kod yazma)
       Response response=given().when().get(url);
       response.prettyPrint();
       //   4) Do Assertion (doğrulama yapma)
       response.then().assertThat().statusCode(200).contentType("application/json").statusLine("HTTP/1.1 200 OK");

      //status code nasil yazdirilir
       System.out.println(response.statusCode());

       //content type nasil yazirilir
       System.out.println(response.contentType());

       //status line nasil yazdirilir
       System.out.println(response.statusLine());

       //header nasil yazdirilir

       System.out.println(response.headers());

       //time nasil yazdirilir
       System.out.println(response.getTime());



   }

}
