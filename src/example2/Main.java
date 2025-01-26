package example2;


public class Main {
    public static void main(String[] args) {

        // first Create a DOM structure
        Paragraph p1 = new Paragraph("Hello there p1");
        Paragraph p2 = new Paragraph("Hello there p2");
        Paragraph p3 = new Paragraph(""); // empty paragraph for validation

        Div div1 = new Div();
        div1.addChild(p1);
        div1.addChild(p2);

        Div rootDiv = new Div();
        rootDiv.addChild(div1);

        rootDiv.addChild(p3);

        // use textEctractorVisitor
        TextExtractorVisitor textExtractorVisitor = new TextExtractorVisitor();
        rootDiv.accept(textExtractorVisitor);
        System.out.println("Extracted Text: " + textExtractorVisitor.getTextContext());

        // Use htmlValidationVisitor
        HtmlValidationVisitor htmlValidationVisitor = new HtmlValidationVisitor();
        rootDiv.accept(htmlValidationVisitor);
        System.out.println("Validation Erros: " + htmlValidationVisitor.getValidationErrors());





    }
}