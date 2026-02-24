# Sprint 1 Plan – YallaEat

## Sprint Information
- **Sprint Number:** 1
- **Duration:** 2 Weeks
- **Start Date:** 05-Jan-2026
- **End Date:** 19-Jan-2026
- **Team Capacity:** ~20 hours (Target 10–12 Story Points)

---

## 🎯 Sprint Goal
Set up the project foundation, understand app requirements, define user stories, and prepare the team communication and task tracking tools.

---

## Selected User Stories

### Story #1: Project Analysis
- **Points:** 2
- **Assigned to:** Whole Team
- **Priority:** Must-Have

**Description:**  
As a team, we want to analyze the YallaEat app so that we understand its features and requirements.

**Tasks:**
- Identify main features
- Write notes about functionality and UI/UX

**Acceptance Criteria:**
- Complete list of app features and notes created
- Team agrees on main functionalities to implement

---

### Story #2: User Stories Creation
- **Points:** 3
- **Assigned to:** Khader Abu Shaban, Ragheb Abu Shaban
- **Priority:** Must-Have

**Description:**  
As a team, we want to create comprehensive user stories so that we have a clear development backlog.

**Tasks:**
- Identify user roles (Customer, Owner)
- Write 10 user stories with descriptions, priorities, and estimated points

**Acceptance Criteria:**
- All core user stories documented
- Priorities and points assigned
- Stories ready to use in Sprint 2

---

### Story #3: Set Up Communication & Project Tracking Tools
- **Points:** 1
- **Assigned to:** Nedal Abu Ghanem
- **Priority:** Must-Have

**Description:**  
As a team, we want communication and task management tools so that we can coordinate efficiently.

**Tasks:**
- Create Slack workspace
- Create Trello board

**Acceptance Criteria:**
- Slack workspace created and all team members added
- Trello board has columns (To Do, Doing, Done)

---

## Definition of Done
A story is considered done when:
- All tasks completed
- Notes and user stories documented
- Slack and Trello ready for team use

---

## Sprint Schedule

**Week 1**
- Analyze YallaEat app
- Identify features and requirements
- Start user stories

**Week 2**
- Complete user stories with acceptance criteria
- Set up Slack and Trello for the team
- Review backlog for Sprint 2 planning

---

## Communication Plan
- Daily updates
- Update Trello board
- Standup: Monday / Wednesday / Friday (15 min)

---

## Success Metrics
Sprint 1 is successful if:
- Project features analyzed and documented
- User stories created and prioritized
- Slack workspace and Trello board ready for Sprint 2
- Team aligned on project plan and next sprint

---

# Sprint 2 Plan – YallaEat

## Sprint Information
- **Sprint Number:** 2
- **Duration:** 2 Weeks
- **Start Date:** 10-Feb-2026
- **End Date:** 24-Feb-2026
- **Team Capacity:** ~20 hours (Target 10–12 Story Points)

---

## 🎯 Sprint Goal
Users can open the app, go through Splash & Onboarding, register/login successfully, and the database foundation with Home Screen is fully set up.

---

## Selected User Stories

### Story #1: Database Setup
- **Points:** 2
- **Assigned to:** Khader Abu Shaban, Ragheb Abu Shaban
- **Priority:** Must-Have

**Description:**  
Set up Room database tables and initial schema for users and other entities.

**Tasks:**

**Database Schema & Setup:**
- Create User entity class with fields: username, password, etc.
- Set up Room Database class with the Users table

**Data Operations:**
- Create DAO for Users (Insert, Update, Query)
- Test insertion and retrieval of user data

**Acceptance Criteria:**
- Users table created successfully
- Data can be added, read, and updated correctly
- Registration and login features can access the database

---

### Story #2: Splash Screen
- **Points:** 1
- **Assigned to:** Nedal Abu Ghanem
- **Priority:** Must-Have

**Description:**  
As a user, I want to see a splash screen when I open the app so that the app feels polished.

**Tasks:**
- Design splash screen layout
- Implement timed transition to Onboarding

