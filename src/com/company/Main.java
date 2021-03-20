package com.company;
import java.util.Scanner;
import java.util.Date;
public class Main {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        //Informacion de usuario
        String Usuario;
        String contraseña;
        double creditocl1;
        double creditocl2;

        //Montos y credito maximo de los clientes
        double maximoprestar;
        double montoinicialcliente1 = 4000;
        double montoinicialcliente2 = 2500;
        double montoanteriorcliente1 = 4000;
        double montoanteriorcliente2 = 2500;
        double montofinalcliente1 = 0;
        double montofinalcliente2 = 0;
        //============================

        //Cantidad de transacciones
        double cantransacciones = 0;
        double cantdetransacciones = 0;
        double comision = 0;
        double comisionacumulada = 0;

        //Acciones
        String opcion;
        String enter;

        /*
        Cliente1:
        Usuario = Mario Gonzales
        Contraseña = MaGonz12345
        monto inicial de esta cuenta = $4000


        Cliente2:
        Usuario: Eduardo Espinosa
        Contraseña: EdEs54321
        monto inicial de esta cuenta = 2500$
         */

        System.out.println("Bienvenido al Banco XYZ\n");
        System.out.println("Inicio de sesión");
        System.out.println("Nombre de usuario: ");
        Usuario = entrada.nextLine();

        System.out.println("Contraseña: ");
        contraseña = entrada.nextLine();

