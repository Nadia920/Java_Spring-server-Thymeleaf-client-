package com.java.Incidents;

public class Singleton {
        private static Singleton instance;

        public static synchronized Singleton getInstance() {
            if (instance == null) {
                instance = new Singleton();
            }
            return instance;
        }

    }
