package example1;

// Concrete Element: File
public class File implements FileSystemElement{
    private String fileName;
    private int fileSize;

    public File(String fileName, int fileSize){
        this.fileName = fileName;
        this.fileSize = fileSize;
    }

    public String getFileName(){
        return fileName;
    }

    public int getFileSize(){
        return fileSize;
    }

    @Override
    public void accept(FileSystemVisitor visitor){
        visitor.visit(this);
    }
}
