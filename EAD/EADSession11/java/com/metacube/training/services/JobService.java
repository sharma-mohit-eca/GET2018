package com.metacube.training.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.metacube.training.Status.Status;
import com.metacube.training.dao.JobDao;
import com.metacube.training.models.JobTitle;

/**
 * This class contains Business Logic for Job
 * 
 * @author Mohit Sharma
 *
 */
@Service
public class JobService {

	@Autowired
	private JobDao jobDao;

	/**
	 * Adds Job
	 * 
	 * @param job
	 * @return
	 */
	public Status addJob(JobTitle job) {
		return jobDao.addJob(job);
	}

	/**
	 * Returns Job By code
	 * 
	 * @param code
	 * @return
	 */
	public JobTitle getJobByCode(int code) {
		return jobDao.getJobByCode(code);
	}

	/**
	 * Returns All Jobs
	 * 
	 * @return
	 */
	public List<JobTitle> getAllJobs() {
		return jobDao.getAllJobs();
	}

	/**
	 * Deletes Job
	 * 
	 * @param code
	 * @return
	 */
	public Status deleteJob(int code) {
		JobTitle job = jobDao.getJobByCode(code);
		if (job == null) {
			return Status.NOT_EXIST;
		} else {
			return jobDao.deleteJob(code);
		}
	}

	/**
	 * Updates Job
	 * 
	 * @param job
	 * @return
	 */
	public Status updateJob(JobTitle job) {
		List<JobTitle> listOfJob = jobDao.getAllJobs();
		for (JobTitle existingJob : listOfJob) {
			if (job.getJobCode() == existingJob.getJobCode()) {
				return jobDao.updateJob(job);
			}
		}
		return Status.NOT_EXIST;
	}
}