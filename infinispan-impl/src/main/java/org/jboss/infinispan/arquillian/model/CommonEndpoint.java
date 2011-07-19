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
import java.net.UnknownHostException;

/**
 * Base class for hotrod, memcached, rest endpoint classes. Just holding an
 * InetAddress of an Infinispan/JBossAS server.
 * 
 * @author <a href="mailto:mgencur@redhat.com">Martin Gencur</a>
 * 
 */
public class CommonEndpoint
{
   private InetAddress addr;

   public CommonEndpoint()
   {
      this.addr = getInetAddress("localhost");
   }

   public CommonEndpoint(InetAddress addr)
   {
      this.addr = addr;
   }

   public InetAddress getInetAddress()
   {
      return this.addr;
   }

   protected static InetAddress getInetAddress(String name)
   {
      try
      {
         return InetAddress.getByName(name);
      }
      catch (UnknownHostException e)
      {
         throw new IllegalArgumentException("Unknown host: " + name);
      }
   }
}
