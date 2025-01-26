package example1;

import java.util.ArrayList;
import java.util.List;

// Concrete Element: Folder
public class Folder implements FileSystemElement{

    private String folderName;
    private List<FileSystemElement> elements = new ArrayList<>();

    public Folder(String folderName) {
        this.folderName = folderName;
    }

    public String getFolderName(){
        return folderName;
    }

    public void addElement(FileSystemElement element){
        elements.add(element);
    }

    public List<FileSystemElement> getElements(){
        return  elements;
    }

    @Override
    public void accept(FileSystemVisitor visitor){
        visitor.visit(this);
    }
}
