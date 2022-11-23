# MATES Robotics Competition Code for the 2022-2023 FIRST® Tech Challenge: Power Play

## Robot Map

1. Imports all necessary packages.
2. Creates variables for each individual motor.
3. Sets base direction of all motors.
4. Ensures all motors are off.
5. Sets all motors to run without encoders.

## Tank Mode

1. Imports all necessary packages.
2. When Tank Mode is initiated, the power of all motors are set to 0.
3. Pressing y, b, and a on the controller correlate to high, medium, and low speed settings respectively. Code defaults to medium speed. When high is selected, it divides the velocity derived from the controller sticks by 1. When medium is selected, it divides the velocity by 2, and when slow is selected, it divides the velocity by 4.
4. Pressing the left and right bumper makes the robot strafe in the respective direction. When strafing, adjacent wheels go in opposite directions. The velocity while strafing is divided by the same constants used in driving, times 1.5.
5. Pressing up and down on the d-pad makes the claw move one increment upwards or downwards, respectivly. The increments correspond to the ground, the ground junction, the low junction, the medium junction, and the high junction. To make finer adjustments to the claw's height the left and right triggers are used.
6. Pressing left and right on the d-pad makes the robot open and close the claw.
8. The controller sticks moves the robot forward when they are both pressed forward, moves the robot backward when they are both pressed backward, turns the robot left when the right stick is pressed forward and the left stick backward, and turns the robot right when the right stick is pressed backward and the left stick forward.
7. At Stop, all motors are set back to 0 power.

## Methods

1. Imports all necessary packages.
2. Turn Method:
   * Takes an input of a degree and a speed. Negative degrees to turn left and positive degrees to turn right.
   * Using the encoders, the wheels turn the correct amount in the correct direction to turn the number of degrees specified at the speed specified.
3. Drive Method:
   * Takes an input of a distance in inches and a speed. Negative distances to go backwards and positive distances to go forwards.
   * Using the encoders, the wheels turn the correct amount in the correct direction to move the distance specified at the speed specified.
4. Strafe Method:
   * Takes an input of a distance in inches and a speed. Negative distances to go left and positive distances to go right.
   * Using the encoders, the wheels turn the correct amount in the correct direction to move the distance specified at the speed specified.
5. Claw Method:
   * Takes an input of a boolean.
   * True will open the claw and false will close the claw.
6. Raising Method:
   * Takes an input of a number (0, 1, 2, 3, or 4) and a speed. These  numbers correspond to the ground, the ground junction, the low junction, the medium junction, and the high junction.
   * Using the encoder the robot then moves the claw to the specified position at the specified speed.
   * (In progress) Using overloaded methods, if the raising method is also given an input of a boolean, the first number in the method will correspond to a specific number of ticks to move to allow for precise changes. The second number will still be a speed.

## Autonomous

1. Imports all necessary packages.
2. Begins with cone in claw.
3. Drives to nearest high junction.
4. Places cone on junction.
5. Drives to nearest alliance terminal to park.
6. Resets all powers to 0.
