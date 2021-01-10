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
To run this game, you should run it from IntelliJ, first, you should introduce the name of every
character in game, then the name and damage of every weapon. The game is settle to have 5 characters
agains 5 enemies, and having in inventory 10 weapons. It is important to say that the damage introduced
should be a number, it can't be a string.
With that information provided, the game will start. You will see a window with 5 enemies images and
5 characters gifs. Also, there is information of the enemies, like their names, life, defense and if 
it is alive or not, same with the characters. By pressing the next button, the first character in queue 
is going to play. If a character of the player is in turn, you will see two options, one of them is to
attack an enemy and the other is to equip a weapon. The first option will let you press an enemy button
to select it to attack, then you will see how much damage has the character done to the enemy. The
second option will bring you information about the actual equipped weapon of the character and the
inventory, you equip a new weapon by clicking the button of the weapon and then you have to press the
back button. If an enemy is attacking, you will see a message saying which enemy is attacking, then you
will see how much damage it has done.
After all enemies or all character of the player are dead, the game will end, and it will show a message
telling if you have won or if you have lose.

**Considerations**
------------------
In this game is considered that every character in the game has 100 points of life, and 50 of defense,
those two are considered as if the character has 150 points of life. By being attacked, the defense will
reduce until it is 0, then, the life will reduce until it is 0 and in that point, the character will be
considered dead.
Also, there is considered the weapons that some characters can equip and those that they can't. Magic
and adverse affects are not implemented in this game.

**Logic**
---------
In this programm there is a class for every character than the player can controll, the characters have 
parameters than indicates their names, life, defense and their turn in the queue, also there is 
a method to equip a weapon to the character, but it has some restrictions considering the type of character; 
there is another class for the enemy that will be controlled by the CPU, this has parameters of name, 
attack, weight and its turn in the queue, but there is no method to equip a weapon, because this will be
settle by default; there is a package for the types of weapons of the game, this classes have parameters of
name, damage and weight. Also, there is a package for the controller, who is going to be in charge to
controll the messeges recibed from the player, and redirect them to wherever they should go, this package
also includes listeners, whose are going to notify the controller when something has change, in this case,
when some character has died and when the turn of some character has ended.

**Links**
---------
The images that this game has, were obtenied from http://www.videogamesprites.net/FinalFantasy3/Party/
and http://www.videogamesprites.net/FinalFantasy3/Enemies/
