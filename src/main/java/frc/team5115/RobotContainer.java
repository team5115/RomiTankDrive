public class RobotContainer {
    private final int number;
    public RobotContainer(){
        switch (Constants.currentMode) {
            case REAL:
                number = 5;
                break;
            case SIM:
                number 20;
                break;
            default:
                number = 10;
                break;
        }
    }
}
