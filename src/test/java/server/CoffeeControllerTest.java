package server;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CoffeeController.class)
@RunWith(SpringRunner.class)
class CoffeeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void getAllCoffee() {
        try {
            mockMvc.perform(get("/coffee/all")).andExpect(status().isOk());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}