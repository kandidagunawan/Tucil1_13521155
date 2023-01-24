import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class App {
    public static double operation(double num1, double num2, double opcode) {
        if (opcode == 0) {
            return (num1 + num2);
        } else if (opcode == 1) {
            return (num1 - num2);
        } else if (opcode == 2) {
            return (num1 * num2);
        } else {
            if (num2 == 0) {
                return -9999999;
            } else {
                return (num1 / num2);
            }
        }
    }

    public static Set hitung(double x1, double x2, double x3, double x4, Set<String> formula) {
        String[] operators = { "+", "-", "*", "/" };
        double hasil = 0;
        double temp = 0;
        int count = 0;
        String op1, op2, op3;
        String formulaString = "";
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                for (int k = 0; k < 4; k++) {
                    for (int l = 0; l < 5; l++) {
                        switch (l) {
                            case 0:
                                // bentuk : ((2+4)+5)+6
                                hasil = operation(x1, x2, i);
                                hasil = operation(hasil, x3, j);
                                hasil = operation(hasil, x4, k);
                                formulaString = "((" + (int) x1 + operators[i] + (int) x2 + ")" + operators[j]
                                        + (int) x3 + ")"
                                        + operators[k] + (int) x4;
                                break;
                            case 1:
                                // bentuk : (2+4)+(5+6)
                                hasil = operation(x1, x2, i);
                                temp = operation(x3, x4, k);
                                hasil = operation(hasil, temp, j);
                                formulaString = "(" + (int) x1 + operators[i] + (int) x2 + ")" + operators[j] + "("
                                        + (int) x3
                                        + operators[k] + (int) x4 + ")";
                                break;
                            case 2:
                                // bentuk : (2+(4+5))+6
                                temp = operation(x2, x3, j);
                                hasil = operation(x1, temp, i);
                                hasil = operation(hasil, x4, k);
                                formulaString = "(" + (int) x1 + operators[i] + "(" + (int) x2 + operators[j] + (int) x3
                                        + "))"
                                        + operators[k] + (int) x4;
                                break;
                            case 3:
                                // bentuk : 2+((4+5)+6)
                                temp = operation(x2, x3, j);
                                hasil = operation(temp, x4, k);
                                hasil = operation(x1, hasil, i);
                                formulaString = (int) x1 + operators[i] + "((" + (int) x2 + operators[j] + (int) x3
                                        + ")" + operators[k]
                                        + (int) x4 + ")";
                                break;
                            case 4:
                                // bentuk : 2+(4+(5+6))
                                hasil = operation(x3, x4, k);
                                hasil = operation(x2, hasil, j);
                                hasil = operation(x1, hasil, i);
                                formulaString = (int) x1 + operators[i] + "(" + (int) x2 + operators[j] + "(" + (int) x3
                                        + operators[k]
                                        + (int) x4 + "))";
                                break;

                        }
                        if (hasil == 24) {
                            formula.add(formulaString);
                        }
                    }
                }
            }
        }
        return formula;
    }

}
