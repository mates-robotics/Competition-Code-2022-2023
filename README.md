# MATES Robotics Competition Code for the 2022-2023 FIRST® Tech Challenge: Power Play

## Robot Map

1. Imports all necessary packages
2. Creates variables for each individual motor
3. Sets base direction of all motors
4. Ensures all motors are off
5. Sets all motors to run without encoders

## Tank Mode

1. Imports all necessary packages
2. When Tank-Mode is initiated, the power of all motors are set to 0
3. Pressing y, b, and a on the controller correlate to high, medium, and low speed settings respectively. Code defaults to medium speed. When high is selected, it divides the velocity derived from the controller sticks by 1. When medium is selected, it divides the velocity by 2, and when slow is selected, it divides the velocity by 4.
4. When strafing, adjacent wheels go in opposite directions.
5. The velocity while strafing is divided by the same constants used in driving, times 1.5
6. At Stop, all motors are set back to 0

## Methods

1. Imports all necessary packages
2. Turn Method:
   * Motors set to run without encoder
   * To turn left, left wheels turn forward and right wheels turn back (and vice versa for turning right
3. Drive Method:
   * Resets encoders
   * Converts distance (in inches) to centimeters, then converts to ticks using * (537.7/30.16)
   * Sets target positions of all motors
   * Runs to target position at speed set
   * Resets all velocities to 0
4. Strafe Method:
   * Set to run without encoders
   * Sets the amount of time strafing to 1000 * distance/18
   * Power is set to +/- 0.33 depending on direction
   * Adjacent wheels run opposite directions
   * Loops for set amount of time
   * Resets all powers to 0

## Autonomous

1. Imports all necessary packages
2. Begins with cone in claw
3. Drives to nearest high junction
4. Places cone on junction
5. Drives to nearest alliance terminal to park
6. Resets all powers to 0
