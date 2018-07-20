package com.sca.files;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Strange behaviour
 * <p/>
 * Runs successfully with Maven Test from Eclipse, but fails when running from CLI or GitBash terminal
 *
 * @author Serguei
 */
public class RenameWithClassLoaderTest {

    @Test
    public void shouldRenameFile() throws IOException {
        String newFileName = "resources_renamed.xml";
        URL resource = getClass().getResource("/test_example_to_rename.cfg");
        File file = new File(resource.getFile());
        Path source = file.toPath();
        Files.move(source, source.resolveSibling(newFileName), StandardCopyOption.REPLACE_EXISTING);
        boolean exists = new File(file.getParent(), newFileName).exists();
        assertThat(exists).isTrue();
    }
}
