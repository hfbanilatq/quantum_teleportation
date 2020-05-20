package com.hfbanilatq.quanticteleportation;

import com.gluonhq.strange.*;
import com.gluonhq.strange.gate.Cnot;
import com.gluonhq.strange.gate.Cz;
import com.gluonhq.strange.gate.Hadamard;
import com.gluonhq.strange.gate.Measurement;
import com.gluonhq.strange.local.SimpleQuantumExecutionEnvironment;
import com.gluonhq.strangefx.render.Renderer;

import java.util.ArrayList;
import java.util.List;

public class QuantumTeleportation {
    private  Double initialqubitValue;
    private List<Step> steps = new ArrayList<>();
    public QuantumTeleportation(Double initialQubit) {
        this.initialqubitValue = initialQubit;
    }

    public QuantumTeleportation(List<Step> steps) {
        this.steps = steps;
    }


    public  QuantumTeleportation(){
    }
    public void run(){
        Program program = new Program(3);
        Step step1 = new Step();
        step1.addGate(new Hadamard(1));
        Step step2 = new Step();
        step2.addGate(new Cnot(1,2));
        Step step3 = new Step();
        step3.addGate(new Cnot(0,1));
        Step step4 = new Step();
        step4.addGate(new Hadamard(0));
        Step step5 = new Step();
        step5.addGate(new Measurement(0));
        step5.addGate(new Measurement(1));
        Step step6 = new Step();
        step6.addGate(new Cnot(1,2));
        Step step7 = new Step();
        step7.addGate(new Cz(0,2));

        if(!steps.isEmpty()) {
            for (Step step: steps) {
                program.addStep(step);
            }
        }
        program.addStep(step1);
        program.addStep(step2);
        program.addStep(step3);
        program.addStep(step4);
        program.addStep(step5);
        program.addStep(step6);
        program.addStep(step7);

        if (initialqubitValue != null){
            program.initializeQubit(0, initialqubitValue);
        }

        QuantumExecutionEnvironment simulator = new SimpleQuantumExecutionEnvironment();
        simulator.runProgram(program);

        Renderer.renderProgram(program);
        Renderer.showProbabilities(program, 1024);
    }
}
