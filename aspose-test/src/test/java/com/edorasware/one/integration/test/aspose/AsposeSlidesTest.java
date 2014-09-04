package com.edorasware.one.integration.test.aspose;

import com.aspose.slides.Presentation;
import com.aspose.slides.SaveFormat;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;

/**
 * Unit test for aspose slides + pdf.
 */
public class AsposeSlidesTest
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AsposeSlidesTest(String testName)
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AsposeSlidesTest.class );
    }

    public void testPdfConversion() {
      InputStream pptPresentationStream = ClassLoader.class.getResourceAsStream("/presentation.ppt");
      Presentation pres = new Presentation(pptPresentationStream);
      ByteArrayOutputStream pdfStream = new ByteArrayOutputStream();
      pres.save(pdfStream, SaveFormat.Pdf);
      assertNotNull(pdfStream.toByteArray());
    }
}