**Acceptance Criteria:**
- Splash screen displays app logo
- Automatically transitions to Onboarding after 2-3 seconds

---

### Story #3: Onboarding Screens
- **Points:** 2
- **Assigned to:** Nedal Abu Ghanem
- **Priority:** Must-Have

**Description:**  
As a new user, I want onboarding screens so I understand the app features.

**Tasks:**
- Design 3 onboarding screens (XML)
- Add swipe navigation
- Link final screen to Registration

**Acceptance Criteria:**
- Screens are swipeable
- Last screen navigates to Registration

---

### Story #4: User Registration
- **Points:** 5
- **Assigned to:** Ragheb Abu Shaban
- **Priority:** Must-Have

**Description:**  
As a new user, I want to create an account using username and password so that I can use the app.

**Tasks:**
- Design registration UI (XML)
- Add input validation
- Insert user into Room database
- Test registration

**Acceptance Criteria:**
- User can register with valid data
- Error shown if fields are empty
- Data saved in database
- Success message displayed

---

### Story #5: User Login
- **Points:** 3
- **Assigned to:** Khader Abu Shaban, Ragheb Abu Shaban
- **Priority:** Must-Have

**Description:**  
As a registered user, I want to login so that I can access the app.

**Tasks:**
- Design login UI – Ragheb Abu Shaban
- Validate credentials from database – Khader Abu Shaban
- Implement session using SharedPreferences – Khader Abu Shaban
- Testing – Khader Abu Shaban

**Acceptance Criteria:**
- User can login with correct credentials
- Error shown for wrong credentials
- Session saved successfully

---

### Story #6: Basic Home Screen
- **Points:** 3
- **Assigned to:** Mohammed Al Moqaiad, Khader Abu Shaban
- **Priority:** Must-Have

**Description:**  
As a logged-in user, I want to see a Home screen so that I can navigate the app.

**Tasks:**
- Design Home layout – Khader Abu Shaban
- Add BottomNavigation – Khader Abu Shaban
- Connect navigation between screens – Mohammed Al Moqaiad
- Testing – Mohammed Al Moqaiad

**Acceptance Criteria:**
- Home screen loads after login
- Navigation works correctly

---

## Definition of Done
- All tasks completed
- Acceptance criteria satisfied
- Code reviewed by at least one teammate
- App runs without crashes
- Manually tested
- Changes pushed to GitHub

---

## Sprint Schedule

**Week 1**
- Setup database
- Splash screen
- Onboarding screens
- Start User Registration

**Week 2**
- Complete Registration
- User Login
- Implement Home Screen
- Testing & bug fixing
- Sprint Review & Retrospective

---

## Communication Plan
- Daily updates
- Update Trello board
- Standup: Monday / Wednesday / Friday (15 min)

---

## Success Metrics
Sprint 2 is successful if:
- Splash & Onboarding work
- Registration & Login work
- Database integrated
- Home screen functional
- No major bugs
- Code uploaded to GitHub

- 

- # Sprint 3 Plan – YallaEat

## Sprint Information
- **Sprint Number:** 3
- **Duration:** 2 Weeks
- **Start Date:** 24-Feb-2026
- **End Date:** 8-Mar-2026
- **Team Capacity:** ~20 hours (Target 14–18 Story Points)

---

## :dart: Sprint Goal
Users can browse menu items by category, add items to cart, place orders, view past orders, manage their profile, and Admin (Owner) can manage dishes.

---

## Selected User Stories

---

### Story #1: Menu Categories & Items
- **Points:** 4
- **Assigned to:** Khader Abu Shaban
- **Priority:** Must-Have

**Description:**
As a user, I want to browse dishes by category so that I can easily select what I want to order.

**Tasks:**
- Create Dish entity (id, name, price, category, image)
- Insert sample dishes into database
- Implement RecyclerView and Adapter
- Filter dishes by category (Starters, Main Course, Desserts, Drinks)

**Acceptance Criteria:**
- Dishes displayed using RecyclerView
- Items categorized correctly
- No crashes while scrolling

