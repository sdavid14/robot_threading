# robot_threading
Example of how you might spawn worker threads for robot subsystems

This sample illustrates how you can wrap each of your subsystem classes in a Runnable, and then have your Robot class instantiate those instead of the subsystem classes directly.

Your teleopPeriodic control loop will then pass commands to the subsystem service threads as they come in.
