package example2;

public class Paragraph implements HtmlElement{

    private final String text;

    public Paragraph(String text){
        this.text = text;
    }
    public String getText(){
        return text;
    }

    @Override
    public void accept(HtmlVisitor visitor){
        visitor.visit(this);
    }
}
