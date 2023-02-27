import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import service.DersService;
import service.KonuService;
import service.OgrenciService;
import service.OgretmenService;

public class MongoClientConnection {

    public static final String uri="mongodb://localhost:27017";
    public static void main(String[] args) {
        try(MongoClient mongoClient= MongoClients.create(uri)){
            MongoDatabase database=mongoClient.getDatabase("mongoÖrneği");
            MongoCollection<Document> collection=database.getCollection("ders");
            DersService dersService=new DersService();
            dersService.addDers(collection);
            KonuService konuService=new KonuService();
            konuService.addKonu(collection);
            OgrenciService ogrenciService=new OgrenciService();
            ogrenciService.addOgrenci(collection);
            OgretmenService ogretmenService=new OgretmenService();
            ogretmenService.addOgretmen(collection);


        }
    }
}
