package elirans.protein.shop;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ItemController {
	
	@PostConstruct
	@RequestMapping("/items")
	public List<Item> getAllItems() {
		return ItemService.getAllItems();
		
	}
	
	@PostConstruct
	@RequestMapping ("/items/{id}")
	public Optional<Item> getItem(@PathVariable String id) {
		return ItemService.getItem(id);
	}
	
	@PostConstruct
	@RequestMapping(method=RequestMethod.POST, value="/items")
	public void addItem(@RequestBody Item item) {
		
		ItemService.addItem(item);
	}
	
	@PostConstruct
	@RequestMapping(method=RequestMethod.PUT, value="/items/{id}")
	public void updateItem(@RequestBody Item item, @PathVariable String id) {
		
		ItemService.addItem(item);
	}
	
	@PostConstruct
	@RequestMapping(method=RequestMethod.DELETE, value="/items/{id}")
	public void deleteItem(@PathVariable String id) {
		ItemService.deleteItem(id);
	}

}
