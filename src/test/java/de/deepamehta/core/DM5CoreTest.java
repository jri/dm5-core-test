package de.deepamehta.core;

import de.deepamehta.core.model.SimpleValue;
import de.deepamehta.core.model.TopicModel;
import dm5.core.TopicModelImpl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;



public class DM5CoreTest {

    @Test
    public void test() {
        TopicModel topic = new TopicModelImpl(1234, "", "dm5.person", new SimpleValue("Jörg"), null);
        assertEquals(1234, topic.getId());
        assertEquals("", topic.getUri());
        assertEquals("dm5.person", topic.getTypeUri());
        assertEquals(new SimpleValue("Jörg"), topic.getSimpleValue());
        assertEquals(null, topic.getChildTopicsModel());
    }
}
