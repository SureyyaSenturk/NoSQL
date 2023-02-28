package service;

import com.google.gson.Gson;
import com.mongodb.BasicDBObject;
import com.mongodb.MongoException;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import entity.Ders;
import org.bson.Document;

import static com.mongodb.client.model.Filters.eq;

public class DersService {
    public void addDers(MongoCollection<Document> collection) {
        try {
            Ders ders = new Ders();
            ders.setDersAdi("Matematik");
            ders.setDersKodu("123KS2W");
            ders.setDersAdi("Türkçe");
            ders.setDersKodu("23ERF43");
            Gson gson = new Gson();
            BasicDBObject dbObject = BasicDBObject.parse(gson.toJson(ders));
            Document dersDocument = new Document();
            dersDocument.append("Kayıt3", dbObject);
            collection.insertOne(dersDocument);
            System.out.println("BAŞARILI BİR ŞEKİLDE KAYIT İŞLEMİ YAPILDI");

        } catch (Exception exception) {
            System.out.println("KAYIT OLUŞTURULURKEN BİR HATA OLUŞTU LÜTFEN TEKRAR DENEYİN");
        }
    }

    public void getDers(MongoCollection<Document> collection) {
        try {
            FindIterable<Document> iterable = collection.find(eq("DersAdi", "Matematik"));
            MongoCursor<Document> cursor = iterable.iterator();
            while (cursor.hasNext()){
                System.out.println(cursor.next().toJson());
            }
        }catch (MongoException exception){
            System.err.println("Hata");
        }

    }
}
