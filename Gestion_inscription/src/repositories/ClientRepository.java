package repositories;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Statement;
import entities.Client;
import entities.Adresse;
public class ClientRepository {
    
    public List<Client> selectAll(){
          List<Client> clients=new ArrayList<>();
          try {
             Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestion_adresse_client" 
                   , "root", "");
            Statement statement = conn.createStatement();
             String sql="SELECT * FROM `client` WHERE adressse_client=;";
             ResultSet rs=statement.executeQuery(sql);
             while (rs.next()) {
                

                 Adresse adresse=new Adresse();
                 adresse.setId(rs.getInt("id_adresse"));
                 adresse.setVille(rs.getString("ville_adresse"));
                 adresse.setQuartier(rs.getString("quartier_adresse"));
                 adresse.setNumVilla(rs.getString("nomVilla_adresse"));

            statement.close();
            rs.close();
            conn.close();
           } 
          }
          catch (ClassNotFoundException e) {
            System.out.println("Erreur de chargement de Driver");
          }
          catch (SQLException e){
            System.out.println("Erreur de Connexion a la BD");
          }
         return clients;
    }
   
}

