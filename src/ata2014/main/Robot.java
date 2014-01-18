package ata2014.main;

import edu.first.main.Constants;
import edu.first.module.actuators.Drivetrain;
import edu.first.module.actuators.VictorModule;
import edu.first.module.joysticks.XboxController;
import edu.first.module.subsystems.Subsystem;
import edu.first.module.subsystems.SubsystemBuilder;
import edu.first.robot.IterativeRobotAdapter;
import edu.first.util.log.Logger;

/**
 * Team 4334's main robot code starting point. Everything that happens is
 * derived from this class.
 *
 * @author Joel Gallant <joelgallant236@gmail.com>
 */
public final class Robot extends IterativeRobotAdapter implements Constants {

    private final XboxController joystick1 = new XboxController(1);
    private final VictorModule left = new VictorModule(LEFT),
            right = new VictorModule(RIGHT);
    private final Drivetrain drivetrain = new Drivetrain(left, right);
    private final VictorModule arm = new VictorModule(ARM);
    private final Subsystem FULL_ROBOT = new SubsystemBuilder()
            .add(joystick1)
            .add(drivetrain).add(left).add(right)
            .add(arm)
            .toSubsystem();

    public Robot() {
        super("2014 Robot");
    }

    public void init() {
        Logger.getLogger(this).warn("Robot is initializing");
        FULL_ROBOT.init();
        Logger.getLogger(this).warn("Robot is ready");
    }

    public void initAutonomous() {
    }

    public void initTeleoperated() {
        Logger.getLogger(this).info("Teleoperated starting...");

        FULL_ROBOT.enable();

        joystick1.addAxisBind(drivetrain.getArcade(joystick1.getLeftY(), joystick1.getRightX()));
        joystick1.addAxisBind(joystick1.getTrigger(), arm);
    }

    public void initDisabled() {
        Logger.getLogger(this).info("Disabled starting...");
        FULL_ROBOT.disable();
    }

    public void initTest() {
        Logger.getLogger(this).info("Test starting...");
    }

    public void periodicAutonomous() {
    }

    public void periodicTeleoperated() {
        joystick1.doBinds();
    }

    public void periodicDisabled() {
    }

    public void periodicTest() {
    }

    public void endAutonomous() {
        Logger.getLogger(this).warn("Autonomous finished");
    }

    public void endTeleoperated() {
        joystick1.clearBinds();

        Logger.getLogger(this).warn("Teleoperated finished");
    }
}
