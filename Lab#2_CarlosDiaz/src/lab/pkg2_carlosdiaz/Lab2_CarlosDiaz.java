package lab.pkg2_carlosdiaz;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

public class Lab2_CarlosDiaz {

    static Scanner leer = new Scanner(System.in);
    static Random R = new Random();

    public static void main(String[] args) {
        ArrayList empleados = new ArrayList();
        int opcion = 0;
        int log = 0, e = 0, gerentes = 0;
        while (opcion != 8) {
            System.out.println("1. Registro de Empleados");
            System.out.println("2. Despedir Empleados");
            System.out.println("3. Log In");
            System.out.println("4. Ascender Cajero");
            System.out.println("5. Listar Empleados");
            System.out.println("6. Modificar Empleado");
            System.out.println("7. RANDOM");    //cantidad de empleados van a cambiar de cargo. cuidado con los gerentes q solo son 3
            System.out.println(empleados.size());
            System.out.println("Ingrese la opción: ");
            opcion = leer.nextInt();
            

            switch (opcion) {
                case 1: {
                    if (log==1) {

                        System.out.print("Nombre del empleado: ");
                        String nombre = leer.next();
                        empleados.add(new Empleado(nombre));
                        System.out.print("Apellido: ");
                        String apellido = leer.next();
                        ((Empleado) empleados.get(e)).setApellido(apellido);
                        /*System.out.print("Color favorito (Azul, Rojo, Verde...): ");
                        String color_f = leer.next();
                        ((Empleado) empleados.get(e)).setColor(color_f);
                        System.out.print("Edad: ");
                        int edad = leer.nextInt();
                        ((Empleado) empleados.get(e)).setEdad(edad);
                        System.out.print("Género (M/F): ");
                        char genero = leer.next().charAt(0);
                        ((Empleado) empleados.get(e)).setGenero(genero);
                        System.out.print("Altura: ");
                        float altura = leer.nextFloat();
                        ((Empleado) empleados.get(e)).setAltura(altura);
                        System.out.print("Peso: ");
                        float peso = leer.nextFloat();
                        ((Empleado) empleados.get(e)).setPeso(peso);
                        System.out.print("Título: ");
                        String titulo = leer.next();
                        ((Empleado) empleados.get(e)).setTitulo(titulo);*/
                        System.out.print("Cargo\n");
                        System.out.println("1. Gerente \n" + "2.Aseador \n" + "3. Cajero \n" + "4. Seguridad");
                        String cargo = "";
                        int salario = 0;
                        int op = leer.nextInt();
                        if ((op==1) && (gerentes<=3)) {       //solo pueden haber 3
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
                            System.out.println("Gerente despedido");
                            for (int i = 0; i < empleados.size(); i++) {
                                cargo = ((Empleado) empleados.get(p)).getCargo();
                                if(cargo.contains("Cajero")){                   //busco a un cajero
                                    p = i;                                      //al último cajero que encuentre
                                }
                            }
                            if(gerentes<=1){                                        //que se mantenga mi condición
                                ((Empleado) empleados.get(p)).setCargo("Gerente");  //a ese lo voy a ascender
                                gerentes++;                                         //aumento el contador para que no se pase de 3
                                System.out.println("Se ascendió a un cajero");
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
                        System.out.println("");
                    } else {
                        System.out.println("Ingresá sesión");
                    }
                }
                break;
                case 5: {
                    if (log == 1) {
                        String salida = "", g="", a="", c="", s="";
                        
                        
                        for (int i = 0; i < empleados.size(); i++) {
                            String cargo = ((Empleado) empleados.get(i)).getCargo();
                            if(cargo.contains("Gerente")){                   //agrupo
                                g += empleados.indexOf(empleados.get(i))+"- "+((Empleado) empleados.get(i)).getNombre()+"\n";
                            } else if(cargo.contains("Cajero")){
                                c += empleados.indexOf(empleados.get(i))+"- "+((Empleado) empleados.get(i)).getNombre()+"\n";
                            } else if(cargo.contains("Aseador")){
                                a += empleados.indexOf(empleados.get(i))+"- "+((Empleado) empleados.get(i)).getNombre()+"\n";;
                            } else if(cargo.contains("Seguridad")){
                                s += empleados.indexOf(empleados.get(i))+"- "+((Empleado) empleados.get(i)).getNombre()+"\n";
                            }
                        }
                        System.out.println("Gerentes: "); System.out.println(g);
                        System.out.println("Cajeros: "); System.out.println(c);
                        System.out.println("Aseadores: "); System.out.println(a);
                        System.out.println("Guardias: "); System.out.println(s);
                        
                    } else {
                        System.out.println("Ingresá sesión");
                    }
                }
                break;
                case 6: {
                    if (log == 1) {
                        System.out.print("Posición del empleado a midificar: ");
                        int p = leer.nextInt();
                        System.out.print("1. Apellido \n"+ "2. Color favorito \n" + "3. Edad \n"+ "4. Género \n"
                        + "5. Altura \n"+ "6. Peso \n"+ "7. Título \n"+ "¿Qué vas a modificar? \n");
                        int m = leer.nextInt();
                        if(m==1){
                            System.out.print("Nuevo nombre: ");
                            String apellido = leer.next();
                            ((Empleado) empleados.get(p)).setApellido(apellido);
                        } else if(m==2){
                            System.out.print("Nuevo color favorito (Azul, Rojo, Verde...): ");
                            String color_f = leer.next();
                            ((Empleado) empleados.get(p)).setColor(color_f);
                        } else if(m==3){
                            System.out.print("Nueva edad (feliz cumpleaños pai): ");
                            int edad = leer.nextInt();
                            ((Empleado) empleados.get(p)).setEdad(edad);
                        } else if(m==4){
                            System.out.print("Nuevo género (M/F): ");
                            char genero = leer.next().charAt(0);
                            ((Empleado) empleados.get(p)).setGenero(genero);
                        } else if(m==5){
                            System.out.print("Nueva altura: ");
                            float altura = leer.nextFloat();
                            ((Empleado) empleados.get(p)).setAltura(altura);
                        } else if(m==6){
                            System.out.print("Nuevo peso: ");
                            float peso = leer.nextFloat();
                            ((Empleado) empleados.get(p)).setPeso(peso);
                        } else if(m==7){
                            System.out.print("Nuevo título: ");
                            String titulo = leer.next();
                            ((Empleado) empleados.get(p)).setTitulo(titulo);
                        } else{
                            System.out.println("No hay nada que añadir");
                        }
                        System.out.println("Modificación exitosa");
                    } else {
                        System.out.println("Ingresá sesión");
                    }
                }
                break;
                case 7: {
                    if (log == 1) {
                        System.out.println("Número de empleados a modificar cargo aleatoriamente: ");
                        int a = leer.nextInt();
                        while(a<=0 || a>empleados.size()){
                            System.out.println("Número positivo y menor a la cantidad: ");
                            a = leer.nextInt();
                        }
                        for (int i = 0; i < a; i++) {
                            int aa = R.nextInt(100)-1;
                            while(aa>=empleados.size() || aa<0){                       //genero posición aleatoriamente, menor al size
                                aa = R.nextInt(100)-1;
                            }
                            //System.out.println(aa+" ");
                            int bb = 1+R.nextInt(4);                            //de 1 a 4
                            //System.out.print(bb+" ");
                            if (bb==1 && gerentes<=3){                          //cuidar los cupos de los gerentes
                                ((Empleado) empleados.get(aa)).setCargo("Gerente");
                            } else if(bb==2){
                                ((Empleado) empleados.get(aa)).setCargo("Aseador");
                            } else if(bb==3){
                                ((Empleado) empleados.get(aa)).setCargo("Seguridad");
                            } else if(bb==4){
                                ((Empleado) empleados.get(aa)).setCargo("Cajero");
                            }
                            
                        }
                    } else {
                        System.out.println("Ingresá sesión");
                    }
                }
                break;
            }
        }

    }

}
