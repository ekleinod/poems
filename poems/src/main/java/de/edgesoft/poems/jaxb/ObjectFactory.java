
package de.edgesoft.poems.jaxb;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the de.edgesoft.poems.jaxb package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _Poems_QNAME = new QName("", "poems");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: de.edgesoft.poems.jaxb
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Poems }
     * 
     */
    public Poems createPoems() {
        return new Poems();
    }

    /**
     * Create an instance of {@link Poem }
     * 
     */
    public Poem createPoem() {
        return new Poem();
    }

    /**
     * Create an instance of {@link Content }
     * 
     */
    public Content createContent() {
        return new Content();
    }

    /**
     * Create an instance of {@link Author }
     * 
     */
    public Author createAuthor() {
        return new Author();
    }

    /**
     * Create an instance of {@link Verse }
     * 
     */
    public Verse createVerse() {
        return new Verse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Poems }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "poems")
    public JAXBElement<Poems> createPoems(Poems value) {
        return new JAXBElement<Poems>(_Poems_QNAME, Poems.class, null, value);
    }

}
