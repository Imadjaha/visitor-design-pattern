package example1;

public class SizeCalculatorVisitor implements FileSystemVisitor{

    private  int totalSize = 0;

    @Override
    public void visit(File file){
        totalSize += file.getFileSize();
    }

    @Override
    public void visit(Folder folder){
        for(FileSystemElement element: folder.getElements()){
            element.accept(this); // recursive call for child elements
        }
    }

    public int getTotalSize(){
        return totalSize;
    }
}
