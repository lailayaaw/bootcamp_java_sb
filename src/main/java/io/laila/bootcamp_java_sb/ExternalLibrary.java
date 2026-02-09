package io.laila.bootcamp_java_sb;

import java.util.UUID;

public class ExternalLibrary {
    private final String libraryUniqID;
    private final String libraryName;

    public ExternalLibrary(String name) {
        this.libraryUniqID = UUID.randomUUID().toString();
        this.libraryName = name;
    }

    public String getLibraryName() {
        return libraryName;
    }

    public String getLibraryUniqID() {
        return libraryUniqID;
    }
}
