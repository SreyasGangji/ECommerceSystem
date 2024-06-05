# Online Shopping System

## Project Overview

This project is an online shopping system implemented in Java, featuring both console-based and GUI-based interfaces. It demonstrates the use of SOLID principles, various design patterns, and JUnit testing for a robust shopping experience.

## Project Structure

The project consists of the following main components:

1. **MainApp**: Console-based interface for the shopping system.
2. **MainAppGUI**: GUI-based interface for the shopping system.
3. **ShopperAuth**: Manages shopper authentication.
4. **ShoppingBasket**: Manages the items in the shopper's basket.
5. **Inventory**: Manages the available items.
6. **ItemLoader**: Loads sample items into the inventory.
7. **ActivityLogger**: Logs activities in the system.
8. **Purchase**: Represents an order placed by a shopper.
9. **PaymentHandler**: Handles payment processing.
10. **Item Interface**: Defines the structure of an item.
11. **ApparelItem**: Represents apparel items.
12. **GadgetItem**: Represents gadget items.
13. **JUnit Tests**: Tests for various components of the system (ShopperAuth, ShoppingBasket, Inventory, and PaymentHandler).

## Getting Started

### Prerequisites

- Java Development Kit (JDK) 8 or higher
- An IDE that supports Java (e.g., IntelliJ IDEA, Eclipse, VSCode)
- JUnit 4 library for testing

### Setting Up the Project

1. **Clone the repository**:
   ```sh
   git clone https://github.com/SreyasGangji/ECommerceSystem.git
   cd online-shopping-system
2. **Open the project in your IDE**:

- If using Eclipse, go to File -> Open Projects from File System... and select the project directory.
- If using IntelliJ IDEA, go to File -> Open and select the project directory.
- If using VSCode, open the project folder directly.

3. **Add JUnit to your project**:

- Download JUnit 4 jar from JUnit and Hamcrest.
- Add the JUnit and Hamcrest jars to your project’s build path:
    - In Eclipse, right-click on the project, go to Build Path -> Configure Build Path..., and add the jars to the Libraries tab.
    - In IntelliJ IDEA, go to File -> Project Structure..., and add the jars under Modules -> Dependencies.
    - In VSCode, use the java.project.referencedLibraries setting to include the jars in settings.json.

#### Running the Console-based Application
1. Navigate to the MainApp.java file in the src/ecommerce package.

2. Run the MainApp class:

    - In your IDE, right-click on MainApp.java and select Run As -> Java Application.
    - Alternatively, use the command line:
        `cd src
        javac ecommerce/MainApp.java
        java ecommerce.MainApp`

3. Interacting with the GUI-based Application:

- Registration: Enter 1, then follow the prompts to enter your username, password, name, and email.
    - Username: Must contain only lowercase letters.
    - Password: Must contain one uppercase letter, one special character, one number, and at least 8 characters.
    - Name: Must be in the format 'First Last' with the first letter of each word capitalized.
    - Email: Must contain the @ symbol.
- Login: Enter 2, then enter your username and password.
- Browse Items: Enter 3 to view available items.
- Add Item to Basket: Enter 4, then type the name of the item to add it to your basket.
- View Basket: Enter 5 to view items in your basket.
- Place Order: Enter 6 to place your order. Payment will be processed via a mock Credit Card.
- Exit: Enter 7 to exit the application.

##### Running the GUI-based Application
1. Navigate to the MainAppGUI.java file in the src/ecommerce package.

2. Run the MainAppGUI class:

    - In your IDE, right-click on MainAppGUI.java and select Run As -> Java Application.
    - Alternatively, use the command line:

    ```java
    javac src/ecommerce/MainAppGUI.java
    java -cp src ecommerce.MainAppGUI
    ```
3. Interacting with the GUI-based Application:

- Register: Click the Register button, enter your details in the dialog box, and click OK.
- Login: Click the Login button, enter your username and password in the dialog box, and click OK.
- Browse Items: Click the Browse Items button to view available items.
- Add to Basket: Click the Add to Basket button, enter the item name in the dialog box, and click OK.
- View Basket: Click the View Basket button to view items in your basket.
- Place Order: Click the Place Order button to place your order. Payment will be processed via a mock Credit Card.

###### Running the Tests

1. Navigate to the PaymentHandlerTest.java, ShoppingBasketTest.java, and InventoryTest.java files in the src/ecommerce package.
2. Run the JUnit tests:
    - In your IDE, right-click on the test file and select Run As -> JUnit Test.

