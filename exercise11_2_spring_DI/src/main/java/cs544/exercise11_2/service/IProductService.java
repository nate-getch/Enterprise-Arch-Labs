package cs544.exercise11_2.service;

public interface IProductService {
	public Product getProduct(int productNumber);
	public int getNumberInStock(int productNumber); 
}
