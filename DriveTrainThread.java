public class DriveTrainThread implements Runnable {

    private DriveTrain driveTrain;

    private void init() {
        driveTrain = new DriveTrain();
    }

    public void sendCommand(String command) {
        driveTrain.doSomething(command);
    }

    @Override
    public void run() {
        init();

        System.out.println("DriveTrain thread working...");
        driveTrain.doSomething();
        try {
            Thread.sleep(3000); // pretend we're working
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("...DriveTrain done working.");

    }
}