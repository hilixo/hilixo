#!groovy
library 'jenkins-pipeline-libs@master'

pipeline {

  agent none
  
  stages {
    stage('Build Server Distribution') {
      steps {
        checkout scm
        sh './gradlew clean build'
      }
    }
  }
  
}