        if (Usuario.equals("Mario Gonzales") && contraseña.equals("MaGonz12345") && montoinicialcliente1 > 1500) {


            System.out.println("Bienvenido al servicio en línea del banco XYZ");
            Date date = new Date();
            System.out.println(date.toString());
            System.out.println("Por motivos de seguridad debe cambiar su contraseña");
            System.out.println("Introduzca nueva contraseña: ");
            contraseña = entrada.nextLine();
            System.out.println("Su nueva contraseña ha sido guardada con éxito pulse enter para ir al menú");
            enter = entrada.nextLine();

            do {

                System.out.println(new String(new char[50]).replace("\0", "\r\n"));
                System.out.println("Menu Principal");

                System.out.println("1: Ver estado de cuenta.");
                System.out.println("2: Solicitar un crédito.");
                System.out.println("3: Cambiar contraseña. ");
                System.out.println("4: Salir.");
                Scanner scan = new Scanner(System.in);
                System.out.println("Seleccione la opción que desea: ");
                opcion = scan.nextLine();

                switch (opcion) {
                    case "1":
                        System.out.println(new String(new char[50]).replace("\0", "\r\n"));
                        System.out.println("Estado de cuenta");
                        System.out.println("Monto inicial: " + montoinicialcliente1);
                        System.out.println("Monto anterior: " + montoanteriorcliente1);
                        // En caso de haber realizado una transacción
                        if (montofinalcliente1 > 0) {
                            System.out.println("Monto actual: " + montofinalcliente1);
                            System.out.println("Usted realizó una transacción de " + cantransacciones + "$ recientemente");
                            System.out.println("Cargo por intereses acumulados: " + comisionacumulada);
                            montoanteriorcliente1 = montofinalcliente1;
                            comision = comisionacumulada;
                            enter = entrada.nextLine();
                        } else {
                            System.out.println("Usted no ha realizado ninguna transacción recientemente");
                            System.out.println("Pulse enter para volver al menu");
                            enter = entrada.nextLine();
                        }
                        break;
                    case "2":
                        System.out.println(new String(new char[50]).replace("\0", "\r\n"));
                        maximoprestar = montoanteriorcliente2 * 90 / 100;
                        System.out.println("Prestamos");
                        System.out.println("Introduzca cantidad de crédito: ");
                        creditocl1 = scan.nextDouble();
                        if (creditocl1 < maximoprestar) {
                            Transacciones transacciones = new Transacciones(creditocl1);

                            System.out.println("Su crédito solicitado de  " + transacciones.getPrestamo() + "$ ha sido agregado a su cuenta");
                            System.out.println("El banco tomará " + transacciones.getComision() + "$ como interes el cual es un 30% del crédito solicitado ");
                            System.out.println("Consulte su estado de cuenta para ver monto disponible");
                            System.out.println("Para volver al menú presione enter");
                            enter = entrada.nextLine();

                            //Guardar transacciones
                            montofinalcliente1 = montoanteriorcliente1 + transacciones.getPrestamo();
                            cantransacciones = transacciones.getPrestamo();
                            comisionacumulada = comision + transacciones.getComision();
                            //Disminuir cantidad que puede prestar el banco
                            montoanteriorcliente2 = montoanteriorcliente2 - transacciones.getPrestamo();
                            //
                        } else {
                            System.out.println("El crédito solicitado es muy alto");
                            System.out.println("pulse enter para volver al menú");
                            enter = entrada.nextLine();
                        }


                        break;
                    case "3":
                        System.out.println(new String(new char[50]).replace("\0", "\r\n"));
                        String contraseñaactual;
                        System.out.println("Cambio de contraseña");
                        System.out.println("Contraseña actual: ");
                        contraseñaactual = entrada.nextLine();
                        if (contraseñaactual.equals(contraseña)) {
                            System.out.println("nueva contraseña: ");
                            contraseña = entrada.nextLine();
                            System.out.println("Su nueva contraseña ha sido guardada pulse enter para volver al menú");
                            enter = entrada.nextLine();
                        } else {
                            System.out.println("Contreseña incorrecta pulse enter para volver al menú e intentelo otra vez");
                            enter = entrada.nextLine();
                        }
                        break;
                    case "4":
                        System.out.println("Sesión cerrada  : " + date.toString());
                        System.exit(0);

                        break;
                }
            } while (!opcion.equals("5"));
        } else if (Usuario.equals("Eduardo Espinosa") && contraseña.equals("EdEs54321") && montoinicialcliente2 > 1500) {


            System.out.println("Bienvenido al servicio en línea del banco XYZ");
            Date date = new Date();
            System.out.println(date.toString());
            System.out.println("Por motivos de seguridad debe cambiar su contraseña");
            System.out.println("Introduzca nueva contraseña: ");
            contraseña = entrada.nextLine();
            System.out.println("Su nueva contraseña ha sido guardada con éxito pulse enter para ir al menú");
            enter = entrada.nextLine();

            do {

                System.out.println(new String(new char[50]).replace("\0", "\r\n"));
                System.out.println("Menu Principal");

                System.out.println("1: Ver estado de cuenta.");
                System.out.println("2: Solicitar un crédito.");
                System.out.println("3: Cambiar contraseña. ");
                System.out.println("4: Salir.");
                Scanner scan = new Scanner(System.in);
                System.out.println("Seleccione la opción que desea: ");
                opcion = scan.nextLine();

                switch (opcion) {
                    case "1":
                        System.out.println(new String(new char[50]).replace("\0", "\r\n"));
                        System.out.println("Estado de cuenta");
                        System.out.println("Monto inicial: " + montoinicialcliente2);
                        System.out.println("Monto anterior: " + montoanteriorcliente2);
                        // En caso de haber realizado una transacción
                        if (montofinalcliente2 > 0) {
                            System.out.println("Monto actual: " + montofinalcliente2);
                            System.out.println("Usted realizó una transacción de " + cantransacciones + "$ recientemente");
                            System.out.println("Cargo por intereses acumulados: " + comisionacumulada);
                            montoanteriorcliente2 = montofinalcliente2;
                            comision = comisionacumulada;
                            enter = entrada.nextLine();
                        } else {
                            System.out.println("Usted no ha realizado ninguna transacción recientemente");
                            System.out.println("Pulse enter para volver al menu");
                            enter = entrada.nextLine();
                        }
                        break;
                    case "2":
                        System.out.println(new String(new char[50]).replace("\0", "\r\n"));
                        maximoprestar = montoanteriorcliente1 * 90 / 100;
                        System.out.println("Prestamos");
                        System.out.println("Introduzca cantidad de crédito: ");
                        creditocl2 = scan.nextDouble();
                        if (creditocl2 < maximoprestar) {
                            Transacciones transacciones = new Transacciones(creditocl2);

                            System.out.println("Su crédito solicitado de  " + transacciones.getPrestamo() + "$ ha sido agregado a su cuenta");
                            System.out.println("El banco tomará " + transacciones.getComision() + "$ como interes el cual es un 30% del crédito solicitado ");
                            System.out.println("Consulte su estado de cuenta para ver monto disponible");
                            System.out.println("Para volver al menú presione enter");
                            enter = entrada.nextLine();

                            //Guardar transacciones
                            montofinalcliente2 = montoanteriorcliente2 + transacciones.getPrestamo();
                            cantransacciones = transacciones.getPrestamo();
                            comisionacumulada = comision + transacciones.getComision();
                            //Disminuir cantidad que puede prestar el banco
                            montoanteriorcliente1 = montoanteriorcliente1 - transacciones.getPrestamo();
                            //
                        } else {
                            System.out.println("El crédito solicitado es muy alto");
                            System.out.println("pulse enter para volver al menú");
                            enter = entrada.nextLine();
                        }


                        break;
                    case "3":
                        System.out.println(new String(new char[50]).replace("\0", "\r\n"));
                        String contraseñaactual;
                        System.out.println("Cambio de contraseña");
                        System.out.println("Contraseña actual: ");
                        contraseñaactual = entrada.nextLine();
                        if (contraseñaactual.equals(contraseña)) {
                            System.out.println("nueva contraseña: ");
                            contraseña = entrada.nextLine();
                            System.out.println("Su nueva contraseña ha sido guardada pulse enter para volver al menú");
                            enter = entrada.nextLine();
                        } else {
                            System.out.println("Contreseña incorrecta pulse enter para volver al menú e intentelo otra vez");
                            enter = entrada.nextLine();
                        }
                        break;
                    case "4":
                        System.out.println("Sesión cerrada  : " + date.toString());
                        System.exit(0);

                        break;


                }
            }while(!opcion.equals("5"));
        }else{
            System.out.println("Usuario o contraseña incorrectos.");
        }
            }
}
