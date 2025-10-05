package com.myproject.aem.core.models;

import com.day.cq.wcm.api.Page;

public interface Author {
    String getFirstName();
    String getLastName();
    boolean getIsProfessor();
    String getPageTitle();
    String getRequestAttribute();
    String getHomePageName();
//    String getCreated();
}
