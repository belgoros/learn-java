package com.sca.tesseract;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

import java.io.File;

/**
 * This is an example of using Tess4J library, a JNA wrapper for <a href="https://github.com/tesseract-ocr/tesseract/tree/main">Tesseract</a>.
 * See https://tess4j.sourceforge.net for more details.
 * <p>
 * To run the below example, you need to add the following dependencies to your project:
 * <code>
 *         <dependency>
 *             <groupId>net.sourceforge.tess4j</groupId>
 *             <artifactId>tess4j</artifactId>
 *             <version>4.5.5</version>
 *         </dependency>
 *         <!-- in case it's not defined yet, SLF4J API binding to Simple implementation -->
 *         <dependency>
 *             <groupId>org.slf4j</groupId>
 *             <artifactId>slf4j-simple</artifactId>
 *             <version>1.7.36</version>
 *         </dependency>
 * </code>
 * <p>
 * 2. Install tesseract on your machine. For macOS, you can use Homebrew: `brew install tesseract`
 * 3. Check the installation of tesseract with the command: `tesseract --version`
 * 4. Check where tessearct was installed with the command: `which tesseract`
 * 5. Locate libtesseract.dylib with the command: `find /opt/homebrew -name "libtesseract.dylib" 2>/dev/null`
 * 6. Set `DYLD_LIBRARY_PATH` correctly either:
 * <p>
 * `export DYLD_LIBRARY_PATH=/opt/homebrew/lib:$DYLD_LIBRARY_PATH`
 * <p>
 * or to make it permanent:
 * <p>
 * `echo 'export DYLD_LIBRARY_PATH=/opt/homebrew/lib:$DYLD_LIBRARY_PATH' >> ~/.zshrc
 * source ~/.zshrc`
 * <p>
 * 7. Modify Java Run Configuration in IntelliJ/Eclipse IDE:
 * `-Djava.library.path=/opt/homebrew/lib`
 * <p>
 * 8. If you need multiple languages, install them with: `brew install tesseract-lang`
 * 9. Then update `tesseract.setLanguage("eng+spa")`; to set teh language as English + Spanish
 *
 */
public class OCRExample {
    public static void main(String[] args) {
        // Path to the image file
        File imageFile = new File("sample.png");

        // Initialize Tesseract OCR instance
        ITesseract tesseract = new Tesseract();

        // Set the path to the Tesseract OCR installation folder (for macOS)
        tesseract.setDatapath("/opt/homebrew/share/tessdata/");
        System.setProperty("jna.library.path", "/opt/homebrew/lib"); // Ensures JNI loads libtesseract


        // Optionally, set the language (e.g., English)
        tesseract.setLanguage("eng");

        try {
            // Perform OCR on the image
            String text = tesseract.doOCR(imageFile);
            System.out.println("Extracted Text:\n" + text);
        } catch (TesseractException e) {
            System.err.println("Error during OCR: " + e.getMessage());
        }
    }
}
