package com.thistech.spotlink.model;

/*
 * “The contents of this file are subject to the SpotLink Public License,
 * version 1.0 (the “License”); you may not use this file except in
 * compliance with the License.  You may obtain a copy of the License at
 * http://www.thistech.com/spotlink/spl.
 *
 * Software distributed under the License is distributed on an “AS IS”
 * basis, WITHOUT WARRANTY OF ANY KIND, either express or implied.  See
 * the License for the specific language governing rights and limitations
 * under the License.
 *
 * The Original Code is SpotLink Server Code, release date February 14, 2011
 * The Initial Developer of the Original Code is This Technology, LLC.
 * Copyright (C) 2010-2011, This Technology, LLC
 * All Rights Reserved.
 */

import java.io.Serializable;
import java.util.*;
import org.apache.commons.lang.StringUtils;

public class TrackingEvents implements Serializable {

    private String id;
    private Map<String, String> eventUrls;

    public TrackingEvents() {
        setId(UUID.randomUUID().toString());
    }

    public String getId() { return id; }
    public TrackingEvents setId(String value) { this.id = value; return this; }

    public Map<String, String> getEventUrls() {
        if (eventUrls == null) { eventUrls = new HashMap<String, String>(); }
        return eventUrls;
    }
    public TrackingEvents setEventUrls(Map<String, String> value) { this.eventUrls = value; return this; }

    public TrackingEvents addEventUrl(String event, String url) {
        if (StringUtils.isNotBlank(event) && StringUtils.isNotBlank(url)) {
            getEventUrls().put(StringUtils.lowerCase(event), StringUtils.trim(url));
        }
        return this;
    }

    public String getEventUrl(String event) {
        return getEventUrls().get(StringUtils.lowerCase(event));
    }
}