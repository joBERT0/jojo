import java.util.List;
import java.util.Scanner;
import entities.Client;
import services.AdresseService;
import services.ClientService;
import entities.Adresse;
public class Views {
    public static void main(String[] args) throws Exception {
        int choix;
        Scanner sc=new Scanner(System.in);
        ClientService clientService=new ClientService();
        AdresseService adresseService=new AdresseService();
        do {
            System.out.println("1-Ajouter un Client");
            System.out.println("2-Lister les Clients"); 
            System.out.println("3-Ajouter une adresse et lui associe un client"); 
            System.out.println("4-Lister les adresse en affichant le nom du client");
            System.out.println("5-Quitter"); 
             choix=sc.nextInt();
             sc.nextLine();
            switch (choix) {
                case 1:
                    System.out.println("Entrer l'id");
                    int id =sc.nextInt(); 
                    sc.nextLine();
                    System.out.println("Entrer le nom complet");
                    String nomComplet=sc.nextLine();
                    System.out.println("le numero de téléphone"); 
                    String telephone=sc.nextLine();
                    sc.nextLine();
                    System.out.println("Entrer l'Email");
                    String email =sc.nextLine(); 
                    System.out.println("Entrer le numéro d'une Adresse");
                    String adresse=sc.nextLine();
                    Client ad=new Client();
                    ad.setId(id);
                    ad.setNomComplet(nomComplet);
                    ad.setTelephone(telephone);
                    ad.setTelephone(email);
                    ad.setAdresse(null);
                    clientService.ajouterClient(ad);
                    break;
                case 2:
                     List<Client> clients= clientService.listerClient();
                     for (Client cl: clients) {
                          System.out.println("Adresse  :"+ cl.getAdresse().getVille()+" "+cl.getAdresse().getNumVilla());
                          System.out.println("Numero :"+ cl.getNomComplet());
                          System.out.println("Solde :"+ cl.getTelephone());
                          System.out.println("Type :"+ cl.getEmail());
                          System.out.println("====================================================================");
                     }
                break;
                case 3:
                System.out.println("Entrer une ville");
                String ville=sc.nextLine(); 
                System.out.println("Entrer un quartier");
                String quartier=sc.nextLine();  
                System.out.println("numero de villa");
                String numVilla=sc.nextLine();   

                Adresse add=new Adresse();
                 add.setVille(ville);
                 add.setQuartier(quartier);
                 add.setNumVilla(numVilla);
                adresseService.insertAdresse(add);
                default:
                    break;
            }
        } while (choix!=5);
    }
}
