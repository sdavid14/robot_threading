import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Robot {
    private static ElevatorThread elevatorThread ;
    private static DriveTrainThread driveTrainThread ;

    private static ExecutorService elevatorExecutor;
    private static ExecutorService driveTrainExecutor ;

    private static void init() {
        elevatorThread = new ElevatorThread();
        driveTrainThread = new DriveTrainThread();

        elevatorExecutor = Executors.newSingleThreadExecutor();
        elevatorExecutor.execute(elevatorThread);

        driveTrainExecutor = Executors.newSingleThreadExecutor();
        driveTrainExecutor.execute(driveTrainThread);
    }

    /**
     * Simulate robot callback method, process joystick commands
     */
    public static void teleopPeriodic() {

       System.out.println("Waiting for threads to terminate...");

       try {

        // Simulate various button commands
        Thread.sleep(100); 
        elevatorThread.sendCommand("button command 1");

        Thread.sleep(100);
        driveTrainThread.sendCommand("joystick command 2");

        Thread.sleep(100);
        elevatorThread.sendCommand("button command 3");


       } catch (InterruptedException e) {
           e.printStackTrace();
       }
    }

    public static void main(String[] args) {

        init();

        for (int i=0; i<5; i++) {
            teleopPeriodic();
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

       elevatorExecutor.shutdown();
       driveTrainExecutor.shutdown();
       System.out.println("...Done with main()");
    }
}