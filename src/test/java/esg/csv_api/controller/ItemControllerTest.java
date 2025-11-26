package esg.csv_api.controller;

import esg.csv_api.model.Item;
import esg.csv_api.repository.ItemRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import tools.jackson.databind.ObjectMapper;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ItemController.class)
public class ItemControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private ItemRepository repo;

    @Autowired
    private ObjectMapper objectMapper;

    private Item createSampleItem() {
        return new Item(1L, "CUST001", "John Doe", "123 Street", "", "City", "County", "UK", "AB12 3CD");
    }

    @Test
    void testCreateItem() throws Exception {
        Item item = createSampleItem();

        Mockito.when(repo.save(any(Item.class))).thenReturn(item);

        mockMvc.perform(post("/api/items")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(item)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.customerRef").value("CUST001"))
                .andExpect(jsonPath("$.customerName").value("John Doe"));
    }

    @Test
    void testGetItemsByCustomerReference() throws Exception {
        List<Item> items = List.of(createSampleItem());

        Mockito.when(repo.findByCustomerRef("CUST001")).thenReturn(items);

        mockMvc.perform(get("/api/items/CUST001"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(1))
                .andExpect(jsonPath("$[0].customerRef").value("CUST001"));
    }

    @Test
    void testGetItemsByCustomerReferenceEmpty() throws Exception {
        Mockito.when(repo.findByCustomerRef("UNKNOWN")).thenReturn(List.of());

        mockMvc.perform(get("/api/items/UNKNOWN"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(0));
    }
}
