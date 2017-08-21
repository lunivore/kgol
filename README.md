# kgol

## A Kotlin-based Game of Life kata for Deliberate Practice

Deliberate practice in a safe space allows us to try things out, without risking our production code. This helps us
to see more possibilities and learn more quickly than a live environment allows. This kata is based on 
[Conway's Game of Life](https://en.wikipedia.org/wiki/Conway%27s_Game_of_Life).

---

The GUI for the game is provided for you - all you need to do is implement the engine!

GUI and engine communicate via the Events, using a publish/subscribe model. Requests come from the GUI. 
The engine needs to respond to these with the correct notifications. Empty test folders exist for you to write
class-level tests, and Cucumber has already been wired up for the first of the end-to-end scenarios, using a little automation tool
I wrote as a helper.

To start, just checkout the master branch!

The solution branch contains my own solution.

Other branches are solutions created in dojos which have used this as a practice piece.
