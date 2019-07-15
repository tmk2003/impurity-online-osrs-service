package com.impurityonline.osrs.builder;

import com.impurityonline.osrs.client.response.player.ApiClueScroll;
import com.impurityonline.osrs.client.response.player.ApiPlayerResponse;
import com.impurityonline.osrs.domain.player.Scroll;
import com.impurityonline.osrs.utils.configs.AbstractTest;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.impurityonline.osrs.utils.OsrsFactory.getValidApiPlayerResponse;
import static com.impurityonline.osrs.utils.OsrsFactory.getValidScroll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

/**
 * @author impurity
 */
class ScrollBuilderTests extends AbstractTest {

    private static ApiPlayerResponse apiPlayerResponse;

    @BeforeAll
    public static void setup() throws Exception {
        apiPlayerResponse = getValidApiPlayerResponse();
    }

    @Test
    @DisplayName("When player api response is null, throw null pointer")
    void minigameBuilder_nullResponse_throwsNullpointer() {
        assertThrows(NullPointerException.class, () -> ScrollsBuilder.buildScrolls(null));
    }

    @Test
    @DisplayName("When clue scroll is null, throw null pointer")
    void minigameBuilder_nullClueScroll_throwsNullpointer() throws Exception {
        ApiPlayerResponse playerResponse = mock(ApiPlayerResponse.class);
        when(playerResponse.getClueScrolls()).thenReturn(null);
        when(playerResponse.getEasyClueScrolls()).thenReturn(getValidScroll());
        when(playerResponse.getMediumClueScrolls()).thenReturn(getValidScroll());
        when(playerResponse.getHardClueScrolls()).thenReturn(getValidScroll());
        when(playerResponse.getEliteClueScrolls()).thenReturn(getValidScroll());
        when(playerResponse.getMasterClueScrolls()).thenReturn(getValidScroll());
        assertThrows(NullPointerException.class, () -> ScrollsBuilder.buildScrolls(playerResponse));
    }

    @Test
    @DisplayName("When easy clue scroll is null, throw null pointer")
    void minigameBuilder_nullEasyClueScroll_throwsNullpointer() throws Exception {
        ApiPlayerResponse playerResponse = mock(ApiPlayerResponse.class);
        when(playerResponse.getClueScrolls()).thenReturn(getValidScroll());
        when(playerResponse.getEasyClueScrolls()).thenReturn(null);
        when(playerResponse.getMediumClueScrolls()).thenReturn(getValidScroll());
        when(playerResponse.getHardClueScrolls()).thenReturn(getValidScroll());
        when(playerResponse.getEliteClueScrolls()).thenReturn(getValidScroll());
        when(playerResponse.getMasterClueScrolls()).thenReturn(getValidScroll());
        assertThrows(NullPointerException.class, () -> ScrollsBuilder.buildScrolls(playerResponse));
    }

    @Test
    @DisplayName("When medium clue scroll is null, throw null pointer")
    void minigameBuilder_nullMediumClueScroll_throwsNullpointer() throws Exception {
        ApiPlayerResponse playerResponse = mock(ApiPlayerResponse.class);
        when(playerResponse.getClueScrolls()).thenReturn(getValidScroll());
        when(playerResponse.getEasyClueScrolls()).thenReturn(getValidScroll());
        when(playerResponse.getMediumClueScrolls()).thenReturn(null);
        when(playerResponse.getHardClueScrolls()).thenReturn(getValidScroll());
        when(playerResponse.getEliteClueScrolls()).thenReturn(getValidScroll());
        when(playerResponse.getMasterClueScrolls()).thenReturn(getValidScroll());
        assertThrows(NullPointerException.class, () -> ScrollsBuilder.buildScrolls(playerResponse));
    }

    @Test
    @DisplayName("When hard clue scroll is null, throw null pointer")
    void minigameBuilder_nullHardClueScroll_throwsNullpointer() throws Exception {
        ApiPlayerResponse playerResponse = mock(ApiPlayerResponse.class);
        when(playerResponse.getClueScrolls()).thenReturn(getValidScroll());
        when(playerResponse.getEasyClueScrolls()).thenReturn(getValidScroll());
        when(playerResponse.getMediumClueScrolls()).thenReturn(getValidScroll());
        when(playerResponse.getHardClueScrolls()).thenReturn(null);
        when(playerResponse.getEliteClueScrolls()).thenReturn(getValidScroll());
        when(playerResponse.getMasterClueScrolls()).thenReturn(getValidScroll());
        assertThrows(NullPointerException.class, () -> ScrollsBuilder.buildScrolls(playerResponse));
    }

