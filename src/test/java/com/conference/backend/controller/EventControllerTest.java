package com.conference.backend.controller;

import com.conference.backend.ConferenceApplication;
import com.conference.backend.entity.Event;
import com.conference.backend.service.EventService;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Arrays;

import static org.junit.Assert.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;
/**
 * @author Kazim Unalan
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ConferenceApplication.class)
@WebAppConfiguration
public class EventControllerTest {

    private MediaType contentType = new MediaType(MediaType.APPLICATION_JSON.getType(),
            MediaType.APPLICATION_JSON.getSubtype(),
            Charset.forName("utf8"));

    private MockMvc mockMvc;

    private ObjectMapper mapper = new ObjectMapper();

    private HttpMessageConverter mappingJackson2HttpMessageConverter;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    private EventService eventService;


    @Autowired
    void setConverters(HttpMessageConverter<?>[] converters) {

        this.mappingJackson2HttpMessageConverter = Arrays.asList(converters).stream()
                .filter(hmc -> hmc instanceof MappingJackson2HttpMessageConverter)
                .findAny()
                .orElse(null);

        assertNotNull("the JSON message converter must not be null",
                this.mappingJackson2HttpMessageConverter);
    }

    protected String json(Object o) throws IOException {
        String jsonInString = mapper.writeValueAsString(o);
        return jsonInString;
    }

    @Before
    public void setUp() throws Exception {
        this.mockMvc = webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void shouldSaveEvent() throws Exception {
        Event event = new Event();
        event.setHeader("Test");
        event.setPresentationTime("60min");
        eventService.createEvent(event);

        mockMvc.perform(
                post("/event/")
                        .content(this.json(event))
                        .contentType(contentType)
        ).andExpect(status().isOk());
    }

    @Test
    public void shouldGetAllEvents() throws Exception {

        mockMvc.perform(
                get("/event/getAll/")
                        .contentType(contentType)
        ).andExpect(status().isOk());
    }


}