package com.stroopgame.io;

import com.stroopgame.FileBasedTest;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URISyntaxException;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

public class FileIOTest extends FileBasedTest {

    @Mock
    File mockFile;

    @Before
    public void setUp( ) {
        initMocks( this );
    }

    @Test(expected = IllegalArgumentException.class)
    public void givenNonExistentFileThenConstructorThrowsException( ) {
        when( mockFile.exists() ).thenReturn( false );

        new FileIO( mockFile );

        verify( mockFile.exists() );
    }

    @Test(expected = FileIOException.class)
    public void givenFileWhenUnableToReadThenThrowException( ) throws FileIOException, IOException {

        when( mockFile.exists() ).thenReturn( true );

        FileIO fileIO = spy( new FileIO( mockFile ) );

        FileInputStream mockFileInputStream = mock( FileInputStream.class );
        when( mockFileInputStream.read( any( byte[].class ) ) ).thenThrow( new IOException( "OOPPPSSS" ) );
        doNothing().when( mockFileInputStream ).close();

        fileIO.read();

        verify( mockFileInputStream ).read( any( byte[].class ) );
        verify( mockFile ).exists();
        verify( mockFileInputStream ).close();
        verify( mockFile.exists() );
    }

    @Test
    public void givenValidInputFileThenItCanBeRead( ) throws FileIOException, IOException, URISyntaxException {

        FileIO fileIO = new FileIO( getTestFile( "sampleFile.json" ) );

        assertThat( fileIO.read(), containsString( "datapoint" ) );
    }

}