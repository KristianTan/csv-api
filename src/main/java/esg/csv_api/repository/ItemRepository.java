package esg.csv_api.repository;

import esg.csv_api.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Long> {
    List<Item> findByCustomerRef(String customerRef);
}