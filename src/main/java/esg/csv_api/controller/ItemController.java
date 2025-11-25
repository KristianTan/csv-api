package esg.csv_api.controller;

import esg.csv_api.model.Item;
import esg.csv_api.repository.ItemRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/items")
public class ItemController {

    private final ItemRepository repo;

    public ItemController(ItemRepository repo) {
        this.repo = repo;
    }

    @PostMapping
    public Item createItem(@RequestBody Item item) {
        return repo.save(item);
    }

    @GetMapping
    public List<Item> getAllItems() {
        return repo.findAll();
    }
}
