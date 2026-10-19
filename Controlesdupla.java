package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.TcheHardware;

@TeleOp(name = "TeleOp_Harsare", group = "TeleOp")
public class Controlesdupla extends LinearOpMode {

    private final TcheHardware robot = new TcheHardware();

    @Override
    public void runOpMode() {

        robot.init(hardwareMap);

        telemetry.addData("Status", "Harsare pronto para 2 Controles. Aguardando inicio...");
        telemetry.update();

        waitForStart();

        while (opModeIsActive()) {

            // =========================================================
            // 1. MOVIMENTAÇÃO MECANUM (EXCLUSIVO NO GAMEPAD 1)
            // =========================================================
            double speedAdjust = 0.80;

            double drive  = -gamepad1.left_stick_y * speedAdjust;
            double strafe = -gamepad1.left_stick_x * speedAdjust * 1.1;
            double twist  = -gamepad1.right_stick_x * speedAdjust;

            double frenteEsquerdaPower =  drive + strafe + twist;
            double trasEsquerdaPower   =  drive - strafe + twist;
            double frenteDireitaPower  =  drive - strafe - twist;
            double trasDireitaPower    =  drive + strafe - twist;

            // Normalização de potência máxima
            double maxPower = Math.max(Math.abs(frenteEsquerdaPower), Math.max(Math.abs(frenteDireitaPower),
                    Math.max(Math.abs(trasEsquerdaPower), Math.abs(trasDireitaPower))));

            if (maxPower > 1.0) {
                frenteEsquerdaPower /= maxPower;
                frenteDireitaPower  /= maxPower;
                trasEsquerdaPower   /= maxPower;
                trasDireitaPower    /= maxPower;
            }

            // Envia a potência para os motores do chassi
            robot.frenteEsquerda.setPower(frenteEsquerdaPower);
            robot.trasEsquerda.setPower(trasEsquerdaPower);
            robot.frenteDireita.setPower(frenteDireitaPower);
            robot.trasDireita.setPower(trasDireitaPower);

            // =========================================================
            // 2. CONTROLE DO INTAKE (EXCLUSIVO NO GAMEPAD 2 - Gatilhos)
            // =========================================================
            if (gamepad2.right_trigger > 0.9) {
                robot.intake.setPower(-gamepad2.right_trigger);
            } else if (gamepad2.left_trigger > 0.9) {
                robot.intake.setPower(gamepad2.left_trigger);
            } else {
                robot.intake.setPower(-0.1);
            }

            // =========================================================
            // 3. CONTROLE DO SHOOTER E INTAKE SHOOTER (EXCLUSIVO NO GAMEPAD 2 - Bumpers)
            // =========================================================
            if (gamepad2.right_bumper) {
                robot.shooter.setPower(-0.6);
                robot.intakeShoter.setPower(1.0);
            } else if (gamepad2.left_bumper) {
                robot.shooter.setPower(0.50);
                robot.intakeShoter.setPower(-0.80);
            } else {
                robot.shooter.setPower(-0.05);
                robot.intakeShoter.setPower(0.10);
            }

            // -----------------------------------------
            // TELEMETRIA
            // -----------------------------------------
            telemetry.addData("Modo", "2 Controles Ativo");
            telemetry.addData("Motores [FE|FD]", "%.2f | %.2f", frenteEsquerdaPower, frenteDireitaPower);
            telemetry.addData("Motores [TE|TD]", "%.2f | %.2f", trasEsquerdaPower, trasDireitaPower);
            telemetry.addData("Intake Power", robot.intake.getPower());
            telemetry.addData("Shooter Power", robot.shooter.getPower());
            telemetry.addData("Intake Shooter Power", robot.intakeShoter.getPower());

            if (robot.garraEsquerda != null) {
                telemetry.addData("Garra (Atual Real)", "%.2f", robot.garraEsquerda.getPosition());
            } else {
                telemetry.addData("Garra Erro", "Servo 'garra_esquerda' não encontrado!");
            }

            telemetry.update();
        }
    }
}