#!/groovy
properties([disableConcurrentBuild()])

pipeline {
    agent {
	label 'main' 
    } 
    options {
	buildDiscarder(logRotation(numToKeepStr: '10' artifactNumToKeepStr: '10'))
	timestamps()
    }	
    stages {
    	stage("First step") {
	    steps {
		sh 'ssh root@ec2' \'hostname\''
		}
	}
    }
}
