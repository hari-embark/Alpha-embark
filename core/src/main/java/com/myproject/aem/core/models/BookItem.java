package com.myproject.aem.core.models;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

@Model(adaptables = Resource.class)
public interface BookItem {
    @ValueMapValue (name = "authorBooks")
    String getBookName();
}
