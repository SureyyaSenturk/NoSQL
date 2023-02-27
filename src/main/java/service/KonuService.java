package service;

import com.google.gson.Gson;
import com.mongodb.BasicDBObject;
import com.mongodb.client.MongoCollection;
import entity.Konu;
import org.bson.Document;

public class KonuService {
    public void addKonu(MongoCollection<Document> collection){
        try{
            Konu konu=new Konu();
            konu.setKonuAd("İntegral");

            Gson gson=new Gson();
            BasicDBObject dbObject=BasicDBObject.parse(gson.toJson(konu));
            Document konuDocument=new Document();
            konuDocument.append("Kayıt2",dbObject);
            collection.insertOne(konuDocument);
            System.out.println("BAŞARILI BİR ŞEKİLDE KAYIT İŞLEMİ YAPILDI");
        }catch (Exception ex){
            System.out.println("KAYIT OLUŞTURULURKEN BİR HATA OLUŞTU LÜTFEN TEKRAR DENEYİN");
        }

    }
}
