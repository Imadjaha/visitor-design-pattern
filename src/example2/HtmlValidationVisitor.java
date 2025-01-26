package example2;

import java.util.ArrayList;
import java.util.List;

public class HtmlValidationVisitor implements HtmlVisitor{

    private List<String> validationErrors = new ArrayList<>();

    @Override
    public void visit(Paragraph paragraph){
        if(paragraph.getText() == null || paragraph.getText().isEmpty()){
            validationErrors.add("Paragraph element is empty!");
        }
    }

    @Override
    public void visit(Div div){
        if(div.getChildren().isEmpty()){
            validationErrors.add("Div element has no children!");
        }
        for(HtmlElement child: div.getChildren()){
            child.accept(this); // recursive call for child elements
        }
    }

    public List<String> getValidationErrors(){
        return  validationErrors;
    }


}
