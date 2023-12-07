package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;


public class Robot extends TimedRobot {
  private final PWMSparkMax m_leftMotor = new PWMSparkMax(1);
  private final PWMSparkMax m_rightMotor = new PWMSparkMax(0);
  private final DifferentialDrive m_robotDrive = new DifferentialDrive(m_leftMotor, m_rightMotor);
  private final Joystick m_stick = new Joystick(0);

  @Override
  public void robotInit() {
    // We need to invert one side of the drivetrain so that positive voltages
    // result in both sides moving forward. Depending on how your robot's
    // gearbox is constructed, you might have to invert the left side instead.
    m_rightMotor.setInverted(true);
  }

  @Override
  public void teleopPeriodic() {
    // Drive with arcade drive.
    // That means that the Y axis drives forward
    // and backward, and the X turns left and right.
    m_robotDrive.arcadeDrive(-m_stick.getY(), m_stick.getX());

    double multipler = m_stick.getRawAxis(3);

    double xSpeed = m_stick.getY() * multipler;
    double zRotation = -m_stick.getZ() * multipler;

    m_robotDrive.arcadeDrive(xSpeed, zRotation);
  }

  //System.out.println(m_stick.getRawAxis(3));
}
