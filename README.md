<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
 
</head>
<body>

  <h1>Visitor Design Pattern</h1>

  <p>
    The <strong>Visitor Pattern</strong> is a <em>behavioral design pattern</em> that allows you to separate algorithms (operations) from the objects on which they operate. 
    By placing new behavior (operations) in separate visitor objects rather than in the classes themselves, you can add new operations to an existing object structure without modifying those classes.
  </p>

  <hr>

<h2>Key Intent</h2>
  <ul>
    <li>Separate an algorithm from an object structure on which it operates.</li>
    <li>Allow adding new operations without changing the classes of the elements on which it operates.</li>
  </ul>

  <hr>

<h2>When to Use</h2>
  <ul>
    <li>
      You need to perform multiple and distinct operations on the elements of an object structure, and you want to avoid "polluting" these elements with all those operations.
    </li>
    <li>
      You want to add new operations to an existing object structure without modifying its classes, following the <em>Open-Closed Principle</em>.
    </li>
    <li>
      The operations frequently change, but the structure of classes is relatively stable.
    </li>
  </ul>

  <hr>

<h2>Participants</h2>
  <ul>
    <li>
      <strong>Visitor</strong>: Declares a set of visit methods, one for each concrete element class in the structure.
    </li>
    <li>
      <strong>Concrete Visitor</strong>: Implements the operations defined in the Visitor interface; contains the specific behavior to be applied to each element type.
    </li>
    <li>
      <strong>Element</strong>: Defines an <code>accept</code> method that takes a visitor as an argument.
    </li>
    <li>
      <strong>Concrete Elements</strong>: Implement the <code>accept</code> method, typically by calling back the corresponding visit method on the visitor.
    </li>
    <li>
      <strong>Object Structure</strong>: Can be a collection of elements, typically providing a way to iterate over its elements and apply a visitor to them.
    </li>
  </ul>

  <hr>

<h2>Structure</h2>
  <p>A simplified UML-like diagram of the Visitor pattern could look like this:</p>
  <pre>
+---------------+        +---------------+       +-----------------+
|   Visitor     |        |   Element     |<------|  ObjectStructure|
+---------------+        +---------------+       +-----------------+
|+ visitCE(e)   |        |+ accept(v:Visitor) |         
|+ visitCE2(e)  |         +---------------+             
+---------------+           ^         ^                         
^                           |         |_____________
|                           |                       |
+------------------+     +----------------+       +----------------+
| ConcreteVisitor |      | ConcreteElement|       |ConcreteElement2|
+------------------+     +----------------+       +----------------+
|+ visitCE(e)     |      |+ accept(v)     |       |+ accept(v)     |
|+ visitCE2(e)    |      +----------------+       +----------------+
+------------------+














  </pre>

  <hr>

<h2>Example (Java)</h2>
  <p>Below is a simplified Java example of the Visitor pattern in action.</p>

  <pre><code>// Element interface
public interface Element {
    void accept(Visitor visitor);
}

// Concrete Element A
public class ConcreteElementA implements Element {
    private String attributeA = "ValueA";

    public String getAttributeA() {
        return attributeA;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}

// Concrete Element B
public class ConcreteElementB implements Element {
    private int attributeB = 42;

    public int getAttributeB() {
        return attributeB;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}

// Visitor interface
public interface Visitor {
    void visit(ConcreteElementA elementA);
    void visit(ConcreteElementB elementB);
}

// Concrete Visitor 1
public class ConcreteVisitor1 implements Visitor {

    @Override
    public void visit(ConcreteElementA elementA) {
        System.out.println("ConcreteVisitor1 visiting ConcreteElementA: " + elementA.getAttributeA());
    }

    @Override
    public void visit(ConcreteElementB elementB) {
        System.out.println("ConcreteVisitor1 visiting ConcreteElementB: " + elementB.getAttributeB());
    }
}

// Concrete Visitor 2
public class ConcreteVisitor2 implements Visitor {

    @Override
    public void visit(ConcreteElementA elementA) {
        System.out.println("ConcreteVisitor2 visiting ConcreteElementA: " + elementA.getAttributeA().toUpperCase());
    }

