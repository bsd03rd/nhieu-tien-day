/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import Model.GoogleUser;
import Model.User;
import java.io.IOException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.fluent.Form;
import org.apache.http.client.fluent.Request;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

    public class GoogleUtils {

        public static String getToken(final String code) throws ClientProtocolException, IOException {
//            String response = Request.Post(Constants.GOOGLE_LINK_GET_TOKEN)
//                    .bodyForm(Form.form().add("client_id", Constants.GOOGLE_CLIENT_ID)
//                            .add("client_secret", Constants.GOOGLE_CLIENT_SECRET)
//                            .add("redirect_uri", Constants.GOOGLE_REDIRECT_URI).add("code", code)
//                            .add("grant_type", Constants.GOOGLE_GRANT_TYPE).build())
//                    .execute().returnContent().asString();
            String uri = "https://accounts.google.com/o/oauth2/token?code="+code+"&client_id=360712733433-c1sc36s6apgp7gvfojp8fj00er2art2e.apps.googleusercontent.com&client_secret=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&redirect_uri=http://localhost:8080/LearningProject/login-google&grant_type=authorization_code";
            String response = Request.Post(uri).execute().returnContent().asString();
            JsonObject jobj = new Gson().fromJson(response, JsonObject.class);
            String accessToken = jobj.get("access_token").toString().replaceAll("\"", "");
            return accessToken;
        }

        public static GoogleUser getUserInfo(final String accessToken) throws ClientProtocolException, IOException {
            String link = "https://www.googleapis.com/oauth2/v1/userinfo?access_token=" + accessToken;
            String response = Request.Get(link).execute().returnContent().asString();
            GoogleUser googlePojo = new Gson().fromJson(response, GoogleUser.class);            
            return googlePojo;
        }
    }

