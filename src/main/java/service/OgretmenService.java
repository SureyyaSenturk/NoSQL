package service;

import com.google.gson.Gson;
import com.mongodb.BasicDBObject;
import com.mongodb.client.MongoCollection;
import entity.Ogretmen;
import org.bson.Document;

public class OgretmenService {
    public void addOgretmen(MongoCollection<Document> collection){
        try {
            Ogretmen ogretmen=new Ogretmen();
            ogretmen.setOgretmenAd("Cem");
            ogretmen.setYas(35);
            ogretmen.setBrans("Bilişim Teknolojileri");
            ogretmen.isIdareciMi();

            Gson gson=new Gson();
            BasicDBObject dbObject=BasicDBObject.parse(gson.toJson(ogretmen));
            Document ogretmenDocument=new Document();
            ogretmenDocument.append("Kayıt4",dbObject);
            collection.insertOne(ogretmenDocument);
            System.out.println("BAŞARILI BİR ŞEKİLDE KAYIT İŞLEMİ YAPILDI");
        }catch(Exception exception){
            System.out.println("KAYIT OLUŞTURULURKEN BİR HATA OLUŞTU LÜTFEN TEKRAR DENEYİN");
        }
    }
}
