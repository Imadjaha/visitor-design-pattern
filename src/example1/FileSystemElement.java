package example1;

public interface FileSystemElement {
    void accept(FileSystemVisitor visitor);
}
