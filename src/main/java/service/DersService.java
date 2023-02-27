package service;

import com.google.gson.Gson;
import com.mongodb.BasicDBObject;
import com.mongodb.client.MongoCollection;
import entity.Ders;
import org.bson.Document;

public class DersService {
    public void addDers(MongoCollection<Document> collection){

        try {
            Ders ders=new Ders();
            ders.setDersAdi("Matematik");
            ders.setDersKodu("K23RED");

            Gson gson=new Gson();
            BasicDBObject dbObject=BasicDBObject.parse(gson.toJson(ders));
            Document dersDocument=new Document();
            dersDocument.append("Kayıt1",dbObject);
            collection.insertOne(dersDocument);
            System.out.println("BAŞARILI BİR ŞEKİLDE KAYIT İŞLEMİ YAPILDI");

        }catch(Exception exception){
            System.out.println("KAYIT OLUŞTURULURKEN BİR HATA OLUŞTU LÜTFEN TEKRAR DENEYİN");

        }
    }
}
