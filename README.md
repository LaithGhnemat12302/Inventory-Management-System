# Inventory-Management-System
Web Services - Assignment#1
Laith Ghnemat-1200610
Birzeit University

The Inventory Managemant System is a comprehensive software system built around four core entities: Product, Customer, Order and Supplier as follows:
    * Each product has a unique ID, name, price, description, production date, expiration date and quantity.
    * Each customer has a unique ID, name, email, address and phone number.
    * Each order has a unique ID, date, total cost and status (processing or shipping).
    * Each supplier has a unique ID, name, address, email and phone number.

The relationships between these entities are critical to the functioning of the system. I have the following relations in my project:
    - Each product can be included in multiple orders, and each order can contain multiple products.
    - Each product is supplied by a single supplier, and each supplier can supply multiple products.
    - Each customer can submit multiple orders, and each order is placed by one customer.

Here is the ER Diagram of my project:

![ERD](https://github.com/LaithGhnemat12302/Inventory-Management-System/assets/134155389/d211d8e2-2c49-40e5-9234-242dd91235eb)




