public class RobotContainer {
    private final int number;
    private final Drive drive;
    public RobotContainer(){
        switch (Constants.currentMode) {
            case REAL:
                drive = new Drive(new DriveIORomi());
                break;
            case SIM:
                drive = new Drive(new DriveIO(){});
                break;
            default:
                drive = new Drive(new DriveIO(){});
                break;
        }
        drive.setDefaultCommand(drive.drive());
    }
}
