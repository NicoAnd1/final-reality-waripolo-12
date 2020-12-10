Final Reality
=============

![http://creativecommons.org/licenses/by/4.0/](https://i.creativecommons.org/l/by/4.0/88x31.png)

This work is licensed under a 
[Creative Commons Attribution 4.0 International License](http://creativecommons.org/licenses/by/4.0/)

Context
-------

This project's goal is to create a (simplified) clone of _Final Fantasy_'s combat, a game developed
by [_Square Enix_](https://www.square-enix.com)
Broadly speaking for the combat the player has a group of characters to control and a group of 
enemies controlled by the computer.

---

**Instructions**
----------------
The programm will compile, but it will only check the tests provided in itself, therefore, there is no
instructions to run the programm.

**Considerations**
------------------
For now, there is considered the weapons that some characters can equip and those that they can't. Magic
and adverse affects are still not considered yet. The controller does not considerer the interaction
with the player, but it knows what should do in some cases.

**Logic**
---------
In this programm is a class for every character than the player can controll, the characters have 
parameters than indicates their names, life, defense and their turn in the queue, also there is 
a method to equip a weapon to the character, but it has some restrictions considering the type of character; 
there is another class for the enemy that will be controlled by the CPU, this has parameters of name, 
attack, weight and its turn in the queue, but there is no method to equip a weapon, because this will be
settle by default; there is a package for the types of weapons of the game, this classes have parameters of
name, damage and weight. Also, there is a package for the controller, who is going to be in charge to
controll the messeges recibed from the player, and redirect them to wherever they should go, this package
also includes listeners, whose are going to notify the controller when something has change, in this case,
when some character has died and when the turn of some character has ended.
