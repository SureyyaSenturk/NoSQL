package service;

import com.google.gson.Gson;
import com.mongodb.BasicDBObject;
import com.mongodb.client.MongoCollection;
import entity.Ogrenci;
import org.bson.Document;

public class OgrenciService {

    public void addOgrenci(MongoCollection<Document> collection){
        try {
            Ogrenci ogrenci=new Ogrenci();
            ogrenci.setOgrenciAd("Süreyya");
            ogrenci.setSoyad("Şentürk");
            ogrenci.setOkulNo(1738);
            ogrenci.setYas(24);

            Gson gson= new Gson();
            BasicDBObject dbObject= BasicDBObject.parse(gson.toJson(ogrenci));
            Document ogrenciDocument=new Document();
            ogrenciDocument.append("Kayıt3",dbObject);
            collection.insertOne(ogrenciDocument);
            System.out.println("BAŞARILI BİR ŞEKİLDE KAYIT İŞLEMİ YAPILDI");

        }catch (Exception exception){
            System.out.println("KAYIT OLUŞTURULURKEN BİR HATA OLUŞTU LÜTFEN TEKRAR DENEYİN");
        }
    }

    public void getOgrenci(MongoCollection<Document> collection){

    }
}
