package com.stroopgame.util;

import android.media.MediaPlayer;

import org.junit.Before;
import org.junit.Ignore;
import org.mockito.Mock;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.initMocks;


public class SoundPlayerTest {

    @Mock
    MediaPlayer mockBuzzerMediaPlayer;

    @Mock
    MediaPlayer mockDingMediaPlayer;

    @Before
    public void setUp( ) {
        initMocks( this );
    }

    @Ignore
    public void givenWrongAnswerGivenByUserSoundPlayerPlaysBuzzerSound( ) {
        doNothing().when( mockBuzzerMediaPlayer ).start();

        SoundPlayer player = new SoundPlayer( mockBuzzerMediaPlayer, mockDingMediaPlayer );

        player.soundFeedbackForUserInput( false );

        verify( mockBuzzerMediaPlayer ).start();
    }

    @Ignore
    public void givenCorrectAnswerGivenByUserSoundPlayerPlaysBuzzerSound( ) {

        doNothing().when( mockDingMediaPlayer ).start();
        SoundPlayer player = new SoundPlayer( mockBuzzerMediaPlayer, mockDingMediaPlayer );

        player.soundFeedbackForUserInput( true );

        verify( mockDingMediaPlayer ).start();
    }
}