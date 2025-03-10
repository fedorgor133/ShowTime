## Overview
**Author:** Fedor Gorshkov  
**Project Type:** Java Application  
**Testing Approach:** User stories and acceptance tests in `.feature` files with step definitions. Implemented using Behavior-Driven Development (BDD).

This project employs **Gherkin** for defining test cases in a structured and human-readable format and utilizes **Cucumber** for test execution.

Keeping low assembly and high cohesion, following the **GRASP** patterns, **S.O.L.I.D** design principles and using design patterns like AbstractFactory, Singleton, Facade, Strategy...

---

## Description

In response to the growing number of movies and TV series available, **SHOW-TV-Time** has been developed to help users track their viewing history and engage with communities of shared interests.

### Key Features

1. **Series and Movie Tracking**: Users can mark episodes and movies as watched, maintaining an up-to-date **WatchedHistory** list.
2. **Ratings and Comments**: Users can rate and review episodes and movies.
3. **Personalized Recommendations**: The application suggests shows and movies based on viewing history and preferences.
4. **New Episode Notifications**: Users receive alerts when new episodes of their favorite series are released.
5. **Social Networking & Interest Groups**: Users can:
    - Join communities with shared interests.
    - Discuss theories, episodes, and key moments.
    - Engage in a gamified experience within groups.

### User Features

Registered users enjoy additional functionalities:

- Maintain a **WatchedHistory** to track and rate watched content.
- Have an automatically updated **WatchNext** list, suggesting unfinished series episodes.
- Receive **personalized recommendations** based on viewing history.
- Follow and participate in **common interest groups** with other users.

---

### Applied Design Patterns

1. **Abstract Factory**
    - `AbstractFactoryData` serves as the abstract factory.
    - `FactoryManagements` acts as the client class, responsible for instantiating specific factories.
    - `FactoryMOCK` serves as the concrete factory.
    - The concrete products are found in the **MOCK** folder (e.g., `DAOEpisodiMOCK`, `DAOTematicaMOCK`).
    - DAO interfaces are located in the **entities** and **relationships** folders.

2. **Singleton**
    - The controller is implemented as a **singleton** to ensure only one instance exists.
    - The constructor is private, and access is provided via a `getInstance()` method.

3. **Facade**
    - Controller functions are modified to interact exclusively with the `ShowTVTime` class.
    - `ShowTVTime` initializes key components: `ManagementData`, `ManagementContent`, and `ManagementLists`.
    - This approach simplifies interactions and improves maintainability.

4. **Strategy**
    - Organizes different methods for how a user can become a member of an interest group.

5. **Data Access Object (DAO)**
    - Facilitates flexible data initialization using external resources (e.g., a simulated MOCK database).
    - Enhances modularity, making persistence layers easily modifiable.

---

## Conclusion

**SHOW-TV-Time** provides a structured and scalable solution for tracking and engaging with TV shows and movies. By implementing **Behavior-Driven Development (BDD)** and leveraging well-established **software design patterns**, the project ensures maintainability, flexibility, and ease of use.

This project is open to future extensions, including support for multiple languages and additional functionalities to enhance user experience.

