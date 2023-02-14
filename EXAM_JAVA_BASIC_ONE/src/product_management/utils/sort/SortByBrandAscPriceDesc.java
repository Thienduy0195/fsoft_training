package product_management.utils.sort;

import java.util.Comparator;

import product_management.entities.Laptop;

public class SortByBrandAscPriceDesc implements Comparator<Laptop> {

	@Override
	public int compare(Laptop o1, Laptop o2) {
		if (o1.getBrand().compareTo(o2.getBrand()) == 0) {
			return o2.getPrice() - o1.getPrice();
		}
		return o1.getBrand().compareTo(o2.getBrand());
	}

}
