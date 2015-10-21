package com.edorasware.one.integration.test.aspose;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Unit test for aspose pdf save.
 */
public class AsposePdfSaveTest
        extends TestCase {
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AsposePdfSaveTest(String testName) {
        super(testName);
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite(AsposePdfSaveTest.class);
    }

    public void testPdfSave() throws Exception {
        InputStream docStream = ClassLoader.class.getResourceAsStream("/documentOriginal.pdf");
        com.aspose.pdf.Document document = new com.aspose.pdf.Document(docStream);
        OutputStream pdfStream = null;
        try {
            pdfStream = new FileOutputStream("documentSaved.pdf");
            document.save(pdfStream);
        } finally {
            if (pdfStream != null)
                pdfStream.close();
        }
    }
}
