package example2;

import java.util.ArrayList;
import java.util.List;

public class Div implements HtmlElement{

    private List<HtmlElement> children = new ArrayList<>();

    public void addChild(HtmlElement element){
        children.add(element);
    }

    public List<HtmlElement> getChildren(){
        return children;
    }

    @Override
    public void accept(HtmlVisitor visitor){
        visitor.visit(this);
    }
}
