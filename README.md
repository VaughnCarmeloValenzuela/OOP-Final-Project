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

> Book and Member classes: Both classes encapsulate data (attributes
> like title, author, genre, available status, etc.) and methods
> (operations like toString(), addReservation(), etc.) that work with
> that data. This hides the internal implementation details from the
> outside world, making the code more maintainable and preventing
> unintended modifications.

*2. Abstraction:*

> Book and Member classes: These classes act as abstract representations
> of real-world entities. They define the essential characteristics and
> behaviors of books and members in the library context, without
> revealing the specific implementation details. This allows for
> flexibility and future changes without impacting other parts of the
> system.

*3. Inheritance (Not Explicitly Used):*

> Reusability: The Book class inherits from LibraryItem, reusing the
> common attributes and methods defined in the parent class. This saves
> code and makes the system more maintainable.
>
> Specialization: The Book class extends the LibraryItem class by adding
> its own unique features, like the genre attribute, and overriding
> methods like borrow() and returnItem() to provide book-specific
> behavior.

*4. Polymorphism:*

> toString() method: The toString() method is overridden in both Book
> and Member classes. This allows for different representations of these
> objects when printed, demonstrating polymorphism.

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
  
### How to Use:

