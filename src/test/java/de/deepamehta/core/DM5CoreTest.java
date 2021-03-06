package de.deepamehta.core;

import dm5.core.DeepaMehtaStorage;
import dm5.core.DatomicStorage;

import clojure.java.api.Clojure;

import datomic.query.EntityMap;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;

import java.util.logging.Logger;



public class DM5CoreTest {

    private Logger logger = Logger.getLogger(getClass().getName());

    static {
        loadClojureNamespace("dm5.core");
    }

    @Test
    public void storeTopic() {
        DeepaMehtaStorage db = new DatomicStorage();
        //
        long id = (Long) db.storeTopic("my.uri", "dm5.person", "Rich Hickey");
        EntityMap topic = (EntityMap) db.fetchTopic(id);
        //
        logger.info("### topic (" + topic.getClass() + ") " + topic);
        //
        assertEquals(topic.get(":db/id"), id);
        // assertEquals(topic.get(":dm5/entity-type"), ":dm5.entity-type/topic");
    }

    // ---

    private static void loadClojureNamespace(String ns) {
        Clojure.var("clojure.core", "require").invoke(Clojure.read(ns));
    }
}
