package com.myproject.aem.core.models.impl;

import com.myproject.aem.core.models.BookItem;
import com.myproject.aem.core.models.Books;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import java.util.List;

@Model(adaptables = Resource.class,
        adapters = Books.class,
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)

public class BooksImpl implements Books {
    private static final Logger LOG = LoggerFactory.getLogger(BooksImpl.class);

    @ValueMapValue
    private String title;

    @ValueMapValue
    private String description;

    @ChildResource(name = "authorBooks")
    private List<BookItem> authorBooks;

    @PostConstruct
    protected void init(){
        if(authorBooks != null && !authorBooks.isEmpty()){
            LOG.info("Author Books list initialized successfully. Total books found: {}", authorBooks.size());
        }else{
            LOG.info("Author Books list is empty or null for this component.");
        }
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public List<BookItem> getAuthorBooks() { return authorBooks; }
}
