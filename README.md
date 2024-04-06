# Inventory-Management-System

Web Services - Assignment#1

Laith Ghnemat-1200610

Birzeit University

   The Inventory Managemant System is a comprehensive software system built around four core entities: Product, Customer, Order and Supplier as follows:
    
   * Product: Represents a product in the inventory. Each product has a unique ID, name, price, description, production date, expiration date and quantity. In my project, I can add new products, update, delete and retrieve product information through this class.
     
   * Customer: Represents a customer who can place orders. Each customer has a unique ID, name, email, address and phone number. I can add new customers, update and retrieve customer information.
    
   * Order: Represents an order placed by a customer. Each order has a unique ID, date, total cost and status (processing or shipping). I can create new orders, update order status and calculate total costs.

   * Supplier: Represents a supplier who provides products to the inventory. Each supplier has a unique ID, name, address, email and phone number. In my project, I can add new suppliers, update and retrieve supplier information.

   The relationships between these entities are critical to the functioning of the system. I have the following relations in my project:
    - Each product can be included in multiple orders, and each order can contain multiple products.
    - Each product is supplied by a single supplier, and each supplier can supply multiple products.
    - Each customer can submit multiple orders, and each order is placed by one customer.

Here is the ER Diagram of my project:

![ERD](https://github.com/LaithGhnemat12302/Inventory-Management-System/assets/134155389/d211d8e2-2c49-40e5-9234-242dd91235eb)




