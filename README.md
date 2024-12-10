## BOOK LOOT: Library Management System 📖

This project is a simple library management system.

### Table of Contents

* [Project Overview](#project-overview)
* [Features](#features)
* [OOP Implementation](#oop-implementation)
* [SDG 4 Integration](#sdg-4-integration)

### Project Overview

The Book Loot: Library Management System is a user friendly, simple
console based application designed to manage the operations of a small
library. It allows users to register members, add new books, borrow
books, return books, reserve books, and view member profiles. The system
seeks to enhance the overall experience for library workers and
customers by automating library procedures.


### Features:

* **Register / Log in** 
* **Add New Books**
* **Borrow Books**
* **Return Books**
* **Search Books** 
* **View Member Profiles**

### OOP Implementation

*1. Encapsulation:*

> The attributes of classes like LibraryItem, Book, and Member are declared as private, ensuring that they cannot be accessed directly from outside the class.

*2. Abstraction:*

> Abstract Class: The use of an abstract class (LibraryItem) allows you to define a template for all library items without specifying how each item's details are displayed or managed.
Interface: The LibraryOperations interface defines a contract for library operations without providing implementation details. Classes like LibraryManagementSystem implement this interface, ensuring they adhere to the defined operations:

*3. Inheritance (Not Explicitly Used):*

> LibraryItem is an abstract class that defines common attributes and methods for all library items. The Book class extends LibraryItem, inheriting its properties and methods while also adding specific features

*4. Polymorphism:*

> Method Overriding: The displayDetails() method in the Book class overrides the abstract method defined in LibraryItem. This allows each subclass to provide its own implementation
> Polymorphic Method Calls: The borrowItem(LibraryItem item) method in LibraryManagementSystem can accept any subclass of LibraryItem, demonstrating polymorphic behavior

### SDG 4 Integration

This project supports SDG 4: Quality Education by making it easier for
library members to access books and resources. By providing a convenient
way to borrow and reserve books, the project aims to encourage reading
and learning within the community. It specifically aligns with SDG
Target 4.1, which emphasizes ensuring that all children complete quality
primary and secondary education.


&ensp;
&ensp;

The **BOOK LOOT: Library Management System** can be understood and used with the help of this README. To make it even more reliable and practical, feel free to experiment with the code and add your own improvements! 
  

