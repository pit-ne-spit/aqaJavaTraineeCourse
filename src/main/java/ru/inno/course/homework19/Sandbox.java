package ru.inno.course.homework19;

import org.apache.commons.codec.binary.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Sandbox {

    static String defaultUri = "https://todo-app-sky.herokuapp.com/";

    static HttpClient httpClient = HttpClientBuilder.create().build();

    public static void main(String[] args) throws IOException {

        HttpPost postRequest = new HttpPost(defaultUri);
        String requestBody = "{title: \"бегит, прыгат\", completed: false}";
        postRequest.setEntity(new StringEntity(requestBody));
        HttpResponse postResponce = httpClient.execute(postRequest);
        System.out.println(postResponce);

        HttpGet getRequest = new HttpGet(defaultUri);
        HttpResponse response = httpClient.execute(getRequest);

        System.out.println(EntityUtils.toString((response.getEntity())));

    }

}
