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
