package designpattern.factorymethod.idcard;

import java.util.*;

import designpattern.factorymethod.framework.Factory;
import designpattern.factorymethod.framework.Product;

public class IDCardFactory extends Factory {
    
    private List owners = new ArrayList();

    protected Product createProduct(String owner) {
	return new IDCard(owner);
    }

    protected void registerProduct(Product product) {
	owners.add(((IDCard) product).getOwner());
    }

    public List getOwners() {
	return owners;
    }
}
