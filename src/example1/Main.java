package example1;

import javax.naming.Name;

public class Main {
    public static void main(String[] args) {

        File file1  = new File("File1.txt", 100);
        File file2 = new File("File2.txt", 200);

        Folder folder1 = new Folder("Folder1");
        folder1.addElement(file1);
        folder1.addElement(file2);

        File file3 = new File("File3.txt",300);
        Folder rootFolder = new Folder("RootFolder");
        rootFolder.addElement(folder1);
        rootFolder.addElement(file3);

        SizeCalculatorVisitor sizeVisitor = new SizeCalculatorVisitor();
        rootFolder.accept(sizeVisitor);
        System.out.println("Total Size of RootFolder: "+ sizeVisitor.getTotalSize() + " bytes");

        SizeCalculatorVisitor sizeVisitor2 = new SizeCalculatorVisitor();
        folder1.accept(sizeVisitor2);
        System.out.println("Total Size of Folder1: " + sizeVisitor2.getTotalSize());
        // User NamePrinterVisitor
        NamePrinterVisitor nameVisitor = new NamePrinterVisitor();
        rootFolder.accept(nameVisitor);



    }
}