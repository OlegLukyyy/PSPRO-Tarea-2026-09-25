
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        new Main().run(args);

    }

    public void run(String[] args) {

        if (args[0].equals("1")) {
            modo1(Double.parseDouble(args[1]));
        } else {
            modo2();
        }


    }

    public void modo1(Double cantidad) {

        Map<String, Double> empleados = readFile();
        empleados.forEach((empleado, salario) -> {
            if (salario > cantidad) {
                System.out.println(empleado + " -> " + salario);
            }
        });

    }

    public void modo2() {
        Double suma = 0.0;
        Map<String, Double> empleados = readFile();
        for (Double salario : empleados.values()) {
            suma += salario;
        }

        System.out.println(suma);
    }

    public Map<String, Double> readFile() {


        Map<String, Double> empleados = new HashMap<>();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String line;
            while ((line = br.readLine()) != null) {
                line = line.trim();
                if (!line.isEmpty()) {
                    String[] partes = line.split(":");
                    empleados.put(partes[0], Double.parseDouble(partes[1]));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return empleados;
    }


}

