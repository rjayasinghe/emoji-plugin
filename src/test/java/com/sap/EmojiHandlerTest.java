package com.sap;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.Test;

import com.sap.cds.services.cds.CdsReadEventContext;

class EmojiHandlerTest {

    @Test
    void testHandler() {

        assertDoesNotThrow(() -> {
            EmojiHandler handler = new EmojiHandler();
            handler.decorateEmoji(CdsReadEventContext.create("test"));
        });
    }
}
