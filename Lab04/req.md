# AIMS Console Application Requirements

Implement a complete console-based application in the `Aims` class. In the `main` method, create an instance of the `Store` class and provide a menu-driven interface that allows users to interact with the system continuously until they choose to exit.

## Main Menu

Implement the following method:

```java
public static void showMenu() {
    System.out.println("AIMS: ");
    System.out.println("--------------------------------");
    System.out.println("1. View store");
    System.out.println("2. Update store");
    System.out.println("3. See current cart");
    System.out.println("0. Exit");
    System.out.println("--------------------------------");
    System.out.println("Please choose a number: 0-1-2-3");
}
```

### Main Menu Functionalities

#### 1. View Store

When the user chooses **View store**:

- Display all media items currently available in the store.
- Show the following submenu:

```java
public static void storeMenu() {
    System.out.println("Options: ");
    System.out.println("--------------------------------");
    System.out.println("1. See a media’s details");
    System.out.println("2. Add a media to cart");
    System.out.println("3. Play a media");
    System.out.println("4. See current cart");
    System.out.println("0. Back");
    System.out.println("--------------------------------");
    System.out.println("Please choose a number: 0-1-2-3-4");
}
```

##### Store Menu Functionalities

###### Option 1 — See a Media’s Details

- Ask the user to enter the title of a media.
- Validate the entered title.
- If the media exists:
  - Display all information of that media.
  - Show the following submenu:

```java
public static void mediaDetailsMenu() {
    System.out.println("Options: ");
    System.out.println("--------------------------------");
    System.out.println("1. Add to cart");
    System.out.println("2. Play");
    System.out.println("0. Back");
    System.out.println("--------------------------------");
    System.out.println("Please choose a number: 0-1-2");
}
```

- The **Play** option is only available for:
  - CD
  - DVD

###### Option 2 — Add a Media to Cart

- Ask the user to enter the title of a media shown in the store list.
- Validate the title.
- Add the selected media to the cart.

Additional requirement:

- After adding a DVD to the cart, display the current number of DVDs in the cart.

###### Option 3 — Play a Media

- Ask the user to enter the title of a media.
- Validate the title.
- If the media supports playback (CD/DVD), execute the play functionality.

###### Option 4 — See Current Cart

- Display all media currently in the cart.
- Show the cart menu.

---

#### 2. Update Store

When the user chooses **Update store**:

- Allow the user to:
  - Add media to the store
  - Remove media from the store

You may implement additional submenus if necessary.

---

#### 3. See Current Cart

Display the following cart menu:

```java
public static void cartMenu() {
    System.out.println("Options: ");
    System.out.println("--------------------------------");
    System.out.println("1. Filter medias in cart");
    System.out.println("2. Sort medias in cart");
    System.out.println("3. Remove media from cart");
    System.out.println("4. Play a media");
    System.out.println("5. Place order");
    System.out.println("0. Back");
    System.out.println("--------------------------------");
    System.out.println("Please choose a number: 0-1-2-3-4-5");
}
```

##### Cart Menu Functionalities

###### Option 1 — Filter Medias in Cart

Allow the user to filter media items by:

1. ID
2. Title

###### Option 2 — Sort Medias in Cart

Allow the user to sort media items by:

1. Title
2. Cost

###### Option 3 — Remove Media from Cart

- Ask the user for the media title or ID.
- Remove the selected media from the cart.

###### Option 4 — Play a Media

- Ask the user to choose a media from the cart.
- If the media supports playback, execute the play functionality.

###### Option 5 — Place Order

When the user places an order:

- Display a notification indicating that the order has been created successfully.
- Empty the current cart.

Note:

- Delivery information gathering and payment processing are not required.
- Only simulate successful order creation.

---

## Suggested Classes

- `Aims`
- `Store`
- `Cart`
- `Media`
- `Book`
- `CompactDisc`
- `DigitalVideoDisc`

---

## Additional Recommendations

### Input Validation

- Prevent invalid menu selections.
- Check media existence before operations.
- Handle invalid IDs or titles gracefully.

### Loop Structure

Keep the application running until the user selects `0. Exit`.

Example:

```java
do {
    showMenu();
    choice = scanner.nextInt();

    switch(choice) {
        case 1:
            // View store
            break;
        case 2:
            // Update store
            break;
        case 3:
            // See current cart
            break;
        case 0:
            System.out.println("Goodbye!");
            break;
        default:
            System.out.println("Invalid choice!");
    }
} while(choice != 0);
```

---

## Expected Outcome

The final application should provide:

- A complete interactive console interface
- Store management
- Cart management
- Media playback
- Filtering and sorting functionalities
- Order placement simulation
- Proper input validation and menu navigation
