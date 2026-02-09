## User Types
**1. Customer (Primary User)**
Customers who use the app to browse the restaurant menu and place orders.
Main needs:
View menu and categories
Add items to cart
Place orders
View order history
Manage profile
**2. Restaurant Owner (Primary User)**
Restaurant owners or staff who manage menu items.
Main needs:
Manage dishes (add, edit, delete)
Manage personal profile

# Product Backlog: YallaEat
## Backlog Summary – Total User Stories: 11
- Must-Have: 6
- Should-Have: 4
- Nice-to-Have: 1
## Must-Have Stories (Priority 1)##
**Story #1: User Registration [5 points]**
As a new user, I want to create an account so that I can use the application and place orders.
Acceptance Criteria:
Given I am on the registration screen
When I enter valid username and password
Then my account should be created successfully and I see a success message

Given I leave required fields empty
Then I should see an error message and account should not be created
**Story #2: User Login [3 points]**
As a registered user, I want to log in so that I can access my personal data.
Acceptance Criteria:
Given I am on the login screen
When I enter correct username and password
Then I should be logged in successfully

Given I enter wrong credentials
Then I should see an error message
**Story #3: Browse Menu Categories [3 points]**
As a customer, I want to browse food categories so that I can find meals easily.
Acceptance Criteria:
Given I am on the main menu
When I select a category
Then the related dishes are displayed
**Story #4: View Dish Details [3 points]**
As a customer, I want to view dish details (name, price, image) so that I can decide what to order.
Acceptance Criteria:
Given I select a dish
Then I should see its name, image, price, and description
**Story #5: Manage Cart [5 points]**
As a customer, I want to add items to the cart and adjust quantities so that I can review my order before placing it.
Acceptance Criteria:
Given I am viewing a dish
When I add it to the cart and select quantity
Then the cart updates with correct item and quantity

Given I open the cart
Then I can adjust quantities or remove items
**Story #6: Place Order [3 points]**
As a customer, I want to place my order so that the restaurant can prepare my food.
Acceptance Criteria:
Given I have items in my cart
When I confirm the order
Then the order is saved and I receive confirmation
**Story #7: Owner Menu Management [5 points]**
As an owner, I want to add, edit, or delete dishes so that the menu stays updated.
Acceptance Criteria:
Given I am logged in as owner
When I add/edit/delete a dish
Then the menu updates accordingly
## Should-Have Stories (Priority 2)##
**Story #8: View Order History [3 points]**
As a customer, I want to view my previous orders so that I can track my past orders.
**Story #9: Manage Profile [2 points]**
As a user, I want to edit my profile or log out so that I can control my account.
**Story #10: Owner Profile Management [2 points]**
As an owner, I want to view and edit my profile so that I can manage my account information.
## Nice-to-Have Stories (Priority 3)##
**Story #11: Favorite Dishes [2 points]**
As a customer, I want to mark dishes as favorites so that I can easily reorder them later.
Acceptance Criteria:
Given I am viewing a dish
When I tap the "favorite" button
Then the dish is added to my favorites list

Given I view my favorites
Then I should see all dishes I marked as favorite
## Icebox (Future Considerations)##
- Push notifications for order status
- In-app payment system
- Dish ratings & reviews