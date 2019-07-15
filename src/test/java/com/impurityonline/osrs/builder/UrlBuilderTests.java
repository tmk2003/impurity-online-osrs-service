package com.impurityonline.osrs.builder;

import com.impurityonline.osrs.utils.configs.AbstractTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * @author impurity
 */
class UrlBuilderTests extends AbstractTest {

    @Test
    @DisplayName("When player url playName is null, throw null pointer")
    void osrsUrl_player_null_playerName() {
        assertThrows(NullPointerException.class, () -> UrlBuilder.buildPlayerURL(null));
    }

    @Test
    @DisplayName("When grandExchange url itemId is null, throw null pointer")
    void osrsUrl_item_null_itemId() {
        assertThrows(NullPointerException.class, () -> UrlBuilder.buildGrandExchangeURL(null));
    }

    @Test
    @DisplayName("When player name supplied, player query param is valid")
    void osrsUrl_player_playerNameIsValid() {
        String playerName = "1234";
        assertEquals(playerName, UrlBuilder.buildPlayerURL(playerName).build().getQueryParams().get("player").get(0));
    }

    @Test
    @DisplayName("When item id supplied, item query param is valid")
    void osrsUrl_item_itemIdIsValid() {
        Long itemId = 1234L;
        assertEquals(itemId, (Long) Long.parseLong(UrlBuilder.buildGrandExchangeURL(itemId).build().getQueryParams().get("item").get(0)));
    }

}
