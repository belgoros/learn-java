package com.sca.xml;

import org.junit.Test;
import org.w3c.dom.Attr;
import org.w3c.dom.Node;
import org.xmlunit.builder.DiffBuilder;
import org.xmlunit.builder.Input;
import org.xmlunit.diff.*;

import java.io.File;
import java.util.Iterator;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.xmlunit.matchers.CompareMatcher.isIdenticalTo;
import static org.xmlunit.matchers.CompareMatcher.isSimilarTo;

/**
 * See the detailed description at https://www.baeldung.com/xmlunit2
 */
public class XmlUnitExamplesTest {
    @Test
    public void given2XMLS_whenIdentical_thenCorrect() {
        String controlXml = "<struct><int>3</int><boolean>false</boolean></struct>";
        String testXml = "<struct><int>3</int><boolean>false</boolean></struct>";
        assertThat(testXml, isIdenticalTo(controlXml));
    }

    @Test
    public void given2XMLSWithSimilarNodesButDifferentSequence_whenNotIdentical_thenCorrect() {
        String controlXml = "<struct><int>3</int><boolean>false</boolean></struct>";
        String testXml = "<struct><boolean>false</boolean><int>3</int></struct>";
        assertThat(testXml, not(isIdenticalTo(controlXml)));
    }

    @Test
    public void given2XMLS_whenGeneratesDifferences_thenCorrect() {
        String controlXml = "<struct><int>3</int><boolean>false</boolean></struct>";
        String testXml = "<struct><boolean>false</boolean><int>3</int></struct>";
        Diff myDiff = DiffBuilder.compare(controlXml).withTest(testXml).build();

        Iterator<Difference> iter = myDiff.getDifferences().iterator();
        int size = 0;
        while (iter.hasNext()) {
            iter.next().toString();
            size++;
        }
        assertThat(size, greaterThan(1));
    }

    @Test
    public void given2XMLS_whenGeneratesOneDifference_thenCorrect() {
        String myControlXML = "<struct><int>3</int><boolean>false</boolean></struct>";
        String myTestXML = "<struct><boolean>false</boolean><int>3</int></struct>";

        Diff myDiff = DiffBuilder
                .compare(myControlXML)
                .withTest(myTestXML)
                .withComparisonController(ComparisonControllers.StopWhenDifferent)
                .build();

        Iterator<Difference> iter = myDiff.getDifferences().iterator();
        int size = 0;
        while (iter.hasNext()) {
            iter.next().toString();
            size++;
        }
        assertThat(size, equalTo(1));
    }

    @Test
    public void givenFileSource_whenAbleToInput_thenCorrect() {
        ClassLoader classLoader = getClass().getClassLoader();
        String testPath = classLoader.getResource("test.xml").getPath();
        String controlPath = classLoader.getResource("control.xml").getPath();

        assertThat(Input.fromFile(testPath), isSimilarTo(Input.fromFile(controlPath)));
    }

    @Test
    public void givenStringSource_whenAbleToInput_thenCorrect() {
        String controlXml = "<struct><int>3</int><boolean>false</boolean></struct>";
        String testXml = "<struct><int>3</int><boolean>false</boolean></struct>";

        assertThat(Input.fromString(testXml), isSimilarTo(Input.fromString(controlXml)));
    }

    @Test
    public void givenStreamAsSource_whenAbleToInput_thenCorrect() {
        assertThat(Input.fromStream(getClass()
                        .getResourceAsStream("/test.xml")),
                isSimilarTo(
                        Input.fromStream(getClass()
                                .getResourceAsStream("/control.xml"))));
    }

    @Test
    public void givenFileSourceAsObject_whenAbleToInput_thenCorrect() {
        ClassLoader classLoader = getClass().getClassLoader();

        assertThat(
                Input.from(new File(classLoader.getResource("test.xml").getFile())),
                isSimilarTo(Input.from(new File(classLoader.getResource("control.xml").getFile()))));
    }

    @Test
    public void givenStringSourceAsObject_whenAbleToInput_thenCorrect() {
        assertThat(
                Input.from("<struct><int>3</int><boolean>false</boolean></struct>"),
                isSimilarTo(Input.from("<struct><int>3</int><boolean>false</boolean></struct>")));
    }

    @Test
    public void given2XMLS_whenSimilar_thenCorrect() {
        String controlXml = "<struct><int>3</int><boolean>false</boolean></struct>";
        String testXml = "<struct><boolean>false</boolean><int>3</int></struct>";

        //assertThat(testXml, isSimilarTo(controlXml)); -> this assertion will fail
        // But when using DefaultNodeMatcher it will pass
        assertThat(testXml,
                isSimilarTo(controlXml).withNodeMatcher(
                        new DefaultNodeMatcher(ElementSelectors.byName)));
    }

    @Test
    public void given2XMLs_whenSimilarWithDiff_thenCorrect() throws Exception {
        String myControlXML = "<struct><int>3</int><boolean>false</boolean></struct>";
        String myTestXML = "<struct><boolean>false</boolean><int>3</int></struct>";
        Diff myDiffSimilar = DiffBuilder.compare(myControlXML).withTest(myTestXML)
                .withNodeMatcher(new DefaultNodeMatcher(ElementSelectors.byName))
                .checkForSimilar().build();

        assertFalse("XML similar " + myDiffSimilar.toString(),
                myDiffSimilar.hasDifferences());
    }

    @Test
    public void given2XMLsWithDifferences_whenTestsDifferentWithoutDifferenceEvaluator_thenCorrect() {
        final String control = "<a><b attr=\"abc\"></b></a>";
        final String test = "<a><b attr=\"xyz\"></b></a>";
        Diff myDiff = DiffBuilder.compare(control).withTest(test)
                .checkForSimilar().build();
        //assertFalse(myDiff.toString(), myDiff.hasDifferences()); -> this will fail
        // see the below example using the internal IgnoreAttributeDifferenceEvaluator class
    }

    @Test
    public void given2XMLsWithDifferences_whenTestsSimilarWithDifferenceEvaluator_thenCorrect() {
        final String control = "<a><b attr=\"abc\"></b></a>";
        final String test = "<a><b attr=\"xyz\"></b></a>";
        Diff myDiff = DiffBuilder.compare(control).withTest(test)
                .withDifferenceEvaluator(new IgnoreAttributeDifferenceEvaluator("attr"))
                .checkForSimilar().build();

        assertFalse(myDiff.toString(), myDiff.hasDifferences());
    }

    public static class IgnoreAttributeDifferenceEvaluator implements DifferenceEvaluator {
        private final String attributeName;

        public IgnoreAttributeDifferenceEvaluator(String attributeName) {
            this.attributeName = attributeName;
        }

        @Override
        public ComparisonResult evaluate(Comparison comparison, ComparisonResult outcome) {
            if (outcome == ComparisonResult.EQUAL)
                return outcome;
            final Node controlNode = comparison.getControlDetails().getTarget();
            if (controlNode instanceof Attr) {
                Attr attr = (Attr) controlNode;
                if (attr.getName().equals(attributeName)) {
                    return ComparisonResult.SIMILAR;
                }
            }
            return outcome;
        }
    }
}
