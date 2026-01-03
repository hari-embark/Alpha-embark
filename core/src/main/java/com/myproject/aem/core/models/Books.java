package com.myproject.aem.core.models;

import org.apache.sling.models.annotations.injectorspecific.ChildResource;

import java.util.List;

public interface Books {
        String getTitle();
        String getDescription();
        @ChildResource (name = "authorBooks")
        List<BookItem> getAuthorBooks();
    }
