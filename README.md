# Competition Code for 2022-2023, Freight Frenzy

## Robot Map

Imports all necessary packages
Creates variables for each individual motor
Sets base direction of all motors
Ensures all motors are off
Sets all motors to run without encoders

## Tank Mode

Imports all necessary packages
When Tank-Mode is initiated, the power of all motors are set to 0

Pressing y, b, and a on the controller correlate to high, medium, and low speed settings respectively. Code defaults to medium speed. When high is selected, it divides the velocity derived from the controller sticks by 1. When medium is selected, it divides the velocity by 2, and when slow is selected, it divides the velocity by 4. 

When strafing, adjacent wheels go in opposite directions.
The velocity while strafing is divided by the same constants used in driving, times 1.5

At Stop, all motors are set back to 0

## Methods

Imports all necessary packages

Turn Method: 
Motors set to run without encoder
to turn left, left wheels turn forward and right wheels turn back (and vice versa for turning right
Drive Method:
Resets encoders
Converts distance (in inches) to centimeters, then converts to ticks using * (537.7/30.16)
Sets target positions of all motors
Runs to target position at speed set
Resets all velocities to 0
Strafe Method:
Set to run without encoders
Sets the amount of time strafing to 1000 * distance/18
Power is set to +/- 0.33 depending on direction
Adjacent wheels run opposite directions
Loops for set amount of time
Resets all powers to 0

## Autonomous

Imports all necessary packages

Begins with cone in claw
Drives to nearest high junction
Places cone on junction
Drives to nearest alliance terminal to park

Resets all powers to 0
