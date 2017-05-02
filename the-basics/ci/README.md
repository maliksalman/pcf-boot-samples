## Sample Concourse CI pipelines
There are couple of [concourse](https://concourse.ci) CI pipelines that will build and deploy the `the-basics` app in CloudFoundry. They both perform the same operation but show different ways of constructing the pipelines.

### pipeline.yml
This is a simpler all-in-one pipeline that demonstrates how to build and deploy the app using a single job. Main concept learned in this pipleline is how to separate tasks from the main pipeline.

To register this pipeline against concourse installation, do this:
```
fly -t <concourse-target> set-pipeline -p the-basics -c pipeline.yml 
```

### pipeline-s3.yml
This version of the pipeline consists of two jobs. One jobs builds the app, updates a version, and saves the version info and build artifacts in S3. The second job retrieves the built artifacts from S3 and deploys the app in CloudFoundry. This pipeline demonstrates:

- how to share data between two jobs
- how semantic versions are handled in concourse
- how to externalize variables like credentials from the pipeline

To register this pipeline against concourse installation, do this:
```
fly -t <concourse-target> set-pipeline -p the-basics -c pipeline-s3.yml -l vars-s3.yml 
```