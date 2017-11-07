package cs544.exercise11_2.service;

public class InventoryService implements IInventoryService {
	public int getNumberInStock(int productNumber) {
		return productNumber - 200;
	}
}
