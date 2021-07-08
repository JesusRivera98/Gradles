package com.platzi.jobsearch.api;

import com.platzi.jobsearch.JobPosition;
import feign.Headers;
import feign.Param;
import feign.QueryMap;
import feign.RequestLine;

import java.util.List;
import java.util.Map;

/**
 * This interface will be used by Feign to make requests to the GitHub API.
 */
@Headers("Accept: application/json")
public interface APIJobs {
    @RequestLine("GET /positions.json")
    List<JobPosition> jobs(@QueryMap Map<String, Object> queryMap);

    @RequestLine("GET /positions/{id}.json")
    JobPosition job(@Param("id") String id);
}
