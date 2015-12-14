/*
 * Licensed to Elasticsearch under one or more contributor
 * license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright
 * ownership. Elasticsearch licenses this file to you under
 * the Apache License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.elasticsearch.index.search.stats;

import org.elasticsearch.common.collect.MapBuilder;
import org.elasticsearch.common.metrics.CounterMetric;
import org.elasticsearch.common.metrics.MeanMetric;
import org.elasticsearch.common.regex.Regex;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.search.internal.SearchContext;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import static java.util.Collections.emptyMap;

/**
 */
public interface ShardSearchStats {

    /**
     * Returns the stats, including group specific stats. If the groups are null/0 length, then nothing
     * is returned for them. If they are set, then only groups provided will be returned, or
     * <tt>_all</tt> for all groups.
     */
    public SearchStats stats(String... groups);

    public void onPreQueryPhase(SearchContext searchContext);

    public void onFailedQueryPhase(SearchContext searchContext);

    public void onQueryPhase(SearchContext searchContext, long tookInNanos);

    public void onPreFetchPhase(SearchContext searchContext);

    public void onFailedFetchPhase(SearchContext searchContext);

    public void onFetchPhase(SearchContext searchContext, long tookInNanos);

    public void clear();

    public void onNewContext(SearchContext context);

    public void onFreeContext(SearchContext context);

    public void onNewScrollContext(SearchContext context);

    public void onFreeScrollContext(SearchContext context);

    public void onRefreshSettings(Settings settings);
}
