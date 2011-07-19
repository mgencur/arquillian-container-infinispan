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
package org.jboss.infinispan.arquillian.core;

import java.net.InetAddress;
import java.net.UnknownHostException;
import org.jboss.infinispan.arquillian.model.CacheManagerInfo;
import org.jboss.infinispan.arquillian.model.HotRodEndpoint;
import org.jboss.infinispan.arquillian.model.MemCachedEndpoint;
import org.jboss.infinispan.arquillian.model.RESTEndpoint;
import org.jboss.infinispan.arquillian.utils.MBeanServerConnectionProvider;

/**
 * Implementation of {@link InfinispanInfo} for Community Infinispan Server
 * 
 * @author <a href="mailto:mgencur@redhat.com">Martin Gencur</a>
 * 
 */
public class StandaloneInfinispanInfoImpl implements InfinispanInfo
{
   private MBeanServerConnectionProvider provider;

   public StandaloneInfinispanInfoImpl(String host, int jmxPort)
   {
      this.provider = new MBeanServerConnectionProvider(getInetAddress(host), jmxPort);
   }

   @Override
   public CacheManagerInfo getDefaultCacheManager()
   {
      return new CacheManagerInfo("DefaultCacheManager", provider);
   }

   @Override
   public CacheManagerInfo getCacheManager(String cacheManagerName)
   {
      return new CacheManagerInfo(cacheManagerName, provider);
   }

   @Override
   public HotRodEndpoint getHotrodEndpoint()
   {
      return new HotRodEndpoint(provider);
   }

   @Override
   public MemCachedEndpoint getMemcachedEndpoint()
   {
      return new MemCachedEndpoint(provider);
   }

   @Override
   public RESTEndpoint getRESTEndpoint()
   {
      // a real value will be returned only for EDG (infinispan in JBossAS 7+)
      throw new RuntimeException("Could not retrieve REST endpoint -> not applicable for Community Infinispan Server");
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
