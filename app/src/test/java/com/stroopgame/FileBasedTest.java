package com.stroopgame;


import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;

public class FileBasedTest {

    public File getTestFile( String fileName ) {

        URL resource = this.getClass().getClassLoader().getResource( fileName );

        try {

            return new File( resource.toURI() );

        } catch ( URISyntaxException e ) {

            throw new IllegalArgumentException( "Invalid test file name given " + fileName );
        }
    }


}
