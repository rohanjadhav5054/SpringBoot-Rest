package org.rohan.springbootrest;

import org.rohan.springbootrest.model.JobPost;
import org.rohan.springbootrest.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class JobRestController {
    @Autowired
    private JobService service;

    @GetMapping("jobPosts")
    public List<JobPost> listAllJobs(){
        return service.getAllJobs();
    }

    @GetMapping("jobPosts/keyword/{keyword}")
    public List<JobPost> searchJobByKeyword(@PathVariable("keyword") String keyword){
        return service.search(keyword);
    }

    @GetMapping("JobPost/{postId}")//using the {} we can mae it as a dynamic
    public JobPost getJob( @PathVariable("postId") int postId){
        return service.getJob(postId);
    }

    @PostMapping("JobPost")
    public JobPost addJob(@RequestBody JobPost job){
        service.addJob(job);
        return service.getJob(job.getPostId());
    }

    @PutMapping("JobPost")
    public JobPost updateJob(@RequestBody JobPost jobPost){
        service.updateJob(jobPost);
        return service.getJob(jobPost.getPostId());
    }

    @DeleteMapping("JobPost/{postId}")
    public String deleteJob(@PathVariable("postId") int postId){
        service.deleteJob(postId);
        return "JobDeleted Successfully";
    }

    @GetMapping("Load")
    public String loadData(){
        service.load();
        return "Load Successfully";
    }
}
