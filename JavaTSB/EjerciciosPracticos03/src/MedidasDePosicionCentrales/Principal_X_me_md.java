package MedidasDePosicionCentrales;



import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Principal_X_me_md {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {

            System.out.println("Digite la cantidad de numeros a operar: ");
            int cantidad = sc.nextInt();

            if (cantidad > 2) {
                String result = "";
                int i = 0;
                int[] numeros = new int[cantidad];

                for (int idx = 0; idx < cantidad; idx++) {
                    System.out.println("Digite el número " + (idx + 1));
                    numeros[idx] = sc.nextInt();
                }

                do {
                    switch (i) {
                        case 0:
                            System.out.println("");
                            System.out.println("");
                            System.out.println("Calculamos la moda aritmetica");

                            List < Integer > acumulado = calcularModa(numeros);

                            if (acumulado.isEmpty()) {
                                System.out.println("La moda no existe");
                            } else {
                                result = "";
                                for (int valor: acumulado) {
                                    if (valor > 0) {
                                        result += valor + ",";
                                    }
                                }

                                System.out.println("La moda es: " + result.substring(0, result.length() - 1));
                            }

                            break;
                        case 1:
                            System.out.println("");
                            System.out.println("");
                            System.out.println("Calculamos la media aritmetica");

                            result = calcularMedia(numeros);

                            System.out.println(result);
                            break;
                        case 2:
                            System.out.println("");
                            System.out.println("");
                            System.out.println("Calculamos la mediana aritmetica");

                            result = calcularMediana(numeros);

                            System.out.println("La mediana es: " + result);
                            break;
                        default:
                            break;
                    }
                    i++;
                } while (i < 3);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sc.close();
        }
    }

    private static List < Integer > calcularModa(int[] numeros) {

        int contadorMedia = 0;
        int veces = 0;
        int conteoMayor = 0;
        List < Integer > acumulado = new ArrayList < > ();


        //recorre el vector de 0 a 9
        for (int j = 0; j <= 9; j++) {
            //c = 0;

            //recorre el vector de numeros ingresado por teclado y compara cada numero
            for (int k = 0; k < numeros.length; k++) {

                if (j == numeros[k]) {
                    contadorMedia++;
                }
            }

            if (veces <= contadorMedia) {
                veces = contadorMedia;
                if (contadorMedia > 1 && contadorMedia < numeros.length) {
                    if (acumulado.size() == 0 || (conteoMayor > 0 && conteoMayor == contadorMedia)) {
                        conteoMayor = contadorMedia;
                        acumulado.add(j);
                    } else if (conteoMayor < contadorMedia) {
                        conteoMayor = contadorMedia;
                        acumulado.clear();
                        acumulado.add(j);
                    }
                }
            }
        }

        return acumulado;
    }

    private static String calcularMedia(int[] numeros) {
        double valor = 0;
        String result = "(";
        for (int numero: numeros) {

            //suma cada valor en forma consecutiva
            valor += (numero * 1.0);
            result += numero + " + ";
        }
        result = result.substring(0, result.length() - 2);
        result += ")/" + numeros.length + " = " + valor / numeros.length;

        return result;
    }

    private static String calcularMediana(int[] numeros) {

        // Ordenamos los numeros de menor a mayor
        Arrays.sort(numeros);

        String result;

        if (numeros.length % 2 == 0) {

            //importante notar el -2 porque como el vector arranca en 0 y no en 1
            //la posicion real es la 2 , que seria la 3 si contas desde 1
            int pos = (numeros.length - 2) / 2;
            result = "" + (((numeros[pos] * 1.0) + numeros[pos + 1]) / 2);
        } else {
            int pos = (numeros.length - 1) / 2;
            result = "" + numeros[pos];
        }

        return result;
    }
}
