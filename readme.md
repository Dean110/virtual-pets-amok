# Virtual Pets AMOK!
> Oh noes! Your virtual pet shelter has become a mess!

## Intro
Our week four focus was on OOP principles.  We covered Polymorphism, Inheritance, and Encapsulation.  Our project aims to test our knowledge of these topics by expanding on the previous two weeks work and building a shelter that has four different style of virtual pets.  Organic pets are joined by robotic brethern, cats and dogs are now making a mess of the shelter.  Differences between cats and dogs are simple, you can walk dogs, cats use the litter box, and dogs stay in their cage.  All pets will have a health attribute that diminishes according to cleanliness of their living area, if their happiness drops too low, or if they have other needs that have not been met.
>We’re introducing a health attribute for pets. Organic pets have their health decreased by unclean circumstances, and by thirst or hunger growing too high. Robotic pets only lose health if they’re not oiled regularly. All pets lose health if their happiness drops too low.

## Requirements

### Setup
You can copy your code from the previous project to use as a starter, or start from scratch.

-[x] Create a Java project in Eclipse named virtual-pets-amok.
-[x] Create a README.md file in your project folder to describe what you’ve done with your project. No fancy formatting is necessary. Just separate paragraphs with an empty line. 
	-[x](If you’d like to learn more about Markdown formatting, check out the Github Markdown Guide.)
-[x] Create a GitHub repository also named virtual-pets-amok and set it up so that you can push your code there from your Eclipse project. Do this now. It’s the least fun part, so just get it out of the way.
Required Tasks
### General
- [ ] introduce ways to track:
	- [x] cage cleanliness for organic dogs
	- [x] shelter litter box cleanliness for organic cats
	- [ ] oil/maintenance level for robot animals

#### All classes
- [ ] Encapsulate all instance variables.
- [ ] Assign appropriate visibility modifiers to methods only used internally by a class or within a class hierarchy.

#### VirtualPet class and related subclasses/interfaces
In addition to the last project’s requirements:
>* - [ ] Create a main method that…
>	* - [ ] implements a game loop.
>	* - [ ] asks for user input.
>	* - [ ] writes output to the console.
>	* - [ ] calls VirtualPetShelter’s tick method after each interaction
>* - [ ] Available user interface actions should include (at minimum)…
>	* - [ ] feeding all the pets
>	* - [ ] watering all the pets
>	* - [ ] playing with an individual pet, which should display a list of pet names and descriptions, allowing a user to select one
>	* - [ ] allow adoption of a pet, which should display a list of pet names and descriptions, allowing a user to select one
>	* - [ ] allow intake of a pet, prompting the user for the pet’s information, requiring the user to (at minimum) specify name and description
>
>#### VirtualPetShelter class
>* - [ ] Include appropriate instance variable(s) to store the pets who reside at the shelter
>* - [ ] Include methods that:
>	* - [ ] return a Collection of all of the pets in the shelter
>	* - [ ] return a specific VirtualPet given its name
>	* - [ ] allow intake of a homeless pet
>	* - [ ] allow adoption of a homeless pet
>	* - [ ] feed all of the pets in the shelter
>	* - [ ] water all of the pets in the shelter
>	* - [ ] plays (or performs some other interaction(s)) with an individual pet in the shelter
>* - [ ] Include a tick method that calls the tick method for each of the pets in the shelter, updating their needs
>
>#### VirtualPet class
>* - [ ] The requirements from last week’s project:
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

- [ ] create a model that allows for dogs and cats, either of which may be robotic
- [ ] introduce an attribute (instance variable) representing overall health that is updated as a result of other attributes moving in a negative or positive direction, influencing happiness
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

- [ ] introduce methods that allow for:
	- [ ] oiling/maintaining all robotic pets
	- [ ] cleaning dog cages
	- [ ] emptying the litterbox
- [ ] modify existing methods to only feed/water pets that are not robotic

#### VirtualPetShelterApp class
In addition to the last project’s requirements:

- [ ] add options to:
	- [ ] walk all dogs
- [ ] clean dog cages
- [ ] clean the shelter litterbox
- [ ] oil all robotic pets

### Tips
Remember: don’t get caught up in the user interface at first. Focus on shelter/pet behavior. Try to get one thing working at a time.
Try creating tests to verify pet behavior, limiting your immediate goal to something small.
### Grading
Here is the rubric.
Category	|Max Score
------------|---------
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
Stretch Tasks
Allow for other types of pets. Are they caged? What maintenance do they require?
Allow an option for giving treats to pets. What sorts of treats do different pets like?
introduce a Cage class for each dog, where cleanliness is tracked, keying these on the dog to which each is assigned (to use a VirtualPet as a key in a HashMap, you should implement hashCode and equals)
Herd your cats.
(Note: the author is aware that it would not be a wise decision to allow all cats in a shelter to share a litterbox. They’re virtual pets, so virtually disease-free.)