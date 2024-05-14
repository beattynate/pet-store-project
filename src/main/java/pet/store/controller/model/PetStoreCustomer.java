package pet.store.controller.model;

import java.util.HashSet;
import java.util.Set;

import lombok.Data;
import lombok.NoArgsConstructor;
import pet.store.entity.Customer;
import pet.store.entity.PetStore;


@Data
@NoArgsConstructor
public class PetStoreCustomer {
	private Long customerId;
	  
	  private String customerFirstName;  
	  private String customerLastName;  
	  private String customerEmail;  
	  
	  private Set<PetStoreData> petStores = new HashSet<>();
	  
	  public PetStoreCustomer (Customer customer) {
			this.customerId = customer.getCustomerId();
			this.customerFirstName = customer.getCustomerFirstName();
			this.customerLastName = customer.getCustomerLastName();
			this.customerEmail = customer.getCustomerEmail();
			
		for(PetStore petStore : customer.getPetStores()) {
			this.petStores.add(new PetStoreData(petStore));
			}
	  }
}
