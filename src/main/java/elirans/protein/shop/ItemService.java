package elirans.protein.shop;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemService {
	
	@Autowired
	private ItemRepository itemRepository;

//	I used this list before I persisted it on H2 DB using JPA.
/*	private static List<Item> items = Arrays.asList(
			
			new Item ("0001","Protein Powder", "30", "70510570396"),
			new Item ("0002","Whey Protein", "20", "70510570486"),
			new Item ("0003","Casein Protein", "20", "70510570123"),
			new Item ("0004","Isolate Protein", "10", "70510570753")
			);
*/
	
	public static List<Item> getAllItems(){
		
		List<Item> items = new ArrayList<Item>();
		itemRepository.findAll().forEach(items::add);
		return items;
	}
	
	public Optional<Item> getItem(String id) {
		
		return itemRepository.findById(id);
		
	}
	
	public void addItem(Item item) {
		
		itemRepository.save(item);
		
	}
	
	public void updateItem(String id, Item item) {
		
		itemRepository.save(item);
	}
	
	public void deleteItem(String id) {
		
		itemRepository.deleteById(id);
	}

}
