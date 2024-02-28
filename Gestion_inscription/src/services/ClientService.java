package services;

import repositories.ClientRepository;

import java.util.List;

import entities.Client;

public class ClientService {

    ClientRepository clientRepository=new ClientRepository();

    public void ajouterClient(Client client){
        clientRepository.insert(client);
    }
     public List<Client> listerClient(){
        return clientRepository.selectAll();
    }
}
