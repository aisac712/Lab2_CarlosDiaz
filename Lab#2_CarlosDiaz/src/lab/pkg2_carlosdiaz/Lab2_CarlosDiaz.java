package lab.pkg2_carlosdiaz;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Scanner;

public class Lab2_CarlosDiaz {

    static Scanner leer = new Scanner(System.in);

    public static void main(String[] args) {
        ArrayList empleados = new ArrayList();
        int opcion = 0;
        while (opcion != 8) {
            System.out.println("1. Registro de Empleados");
            System.out.println("2. Despedir Empleados");
            System.out.println("3. Log In");
            System.out.println("4. Ascender Cajero");
            System.out.println("5. Listar Empleados");
            System.out.println("6. Modificar Empleado");
            System.out.println("7. RANDOM");    //cantidad de empleados van a cambiar de cargo. cuidado con los gerentes q solo son 3
            System.out.println("Ingrese la opción: ");
            opcion = leer.nextInt();
            int log = 0, e = 0, gerentes = 0;

            switch (opcion) {
                case 1: {
                    if (log == 1) {

                        System.out.print("Nombre del empleado: ");
                        String nombre = leer.next();
                        empleados.add(new Empleado(nombre));
                        System.out.print("Apellido: ");
                        String apellido = leer.next();
                        ((Empleado) empleados.get(e)).setApellido(apellido);
                        System.out.print("Color favorito (Azul, Rojo, Verde...): ");
                        String color_f = leer.next();
                        ((Empleado) empleados.get(e)).setColor(color_f);
                        System.out.print("Edad: ");
                        int edad = leer.nextInt();
                        ((Empleado) empleados.get(e)).setEdad(edad);
                        System.out.print("Género (M/F): ");
                        char genero = leer.next().charAt(0);
                        ((Empleado) empleados.get(e)).setGenero(genero);
                        System.out.print("Altura: ");
                        int altura = leer.nextInt();
                        ((Empleado) empleados.get(e)).setAltura(altura);
                        System.out.print("Peso: ");
                        int peso = leer.nextInt();
                        ((Empleado) empleados.get(e)).setPeso(peso);
                        System.out.print("Título: ");
                        String titulo = leer.next();
                        ((Empleado) empleados.get(e)).setTitulo(titulo);
                        System.out.print("Cargo\n");
                        System.out.println("1. Gerente \n" + "2.Aseador \n" + "3. Cajero \n" + "4. Seguridad \n: ");
                        String cargo = "";
                        int salario = 0;
                        int op = leer.nextInt();
                        if (op == 1 && gerentes <= 3) {       //solo pueden haber 3
                            cargo = "Gerente";
                            salario = 50000;
                            gerentes++;
                        } else if (op == 2) {
                            cargo = "Aseador";
                            salario = 30000;
                        } else if (op == 3) {
                            cargo = "Cajero";
                            salario = 40000;
                        } else if (op == 4) {
                            cargo = "Seguridad";
                            salario = 38000;
                        } else {
                            System.out.print("No ingresaste un número dentro del rango. Ahora vas a ser Aseador");
                            cargo = "Aseador";
                            salario = 38000;
                        }
                        ((Empleado) empleados.get(e)).setCargo(cargo);
                        ((Empleado) empleados.get(e)).setSalario(salario);

                        System.out.println("Empleado ingresado con éxito");
                        e++;        //controla la posición dentro del ArrayList de empleados para setear sus datos

                    } else {
                        System.out.println("Ingresá sesión");
                    }
                }
                break;
                case 2: {
                    if (log == 1) {
                        System.out.print("Ingrese la posición del empleado que desea despedir: ");
                        int p = leer.nextInt();
                        String cargo = ((Empleado) empleados.get(p)).getCargo();
                        if(cargo.contains("Gerente")){
                            empleados.remove(p);                                //lo saco adiós gudbai
                            gerentes--;                                         //decrementa el contador de gerentes pai
                            for (int i = 0; i < empleados.size(); i++) {
                                cargo = ((Empleado) empleados.get(p)).getCargo();
                                if(cargo.contains("Cajero")){                   //busco a un cajero
                                    p = i;                                      //al último cajero que encuentre
                                }
                            }
                            if(gerentes<=3){                                        //que se mantenga mi condición
                                ((Empleado) empleados.get(p)).setCargo("Gerente");  //a ese lo voy a ascender
                                gerentes++;                                         //aumento el contador para que no se pase de 3
                            } else{
                                System.out.println("No se puede ascender a un cajero porque ya existen 3 gerentes.");
                            }
                        } else {
                            empleados.remove(p);
                        }
                        System.out.print("Felices vacaciones");
                        
                    } else {
                        System.out.println("Ingresá sesión");
                    }
                }
                break;
                case 3: {
                    System.out.print("Ingrese nombre de usuario: ");
                    String nom = leer.next();
                    System.out.print("Contraseña: ");
                    int c = leer.nextInt();
                    if (nom.contains("leobanegas") && c == 99) {
                        log = 1;
                    } else {
                        System.out.println("Incorrecto");
                    }
                }
                break;
                case 4: {
                    if (log == 1) {
                        if(gerentes<=3){                                        //que se mantenga la condición
                            System.out.print("Posición del cajero a ascender: ");
                            int p = leer.nextInt();
                            
                            String cargo = ((Empleado) empleados.get(p)).getCargo();    //cargo de ese bro
                            if(cargo.contains("Cajero")){
                                ((Empleado) empleados.get(p)).setCargo("Gerente");  //a ese lo voy a ascender
                                gerentes++;                                         //aumento el contador para que no se pase de 3
                                String n = ((Empleado) empleados.get(p)).getNombre();
                                System.out.println(n+ " fue ascendido a Gerente exitosamente.");    //estética nada más
                            } else {
                                System.out.println("Ese empleado no es un cajero. ");
                            }
                            
                        } else{
                            System.out.println("No podés ascender cajeros, los 3 cupos de gerente ya están llenos");
                        }
                    } else {
                        System.out.println("Ingresá sesión");
                    }
                }
                break;
                case 5: {
                    if (log == 1) {

                    } else {
                        System.out.println("Ingresá sesión");
                    }
                }
                break;
                case 6: {
                    if (log == 1) {

                    } else {
                        System.out.println("Ingresá sesión");
                    }
                }
                break;
                case 7: {
                    if (log == 1) {

                    } else {
                        System.out.println("Ingresá sesión");
                    }
                }
                break;
                default:
                    System.out.println("Opción ni válida");
            }
        }

    }

}
