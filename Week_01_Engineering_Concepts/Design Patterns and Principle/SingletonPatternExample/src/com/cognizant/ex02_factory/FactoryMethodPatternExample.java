package com.cognizant.ex02_factory;


interface Document {
    void open();
    void close();
}

class WordDocument implements Document {
    @Override
    public void open() { System.out.println("Opening Word Document (.docx)..."); }
    @Override
    public void close() { System.out.println("Closing Word Document."); }
}

class PdfDocument implements Document {
    @Override
    public void open() { System.out.println("Opening PDF Document (.pdf)..."); }
    @Override
    public void close() { System.out.println("Closing PDF Document."); }
}

class ExcelDocument implements Document {
    @Override
    public void open() { System.out.println("Opening Excel Spreadsheet (.xlsx)..."); }
    @Override
    public void close() { System.out.println("Closing Excel Spreadsheet."); }
}

abstract class DocumentFactory {
    public abstract Document createDocument(); // The Factory Method [cite: 27, 28]
}

class WordDocumentFactory extends DocumentFactory {
    @Override
    public Document createDocument() { return new WordDocument(); }
}

class PdfDocumentFactory extends DocumentFactory {
    @Override
    public Document createDocument() { return new PdfDocument(); }
}

class ExcelDocumentFactory extends DocumentFactory {
    @Override
    public Document createDocument() { return new ExcelDocument(); }
}


public class FactoryMethodPatternExample {
    public static void main(String[] args) {
        System.out.println("=== Testing Factory Method Pattern ===");

        // Testing Word Document Creation
        DocumentFactory wordFactory = new WordDocumentFactory();
        Document wordDoc = wordFactory.createDocument();
        wordDoc.open();
        wordDoc.close();

        System.out.println("------------------------------------");

        DocumentFactory pdfFactory = new PdfDocumentFactory();
        Document pdfDoc = pdfFactory.createDocument();
        pdfDoc.open();
        pdfDoc.close();

        System.out.println("------------------------------------");

        DocumentFactory excelFactory = new ExcelDocumentFactory();
        Document excelDoc = excelFactory.createDocument();
        excelDoc.open();
        excelDoc.close();
    }
}