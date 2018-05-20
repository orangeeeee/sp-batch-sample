package com.example.spbatchsample;

import org.springframework.batch.core.explore.JobExplorer;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.batch.JobLauncherCommandLineRunner;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpBatchSampleApplication {

    @Bean
    public JobLauncherCommandLineRunner jobLauncherCommandLineRunner(JobLauncher jobLauncher, JobExplorer jobExplorer, @Value(
            "${job.name}") String jobName) {
        JobLauncherCommandLineRunner runner = new JobLauncherCommandLineRunner(jobLauncher, jobExplorer);
        runner.setJobNames(jobName);
        return runner;
    }

    public static void main(String[] args) {
        System.exit(SpringApplication.exit(SpringApplication.run(SpBatchSampleApplication.class, args)));
    }
}
