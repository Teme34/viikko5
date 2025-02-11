package main;

import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main( String[] args ) {
       
        Scanner sc = new Scanner(System.in);

        System.out.println("Anna tehtaalle nimi: ");
        String name = sc.nextLine();

        Factory newFactory = new Factory(name);
        
        boolean exit = false;
        while (!exit) {
            System.out.println("1) Lisää kone");
            System.out.println("2) Listaa kaikki koneet");
            System.out.println("0) Lopeta ohjelma");

            if(sc.hasNext()) {
                int i = 0;
                String stringInput = sc.nextLine();
                i = Integer.parseInt(stringInput);
                switch(i) {
                    case 1:
                        System.out.println("Anna koneen tyyppi: ");
                            String type = sc.nextLine();
                        System.out.println("Anna koneen malli: ");
                            String model = sc.nextLine();  
                        System.out.println("Anna työntekijän nimi: ");
                            String operatorName = sc.nextLine();
                        System.out.println("Anna työntekijän ammattinimike: ");
                            String role = sc.nextLine();

                        Worker newWorker = new Worker(operatorName, role);

                        Machine newMachine = new Machine(type, model, newWorker);

                        newFactory.addMachine(newMachine);
                        System.out.println("Kone lisätty!");
                        break;
                    case 2:
                        name = newFactory.getName();
                        System.out.println("Tehtaasta " + name + " löytyy seuraavat koneet:");
                        ArrayList<Machine> machines = newFactory.getMachines();
                        for(Machine machine : machines) {
                            String string = machine.getMachineDetails();
                            System.out.println("Koneen tiedot: " + string);
                        }
                        break;
                    case 0:
                        System.out.println("Kiitos ohjelman käytöstä.");
                        exit = true;
                        break;
                    default: 
                        System.out.println("Syöte oli väärä");
                        break;             
                }
            }
        }
        sc.close();
    }
}
