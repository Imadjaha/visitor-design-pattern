package example2;

public interface HtmlVisitor {
    void visit(Paragraph paragraph);
    void visit(Div div);
}
