package ru.inno.course.homework19;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class toDoListTests {
    String defaultUri = "https://todo-app-sky.herokuapp.com/";

    HttpClient httpClient;

    @BeforeEach
    public void setUp() {
        httpClient = HttpClientBuilder.create().build();
    }

    @Test
    public void cantCreateEmptyIssue() throws IOException {
        HttpPost postRequest = new HttpPost(defaultUri);
        assertEquals(400, httpClient.execute(postRequest).getStatusLine().getStatusCode());
    }
}
