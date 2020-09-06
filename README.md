# Kredi Limit Sorgulama Uygulaması

T.C Kimlik numarası ile kredi limit sorgulama uygulaması 

Bu projede bir kredi başvuru sistem için, kredi başvuru isteklerin alıp ilgili kriterlere göre müşteriye
kredi sonucunu dönen servis yazılmıştır. 

Backend tarafı Java-Spring Boot kütüphanesi ile frontend tarafı ise Javascript-AJAX kütüphanesi ile yazılmıştır.

Proje modülleri mikroservis mimarisine uygun şekilde yazılmıştır. Müşteriden bilgileri kabul edip limit hesaplayan ve başvuruyu H2 inmemory veritabanına kaydeden servis loan-application modülü,
T.C kimlik numarasına göre MongoDB veritabanından ilgili müşterinin kredi skorunu getiren servis credit-score modülü, 
işlem sonucunda müşteriye başvuru sonucuna göre gerekli bildirimi(SMS-E-mail) gönderen notification modülü olarak yazılmıştır..

#### Swagger Dökümanı
Swagger dökümanı proje içerisine 'http://localhost:8080/swagger' adresine html olarak gömülmüştür. 
Ayrıca 'https://app.swaggerhub.com/apis/yyusufaslan/KrediLimitSorgulama/1.0.0' adresinden de incelenebilir. 

## Projenin Çalıştırılması

##### Gereksinimler :
    Java 1.8
    Maven
    Docker
    MongoDB
    PostgreSQL
#### Manuel Çalıştırma : 
    - creditscore isimili veritabanı MongoDB de oluşturulmalı ve mongo_script.text içinde ki script çalıştırılmalı.
    - loanapplication isimli veritabanı PostgreSQL de oluşturulmalı.
    - Her projenin içinde 'mvn spring-boot:run' metodu çalıştırılmalı
    
#### Docker Compose : 
    run: docker-compose up

    open: http://localhost:8080 

#### Actuator endpoints:

http://localhost:8080/actuator/metrics

http://localhost:8080/actuator/health

## Ekran Görüntüleri

![image](https://user-images.githubusercontent.com/22644682/92335776-dceb5580-f0a2-11ea-8c37-ab877545ff5b.png)


![image](https://user-images.githubusercontent.com/22644682/92335744-9ac21400-f0a2-11ea-8e24-65bb0365c4a1.png)


![image](https://user-images.githubusercontent.com/22644682/92335784-00ae9b80-f0a3-11ea-9779-5583a312e705.png)

