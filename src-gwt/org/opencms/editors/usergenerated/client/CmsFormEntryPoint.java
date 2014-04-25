/*
 * This library is part of OpenCms -
 * the Open Source Content Management System
 *
 * Copyright (c) Alkacon Software GmbH (http://www.alkacon.com)
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * For further information about Alkacon Software, please see the
 * company website: http://www.alkacon.com
 *
 * For further information about OpenCms, please see the
 * project website: http://www.opencms.org
 * 
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
 */

package org.opencms.editors.usergenerated.client;

import org.opencms.editors.usergenerated.client.export.CmsXmlContentFormApi;

import org.timepedia.exporter.client.ExporterUtil;

/**
 * Entry point for client-side form handling code for user-generated content module.<p>
 */
public class CmsFormEntryPoint {

    /**
     * Exports the API objects as native Javascript objects.<p>
     * 
     * @param api the API to expose as Javascript object 
     */
    public native void installJavascriptApi(CmsXmlContentFormApi api) /*-{
                                                                      $wnd.OpenCmsXmlContentFormApi = new $wnd.opencms.CmsXmlContentFormApi(api); 
                                                                      }-*/;

    /**
    * @see com.google.gwt.core.client.EntryPoint#onModuleLoad()
    */
    public void onModuleLoad() {

        ExporterUtil.exportAll();
        CmsXmlContentFormApi api = new CmsXmlContentFormApi();
        installJavascriptApi(api);
    }

}
