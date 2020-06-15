package com.example.tallink;

import com.example.tallink.model.Conference;
import com.example.tallink.rest.ConferenceController;
import com.example.tallink.service.ConferenceService;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.time.Instant;

import static io.restassured.module.mockmvc.RestAssuredMockMvc.*;
import static org.hamcrest.Matchers.equalTo;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ConferenceControllerTests {

    @Autowired
    private ConferenceController conferenceController;

    @Autowired
    private ConferenceService conferenceService;

    @Autowired
    private EntityManager entityManager;

    @BeforeEach
    public void setup() {
        standaloneSetup(conferenceController);
    }

    @Test
    @Transactional
    public void testCreateConference() {
        given()
                .body(new Conference("zuljen", Instant.now().plusSeconds(864000L)))
                .contentType(ContentType.JSON)
                .when()
                .post("/conference")
                .then()
                .assertThat()
                .statusCode(201)
                .contentType(ContentType.JSON)
                .body("name", equalTo("zuljen"));
    }

    @Test
    @Transactional
    public void testFindConferenceById() {
        entityManager.persist(new Conference("testconference", Instant.now()));
        conferenceService.findConferences().forEach(System.out::println);
        get("/conference/{id}", 1)
                .then()
                .assertThat()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .header("andrei", equalTo("hello"))
                .body("name", equalTo("testconference"));
    }
}

//    @Test
//    public void response ()
//    {
//        baseURI="http://testme/api/";
//        given().
//                header("Id", "abc").
//                param("Key", "NuDVhdsfYmNkDLOZQ").
//                param("ConId", "xyz").
//                when().
//                get("/uk?Id=DT44FR100731").
//                then().
//                contentType(ContentType.JSON).
//                body("response.code", equalTo("200"));
//    }

//    @Test
//    public void restAssuredGetExample() {
//        given()
//                .when()
//                .get("/test")
//                .then()
//                .statusCode(200);
//    }