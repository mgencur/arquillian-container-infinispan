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

import org.jboss.infinispan.arquillian.utils.MBeanObjects;
import org.jboss.infinispan.arquillian.utils.MBeanServerConnectionProvider;
import org.jboss.infinispan.arquillian.utils.MBeanUtils;

/**
 * Retrieve various information about a cache manager, either with default name
 * or another name specified for exposing via JMX.
 * 
 * @author <a href="mailto:mgencur@redhat.com">Martin Gencur</a>
 * 
 */
public class CacheManagerInfo
{
   private MBeanServerConnectionProvider provider;

   private String cacheManagerName;

   public CacheManagerInfo(String cacheManagerName, MBeanServerConnectionProvider provider)
   {
      this.cacheManagerName = cacheManagerName;
      this.provider = provider;
   }

   public int getCreatedCacheCount()
   {
      String createdCacheCount = null;
      try
      {
         createdCacheCount = MBeanUtils.getMBeanAttribute(provider, MBeanObjects.getCacheManagerMBean(cacheManagerName), CacheManagerAttributes.CREATED_CACHE_COUNT);
      }
      catch (Exception e)
      {
         throw new RuntimeException("Could not get createdCacheCount", e);
      }
      return Integer.parseInt(createdCacheCount);
   }

   public int getDefinedCacheCount()
   {
      String definedCacheCount = null;
      try
      {
         definedCacheCount = MBeanUtils.getMBeanAttribute(provider, MBeanObjects.getCacheManagerMBean(cacheManagerName), CacheManagerAttributes.DEFINED_CACHE_COUNT);
      }
      catch (Exception e)
      {
         throw new RuntimeException("Could not get definedCacheCount", e);
      }
      return Integer.parseInt(definedCacheCount);
   }

   public int getRunningCacheCount()
   {
      String runningCacheCount = null;
      try
      {
         runningCacheCount = MBeanUtils.getMBeanAttribute(provider, MBeanObjects.getCacheManagerMBean(cacheManagerName), CacheManagerAttributes.RUNNING_CACHE_COUNT);
      }
      catch (Exception e)
      {
         throw new RuntimeException("Could not get definedCacheCount", e);
      }
      return Integer.parseInt(runningCacheCount);
   }

   public String getCacheName()
   {
      try
      {
         return MBeanUtils.getMBeanAttribute(provider, MBeanObjects.getCacheManagerMBean(cacheManagerName), CacheManagerAttributes.RUNNING_CACHE_COUNT);
      }
      catch (Exception e)
      {
         throw new RuntimeException("Could not get cacheName", e);
      }
   }

   public int getClusterSize()
   {
      String clusterSize = null;
      try
      {
         clusterSize = MBeanUtils.getMBeanAttribute(provider, MBeanObjects.getCacheManagerMBean(cacheManagerName), CacheManagerAttributes.CLUSTER_SIZE);
      }
      catch (Exception e)
      {
         throw new RuntimeException("Could not get definedCacheCount", e);
      }
      return Integer.parseInt(clusterSize);
   }

   public String getCacheManagerStatus()
   {
      try
      {
         return MBeanUtils.getMBeanAttribute(provider, MBeanObjects.getCacheManagerMBean(cacheManagerName), CacheManagerAttributes.CACHE_MANAGER_STATUS);
      }
      catch (Exception e)
      {
         throw new RuntimeException("Could not get cacheManagerStatus", e);
      }
   }

   public String getNodeAddress()
   {
      try
      {
         return MBeanUtils.getMBeanAttribute(provider, MBeanObjects.getCacheManagerMBean(cacheManagerName), CacheManagerAttributes.NODE_ADDRESS);
      }
      catch (Exception e)
      {
         throw new RuntimeException("Could not get nodeAddress", e);
      }
   }

   public String getVersion()
   {
      try
      {
         return MBeanUtils.getMBeanAttribute(provider, MBeanObjects.getCacheManagerMBean(cacheManagerName), CacheManagerAttributes.VERSION);
      }
      catch (Exception e)
      {
         throw new RuntimeException("Could not get version", e);
      }
   }

   public String getDefinedCacheNames()
   {
      try
      {
         return MBeanUtils.getMBeanAttribute(provider, MBeanObjects.getCacheManagerMBean(cacheManagerName), CacheManagerAttributes.DEFINED_CACHE_NAMES);
      }
      catch (Exception e)
      {
         throw new RuntimeException("Could not get definedCacheNames", e);
      }
   }

   public String getClusterMembers()
   {
      try
      {
         return MBeanUtils.getMBeanAttribute(provider, MBeanObjects.getCacheManagerMBean(cacheManagerName), CacheManagerAttributes.CLUSTER_MEMBERS);
      }
      catch (Exception e)
      {
         throw new RuntimeException("Could not get clusterMembers", e);
      }
   }

   public String getPhysicalAddresses()
   {
      try
      {
         return MBeanUtils.getMBeanAttribute(provider, MBeanObjects.getCacheManagerMBean(cacheManagerName), CacheManagerAttributes.PHYSICAL_ADDRESSES);
      }
      catch (Exception e)
      {
         throw new RuntimeException("Could not get physicalAddresses", e);
      }
   }

   public CacheInfo getCache(String cacheName)
   {
      try
      {
         return new CacheInfo(cacheName, cacheManagerName, provider);
      }
      catch (Exception e)
      {
         throw new RuntimeException("Could not get cache named " + cacheName, e);
      }
   }

   public CacheInfo getDefaultCache()
   {
      String defaultCacheName = "___defaultcache(local)";
      try
      {
         return new CacheInfo(defaultCacheName, cacheManagerName, provider);
      }
      catch (Exception e)
      {
         throw new RuntimeException("Could not get default cache named " + defaultCacheName, e);
      }
   }
}
