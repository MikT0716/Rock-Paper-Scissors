## Rock-Paper-Scissors

### A simple Rock, Paper, Scissors application that operates on the web via its dedicated REST API.

* Maven JAVA project
* 2 Layered
* 1 controller
* 1 service
* Manual testing with HTTP file
* Automated testing with WebTestClient

Endpoints:

| HTTP method | Endpoint                      | Description                                                                                     |
|-------------|-------------------------------|-------------------------------------------------------------------------------------------------|
| GET         | `/api/game/rules`             | Lists the possible hands and the rules                                                          |
| POST        | `/api/game/play`              | Plays the game with the user-selected hand and returns the result                               |
| POST        | `/api/game/play?explain=true` | Plays the game with the user-selected hand, returns the result and an explanation of the results |

How to play:

Currently limited to running the Spring boot app in an IDE and connecting to http://localhost:8080/.
User's choice to be clicked on the cards, results can be viewed in the development console of the browser.