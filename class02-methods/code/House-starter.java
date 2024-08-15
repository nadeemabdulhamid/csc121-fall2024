/**************************************************************
 Suppose you were given the following assignment: 
  
       ...Develop a "real estate assistant" program.  The "assistant" helps 
       real estate agents locate available houses for clients. The information 
       about a house includes its kind, the square footage, its address, and 
       the asking price. An address consists of a street number and a 
       street name.
  
  Examples:
       1. Ranch, 2500 sq ft, 23 Maple St., $375,000 
       2. Colonial,2000 sq ft, 18 Thelberg Rd., $250,000 
       3. Cape, 4000 sq ft, 12 Timberline Dr., $400,000 
*/

  
/*
 +--------------------------------+
 | House                          |
 +--------------------------------+
 | String kind                    |
 | int area                       |
 | String address                 |
 | int price                      |
 +--------------------------------+  
 | int costPerSqFt()              |
 | boolean moreExpensiveThan(int) |
 | boolean morePerSqFtThan(House) |
 +--------------------------------+  
*/

/** Represents information about a house for sale */
class House {
  String kind;
  int area;     // in square feet
  String address;
  int price;    // in dollars
  
  House(String kind, int area, String address, int price) {
    this.kind = kind;
    this.area = area;
    this.address = address;
    this.price = price;
  } 
  
  /* TEMPLATE
  ...
  */
  
  /**************************************************************
  ...Now design a method called costPerSqFt that computes the price 
       per square foot of a given house... 
  */
  
 
  
  /**************************************************************
  ...Design a method to determine whether the asking price of a house is 
    greater than a given value... (pg 93, method arguments)
  */
 

  /**************************************************************
  ...Design a method to determine whether the cost per sq ft of a house is 
    greater than the cost per sq ft of another house...(p. 95... two House
    arguments)  
  */
  
 
  
  /**************************************************************
  ...Design a method to compute the amount of property tax on a house,
  based on their listed sale price. Houses priced up to $200,000 are
  taxed at 1/100 of their value; houses valued up to $350,000 are taxed 
  at 3/200 of their value; and houses above that are taxed at 1/50 of 
  their value...
  */
  

  
}


