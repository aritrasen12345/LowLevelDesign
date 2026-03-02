package InterviewQuestions;

import java.util.*;

interface DocumentElement {
    String render();
}

class TextElement implements DocumentElement {
    String text;

    TextElement(String text) {
        this.text = text;
    }

    @Override
    public String render() {
        return this.text;
    }
}

class ImageElement implements DocumentElement {
    String imgPath;

    ImageElement(String imgPath) {
        this.imgPath = imgPath;
    }

    @Override
    public String render() {
        return this.imgPath;
    }
}

interface Persistence {
    void save();
}

class SaveToFile implements Persistence {
    SaveToFile() {}

    @Override
    public void save() {
        System.out.println("Saving document to file!");
    }
    
}

class Document {
    List<DocumentElement> elements;

    Document() {
        this.elements = new ArrayList<>();
    }
    void addElement(DocumentElement element) {
        this.elements.add(element);
    }

    String render() {
        StringBuilder sb = new StringBuilder();
        for(DocumentElement element : elements) {
            sb.append(element.render());
        }
        return sb.toString();
    }
}

class DocumentEditor {
    Document doc;
    Persistence db;
    String renderedDocument = "";

    DocumentEditor(Document _doc, Persistence _db) {
        this.doc = _doc;
        this.db = _db;
    }  

    void addText(String text) {
        this.doc.addElement(new TextElement(text));
    }

    void addImage(String imgPath) {
        this.doc.addElement(new ImageElement(imgPath));
    }

    // void addTabSpaceElement(String imgPath) {
    //     this.doc.addElement(new TabSpaceElement(imgPath));
    // }

    String renderDocument() {
        if(renderedDocument.isEmpty()) {
            renderedDocument = this.doc.render();
        }
        return renderedDocument;
    }
    
    void save() {
        this.db.save();
    }
}


public class GoogleDocs {
    public static void main(String[] args) {
        Document doc = new Document();
        Persistence filePersistence = new SaveToFile();

        DocumentEditor docEditor = new DocumentEditor(doc, filePersistence);
        docEditor.addText("Hello World");

        docEditor.addImage("PATH TO IMAGE");

        System.out.println(docEditor.renderDocument());
        docEditor.save();
    }
}

