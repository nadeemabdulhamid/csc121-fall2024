/** Represents the receipt for a coffee sale */ 
class Coffee {
	String kind;
	int price; // cents per pound 
	int weight; // pounds

	Coffee(String kind, int price, int weight) { 
		this.kind = kind;
		this.price = price;
		this.weight = weight;
	}
}

