//package com.example.faculty;
//
//import com.mongodb.MongoClient;
//import com.mongodb.client.MongoCollection;
//import com.mongodb.client.MongoDatabase;
//import org.bson.Document;
//
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.IOException;
//import java.util.Scanner;
//
//public class UploadImageToMongoDB {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Enter the path of the image file to upload: ");
//        String imagePath = scanner.nextLine();
//
//        try {
//            // Connect to the MongoDB server
//            MongoClient mongoClient = new MongoClient("localhost", 27017);
//
//            // Get the "mydatabase" database
//            MongoDatabase database = mongoClient.getDatabase("mydatabase");
//
//            // Get the "images" collection
//            MongoCollection<Document> collection = database.getCollection("images");
//
//            // Create a new document to insert the image data
//            Document document = new Document();
//
//            // Set the name parameter to the file name
//            File file = new File(imagePath);
//            String fileName = file.getName();
//            document.append("name", fileName);
//
//            // Set the data parameter to the image data
//            FileInputStream inputStream = new FileInputStream(file);
//            byte[] data = new byte[(int) file.length()];
//            inputStream.read(data);
//            document.append("data", data);
//
//            // Insert the document into the collection
//            collection.insertOne(document);
//
//            // Close the resources
//            inputStream.close();
//            mongoClient.close();
//
//            System.out.println("Image uploaded successfully.");
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//}
