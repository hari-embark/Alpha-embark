package com.myproject.aem.core.models.impl;

import com.day.cq.wcm.api.Page;
import com.myproject.aem.core.models.Author;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Default;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.Via;
import org.apache.sling.models.annotations.injectorspecific.RequestAttribute;
import org.apache.sling.models.annotations.injectorspecific.ResourcePath;
import org.apache.sling.models.annotations.injectorspecific.ScriptVariable;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

@Model(adaptables = SlingHttpServletRequest.class,
adapters = Author.class,
defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class AuthorImpl implements Author{
    private static final Logger LOG = LoggerFactory.getLogger(AuthorImpl.class);

    @ScriptVariable
    Page currentPage;

    @RequestAttribute(name = "rAttribute")
    private String reqAttribute;

    @ResourcePath(path = "/content/myproject/us/en/baseTestingTemplate")
    @Via("resource")
    Resource resource;

//    @Inject
//    @Via
//    @Named("jcr:created")
//    String created;


    @Via("resource")
    @Inject
    @Default(values="AEM")
    String fname;

    @ValueMapValue
    @Default(values = "Cloud")
    String lname;

    @Inject
    boolean professor;

    @Override
    public String getFirstName() {
        return fname;
    }

    @Override
    public String getLastName() {
        return lname;
    }

    @Override
    public boolean getIsProfessor() {
        return professor;
    }

    @Override
    public String getPageTitle() {
        return currentPage.getTitle();
    }

    @Override
    public String getRequestAttribute() {
        return reqAttribute;
    }

    @Override
    public String getHomePageName() {
        return resource.getName();
    }

//    @Override
//    public String getCreated() {
//        return created();
//    }

    @PostConstruct
    protected void init(){
        LOG.info("\n Inside Init {} : {}" , currentPage.getTitle(), resource.getPath());
    }
}
