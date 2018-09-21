package pl.baadamczyk.designpatterns.structural.bridge;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class MediaPlayerTest {

  public MediaPlayer mediaPlayer;

  @BeforeEach
  public void setUp() throws ReflectiveOperationException {
    mediaPlayer = mediaPlayer.getInstance();
  }

  @Test
  public void shouldPlayFLACFile() throws FileTypeNotSupportedException {
    MediaFile flacFile = FlacFile.of("HEALTH", "TEARS", 2012, "[ALBUM COVER]");

    String playerOutput = mediaPlayer.play(flacFile);
    String fileInfo = mediaPlayer.showFileInfo(flacFile);

    assertThat(playerOutput).isEqualTo("Playing |TEARS| by |HEALTH|");
    assertThat(fileInfo)
        .isEqualTo(
            "FileType: FLAC | Artist: HEALTH | Song: TEARS | Year: 2012 | Album Cover: [ALBUM COVER]");
  }

  @Test
  public void shouldPlayMPEGFile() throws FileTypeNotSupportedException {
    MediaFile mpegFile = MpegFile.of("Tsukamoto Shinya", "Iron Man Tetsuo", 1989, "[MOVIE POSTER]");

    String playerOutput = mediaPlayer.play(mpegFile);
    String fileInfo = mediaPlayer.showFileInfo(mpegFile);

    assertThat(playerOutput).isEqualTo("Playing |Iron Man Tetsuo|");
    assertThat(fileInfo)
        .isEqualTo(
            "FileType: MPEG | Title: Iron Man Tetsuo | Director: Tsukamoto Shinya | Year: 1989 | Movie Poster: [MOVIE POSTER]");
  }

  @Test
  public void shouldThrowException_whenTryingToPlayUnsupportedType() {
    MediaFile unsupportedFile = XLSFile.of("baadamczyk", "Spreadsheet1", 2018, null);

    assertThatExceptionOfType(FileTypeNotSupportedException.class)
        .isThrownBy(() -> mediaPlayer.play(unsupportedFile));
  }
}
