# Pebble
Auto pebble jumping game

The completion and challenge involve a pebble game that is played on a board containing rows of dishes. Every row has a red pebble in one dish and a blue pebble in another dish. The number of dishes in each row can be different, and the positions of the red and blue pebbles can be different. Here is one possible board for the pebble game which has five rows. The first row has 6 dishes, the second row has 7 dishes, etc.


To play the pebble game, the red and blue players start with all their pebbles in the home positions:

red pebbles at the left ends of the rows, and

blue pebbles at the right ends of the rows.

They then take turns moving one of their pebbles:

A player can move a pebble to an empty dish on the left or the right.

If one of their pebbles is in a dish next to the opponent's pebble, then they can "hop over" the opponent's pebble, and send it home, UNLESS:

there isn't an empty dish on the other side of the opponent's pebble - in which case they can't hop, OR

they hopped into the opponent's home - in which case they can't send the opponent home.

The winner is the first player to get all their pebbles into their opponent's home positions

The simplest version of the game has just one row. Write a method that will show a simulation of a game with just one row.

Your method should ask the user for the size of the row, then draw the board (just one row) with the pebbles in their home positions.

Then simulate the game by repeatedly making the players move a pebble and then redrawing the board. Use UI.sleep(500) to make a pause between moves.

Both players should move forward in each move (red to right and blue to left), unless their opponent's pebble is in the next dish, in which case they should hop over the opponent and send them home.

