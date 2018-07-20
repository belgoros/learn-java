package com.sca.files;

import org.junit.Test;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;

import static org.assertj.core.api.Assertions.assertThat;

public class ReadFromResourcesTest {

    @Test
    public void shouldSetPath() throws URISyntaxException {
        URL url = getClass().getResource("/index.csv");
        File f = new File(url.toURI());
        assertThat(f).isFile().exists();
    }
}
