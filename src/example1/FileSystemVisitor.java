package example1;

public interface FileSystemVisitor {
    void visit(File file);
    void visit(Folder folder);
}
