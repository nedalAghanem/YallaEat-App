# Project Proposal: YallaEat
## 1. Project Overview
YallaEat is an Android mobile application that helps users order food easily from their phones. The application allows customers to view the menu, choose meals, and place orders quickly in a simple and clear way.

## 2. Problem Statement
Many restaurants still rely on manual ordering or phone calls, which can cause delays and order mistakes. Customers also lack an easy way to view menus and place orders. This system provides a digital solution to simplify ordering and order management.

## 3. Target Users
**Primary User Type 1:** Customers
- Description: People who order food from the restaurant
- Goals: View the menu and place orders easily
- Pain Points: Long waiting times, order mistakes, unclear menus
**Primary User Type 2:** Restaurant Staff (Owner)
- Description: Restaurant managers or employees
- Goals: Manage menu items and process orders
- Pain Points: Manual order tracking, lack of organization

 
## 4. Core Features (Must-Have for MVP).  
1. **Splash Screen** 
- Description: Shows the app logo when the application starts
- User Benefit: Gives a clear and friendly first impression
2. **Onboarding Screens**
- Description: Short screens that explain how the app works the first time it is opened
- User Benefit: Helps new users understand the app quickly
3. **User Authentication (Register & Login)**
- Description: Users can create an account and log in to the app
- User Benefit: Saves user information and provides a personal experience
4. **Session Management**
-Description: The app remembers the user so they do not need to log in every time
- User Benefit: Saves time and effort
5. **Menu Categories**
- Description: Food items are organized into clear categories
- User Benefit: Makes browsing the menu easy and organized
6. **Menu Display**
- Description: Users can see food items with name, price, and image
- User Benefit: Helps users choose meals confidently
7. **Cart Management**
- Description: Users can choose food items, select quantity, and review all items before placing the order
- User Benefit: Makes ordering simple and reduces mistakes
8. **Order Placement**
- Description: Users can confirm and place their order
- User Benefit: Simple and fast ordering process
9. **Order History**
- Description: Users can view their previous orders
- User Benefit: Easy access to past order details
10. **Main Navigation**
- Description: Simple navigation between main sections of the app
- User Benefit: Easy movement inside the application.
11. **User Profile**
- Description: Users can view, edit their information, and log out
- User Benefit: Full control over personal account

 
## 5. Additional Features (Nice-to-Have) 
**Notifications**
- Description: Users receive alerts when their order is confirmed or updated
- User Benefit: Keeps users informed about the status of their orders
**Confirmation Messages**
- Description: Users get confirmation messages when they place or modify an order
- User Benefit: Prevents mistakes and makes the ordering process safer
 
## 6. Technical Stack 
**Mobile Application (Frontend & Backend in App):**
- Platform: Android
- IDE: Android Studio
- Language: Java
- UI Design: XML (Material Design for layouts)
- User Interface Elements: CardView, RecyclerView, BottomNavigation, TabLayout
- Local Data Storage: Room Database (for users, menu items, cart, and orders)
- Session Handling: SharedPreferences (to remember login state)
- Notifications & Alerts: Local notifications and confirmation messages
**Development Tools:**
- Version Control: GitHub
- Project Management: Trello
- Testing: Manual testing (checking app functionality by using the app directly)

## 7. System Architecture
- Description: The app is self contained on the user’s device. All data like menu items, orders, and user information are stored locally, and the app manages everything internally.
- User Flow : https://www.figma.com/proto/qfQhIPVV28zrgU96rA0hUu/YallaEat-App-User-Flow?page-id=0%3A1&node-id=1-2&p=f&viewport=8%2C121%2C0.44&t=LU5eophs8uV2yOD1-1&scaling=min-zoom&content-scaling=fixed
 
## 8. Project Timeline 
**Sprint 1 (Week 3-4):** Basic authentication and user management
-Set up the user database
-Create the registration screen with data validation
-Create the login screen
-Add the logout feature
-Configure the session using SharedPreferences to save login status
-Test the core functionality (Register, Login, Logout)
**Sprint 2 (Week 5-6):** Core feature 1 and 2
-Design the splash screen with the app logo
-Create onboarding screens to demonstrate how to use the app
-Integrate onboarding with login
-Test the app's first-time user experience
**Sprint 3 (Week 7-8):** Core feature 3 and 4
-Improved login system
-Enhanced session management to ensure users remember the settings permanently
-Added a password recovery screen 
-Comprehensive testing of the login and logout process
**Sprint 4 (Week 9-10):** Remaining core features
-Create a menu display with categories
-Add a shopping cart with the ability to edit quantities
-Improve the order placement process
-Create an order history screen
-Improve the user profile screen
**Sprint 5 (Week 11-12):** Polish, testing, bug fixes 
-Improved user interface (UI/UX)
-Fixed identified bugs
-Comprehensive testing of all features
-Improved performance and user experience
**Sprint 6 (Week 13-14):** Final testing and presentation prep
-Final testing of the application on different devices
-Preparing presentation slides
-Recording a demo video
-Upload the final version to GitHub along with the documentation
 
## 9. Success Criteria 
The project will be considered successful if:
- [ ] All core features are implemented and working
- [ ] Users can complete primary workflows without errors
- [ ] Code is well-documented and maintainable
- [ ] Test coverage is at least 70%
-[ ] Application is responsive and user-friendly 
- [ ] Security best practices are followed
 
## 10. Risks and Mitigation 
**Risk 1:** [ Team member unavailable]
**Mitigation:** [Distribute tasks in a balanced way and document each step on GitHub and Trello so that any member can continue the work of another]
**Risk 2:** [ Technical complexity too high]
**Mitigation:** [Focus first on the core features (MVP such as Login, Menu, Cart) and postpone additional features if time is limited]
**Risk 3:** [ Integration issues] 
**Mitigation:** [Use GitHub in an organized way (Branches, Pull Requests, Code Reviews) and perform regular merges to avoid accumulated conflicts]
 
## 11. Team Roles and Responsibilities 
**[khaderAbuShaban1] - Product Owner:**
- Manages product backlog
- Defines priorities
- Accepts completed work
**[NedalAbuGhanem] - Scrum Master:**
- Facilitates Scrum ceremonies
- Removes blockers
- Tracks progress
**[RaghebAbuShaban] - Lead Developer:**
- Backend architecture
- Database design
- API development
**[MohammedMoqaiad] - Frontend Developer:**
- UI/UX implementation
- Frontend integration
- Responsive design
[Note: While each member has a primary role, all team members contribute to different areas of the project]

## 12. Deliverables 
- Working web application
- Source code on GitHub
- Documentation (README, API docs, user guide)
- Test suite
- Presentation slides
- Demo video
---
**Approved by Team:**
- Khader abu shaban - 1/21/2026
- Ragheb abu shaban - 1/21/2026
- [Mohammed Moqaiad] - 1/21/2026
- Nedal AbuGhanem - 1/21/2026
- [Name] - [Date]
**Instructor Approval:** ________________ Date: _______
