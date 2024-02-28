package repositories;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import entities.Adresse;
public class AdresseRepository {
    
    public void insert(Adresse adresse){

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
              Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestion_adresse_client" 
                    , "root", "");
              Statement statement= conn.createStatement(); 
              String sql= String.format("INSERT INTO `adresse` ( `ville_adresse`, `quartier_adresse`, `numVilla_adresse`) "
              + " VALUES ('%s', '%s', '%s')" ,
              adresse.getVille(), adresse.getQuartier(), adresse.getNumVilla());

              int nbreLigne=statement.executeUpdate(sql);
              statement.close();
              conn.close();
        } catch (ClassNotFoundException e) {
            System.out.println("Erreur de chargement de Driver");
        }
        catch (SQLException e) {
            System.out.println("Erreur de Connexion a la BD");
        }
    }


    public List<Adresse> selectAll(){
        List<Adresse> adresses=new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestion_adresse_client" 
                     , "root", "");
            Statement statement = conn.createStatement();
           String sql="Select * from adresse";
           ResultSet rs=statement.executeQuery(sql);   
           while (rs.next()) {
    
             Adresse adresse=new Adresse();
             adresse.setId(rs.getInt("id_adresse"));
             adresse.setVille(rs.getString("ville_adresse"));
             adresse.setQuartier(rs.getString("quartier_adresse"));
             adresse.setNumVilla(rs.getString("numVilla_adresse"));
             adresses.add(adresse);
         }
         statement.close();
         rs.close();
         conn.close();      
        } catch (ClassNotFoundException e) {
            System.out.println("Erreur de chargement de Driver");
        }catch (SQLException e) {
            System.out.println("Erreur de Connexion a la BD");
        }
        return adresses;
        
    }
}
