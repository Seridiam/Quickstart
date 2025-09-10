package OpModes;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

import Mechanisms.LaunchBoard;
import Mechanisms.OmnimovementBoard;

@com.qualcomm.robotcore.eventloop.opmode.Autonomous(name = "Autonomous_blueWall")
public class AutonomousBlueWall extends LinearOpMode
{
    OmnimovementBoard OmniBoard = new OmnimovementBoard();
    LaunchBoard LaunchBoard = new LaunchBoard();
    ElapsedTime timer = new ElapsedTime();

    @Override
    public void runOpMode()
    {
        //Init
        OmniBoard.init(hardwareMap); OmniBoard.initAuto(this);
        LaunchBoard.init(hardwareMap);
        telemetry.addData("IMU:", OmniBoard.getIntegratedHeading());
        waitForStart();

        //Moving
        OmniBoard.IMUFollow(200, 30, 0);
        timer.reset(); while (timer.milliseconds() <= 4000) {}
        OmniBoard.IMUFollow(2300, 50, 0);
        /*OmniBoard.IMUFollow(200,-60,0);
        OmniBoard.IMUFollow(500, 0, -40);
        OmniBoard.ChangeIMUAngle(-45);
        OmniBoard.IMUFollow(300,60,0);
        OmniBoard.IMUFollow(200,-60,0);

        LaunchAll();
        OmniBoard.ChangeIMUAngle(-45);
        OmniBoard.IMUFollow(500, 50, 0);
        OmniBoard.IMUFollow(500, 0, 60);
    }

    private void LaunchAll()
    {
        for (int i = 0; i < 3; i++)
        {
            LaunchBoard.SideGeckoMovement(0.85);
            timer.reset(); while (timer.milliseconds() <= 650) {}
            LaunchBoard.SideGeckoMovement(0);
            timer.reset(); while (timer.milliseconds() <= 400) {}
        }*/
    }
}