    @Override
    public void visit(ConcreteElementB elementB) {
        System.out.println("ConcreteVisitor2 visiting ConcreteElementB (double): " + elementB.getAttributeB() * 2);
    }
}

// Object Structure
import java.util.ArrayList;
import java.util.List;

public class ObjectStructure {
    private List<Element> elements = new ArrayList<>();

    public void addElement(Element e) {
        elements.add(e);
    }

    public void acceptAll(Visitor visitor) {
        for(Element e : elements) {
            e.accept(visitor);
        }
    }
}

// Client code
public class Client {
    public static void main(String[] args) {
        // Create elements
        ConcreteElementA elementA = new ConcreteElementA();
        ConcreteElementB elementB = new ConcreteElementB();

        // Create object structure
        ObjectStructure objectStructure = new ObjectStructure();
        objectStructure.addElement(elementA);
        objectStructure.addElement(elementB);

        // Create visitors
        ConcreteVisitor1 visitor1 = new ConcreteVisitor1();
        ConcreteVisitor2 visitor2 = new ConcreteVisitor2();

        // Accept visitors
        System.out.println("Using ConcreteVisitor1:");
        objectStructure.acceptAll(visitor1);

        System.out.println("\nUsing ConcreteVisitor2:");
        objectStructure.acceptAll(visitor2);
    }
}
  </code></pre>

  <p>
    In this example:
    <ul>
      <li><strong>Element</strong>: The interface that declares the <code>accept</code> method (e.g., <code>ConcreteElementA</code> and <code>ConcreteElementB</code>).</li>
      <li><strong>Visitor</strong>: Interface with <code>visit</code> methods for each type of concrete element.</li>
      <li><strong>ConcreteVisitor1</strong> and <strong>ConcreteVisitor2</strong>: Implement the visitor interface, providing specialized behavior for each element type.</li>
      <li><strong>ObjectStructure</strong>: Maintains a collection of elements and provides a method to apply a visitor to all of them.</li>
      <li><strong>Client</strong>: Creates the elements, the object structure, and visitors. It then applies each visitor to all elements, demonstrating how each visitor can perform different operations on the same set of elements.</li>
    </ul>
  </p>

  <hr>

<h2>Benefits</h2>
  <ul>
    <li>
      <strong>Open/Closed Principle compliance:</strong> You can introduce new operations by adding new visitors without changing the element classes.
    </li>
    <li>
      <strong>Single Responsibility Principle:</strong> The element classes do not need to handle new operations; these are encapsulated in separate visitor objects.
    </li>
    <li>
      <strong>Multiple operations:</strong> You can define multiple visitors to perform different sets of operations on the same objects.
    </li>
  </ul>

  <hr>

<h2>Drawbacks</h2>
  <ul>
    <li>
      <strong>Adding new Element types is hard:</strong> If you add a new element type, you must update every visitor to handle it.
    </li>
    <li>
      <strong>Visibility of internal state:</strong> You might be forced to expose the internal details of Element classes so that the visitor can do its job.
    </li>
    <li>
      <strong>Double dispatch complexity:</strong> It relies on double dispatch (the <code>accept</code> method calls <code>visit</code>), which can be tricky to implement correctly.
    </li>
  </ul>

  <hr>

<h2>Related Patterns</h2>
  <ul>
    <li><strong>Composite</strong>: Visitors can be used to apply operations over components of composite structures.</li>
    <li><strong>Interpreter</strong>: Visitors can be used to traverse abstract syntax trees.</li>
    <li><strong>Iterator</strong>: Often used to traverse complex data structures that visitors might operate on.</li>
  </ul>

  <hr>

<h2>Conclusion</h2>
  <p>
    The Visitor design pattern is a powerful technique for separating operations from the objects on which they operate, especially useful when the element classes are stable 
    but you frequently add new operations. If you need to add new element types, however, each existing visitor must change, so it's best suited for systems where the object 
    structure rarely changes, but the operations on that structure change often.
  </p>

</body>
</html>
