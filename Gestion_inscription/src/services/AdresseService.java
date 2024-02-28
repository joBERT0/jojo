package services;

import repositories.AdresseRepository;

import java.util.List;

import entities.Adresse;

public class AdresseService {
    
    AdresseRepository adresseRepository=new AdresseRepository();

    public void insertAdresse(Adresse adresse){
        adresseRepository.insert(adresse);
    
    }
     
   public  List<Adresse>listerAdresse(){
    
        return AdresseRepository.selectAll();
    }
}
