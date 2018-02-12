# Virtual Pets AMOK!
> Oh noes! Your virtual pet shelter has become a mess!

## Intro
Our week four focus was on OOP principles.  We covered Polymorphism, Inheritance, and Encapsulation.  Our project aims to test our knowledge of these topics by expanding on the previous two weeks work and building a shelter that has four different style of virtual pets.  Organic pets are joined by robotic brethern, cats and dogs are now making a mess of the shelter.  Differences between cats and dogs are simple, you can walk dogs, cats use the litter box, and dogs stay in their cage.  All pets will have a health attribute that diminishes according to cleanliness of their living area, if their happiness drops too low, or if they have other needs that have not been met.
>We’re introducing a health attribute for pets. Organic pets have their health decreased by unclean circumstances, and by thirst or hunger growing too high. Robotic pets only lose health if they’re not oiled regularly. All pets lose health if their happiness drops too low.

## Requirements
Here are the given requirements for this weeks project.
### Setup
You can copy your code from the previous project to use as a starter, or start from scratch.

-[x] Create a Java project in Eclipse named virtual-pets-amok.
-[x] Create a README.md file in your project folder to describe what you’ve done with your project. No fancy formatting is necessary. Just separate paragraphs with an empty line. 
	-[x](If you’d like to learn more about Markdown formatting, check out the Github Markdown Guide.)
-[x] Create a GitHub repository also named virtual-pets-amok and set it up so that you can push your code there from your Eclipse project. Do this now. It’s the least fun part, so just get it out of the way.
Required Tasks
### General
- [x] introduce ways to track:
	- [x] cage cleanliness for organic dogs
	- [x] shelter litter box cleanliness for organic cats
	- [x] oil/maintenance level for robot animals

#### All classes
- [x] Encapsulate all instance variables.
- [x] Assign appropriate visibility modifiers to methods only used internally by a class or within a class hierarchy.

#### VirtualPet class and related subclasses/interfaces
In addition to the last project’s requirements:
>* - [x] Create a main method that…
>	* - [x] implements a game loop.
>	* - [x] asks for user input.
>	* - [x] writes output to the console.
>	* - [x] calls VirtualPetShelter’s tick method after each interaction
>* - [x] Available user interface actions should include (at minimum)…
>	* - [x] feeding all the pets
>	* - [x] watering all the pets
>	* - [x] playing with an individual pet, which should display a list of pet names and descriptions, allowing a user to select one
>	* - [x] allow adoption of a pet, which should display a list of pet names and descriptions, allowing a user to select one
>	* - [x] allow intake of a pet, prompting the user for the pet’s information, requiring the user to (at minimum) specify name and description
>
>#### VirtualPetShelter class
>* - [x] Include appropriate instance variable(s) to store the pets who reside at the shelter
>* - [x] Include methods that:
>	* - [x] return a Collection of all of the pets in the shelter
>	* - [x] return a specific VirtualPet given its name
>	* - [x] allow intake of a homeless pet
>	* - [x] allow adoption of a homeless pet
>	* - [x] feed all of the pets in the shelter
>	* - [x] water all of the pets in the shelter
>	* - [x] plays (or performs some other interaction(s)) with an individual pet in the shelter
>* - [x] Include a tick method that calls the tick method for each of the pets in the shelter, updating their needs
>
>#### VirtualPet class
>* - [x] The requirements from last week’s project:
>	* - [x] Create a tick() method that represents the passage of time.
> 	* - [x] Create at least three instance variables (aka attributes aka properties aka fields).
>	* - [x] Create at least three methods (messages you send to your pet).
> 
>* - [x] Include instance variables representing:
>	* - [x] name
>	* - [x] description
>	* - [x] include a constructor that accepts a name and description
>	* - [ ] ~~include a constructor that, in addition to name and description, accepts default values for the pet’s attributes (hunger, boredom, etc)~~
>	* - [x] Do not include a default (zero arguments) constructor.

- [x] create a model that allows for dogs and cats, either of which may be robotic
- [x] introduce an attribute (instance variable) representing overall health that is updated as a result of other attributes moving in a negative or positive direction, influencing happiness
- [x] introduce methods that allow for:
	- [x] oiling robotic pets
	- [x] walking dogs, decreasing the likelihood that organic dogs will soil their cages, while increasing happiness in all dogs
- [x] do not allow:
	- [x] feeding/watering robotic pets
	- [x] oiling organic pets
- [x] modify the tick method to return a value indicating the amount of waste a pet creates, which should contribute to either:
	- [x] amount of waste in the litter box
	- [x] amount of waste in an individual dog cage

#### VirtualPetShelter class
In addition to the last project’s requirements:

- [x] introduce methods that allow for:
	- [x] oiling/maintaining all robotic pets
	- [x] cleaning dog cages
	- [x] emptying the litterbox
- [x] modify existing methods to only feed/water pets that are not robotic

#### VirtualPetShelterApp class
In addition to the last project’s requirements:

- [x] add options to:
	- [x] walk all dogs
	- [x] clean dog cages
	- [x] clean the shelter litterbox
	- [x] oil all robotic pets

### Grading
Here is the rubric.
Category	| Max Score
------------|----------
oilAllRobots()	|10
cleanAllCages()	|10
emptyLitterBox()	|10
has interfaces for necessary functionality	|10
instance variable for health	|10
modify tick() - amount of waste in the litter box and amount of waste in an individual dog cage	|10
encapsulate all instance variables	|10
proper modifiers for instance variables	|10
adequate unit tests to drive production	|10
style/formatting/code quality	|10

