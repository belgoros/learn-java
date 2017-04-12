package com.sca.files;

import org.junit.Test;

import java.io.File;
import java.net.URISyntaxException;

import static org.assertj.core.api.Assertions.assertThat;

public class RenameFileExampleTest {

    @Test
    public void shouldRenameFile() throws URISyntaxException {
        RenameFileExample example = new RenameFileExample();
        File cfgFile = example.initFile("test_example_to_rename.cfg");

        String newName = example.buildNewFileName(cfgFile);

        //boolean isRenamed = example.renameConfigFile(cfgFile);

        //assertThat(isRenamed).isTrue();
        assertThat(newName).isEqualTo("test_example_to_rename.cfg.done");


    }
}