---

### Story #2: Add to Cart
- **Points:** 3
- **Assigned to:** Ragheb Abu Shaban
- **Priority:** Must-Have

**Description:**
As a user, I want to add dishes to my cart with selected quantity so that I can control my order.

**Tasks:**
- Create Cart entity (id, dishId, quantity, userId)
- Create Cart DAO
- select quantity
- Save selected item to Room database

**Acceptance Criteria:**
- Quantity dialog appears when adding item
- Selected item saved correctly
- Confirmation message displayed
- No duplicate insertion errors

---

### Story #3: Cart Screen
- **Points:** 3
- **Assigned to:** Ragheb Abu Shaban
- **Priority:** Must-Have

**Description:**
As a user, I want to view my cart items before placing an order.

**Tasks:**
- Display cart items using RecyclerView
- Calculate total price dynamically
- Add remove item option

**Acceptance Criteria:**
- All cart items displayed
- Total price calculated correctly
- User can remove items
- Cart updates instantly

---

### Story #4: Place Order
- **Points:** 3
- **Assigned to:** Nedal Abu Ghanem
- **Priority:** Must-Have

**Description:**
As a user, I want to place my order and save it in the database.

**Tasks:**
- Create Order entity (id, userId, totalPrice, date, status)
- Create Order DAO
- Save cart items as an order
- Clear cart after successful order
- Show confirmation message

**Acceptance Criteria:**
- Order saved in database
- Cart cleared after placing order
- Success message displayed
- Order contains correct total price and date

---

### Story #5: View Past Orders
- **Points:** 2
- **Assigned to:** Nedal Abu Ghanem
- **Priority:** Must-Have

**Description:**
As a user, I want to see my previous orders with details.

**Tasks:**
- Create Orders Fragment
- Retrieve orders by logged-in user
- Display order date, total price, and status

**Acceptance Criteria:**
- Orders displayed correctly
- Data matches database
- RecyclerView works smoothly

---

### Story #6: Profile Screen (Edit + Logout)
- **Points:** 2
- **Assigned to:** Khader Abu Shaban
- **Priority:** Must-Have

**Description:**
As a user, I want to edit my profile and logout from the app.

**Tasks:**
- Create Profile Fragment
- Allow editing username
- Implement Logout using SharedPreferences
- Redirect to Login screen after logout

**Acceptance Criteria:**
- Profile information editable
- Logout clears session
- User redirected correctly

---

### Story #7: Owner Profile Screen & Dish Management
- **Points:** 3
- **Assigned to:** Mohammed Al Moqaiad
- **Priority:** Should-Have

**Description:**
As an Owner, I want to manage dishes and view profile.

**Tasks:**

**Dish Management:**
- Create Add Dish screen with AlertDialog
- Create Edit Dish screen with AlertDialog
- Add Delete option with AlertDialog confirmation

**Profile Management:** 
- Display Owner username
- Redirect to Login screen after logout

**Acceptance Criteria:**
- Owner can login successfully
- Owner can add, edit, delete dishes
- Normal users cannot access Owner features

---

## Definition of Done
A story is considered done when:
- All tasks completed
- Acceptance criteria satisfied
- Code reviewed by at least one teammate
- App runs without crashes
- Manually tested
- Changes pushed to GitHub

---

## Sprint Schedule

### Week 1
- Implement Dish entity and menu display
- Setup RecyclerView and categories
- Add to Cart functionality
- Build Cart screen

### Week 2
- Implement Place Order logic
- Build Orders screen
- Create Profile screen
- Implement Admin panel
- Testing & bug fixing
- Sprint Review & Retrospective

---

## Communication Plan
- Daily updates
- Update Trello board regularly
- Standup: Monday / Wednesday / Friday (15 minutes)
- Code review before merging pull requests

---

## Success Metrics
Sprint 3 is successful if:
- Users can browse menu by category
- Add items to cart
- Place orders successfully
- View previous orders
- Edit profile and logout
- Admin can manage dishes
- App runs without major bugs
- Code uploaded to GitHub


