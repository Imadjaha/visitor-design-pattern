package example2;

public class TextExtractorVisitor implements HtmlVisitor{

    private StringBuilder textContent = new StringBuilder();

    @Override
    public void visit(Paragraph paragraph){
textContent.append(paragraph.getText()).append(" ");
    }

    @Override
    public void visit(Div div){
        for(HtmlElement child: div.getChildren()){
            child.accept(this);
        }
    }

    public String getTextContext(){
        return textContent.toString().trim();
    }
}
