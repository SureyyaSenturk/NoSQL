package service;

import com.google.gson.Gson;
import com.mongodb.BasicDBObject;
import com.mongodb.client.MongoCollection;
import entity.Dersogrenci;
import org.bson.Document;

public class DersOgrenciService {

    public void addDevamsizlik(MongoCollection<Document>collection){
  try {
      Dersogrenci dersogrenci=new Dersogrenci();
      dersogrenci.setDevamsizlik(2);

      Gson gson=new Gson();
      BasicDBObject dbObject=BasicDBObject.parse(gson.toJson(dersogrenci));
      Document dersOgrenciDocument=new Document();
      dersOgrenciDocument.append("Kayıt",dbObject);
      collection.insertOne(dersOgrenciDocument);
      System.out.println("BAŞARILI BİR ŞEKİLDE KAYIT İŞLEMİ YAPILDI");
  }catch(Exception exception){
      System.out.println("KAYIT OLUŞTURULURKEN BİR HATA OLUŞTU LÜTFEN TEKRAR DENEYİN");
  }
    }
}
