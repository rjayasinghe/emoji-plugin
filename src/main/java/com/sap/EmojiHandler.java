package com.sap;


import com.sap.cds.CdsDataProcessor;
import com.sap.cds.services.cds.ApplicationService;
import com.sap.cds.services.cds.CdsReadEventContext;
import com.sap.cds.services.handler.EventHandler;
import com.sap.cds.services.handler.annotations.After;
import com.sap.cds.services.handler.annotations.ServiceName;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ServiceName(value = "*", type = ApplicationService.class)
public class EmojiHandler implements EventHandler {
    private static final Logger logger = LoggerFactory.getLogger(EmojiHandler.class);
    private static final String EMOJI_ANNOTATION_NAME = "@emoji";

    @After()
    public void decorateEmoji(CdsReadEventContext context) {
        if(null == context.getResult()) {
            return;
        }
        CdsDataProcessor.create()
                .addConverter(
                        (path, element, type)  -> element.findAnnotation(EMOJI_ANNOTATION_NAME).isPresent(),
                        (path, element, value) -> value + "🙃")
                .process(context.getResult());
    }
}
