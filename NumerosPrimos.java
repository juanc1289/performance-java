import java.time.Duration;
import java.time.Instant;

/*
Resultados hasta 1M:

PC: Intel Core i5-7200U 2.50GHz
Cantidad de números primos hasta 1000000: 78498
Tiempo de ejecución: 0.282 segundos

Raspberry Pi 4: ARM Cortex-A72 1.5GHz
Cantidad de números primos hasta 1000000: 78498
Tiempo de ejecución: 0.337 segundos

Resultados hasta 10M:

PC: Intel Core i5-7200U 2.50GHz
Cantidad de números primos hasta 10000000: 664579
Tiempo de ejecución: 7.306 segundos

Raspberry Pi 4: ARM Cortex-A72 1.5GHz
 Cantidad de números primos hasta 10000000: 664579
Tiempo de ejecución: 9.376 segundos

Macbook pro M3
1.4 seg



 */

public class NumerosPrimos {

    public static boolean esPrimo(int n) {
        if (n < 2) return false;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        final int limite = 10000000;
        int contadorPrimos = 0;

        // Inicia la medición de tiempo
        Instant inicio = Instant.now();

        for (int i = 2; i <= limite; i++) {
            if (esPrimo(i)) {
                contadorPrimos++;
            }
        }

        // Termina la medición de tiempo
        Instant fin = Instant.now();
        Duration duracion = Duration.between(inicio, fin);

        System.out.println("Cantidad de números primos hasta " + limite + ": " + contadorPrimos);
        System.out.println("Tiempo de ejecución: " + duracion.toMillis() / 1000.0 + " segundos");
    }
}
