package example1;

public class NamePrinterVisitor implements FileSystemVisitor {

    @Override
    public void visit(File file) {
        System.out.println("File: " + file.getFileName());

    }

    @Override
    public void visit(Folder folder){
        System.out.println("Folder: " + folder.getFolderName());
        for(FileSystemElement element: folder.getElements()){
            element.accept(this);
        }
    }
}
