# CommandBasedTestBot_JAVA

Latest changes
Simple changes here and there
- added a controls ENUM class under logic
  - this allows us to call this class and say hey A.toInt() and it will return the corresponding number needed for A key
- added two new functions to NeoUtil which are just for shortening down if statements 
- cleaned up all the imports 
  - they look much busier, but in terms of compiling its just a bit lighter on the system
  - many imports have been converted to static 
    - static imports are refered to as they are
      - instead of Robot.kChassis you would just do kChassis

OI Changes
- initializing OI now sets all the buttons and controllers in seperate functions
  - first function sets controllers
  - second and third sets all the drivers and operator buttons
  - fourth sets the functions for every button
- addapted controller buttons to the controls class
- changed OI from static class to a proper object class
  - instead of OI.func do Robot.m_oi.func

RobotMap changes
- Went through and added a better labeling so its easier to navigate
- added specialized spacing so reading is easier
- added new variabls for various parts throughout the code

Command changes (not including auto based commands)
- most importantly created sub command packages for each subsystem just for orginization
- cleaned up every command and got rid of unnecessary space
- changed climbing and start configurations to be command groups instead (NEEDS TESTING)
- if you havent read the imports change under "Simple changes here and there"
- Drive command
  - renamed from CustomXboxDrive to Drive
  - redid the algorithm used for setting the speeds
- fold arm
  - added a safety feature where arm has to be X high
- move arm
  - added safety feature so cant go past values set
    - min value depends on wether arm is folded or not
- commands dealing with the gear box
  - renamed majority
  - added safety feautres to neutralizer where it cant activate/deactive unless in high gear

subsystem changes
- all
  - redid imports
  - renamed variables for clarity
  - redid constructor
  - constructors now set into default physical positions but this may need to change as it may 
    acitvate right as the robot turns on
  - removed functions I felt should be commands instead
  - changed most enable and disable functions to a single set which takes in true or false
    - should be true for enabled and false for disabled
- chassis
  - removed break, instead we should really stick to just setting the speed to 0

other files cleaned up
- robot
  - nothing much done just some simple cleaning up and may need to add in old stuff again
changearmspeed
  - probably temporary
wait command
  - not sure if works but if it does should just make the robot wait for a second
  
  
future plans
- fix auto commands
- create a smartdashboard type class
  - this will basically run everytime the robot is update and get every value we want and
    display it to the smart dashboard instead of randomly scatering putNumbers and such what
    all over the code
 
