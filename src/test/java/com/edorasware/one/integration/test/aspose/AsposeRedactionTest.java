package com.edorasware.one.integration.test.aspose;
import com.aspose.pdf.*;
import com.aspose.pdf.facades.PdfAnnotationEditor;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.awt.*;
import java.awt.Color;
import java.awt.Rectangle;
import java.io.*;
import java.util.Date;

/**
 * Unit test for aspose redaction + pdf.
 */
public class AsposeRedactionTest
        extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AsposeRedactionTest(String testName)
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AsposeRedactionTest.class );
    }

    public void testPdfRedactionWorking() throws FileNotFoundException {
        InputStream pdfSample = ClassLoader.class.getResourceAsStream("/pdf-sample.pdf" );

        PdfAnnotationEditor pdfAnnotationEditor = new PdfAnnotationEditor();
        pdfAnnotationEditor.bindPdf(pdfSample);
        IDocument document = pdfAnnotationEditor.getDocument();
        PageCollection pages = document.getPages();
        double documentHeight = pages.get_Item(1).getMediaBox().getHeight();
        pdfAnnotationEditor.redactArea(1, createRectangle(100, 100, 100, 100, documentHeight), Color.BLACK);
        pdfAnnotationEditor.redactArea(1, createRectangle(300, 100, 100, 100, documentHeight), Color.BLACK);
        pdfAnnotationEditor.redactArea(1, createRectangle(200, 200, 100, 100, documentHeight), Color.BLACK);

        pdfAnnotationEditor.save(new FileOutputStream(new File("pdf-sample_" + new Date().getTime() +"_.pdf")));
    }

    public void testPdfRedactionNotWorking() throws FileNotFoundException {
        InputStream pdfSample = ClassLoader.class.getResourceAsStream("/pdf-sample2.pdf");

        PdfAnnotationEditor pdfAnnotationEditor = new PdfAnnotationEditor();
        pdfAnnotationEditor.bindPdf(pdfSample);
        IDocument document = pdfAnnotationEditor.getDocument();
        PageCollection pages = document.getPages();
        double documentHeight = pages.get_Item(1).getMediaBox().getHeight();
        pdfAnnotationEditor.redactArea(1, createRectangle(100, 100, 100, 100, documentHeight), Color.BLACK);
        pdfAnnotationEditor.redactArea(1, createRectangle(300, 100, 100, 100, documentHeight), Color.BLACK);
        pdfAnnotationEditor.redactArea(1, createRectangle(200, 200, 100, 100, documentHeight), Color.BLACK);

        pdfAnnotationEditor.save(new FileOutputStream(new File("pdf-sample2_" + new Date().getTime() +"_.pdf")));
    }

    private static com.aspose.pdf.Rectangle createRectangle(double x, double y, double height, double width, double documentHeight) {
        double lly = documentHeight - height - y; //
        double urx = x + width;
        double ury = lly + height;

        return new com.aspose.pdf.Rectangle(x, lly, urx, ury);
    }
}
