package pet.store.controller;




import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import pet.store.controller.model.PetStoreCustomer;
import pet.store.controller.model.PetStoreData;
import pet.store.controller.model.PetStoreEmployee;
import pet.store.service.PetStoreService;

@RestController
@RequestMapping("/pet_store")
@Slf4j
public class PetStoreController {
  @Autowired
  private PetStoreService petStoreService;
    
  @PostMapping("/pet_store")
  public PetStoreData insertPetStore(
		  @RequestBody PetStoreData petStoreData) {
	log.info("Creating pet store {}", petStoreData);
	return petStoreService.savePetStore(petStoreData);
  }
  @PutMapping("/{petStoreId}")
  public  PetStoreData modifyPetStore(@PathVariable Long petStoreId, 
		  @RequestBody PetStoreData petStoreData) {
	  petStoreData.setPetStoreId(petStoreId);
	  log.info("Updating pet store {}", petStoreData);
	  return petStoreService.savePetStore(petStoreData);
  }
  @PostMapping("/{petStoreId}/employee")
  @ResponseStatus(code = HttpStatus.CREATED)
  public PetStoreEmployee insertEmployee(@PathVariable Long petStoreId,
		  @RequestBody PetStoreEmployee petStoreEmployee) {
	  log.info("Creating employee {}", petStoreEmployee);
	  return petStoreService.saveEmployee(petStoreId, petStoreEmployee);
  }
  @PostMapping("/{petStoreId}/customer")
  @ResponseStatus(code = HttpStatus.CREATED)
  public PetStoreCustomer insertCustomer(@PathVariable Long petStoreId,
		  @RequestBody PetStoreCustomer petStoreCustomer) {
	  log.info("Creating customer {}", petStoreCustomer);
	  return petStoreService.saveCustomer(petStoreId, petStoreCustomer);
}
  @GetMapping("/pet_stores")
  public List<PetStoreData> retrievePetStores() {
	  return petStoreService.retrieveAllPetStores();
	  
  }
  @GetMapping("/{petStoreId}/pet_store")
  public PetStoreData retrievePetStore(@PathVariable Long petStoreId) {
	  return petStoreService.retrievePetStore(petStoreId);
  }
  @DeleteMapping("/{petStoreId}/pet_store")
  public Map<String,String> deletePetStoreById(
		  @PathVariable Long petStoreId) {
	  log.info("Deleting Pet Store with ID={} ", petStoreId);
	  
	  petStoreService.deletePetStoreById(petStoreId);
	  
	  return Map.of("message", "Deletion of Pet Store with ID=" + petStoreId + "was successful.");
  }
}
