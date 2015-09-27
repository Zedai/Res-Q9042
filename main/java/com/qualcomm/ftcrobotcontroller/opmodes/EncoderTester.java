package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorController;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.Range;
/**
 * Created by Anjali on 9/20/2015.
 */
public class EncoderTester extends OpMode {

    DcMotor l1, l2, r1, r2;

    public EncoderTester() {

    }

    public void init() {
        l1 = hardwareMap.dcMotor.get("l1");
        l2 = hardwareMap.dcMotor.get("l2");
        r1 = hardwareMap.dcMotor.get("r1");
        r2 = hardwareMap.dcMotor.get("r2");

        l1.setDirection(DcMotor.Direction.REVERSE);
        l2.setDirection(DcMotor.Direction.REVERSE);

        r1.setChannelMode(DcMotorController.RunMode.RESET_ENCODERS);
        r2.setChannelMode(DcMotorController.RunMode.RESET_ENCODERS);
        l1.setChannelMode(DcMotorController.RunMode.RESET_ENCODERS);
        l2.setChannelMode(DcMotorController.RunMode.RESET_ENCODERS);
        r1.setChannelMode(DcMotorController.RunMode.RUN_TO_POSITION);
        r2.setChannelMode(DcMotorController.RunMode.RUN_TO_POSITION);
        l1.setChannelMode(DcMotorController.RunMode.RUN_TO_POSITION);
        l2.setChannelMode(DcMotorController.RunMode.RUN_TO_POSITION);
    }

    public void loop() {

        telemetry.addData("Right1 Encoder: ", r1.getCurrentPosition());
        telemetry.addData("Right2 Encoder: ", r2.getCurrentPosition());
        telemetry.addData("Left1 Encoder: ", +l1.getCurrentPosition());
        telemetry.addData("Left2 Encoder: ", l2.getCurrentPosition());

//        r1.setTargetPosition(5000);
//        r1.setPower(.10);
//        r2.setTargetPosition(5000);
//        r2.setPower(.10);
//        l1.setTargetPosition(5000);
//        l1.setPower(.10);
//        l2.setTargetPosition(5000);
//        l2.setPower(.10);
    }

    public void stop() {
        r1.setPower(0);
        r2.setPower(0);
        l1.setPower(0);
        l2.setPower(0);
    }
}