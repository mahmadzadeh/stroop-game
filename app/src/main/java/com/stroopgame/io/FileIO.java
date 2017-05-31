package com.stroopgame.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import static org.apache.commons.io.FileUtils.readFileToString;

public class FileIO implements IO {

    private File file;

    public FileIO( File file ) {
        if ( file == null || !file.exists() ) {
            throw new IllegalArgumentException( "Invalid file " + file );
        }

        this.file = file;
    }

    @Override
    public String read( ) throws FileIOException {

        try {

            return readFileToString( file, "UTF-8" );

        } catch ( IOException e ) {

            throw new FileIOException( "Unable to read input stream in FileIO  ", e );
        }
    }

    @Override
    public void write( String data ) throws FileIOException {
        FileOutputStream stream = null;

        try {

            stream = new FileOutputStream( file );

            stream.write( data.getBytes() );

        } catch ( FileNotFoundException e ) {

            throw new FileIOException( "Unable to write to file " + file, e );

        } catch ( IOException e ) {

            throw new FileIOException( "Unable to write to file " + file, e );

        } finally {

            try {
                stream.close();
            } catch ( IOException e ) {
                throw new FileIOException( "Unable to close (after writing) file " + file, e );
            }
        }
    }
}
