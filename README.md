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

* This is the design and documentation for the Supplier resource:
![1](https://github.com/LaithGhnemat12302/Inventory-Management-System/assets/134155389/e06f47ed-425e-48cb-92e0-787cd9e9b7b2)
![2](https://github.com/LaithGhnemat12302/Inventory-Management-System/assets/134155389/d05e9dac-fff5-43bd-bdbb-f4a06e0f5a8f)

* This is the design and documentation for the Product resource:
![3](https://github.com/LaithGhnemat12302/Inventory-Management-System/assets/134155389/419e0b1f-4546-4193-822b-00817e0b0d42)
![4](https://github.com/LaithGhnemat12302/Inventory-Management-System/assets/134155389/426336f0-9dbc-4a0a-abb4-a78febf67692)





