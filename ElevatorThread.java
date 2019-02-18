public class ElevatorThread implements Runnable {

    private Elevator elevator;

    private void init() {
        elevator = new Elevator();
    }
    public void sendCommand(String command) {
        elevator.doSomething(command);
    }
    @Override
    public void run() {

        init();
    
        System.out.println("ElevatorThread thread working...");
        elevator.doSomething();
        try {
            Thread.sleep(3000); // pretend we're working
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("...ElevatorThread done working.");
    }
}