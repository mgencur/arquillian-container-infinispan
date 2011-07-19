/*
 * JBoss, Home of Professional Open Source.
 * Copyright 2009, Red Hat Middleware LLC, and individual contributors
 * as indicated by the @author tags. See the copyright.txt file in the
 * distribution for a full listing of individual contributors.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */
package org.jboss.infinispan.arquillian.model;

import java.net.InetAddress;
import org.jboss.infinispan.arquillian.utils.MBeanServerConnectionProvider;

/**
 * Hold REST server module's context path. Can be retrieved inside a test to
 * find out on which contextPath REST service is running. Available only for
 * EDG, not for community Infinispan Server.
 * 
 * @author <a href="mailto:mgencur@redhat.com">Martin Gencur</a>
 * 
 */
public class RESTEndpoint
{
   private String contextPath = "datagrid/rest";

   private MBeanServerConnectionProvider provider;

   public RESTEndpoint(MBeanServerConnectionProvider provider)
   {
      this.provider = provider;
   }

   public InetAddress getInetAddress()
   {
      //TODO: return proper address based on information from EDG
      return null;
   }

   public String getContextPath()
   {
      return contextPath;
   }
}
