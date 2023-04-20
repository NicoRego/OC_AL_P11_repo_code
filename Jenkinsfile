pipeline {
	agent any

	environment {
		mavenHome = tool 'jenkins-maven'
	}

	tools {
		jdk 'jdk-jenkins'
	}

	stages {

	    stage('Build'){
			steps {
				bat "mvnw clean install -DskipTests"
			}
		}

		stage('Test'){
			steps{
				bat "mvnw test"
			}
		}

		stage('Code coverage report'){
  			steps{
   				bat "mvnw jacoco:report"
   			}
  		}





	}
}