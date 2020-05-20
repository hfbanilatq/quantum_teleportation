package com.hfbanilatq.quanticteleportation;

import com.gluonhq.strange.Complex;
import com.gluonhq.strange.Gate;
import com.gluonhq.strange.Step;
import com.gluonhq.strange.gate.Hadamard;
import com.gluonhq.strange.gate.X;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner  sc = new Scanner(System.in);
        QuantumTeleportation qt;
        List<Step> steps;
        System.out.println("Bienbenido Al Simulador Cuántico de Banilat");
        while (true) {
            System.out.println("Ingrese el qubit a teleportar dentro de las opciones: ");
            System.out.println("1. |0> \n" +
                    "2. |1> \n" +
                    "3. |+> \n" +
                    "4. |-> \n" +
                    "5. Personalizado");

            switch (sc.nextInt()){
                case 1:
                    qt = new QuantumTeleportation();
                    qt.run();
                    break;
                case 2:
                    steps = new ArrayList<>();
                    Step step2 = new Step();
                    step2.addGate(new X(0));
                    steps.add(step2);
                    qt = new QuantumTeleportation(steps);
                    qt.run();
                    break;
                case 3:
                    steps = new ArrayList<>();
                    Step step3 = new Step();
                    step3.addGate(new Hadamard(0));
                    steps.add(step3);
                    qt = new QuantumTeleportation(steps);
                    qt.run();
                    break;
                case 4:
                    steps = new ArrayList<>();
                    Step step4 = new Step();
                    step4.addGate(new X(0));
                    Step step41 = new Step();
                    step41.addGate(new Hadamard(0));
                    steps.add(step4);
                    steps.add(step41);
                    qt = new QuantumTeleportation(steps);
                    qt.run();
                    break;
                case 5:
                    System.out.println("Ingrese el valor de Alpha en punto flotante:");
                    qt = new QuantumTeleportation(sc.nextDouble());
                    qt.run();
                    break;

                default:
                    System.out.println("Error, la opción seleccionada no existe");
                    break;

            }
        }
    }
}
