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
![1](https://github.com/LaithGhnemat12302/Inventory-Management-System/assets/134155389/32b2d9de-75a0-441e-8d23-a3c547439507)
![2](https://github.com/LaithGhnemat12302/Inventory-Management-System/assets/134155389/25b2ab11-9979-4e3b-aae4-05c21ea8a761)


* This is the design and documentation for the Product resource:
![3](https://github.com/LaithGhnemat12302/Inventory-Management-System/assets/134155389/7bcbf907-be20-4cb1-b7a4-8312660ad245)
![4](https://github.com/LaithGhnemat12302/Inventory-Management-System/assets/134155389/9942d4dd-c97c-4309-b81b-b2f3bf1d4d08)


* This is the design and documentation for the Order resource:
![5](https://github.com/LaithGhnemat12302/Inventory-Management-System/assets/134155389/d5e75cd5-93a4-4838-8f70-58d805f0910e)
![6](https://github.com/LaithGhnemat12302/Inventory-Management-System/assets/134155389/8bf8a5b2-36f1-4489-bdc1-b0151c8f4ff4)


* This is the design and documentation for the Customer resource:
![7](https://github.com/LaithGhnemat12302/Inventory-Management-System/assets/134155389/5547ba8d-2974-49c1-aaaf-9ae52caad464)
![8](https://github.com/LaithGhnemat12302/Inventory-Management-System/assets/134155389/acf5eebe-6090-46c4-be4b-32c7826f41a2)


This is the openAPI:
![openapi](web_services/openapi3_1.yaml)










