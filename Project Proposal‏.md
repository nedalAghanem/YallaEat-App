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
**Sprint 2 (Week 5-6):** Core feature 1 and 2
**Sprint 3 (Week 7-8):** Core feature 3 and 4
**Sprint 4 (Week 9-10):** Remaining core features
**Sprint 5 (Week 11-12):** Polish, testing, bug fixes 
**Sprint 6 (Week 13-14):** Final testing and presentation prep
 
## 9. Success Criteria 
The project will be considered successful if:
- [ ] All core features are implemented and working
- [ ] Users can complete primary workflows without errors
- [ ] Code is well-documented and maintainable
- [ ] Test coverage is at least 70%
-[ ] Application is responsive and user-friendly 
- [ ] Security best practices are followed
 
## 10. Risks and Mitigation 
**Risk 1:** [e.g., Team member unavailable]
**Mitigation:** [e.g., Cross-train all members on all components]
**Risk 2:** [e.g., Technical complexity too high]
**Mitigation:** [e.g., Simplify scope, focus on core features]
**Risk 3:** [e.g., Integration issues] 
**Mitigation:** [e.g., Early integration testing, clear API contracts]
 
## 11. Team Roles and Responsibilities 
**[Name] - Product Owner:**
- Manages product backlog
- Defines priorities
- Accepts completed work
**[Name] - Scrum Master:**
- Facilitates Scrum ceremonies
- Removes blockers
- Tracks progress
**[Name] - Lead Developer:**
- Backend architecture
- Database design
- API development
**[Name] - Frontend Developer:**
- UI/UX implementation
- Frontend integration
- Responsive design
[Note: All members contribute to all areas, these are primary focuses]

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
- [Name] - [Date]
- [Name] - [Date]
**Instructor Approval:** ________________ Date: _______