package bankaccount;

import java.util.Random;

public class BankAccount {

    private String numeroCuenta;
    private Double SueldoCorriente;
    private Double SueldoAhorro;
    private static Integer cantidadCuentas = 0;
    private static Double dineroTotal = 0.0;

    public BankAccount() {
        numeroCuenta = numeroDeCuenta();
        SueldoCorriente = 0.0;
        SueldoAhorro = 0.0;
        dineroTotal = 0.0;
        cantidadCuentas++;
    }

    private String numeroDeCuenta() {
        Random random = new Random();
        StringBuilder numeroCuentaBuilder = new StringBuilder();

        for (int i = 0; i < 10; i++) {
            numeroCuentaBuilder.append(random.nextInt(10));
        }

        return numeroCuentaBuilder.toString();
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public static Integer getCantidadCuentas() {
        return cantidadCuentas;
    }

    public static Double getDineroTotal() {
        return dineroTotal;
    }

    public Double getSueldoCorriente() {
        return SueldoCorriente;
    }

    public Double getSueldoAhorro() {
        return SueldoAhorro;
    }

    public void depositarDinero(Double dinero) {
        if (dinero < 0) {
            throw new IllegalArgumentException("No se puede depositar una cantidad negativa de dinero a la cuenta.");
        }
        this.SueldoAhorro += dinero;
        dineroTotal += dinero;
    }

    public void retirarDinero(Double dinero) {
        if (dinero <= 0) {
            throw new IllegalArgumentException("La cantidad a retirar debe ser mayor que cero.");
        }

        if (this.SueldoAhorro >= dinero) {
            this.SueldoAhorro -= dinero;
        } else if (this.SueldoCorriente >= dinero) {
            this.SueldoCorriente -= dinero;
        } else {
            throw new IllegalArgumentException("Saldo insuficiente en ambas cuentas.");
        }
    }

    public void verDinero() {
        System.out.println("Información de la cuenta:");
        System.out.println("Número de cuenta: " + numeroCuenta);
        System.out.println("Saldo de cuenta corriente: " + SueldoCorriente);
        System.out.println("Saldo de cuenta de ahorro: " + SueldoAhorro);
        System.out.println("Dinero total en todas las cuentas: " + dineroTotal);
    }
}
