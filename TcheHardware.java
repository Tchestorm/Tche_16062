package org.firstinspires.ftc.teamcode;



import com.qualcomm.robotcore.hardware.DcMotor;

import com.qualcomm.robotcore.hardware.HardwareMap;

import com.qualcomm.robotcore.hardware.Servo;



public class TcheHardware {



    public DcMotor trasDireita;

    public DcMotor trasEsquerda;

    public DcMotor frenteDireita;

    public DcMotor frenteEsquerda;

    public DcMotor shooter;

    public DcMotor intake;

    public DcMotor intakeShoter;

    public Servo garraEsquerda;



    HardwareMap hardwareMap;



    public void init(HardwareMap ahardwareMap) {

        hardwareMap = ahardwareMap;



// 1. Mapeamento dos motores e servos

        trasDireita = hardwareMap.get(DcMotor.class, "tras_direita");

        trasEsquerda = hardwareMap.get(DcMotor.class, "tras_esquerda");

        frenteDireita = hardwareMap.get(DcMotor.class, "frente_direita");

        frenteEsquerda = hardwareMap.get(DcMotor.class, "frente_esquerda");

        intake = hardwareMap.get(DcMotor.class, "motor_passagem");

        shooter = hardwareMap.get(DcMotor.class, "motor_atirador");

        intakeShoter = hardwareMap.get(DcMotor.class, "motor_passagemDoshoter");



// Mapeia o servo. O nome "servo" deve estar idêntico no Driver Hub / Robot Controller!

        garraEsquerda = hardwareMap.get(Servo.class, "servo");



// 2. Direção dos motores (Padrão oficial FTC para chassis Mecanum)

        frenteEsquerda.setDirection(DcMotor.Direction.REVERSE);

        trasEsquerda.setDirection(DcMotor.Direction.FORWARD);

        frenteDireita.setDirection(DcMotor.Direction.FORWARD);

        trasDireita.setDirection(DcMotor.Direction.REVERSE);



// 3. Inicializar a posição do servo (OBRIGATÓRIO)

        garraEsquerda.setPosition(0.5);



// Zerar potência inicial dos motores

        trasDireita.setPower(0);

        trasEsquerda.setPower(0);

        frenteDireita.setPower(0);

        frenteEsquerda.setPower(0);

        intake.setPower(0);

        shooter.setPower(0);

        intakeShoter.setPower(0);



// Modo dos motores

        trasDireita.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        trasEsquerda.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        frenteDireita.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        frenteEsquerda.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        intake.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        shooter.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        intakeShoter.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);



// Comportamento ao parar

        trasDireita.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        trasEsquerda.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        frenteDireita.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        frenteEsquerda.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        intake.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        shooter.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        intakeShoter.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

    }

}