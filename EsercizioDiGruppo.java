import java.util.ArrayList;
import java.util.Scanner;

public class EsercizioDiGruppo {

    static ArrayList<String> id = new ArrayList<>();
    static ArrayList<String> password = new ArrayList<>();
    static ArrayList<String> eta = new ArrayList<>();
    static ArrayList<String> nome = new ArrayList<>();
    static ArrayList<String> email = new ArrayList<>();
    static int somma = 0;
    static int diff = 0;
    static int molt = 0;
    static double resto = 0;
    static boolean loggedIn = false;
    static int loggedInIndex = -1;
    static int idCounter = 1; // Variabile per generare ID univoci

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        menu(scanner);
        scanner.close();
    }

    public static void menu(Scanner scanner) {

        int scelta = -1;

        do {
            // Menu principale
            System.out.println("\n--- Menu Gestione Utenti ---");
            System.out.println("1. Registrati");
            System.out.println("2. Effettua il login");
            if (loggedIn) {
                System.out.println("3. Sotto Menu");
            }
            System.out.println("0. Esci");
            System.out.print("Scegli un'opzione: ");
            
            if (scanner.hasNextInt()) {
                scelta = scanner.nextInt();
                scanner.nextLine(); // Consuma la newline rimasta nel buffer

                switch (scelta) {
                    case 1:
                        registrazione(scanner);
                        break;
                    case 2:
                        login(scanner);
                        break;
                    case 3:
                        if (loggedIn) {
                            menu2(scanner);
                        } else {
                            System.out.println("Devi effettuare il login prima di accedere al sotto menu.");
                        }
                        break;
                    case 0:
                        System.out.println("Uscita dal programma.");
                        break;
                    default:
                        System.out.println("Opzione non valida! Riprova.");
                }
            } else {
                System.out.println("Input non valido. Per favore inserisci un numero.");
                scanner.next(); // Consuma l'input non valido
            }
        } while (scelta != 0);

    }

    public static void login(Scanner scanner) {

        // Chiediamo all'utente di inserire il nome
        System.out.print("Inserisci il tuo nome: ");
        String idInserito = scanner.nextLine();

        // Chiediamo di inserire la password
        System.out.print("Inserisci la tua password: ");
        String passwordInserita = scanner.nextLine();

        // Controlliamo se il nome e la password sono presenti negli ArrayList
        if (id.contains(idInserito) && password.contains(passwordInserita)) {

            int indice = id.indexOf(idInserito);

            if (password.get(indice).equals(passwordInserita)) {
                loggedIn = true;
                loggedInIndex = indice;
                System.out.println("Login effettuato con successo!");

            } else {
                System.out.println("Nome utente o password errati. Riprova.");
            }
        } else {
            System.out.println("Nome utente o password errati. Riprova.");
        }

    }

    public static void registrazione(Scanner scanner) {

        System.out.println("Inserisci il tuo nome:");
        String nomeute = scanner.nextLine();

        System.out.println("Crea una password:");
        String pass = scanner.nextLine();

        System.out.println("Dammi la tua età:");
        String et = scanner.nextLine();

        System.out.println("Dammi la tua mail:");
        String email1 = scanner.nextLine();

        // Verifica se l'email è già registrata
        if (email.contains(email1)) {
            System.out.println("Errore: Questa email è già registrata! Riprova con un'altra.");
        } else {
            // Assegnazione codice univoco e aggiunta ai rispettivi ArrayList
            id.add(String.valueOf(idCounter));
            nome.add(nomeute);
            password.add(pass);
            eta.add(et);
            email.add(email1);

            System.out.println("Registrazione completata con successo!");
            System.out.println("Codice univoco: " + idCounter);
            System.out.println("Nome: " + nomeute);
            System.out.println("Età: " + et);
            System.out.println("Email: " + email1);

            // Incremento ID per il prossimo utente
            idCounter++;
        }

    }

    public static void menu2(Scanner scanner) {
        int scelta = -1;

        do {
            // Sotto menu
            System.out.println("\n--- Sotto Menu ---");
            System.out.println("1. Calcolatrice");
            System.out.println("2. Visualizza");
            System.out.println("3. Modifica Profilo");
            System.out.println("0. Torna al menu principale");
            System.out.print("Scegli un'opzione: ");
            
            if (scanner.hasNextInt()) {
                scelta = scanner.nextInt();
                scanner.nextLine(); // Consuma la newline rimasta nel buffer

                switch (scelta) {
                    case 1:
                        calcolatrice(scanner);
                        break;
                    case 2:
                        visualizza(scanner);
                        break;
                    case 3:
                        modificaProfilo(loggedInIndex, scanner);
                        break;
                    case 0:
                        System.out.println("Torna al menu principale.");
                        break;
                    default:
                        System.out.println("Opzione non valida! Riprova.");
                }
            } else {
                System.out.println("Input non valido. Per favore inserisci un numero.");
                scanner.next(); // Consuma l'input non valido
            }
        } while (scelta != 0);
    }

    public static void calcolatrice (Scanner in){

        System.out.println("Inserisci il primo operando.");
        if (in.hasNextInt()) {
            int x = in.nextInt();

            System.out.println("Inserisci il secondo operando");
            if (in.hasNextInt()) {
                int y = in.nextInt();

                System.out.println("Scegli un'operazione tra le seguenti digitando un numero da 1 a 4:\n 1)Addizione\n 2)Sottrazione\n 3)Moltiplicazione\n 4)Divisione");
                if (in.hasNextInt()) {
                    int scelta = in.nextInt();
                    switch(scelta){
                        case 1:
                            somma = x + y;
                            break;
                        case 2:
                            if (x > y) {
                                diff = x - y;
                            } else {
                                System.out.println("Errore");
                            }
                            break;
                        case 3:
                            molt = x * y;
                            break;
                        case 4:
                            if (x > y) {
                                resto = x / y;
                            } else {
                                System.out.println("Errore");
                            }
                            break;
                        default:
                            System.out.println("Operazione non valida.");
                    }
                } else {
                    System.out.println("Input non valido per l'operazione.");
                    in.next(); // Consuma l'input non valido
                }
            } else {
                System.out.println("Input non valido per il secondo operando.");
                in.next(); // Consuma l'input non valido
            }
        } else {
            System.out.println("Input non valido per il primo operando.");
            in.next(); // Consuma l'input non valido
        }
    }

    public static void visualizza(Scanner in){

        System.out.println("Vuoi rivedere tutti i risultati? si/no");
        String decisione = in.nextLine();
        if (decisione.toLowerCase().trim().equals("si")){
            System.out.println("Somma: " + somma + "\nDifferenza: " + diff + "\nMoltiplicazione: " + molt + "\nDivisione: " + resto);
        }
    }

    public static void modificaProfilo(int index, Scanner scanner) {
        System.out.println("Modifica profilo:");
        System.out.println("1. Cambia Nome");
        System.out.println("2. Cambia Età");
        System.out.println("3. Cambia Email");
        System.out.print("Scelta: ");
        
        if (scanner.hasNextInt()) {
            int scelta = scanner.nextInt();
            scanner.nextLine(); // Pulisce il buffer
            
            switch (scelta) {
                case 1:
                    System.out.print("Inserisci nuovo nome: ");
                    nome.set(index, scanner.nextLine());
                    break;
                case 2:
                    System.out.print("Inserisci nuova età: ");
                    eta.set(index, scanner.nextLine());
                    break;
                case 3:
                    System.out.print("Inserisci nuova email: ");
                    email.set(index, scanner.nextLine());
                    break;
                default:
                    System.out.println("Scelta non valida.");
            }
            
            System.out.println("Profilo aggiornato con successo!");
            System.out.println("Nome: " + nome.get(index));
            System.out.println("Età: " + eta.get(index));
            System.out.println("Email: " + email.get(index));
        } else {
            System.out.println("Input non valido. Per favore inserisci un numero.");
            scanner.next(); // Consuma l'input non valido
        }
    }
}
