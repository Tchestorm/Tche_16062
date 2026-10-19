package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.TcheHardware;

@Autonomous(name = "Robot: Far", group = "Robot")
public class Far extends LinearOpMode {

    private final TcheHardware robot = new TcheHardware();

    // Como o motor não tem redução, usamos apenas os ticks base do encoder do motor (ex: 28.0)

    @Override
    public void runOpMode() {

        robot.init(hardwareMap);


        // Liga o shooter ANTES do waitForStart para embalar sem delay
        robot.shooter.setPower(0.6);

        waitForStart();

        sleep(500);

        robot.intakeShoter.setPower(0.6);
        sleep(1000);

        // Sequência do intake
        robot.intake.setPower(-0.6);
        sleep(250);
        robot.intake.setPower(0);
        sleep(450);

        robot.intake.setPower(-0.6);
        sleep(250);
        robot.intake.setPower(0);
        sleep(450);

        robot.intake.setPower(-0.6);
        sleep(6000);

        // Parando os motores
        robot.shooter.setPower(0);
        robot.intakeShoter.setPower(0);
        robot.intake.setPower(0);
    }
}