    @Test
    @DisplayName("When elite clue scroll is null, throw null pointer")
    void minigameBuilder_nullEliteClueScroll_throwsNullpointer() throws Exception {
        ApiPlayerResponse playerResponse = mock(ApiPlayerResponse.class);
        when(playerResponse.getClueScrolls()).thenReturn(getValidScroll());
        when(playerResponse.getEasyClueScrolls()).thenReturn(getValidScroll());
        when(playerResponse.getMediumClueScrolls()).thenReturn(getValidScroll());
        when(playerResponse.getHardClueScrolls()).thenReturn(getValidScroll());
        when(playerResponse.getEliteClueScrolls()).thenReturn(null);
        when(playerResponse.getMasterClueScrolls()).thenReturn(getValidScroll());
        assertThrows(NullPointerException.class, () -> ScrollsBuilder.buildScrolls(playerResponse));
    }

    @Test
    @DisplayName("When master clue scroll is null, throw null pointer")
    void minigameBuilder_nullMasterClueScroll_throwsNullpointer() throws Exception {
        ApiPlayerResponse playerResponse = mock(ApiPlayerResponse.class);
        when(playerResponse.getClueScrolls()).thenReturn(getValidScroll());
        when(playerResponse.getEasyClueScrolls()).thenReturn(getValidScroll());
        when(playerResponse.getMediumClueScrolls()).thenReturn(getValidScroll());
        when(playerResponse.getHardClueScrolls()).thenReturn(getValidScroll());
        when(playerResponse.getEliteClueScrolls()).thenReturn(getValidScroll());
        when(playerResponse.getMasterClueScrolls()).thenReturn(null);
        assertThrows(NullPointerException.class, () -> ScrollsBuilder.buildScrolls(playerResponse));
    }

    @Test
    @DisplayName("When player api response is valid, build the medium clue scroll")
    void scollBuild_buildsClueScroll() {
        ApiClueScroll expected = apiPlayerResponse.getClueScrolls();
        Scroll actual = ScrollsBuilder.buildScrolls(apiPlayerResponse).getClueScrolls();
        assertEquals(expected.getRank(), actual.getRank());
        assertEquals(expected.getScore(), actual.getScore());
    }

    @Test
    @DisplayName("When player api response is valid, build the medium clue scroll")
    void scollBuild_buildsEasyClueScroll() {
        ApiClueScroll expected = apiPlayerResponse.getEasyClueScrolls();
        Scroll actual = ScrollsBuilder.buildScrolls(apiPlayerResponse).getEasyClueScrolls();
        assertEquals(expected.getRank(), actual.getRank());
        assertEquals(expected.getScore(), actual.getScore());
    }

    @Test
    @DisplayName("When player api response is valid, build the medium clue scroll")
    void scollBuild_buildsMediumClueScroll() {
        ApiClueScroll expected = apiPlayerResponse.getMediumClueScrolls();
        Scroll actual = ScrollsBuilder.buildScrolls(apiPlayerResponse).getMediumClueScrolls();
        assertEquals(expected.getRank(), actual.getRank());
        assertEquals(expected.getScore(), actual.getScore());
    }

    @Test
    @DisplayName("When player api response is valid, build the hard clue scroll")
    void scollBuild_buildsHardClueScroll() {
        ApiClueScroll expected = apiPlayerResponse.getHardClueScrolls();
        Scroll actual = ScrollsBuilder.buildScrolls(apiPlayerResponse).getHardClueScrolls();
        assertEquals(expected.getRank(), actual.getRank());
        assertEquals(expected.getScore(), actual.getScore());
    }

    @Test
    @DisplayName("When player api response is valid, build the elite clue scroll")
    void scollBuild_buildsEliteClueScroll() {
        ApiClueScroll expected = apiPlayerResponse.getEliteClueScrolls();
        Scroll actual = ScrollsBuilder.buildScrolls(apiPlayerResponse).getEliteClueScrolls();
        assertEquals(expected.getRank(), actual.getRank());
        assertEquals(expected.getScore(), actual.getScore());
    }

    @Test
    @DisplayName("When player api response is valid, build the master clue scroll")
    void scollBuild_buildsMasterClueScroll() {
        ApiClueScroll expected = apiPlayerResponse.getMasterClueScrolls();
        Scroll actual = ScrollsBuilder.buildScrolls(apiPlayerResponse).getMasterClueScrolls();
        assertEquals(expected.getRank(), actual.getRank());
        assertEquals(expected.getScore(), actual.getScore());
    }
}
